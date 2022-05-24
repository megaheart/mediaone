package com.shopkeeper.linh.database;

import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.Settings;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
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
        if(createStaffsTable()) throw new Exception("DatabaseWorker2 created Staffs tables false");
        if(createSettingsTable()) throw new Exception("DatabaseWorker2 created Settings tables false");
        if(createCustomersTable()) throw new Exception("DatabaseWorker2 created Customers tables false");
        if(createTextValuesTable()) throw new Exception("DatabaseWorker2 created TextValues tables false");
    }
    public void load1(DbAdapterCache cache) throws Exception{
        loadStaffs(cache);
        loadSettings(cache);
        loadCustomers(cache);
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
        String sql = "UPDATE staffs SET name=?,isMale=?,dateOfBirth=?,email=?,phoneNumber=?,description=?,state=? WHERE staffId=?";

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
        if(value == null || value.length() == 0){
            String sql = "delete from textvalues where [key]=?;";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, key);
                pstmt.executeUpdate();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }
            return true;
        }
        else {
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
        }
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
    //region Feedback

    //endregion
}