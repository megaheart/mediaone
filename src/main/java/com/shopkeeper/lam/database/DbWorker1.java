package com.shopkeeper.lam.database;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.mediaone.database.DbAdapterCache;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DbWorker1 {
    private Connection conn;

    public DbWorker1(Connection conn) {
        this.conn = conn;
        //this.cache = cache;
    }

    public void initializeTables() throws Exception {
        if (createCategoriesTable()) throw new Exception("DatabaseWorker1 created Category tables false");
        if (createPersonTable()) throw new Exception("DatabaseWorker1 created Person tables false");

    }




    //CATEGORY

    public boolean createCategoriesTable() {
        String sql = "CREATE TABLE categories ("
                + "categoryId     INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name           TEXT      NOT NULL,"
                + "description    TEXT      NOT NULL,"
                + "productType    DATETIME  NOT NULL,"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_categories_categoryId ON categories(categoryId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void loadCategories(DbAdapterCache cache) throws Exception {
        String sql = "SELECT categoryId, name, description,productType FROM categories";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Category category;
        while (rs.next()) {
            category = new Category();
            category.setCategoryId(rs.getLong("categoryId"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setProductType(ProductType.valueOf(rs.getString("productType")));
            cache.getCategories().add(category);
        }

        rs.close();
        stmt.close();
    }

    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertCategory(Category category) {
        String sql = "INSERT INTO categories(name, description, productType) VALUES(?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDescription());
            pstmt.setString(3, category.getDescription().toString());
            int affected = pstmt.executeUpdate();
            if (affected == 0) throw new Exception("Creating staff failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                category.setCategoryId(generatedKeys.getLong(1));
            } else throw new Exception("Creating category failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    //Return true if success, otherwise return false
    public boolean updateCategory(Category category) {
        String sql = "UPDATE categories SET name=?,description=?,productType=? WHERE categoryId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getName());
            pstmt.setString(6, category.getDescription());
            pstmt.setString(7, category.getProductType().toString());
            pstmt.setLong(8, category.getCategoryId());
            int affected = pstmt.executeUpdate();
            if (affected == 0)
                throw new Exception("Category (ID = " + category.getCategoryId() + ") does not exist in \"categories\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    //Return true if success, otherwise return false
    public boolean deleteCategories(Category category) {
        String sql = "DELETE FROM categories WHERE categoryId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, category.getCategoryId());
            int affected = pstmt.executeUpdate();
            if (affected == 0)
                throw new Exception("Category (ID = " + category.getCategoryId() + ") does not exist in \"categories\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }


    //PERSON

    public boolean createPersonTable() {
        String sql = "CREATE TABLE people ("
                + "personId      INTEGER  PRIMARY KEY NOT NULL,"
                + "name          TEXT PRIMARY KEY AUTOINCREMENT,"
                + "dateOfBirth   TEXT      NOT NULL,"
                + "description   TEXT      NOT NULL,"
                + "jobs          TEXT      NOT NULL,"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_people_personId ON staffs(personId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void loadPeople(DbAdapterCache cache) throws Exception {
        String sql = "SELECT personId, name, dateOfBirth, description FROM people";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Person person;

        while (rs.next()) {
            person = new Person();
            person.setPersonId(rs.getLong("personId"));
            person.setName(rs.getString("name"));
            person.setDateOfBirth(LocalDate.parse(rs.getString("dateOfBirth")));
            person.setDescription(rs.getString("description"));
            person.setJob(JobOfPerson.valueOf(rs.getString("jobs")));

            cache.getPeople().add(person);
        }
            rs.close();
            stmt.close();
        }
        //Auto set id for staff after it was inserted
        //Return true if success, otherwise return false
        public boolean insertPerson(Person person){
            if (person.getPersonId() != 0) return false;
            String sql = "INSERT INTO person(name, dateOfBirth, description, jobs) VALUES(?,DATE(?),?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, person.getName());
                pstmt.setString(2, person.getDateOfBirth().toString());
                pstmt.setString(3, person.getDescription());
                pstmt.setString(4, person.getJob().toString());
                int affected = pstmt.executeUpdate();
                if (affected == 0) throw new Exception("Creating person failed, no rows affected.");
                //Auto set ID
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    person.setPersonId(generatedKeys.getLong(1));
                } else throw new Exception("Creating staff failed, no ID obtained.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }
            return true;
        }
        //Return true if success, otherwise return false
        public boolean updatePeople (Person person){
            String sql = "UPDATE people SET name=?,dateOfBirth=DATE(?),description=?,jobs=? WHERE personId=?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, person.getName());
                pstmt.setString(2, person.getDateOfBirth().toString());
                pstmt.setString(3, person.getDescription());
                pstmt.setString(4, person.getJob().toString());
                pstmt.setLong(5, person.getPersonId());
                int affected = pstmt.executeUpdate();
                if (affected == 0)
                    throw new Exception("Person (ID = " + person.getPersonId() + ") does not exist in \"people\" table.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }
            return true;
        }
        //Return true if success, otherwise return false
        public boolean deletePerson(Person person){
            String sql = "DELETE FROM people WHERE personId = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setLong(1, person.getPersonId());
                int affected = pstmt.executeUpdate();
                if (affected == 0)
                    throw new Exception("Person (ID = " + person.getPersonId() + ") does not exist in \"people\" table.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }
            return true;
        }

        // PRODUCT

    public boolean createProductsTable() {
        String sql = "CREATE TABLE products ("
                +  "productId      INTEGER PRIMARY KEY AUTOINCREMENT,"
                +  "productInfoId  TEXT    NOT NULL,"
                +  "productType    TEXT    NOT NULL,"
                +  "state          TEXT    NOT NULL,"
                +  "importBillId   TEXT    NOT NULL,"
                +  "saleBillId     TEXT    NOT NULL,"
                +  "importCost     DOUBLE  NOT NULL,"
                +  "saleValue      DOUBLE  NOT NULL,"
                +  "trialFilename  TEXT    NOT NULL,"
                +  "placement      TEXT    NOT NULL,"
                +  ");";
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_products_productId ON products(productId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void loadProducts(DbAdapterCache cache) throws Exception{
        String sql = "SELECT productId, name, isMale, dateOfBirth, email, phoneNumber, description, state FROM products";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Product product;
        while (rs.next()) {
            product = new Product();
            product.setProductId(rs.getLong("productId"));
            product.getProductInfo().setProductInfoId(rs.getLong("productInfoId"));
            product.setProductType(ProductType.valueOf(rs.getString("productType")));
            product.setState(ProductState.valueOf(rs.getString("productState")));
            product.getImportBill().setBillId(rs.getInt("importBillId"));
            product.getSaleBill().setBillId(rs.getInt("saleBillId"));
            product.setImportCost(rs.getDouble("importCost"));
            product.setTrialFilename(rs.getString("trialFilename"));
            product.setPlacement(rs.getString("placement"));
            cache.getProducts().add(product);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertProduct(Product product) {
        if(product.getProductId() != 0) return false;
        String sql = "INSERT INTO products(productInfoId, productType, productState, importBillId, saleBillId, importCost, trialFilename,placement) VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, product.getProductInfo().getProductInfoId());
            pstmt.setString(2, product.getProductType().toString());
            pstmt.setString(3, product.getState().toString());
            pstmt.setInt(4, product.getImportBill().getBillId());
            pstmt.setInt(5, product.getSaleBill().getBillId());
            pstmt.setDouble(6, product.getImportCost());
            pstmt.setString(7, product.getTrialFilename());
            pstmt.setString(8, product.getPlacement());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating product failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setProductId(generatedKeys.getLong(1));
            }
            else throw new Exception("Creating product failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET productInfoId=?,productType=?,productState=?,importBillId=?,saleBillId=?,importCost=?,trialFilename=?,placement=? WHERE productId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, product.getProductInfo().getProductInfoId());
            pstmt.setString(2, product.getProductType().toString());
            pstmt.setString(3, product.getState().toString());
            pstmt.setInt(4, product.getImportBill().getBillId());
            pstmt.setInt(5, product.getSaleBill().getBillId());
            pstmt.setDouble(6, product.getImportCost());
            pstmt.setString(7, product.getTrialFilename());
            pstmt.setString(8, product.getPlacement());
            pstmt.setLong(9, product.getProductId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Product (ID = " + product.getProductId() + ") does not exist in \"products\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean deleteProduct(Product product) {
        String sql = "DELETE FROM products WHERE productId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, product.getProductId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Product (ID = " + product.getProductId() + ") does not exist in \"products\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    //PUBLISHER
    public boolean createPublishersTable() {
        String sql = "CREATE TABLE publishers ("
                +  "publisherId    LONG PRIMARY KEY AUTOINCREMENT,"
                +  "name           TEXT    NOT NULL,"
                +  "address        TEXT    NOT NULL,"
                +  "description    TEXT    NOT NULL,"
                +  ");";
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_publishers_publisherId ON publishers(publisherId );");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void loadPublishers(DbAdapterCache cache) throws Exception{
        String sql = "SELECT publisherId, name, address, description  FROM publishers";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Publisher publisher;
        while (rs.next()) {
            publisher = new Publisher();
            publisher.setPublisherId(rs.getLong("publisherId"));
            publisher.setName(rs.getString("name"));
            publisher.setAddress(rs.getString("address"));
            publisher.setDescription(rs.getString("description"));
            cache.getPublishers().add(publisher);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertPublisher(Publisher publisher) {
        if(publisher.getPublisherId() != 0) return false;
        String sql = "INSERT INTO publishers(name, address, description) VALUES(?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, publisher.getName());
            pstmt.setString(2, publisher.getAddress());
            pstmt.setString(3, publisher.getDescription());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating publisher failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                publisher.setPublisherId(generatedKeys.getLong(1));
            }
            else throw new Exception("Creating publisher failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean updatePublisher(Publisher publisher) {
        String sql = "UPDATE publishers SET name=?,address=?,description=? WHERE publisherId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, publisher.getName());
            pstmt.setString(2, publisher.getAddress());
            pstmt.setString(3, publisher.getDescription());
            pstmt.setLong(4, publisher.getPublisherId());

            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Publisher (ID = " + publisher.getPublisherId() + ") does not exist in \"publishers\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean deletePublisher(Publisher publisher) {
        String sql = "DELETE FROM publishers WHERE publisherId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, publisher.getPublisherId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Publisher (ID = " + publisher.getPublisherId() + ") does not exist in \"publishers\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

}
