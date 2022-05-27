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
    }
