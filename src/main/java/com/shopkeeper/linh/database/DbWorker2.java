package com.shopkeeper.linh.database;

import com.shopkeeper.linh.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.mediaone.database.DbAdapterCache;

import java.sql.*;
import java.time.LocalDate;

public class DbWorker2 {
    private Connection conn;
    public DbWorker2(Connection conn/*, DbAdapterCache cache*/){
        this.conn = conn;

        //this.cache = cache;
    }
    public void initializeTables() throws Exception{
        if(!createStaffsTable()) throw new Exception("DatabaseWorker2 created Staffs tables false");
        if(!createSettingsTable()) throw new Exception("DatabaseWorker2 created Settings tables false");
        if(!createCustomersTable()) throw new Exception("DatabaseWorker2 created Customers tables false");
        if(!createTextValuesTable()) throw new Exception("DatabaseWorker2 created TextValues tables false");
        if(!createSaleBillsTable()) throw new Exception("DatabaseWorker2 created SaleBills tables false");
        if(!createFeedbacksTable()) throw new Exception("DatabaseWorker2 created Feedbacks tables false");
    }
    public void load1(DbAdapterCache cache) throws Exception{
        loadStaffs(cache);
        loadSettings(cache);
        loadCustomers(cache);
        loadSaleBills(cache);
    }
    //region Staffs Database
    //Return true if success, otherwise return false
    public boolean createStaffsTable() {
        String sql = "CREATE TABLE staffs ("
                +  "staffId     INTEGER PRIMARY KEY AUTOINCREMENT,"
                +  "name        TEXT      NOT NULL,"
                +  "isMale      BOOLEAN   NOT NULL,"
                +  "dateOfBirth DATETIME  NOT NULL,"
                +  "email       TEXT      NOT NULL,"
                +  "phoneNumber TEXT      NOT NULL,"
                +  "description TEXT,"
                +  "state       TEXT (40) NOT NULL"
                +  ");";
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_staffs_staffId ON staffs(staffId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void loadStaffs(DbAdapterCache cache) throws Exception{
        String sql = "SELECT staffId, name, isMale, dateOfBirth, email, phoneNumber, description, state FROM staffs";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Staff staff;
        while (rs.next()) {
            staff = new Staff();
            staff.setStaffId(rs.getLong("staffId"));
            staff.setName(rs.getString("name"));
            staff.setIsMale(rs.getBoolean("isMale"));
            //;
            staff.setDateOfBirth(LocalDate.parse(rs.getString("dateOfBirth")));
            staff.setEmail(rs.getString("email"));
            staff.setPhoneNumber(rs.getString("phoneNumber"));
            staff.setDescription(rs.getString("description"));
            staff.setState(StaffState.valueOf(rs.getString("state")));
            cache.getStaffs().add(staff);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertStaff(Staff staff) {
        if(staff.getStaffId() != 0) return false;
        String sql = "INSERT INTO staffs(name, isMale, dateOfBirth, email, phoneNumber, description, state) VALUES(?,?,DATE(?),?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, staff.getName());
            pstmt.setBoolean(2, staff.getIsMale());
            pstmt.setString(3, staff.getDateOfBirth().toString());
            pstmt.setString(4, staff.getEmail());
            pstmt.setString(5, staff.getPhoneNumber());
            pstmt.setString(6, staff.getDescription());
            pstmt.setString(7, staff.getState().toString());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating staff failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                staff.setStaffId(generatedKeys.getLong(1));
            }
            else throw new Exception("Creating staff failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean updateStaff(Staff staff) {
        String sql = "UPDATE staffs SET name=?,isMale=?,dateOfBirth=DATE(?),email=?,phoneNumber=?,description=?,state=? WHERE staffId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getName());
            pstmt.setBoolean(2, staff.getIsMale());
            pstmt.setString(3, staff.getDateOfBirth().toString());
            pstmt.setString(4, staff.getEmail());
            pstmt.setString(5, staff.getPhoneNumber());
            pstmt.setString(6, staff.getDescription());
            pstmt.setString(7, staff.getState().toString());
            pstmt.setLong(8, staff.getStaffId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Staff (ID = " + staff.getStaffId() + ") does not exist in \"staffs\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean deleteStaff(Staff staff) {
        String sql = "DELETE FROM staffs WHERE staffId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, staff.getStaffId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Staff (ID = " + staff.getStaffId() + ") does not exist in \"staffs\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //endregion
    //region Settings

    //Return true if success, otherwise return false
    public boolean createSettingsTable() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE settings(");
        sqlBuilder.append("    name         TEXT PRIMARY KEY NOT NULL UNIQUE,");
        sqlBuilder.append("    value        TEXT      NOT NULL,");
        sqlBuilder.append("    defaultValue TEXT      NOT NULL");
        sqlBuilder.append(");");
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sqlBuilder.toString());
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_settings_name ON settings(name);");
            //Initialize settings
            stmt.execute("INSERT INTO settings(name, value, defaultValue) VALUES('standardSalaryPerHour','0','0');");
            stmt.execute("INSERT INTO settings(name, value, defaultValue) VALUES('clearingFeedbackDuration','30','30');");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
    private boolean isStandardSalaryPerHourChanged;
    private boolean isClearingFeedbackDurationChanged;
    public void loadSettings(DbAdapterCache cache) throws Exception{
        String sql = "SELECT name, value FROM settings";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Settings settings = cache.getSettings();
        // loop through the result set
        while (rs.next()) {
            switch (rs.getString("name")){
                case "standardSalaryPerHour":
                    settings.setStandardSalaryPerHour(rs.getDouble("value"));
                    break;
                case "clearingFeedbackDuration":
                    settings.setClearingFeedbackDuration(rs.getInt("value"));
                    break;
            }
        }
        stmt.close();
        rs.close();
        isStandardSalaryPerHourChanged = false;
        isClearingFeedbackDurationChanged = false;
        settings.standardSalaryPerHourProperty().addListener(((observable, oldValue, newValue) -> {
            isStandardSalaryPerHourChanged = true;
        }));
        settings.clearingFeedbackDurationProperty().addListener(((observable, oldValue, newValue) -> {
            isClearingFeedbackDurationChanged = true;
        }));
    }

    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean updateSettings(Settings settings) {
        try (Statement stmt = conn.createStatement()) {
            if(isStandardSalaryPerHourChanged){
                int affected = stmt.executeUpdate(
                        "UPDATE settings SET value='" + settings.getStandardSalaryPerHour() + "' WHERE name='standardSalaryPerHour';");
                if(affected == 0) throw new Exception("Updating settings' property (standardSalaryPerHour) failed.");
                //System.out.println("Updating settings' property (standardSalaryPerHour) successful.");
            }
            if(isClearingFeedbackDurationChanged){
                int affected = stmt.executeUpdate(
                        "UPDATE settings SET value='" + settings.getStandardSalaryPerHour() + "' WHERE name='clearingFeedbackDuration';");
                if(affected == 0) throw new Exception("Updating settings' property (clearingFeedbackDuration) failed.");
                //System.out.println("Updating settings' property (clearingFeedbackDuration) successful.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        isStandardSalaryPerHourChanged = false;
        isClearingFeedbackDurationChanged = false;
        return true;
    }
    //Return true if success, otherwise return false
    public boolean resetSettings(Settings settings) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT name, defaultValue FROM settings");
            while (rs.next()) {
                switch (rs.getString("name")){
                    case "standardSalaryPerHour":
                        settings.setStandardSalaryPerHour(rs.getDouble("defaultValue"));
                        break;
                    case "clearingFeedbackDuration":
                        settings.setClearingFeedbackDuration(rs.getInt("defaultValue"));
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        return updateSettings(settings);
    }
    //endregion
    //region Customer
    //Return true if success, otherwise return false
    public boolean createCustomersTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE customers (");
        sqlBuilder.append("customerId  INTEGER PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("name               TEXT      NOT NULL,");
        sqlBuilder.append("defaultLocation    TEXT      NOT NULL,");
        sqlBuilder.append("phoneNumber        TEXT      NOT NULL");
        sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_customers_customerId ON customers(customerId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void loadCustomers(DbAdapterCache cache) throws Exception{
        String sql = "SELECT customerId, name, defaultLocation, phoneNumber FROM customers";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Customer customer;
        while (rs.next()) {
            customer = new Customer();
            customer.setCustomerId(rs.getLong("customerId"));
            customer.setName(rs.getString("name"));
            customer.setDefaultLocation(rs.getString("defaultLocation"));
            customer.setPhoneNumber(rs.getString("phoneNumber"));
            cache.getCustomers().add(customer);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertCustomer(Customer customer) {
        if(customer.getCustomerId() != 0) return false;
        String sql = "INSERT INTO customers(name, defaultLocation, phoneNumber) VALUES(?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getDefaultLocation());
            pstmt.setString(3, customer.getPhoneNumber());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating customer failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                customer.setCustomerId(generatedKeys.getLong(1));
            }
            else throw new Exception("Creating customer failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET name=?,defaultLocation=?,phoneNumber=? WHERE customerId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getDefaultLocation());
            pstmt.setString(3, customer.getPhoneNumber());
            pstmt.setLong(4, customer.getCustomerId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Customer (ID = " + customer.getCustomerId() + ") does not exist in \"customers\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean deleteCustomer(Customer customer) {
        String sql = "DELETE FROM customers WHERE customerId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, customer.getCustomerId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Customer (ID = " + customer.getCustomerId() + ") does not exist in \"customers\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //endregion
    //region TextValue
    public boolean createTextValuesTable() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE textvalues(");
        sqlBuilder.append("    key    TEXT PRIMARY KEY NOT NULL UNIQUE,");
        sqlBuilder.append("    value  TEXT      NOT NULL");
        sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_textvalues_key ON textvalues(key);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean setTextValue(String key, String value) {
        if(key == null) return false;
        if(value == null) value = "";
//        if(value == null || value.length() == 0){
//            String sql = "delete from textvalues where [key]=?;";
//            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                pstmt.setString(1, key);
//                pstmt.executeUpdate();
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//                return false;
//            }
//            return true;
//        }
//        else {
            String sql = "insert or replace into textvalues([key], value) values (?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, key);
                pstmt.setString(2, value);
                pstmt.executeUpdate();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }
            return true;
        //}
    }
    //Return true if success, otherwise return false
    public String getTextValue(String key) {
        String sql = "SELECT value FROM textvalues WHERE [key]=?;";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, key);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            return "";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    //endregion
    //region SaleBill
    //Return true if success, otherwise return false
    public boolean createSaleBillsTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE salebills (");
        sqlBuilder.append("billId  INTEGER PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("name          TEXT      NOT NULL,");
        sqlBuilder.append("location      TEXT      NOT NULL,");
        sqlBuilder.append("customerId    INTEGER   NOT NULL,");
        sqlBuilder.append("isPaid        BOOLEAN   NOT NULL,");
        sqlBuilder.append("price         DOUBLE    NOT NULL,");
        sqlBuilder.append("time          DATETIME  NOT NULL,");
        sqlBuilder.append("effected      BOOLEAN   NOT NULL,");
        sqlBuilder.append("note          TEXT      NOT NULL");
        sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_salebills_billId ON salebills(billId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void loadSaleBills(DbAdapterCache cache) throws Exception{
        String sql = "SELECT billId, name, customerId, location ,isPaid, price, time, effected, note FROM salebills";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        SaleBill bill;
        long customerId;
        var customers = cache.getCustomers();
        while (rs.next()) {
            bill = new SaleBill();
            bill.setBillId(rs.getInt("billId"));
            bill.setName(rs.getString("name"));
            bill.setLocation(rs.getString("location"));
            customerId = rs.getLong("customerId");
            for(int i = 0; i < customers.size(); i++){
                var customer = customers.get(i);
                if(customer.getCustomerId() == customerId){
                    bill.setCustomer(customer);
                    customer.increaseTimesToBeReferenced();
                }
            }
            if(bill.getCustomer() == null){
                throw new Exception("Be careful when delete a customer, the action can affect to a salebill whose customer is deleted.");
            }
            bill.setIsPaid(rs.getBoolean("isPaid"));
            bill.setPrice(rs.getDouble("price"));
            bill.setTime(LocalDate.parse(rs.getString("time")));
            bill.setIsEffected(rs.getBoolean("effected"));
            bill.setNote(rs.getString("note"));
            cache.getSaleBills().add(bill);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertSaleBill(SaleBill bill) {
        if(bill.getBillId() != 0) return false;
        String sql = "INSERT INTO salebills(name, customerId, location ,isPaid, price, time, effected, note) VALUES(?,?,?,?,?,DATE(?),?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, bill.getName());
            pstmt.setLong(2, bill.getCustomer().getCustomerId());
            pstmt.setString(3, bill.getLocation());
            pstmt.setBoolean(4, bill.getIsPaid());
            pstmt.setDouble(5, bill.getPrice());
            pstmt.setString(6, bill.getTime().toString());
            pstmt.setBoolean(7, bill.getIsEffected());
            pstmt.setString(8, bill.getNote());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating salebill failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                bill.setBillId(generatedKeys.getInt(1));
            }
            else throw new Exception("Creating salebill failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean updateSaleBill(SaleBill bill, Customer[] customers) {
        String sql = "UPDATE salebills SET name=?, customerId=?, location=?, isPaid=?, price=?, time=DATE(?), effected=?, note=? WHERE billId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT customerId FROM salebills WHERE billId=" + bill.getBillId());
            Customer old = null;
            if(rs.next()){
                int billId = rs.getInt(1);
                for (var x: customers) {
                    if(x.getCustomerId() == billId){
                        old = x;
                        break;
                    }
                }
            }
            pstmt.setString(1, bill.getName());
            pstmt.setLong(2, bill.getCustomer().getCustomerId());
            pstmt.setString(3, bill.getLocation());
            pstmt.setBoolean(4, bill.getIsPaid());
            pstmt.setDouble(5, bill.getPrice());
            pstmt.setString(6, bill.getTime().toString());
            pstmt.setBoolean(7, bill.getIsEffected());
            pstmt.setString(8, bill.getNote());
            pstmt.setInt(9, bill.getBillId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("SaleBill (ID = " + bill.getBillId() + ") does not exist in \"salebills\" table.");
            if(old != null) old.decreaseTimesToBeReferenced();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean deleteSaleBill(SaleBill bill) {
        String sql = "DELETE FROM salebills WHERE billId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, bill.getBillId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("SaleBill (ID = " + bill.getBillId() + ") does not exist in \"salebills\" table.");

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //endregion
    //region Feedback
    public boolean createFeedbacksTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE feedbacks (");
        sqlBuilder.append("feedbackId  INTEGER PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("title                 TEXT        NOT NULL,");
        sqlBuilder.append("description           TEXT        NOT NULL,");
        sqlBuilder.append("feedbackAbout         TEXT        NOT NULL,");
        sqlBuilder.append("feedbackType          TEXT        NOT NULL,");
        sqlBuilder.append("productTargetId       TEXT        NOT NULL,");
        sqlBuilder.append("productInfoTargetId   TEXT        NOT NULL,");
        sqlBuilder.append("productInfoRating     INTEGER     NOT NULL,");
        sqlBuilder.append("staffTargetId         INTEGER     NOT NULL,");
        sqlBuilder.append("isUseful              BOOLEAN     NOT NULL,");
        sqlBuilder.append("time                  DATETIME    NOT NULL");
        sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_feedbacks_feedbackId ON feedbacks(feedbackId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void loadFeedbacks(DbAdapterCache cache) throws Exception{
        String sql = "SELECT feedbackId, title, description, feedbackAbout, feedbackType, productTargetId, productInfoTargetId, productInfoRating, staffTargetId, isUseful, time FROM feedbacks";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Feedback feedback;
        long id;
        while (rs.next()) {
            feedback = new Feedback();
            feedback.setFeedbackId(rs.getLong("feedbackId"));
            feedback.setTitle(rs.getString("title"));
            feedback.setDescription(rs.getString("description"));
            feedback.setFeedbackAbout(FeedbackAbout.valueOf(rs.getString("feedbackAbout")));
            feedback.setFeedbackType(FeedbackType.valueOf(rs.getString("feedbackType")));
            switch (feedback.getFeedbackAbout()){
                case Staff:

                    //feedback.setStaffTarget();

                    break;
                case ProductInfo:

                    //feedback.setProductInfoTarget();

                    feedback.setProductInfoRating(rs.getInt("productInfoRating"));
                    break;
                case  Product:

                    //feedback.setProductTarget();

                    break;
                case Service:
                    //Do nothing
                    break;
            }
            feedback.setIsUseful(rs.getBoolean("isUseful"));
            feedback.setTime(LocalDate.parse(rs.getString("time")));
            cache.getFeedbacks().add(feedback);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertFeedback(Feedback feedback) {
        if(feedback.getFeedbackId() != 0) return false;
        String sql = "INSERT INTO feedbacks(title, description, feedbackAbout, feedbackType, productTargetId, productInfoTargetId, productInfoRating, staffTargetId, isUseful, time) VALUES(?,?,?,?,?,?,?,?,?,DATE(?))";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, feedback.getTitle());
            pstmt.setString(2, feedback.getDescription());
            pstmt.setString(3, feedback.getFeedbackAbout().toString());
            pstmt.setString(4, feedback.getFeedbackType().toString());
            switch (feedback.getFeedbackAbout()){
                case Staff:
                    pstmt.setInt(5, 0);//productTarget
                    pstmt.setString(6, "");//productInfoTarget
                    pstmt.setInt(7, 0);//productInfoRating
                    pstmt.setLong(8, feedback.getStaffTarget().getStaffId());//staffTarget
                    break;
                case ProductInfo:
                    pstmt.setInt(5, 0);//productTarget
                    pstmt.setLong(6, feedback.getProductInfoTarget().getProductInfoId());//productInfoTarget
                    pstmt.setInt(7, feedback.getProductInfoRating());//productInfoRating
                    pstmt.setLong(8, 0);//staffTarget
                    break;
                case  Product:
                    pstmt.setLong(5, feedback.getProductTarget().getProductId());//productTarget
                    pstmt.setString(6, "");//productInfoTarget
                    pstmt.setInt(7, 0);//productInfoRating
                    pstmt.setLong(8, 0);//staffTarget
                    break;
                case Service:
                    //Do nothing
                    break;
            }
            pstmt.setBoolean(9, feedback.getIsUseful());
            pstmt.setString(10, feedback.getTime().toString());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating feedback failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                feedback.setFeedbackId(generatedKeys.getInt(1));
            }
            else throw new Exception("Creating feedback failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean updateFeedback(Feedback feedback) {
        String sql = "UPDATE feedbacks SET title=?, description=?, feedbackAbout=?, feedbackType=?, productTargetId=?, productInfoTargetId=?, productInfoRating=?, staffTargetId=?, isUseful=?, time=? WHERE feedbackId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, feedback.getTitle());
            pstmt.setString(2, feedback.getDescription());
            pstmt.setString(3, feedback.getFeedbackAbout().toString());
            pstmt.setString(4, feedback.getFeedbackType().toString());
            switch (feedback.getFeedbackAbout()){
                case Staff:
                    pstmt.setInt(5, 0);//productTarget
                    pstmt.setString(6, "");//productInfoTarget
                    pstmt.setInt(7, 0);//productInfoRating
                    pstmt.setLong(8, feedback.getStaffTarget().getStaffId());//staffTarget
                    break;
                case ProductInfo:
                    pstmt.setInt(5, 0);//productTarget
                    pstmt.setLong(6, feedback.getProductInfoTarget().getProductInfoId());//productInfoTarget
                    pstmt.setInt(7, feedback.getProductInfoRating());//productInfoRating
                    pstmt.setLong(8, 0);//staffTarget
                    break;
                case  Product:
                    pstmt.setLong(5, feedback.getProductTarget().getProductId());//productTarget
                    pstmt.setString(6, "");//productInfoTarget
                    pstmt.setInt(7, 0);//productInfoRating
                    pstmt.setLong(8, 0);//staffTarget
                    break;
                case Service:
                    //Do nothing
                    break;
            }
            pstmt.setBoolean(9, feedback.getIsUseful());
            pstmt.setString(10, feedback.getTime().toString());
            pstmt.setLong(11, feedback.getFeedbackId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Feedback (ID = " + feedback.getFeedbackId() + ") does not exist in \"feedbacks\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean deleteFeedback(Feedback feedback) {
        String sql = "DELETE FROM feedbacks WHERE feedbackId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, feedback.getFeedbackId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Feedback (ID = " + feedback.getFeedbackId() + ") does not exist in \"feedbacks\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //endregion
}
