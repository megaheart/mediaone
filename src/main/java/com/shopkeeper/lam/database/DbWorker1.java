/*
package com.shopkeeper.lam.database;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DbAdapterCache;
import javafx.collections.ObservableList;

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
        if (!createCategoriesTable()) throw new Exception("DatabaseWorker1 created Category tables false");
        if (!createPeopleTable()) throw new Exception("DatabaseWorker1 created People tables false");
        if(!createProductsTable()) throw new Exception("DatabaseWorker1 created Products tables false");
        if(!createPublishersTable()) throw new Exception("DatabaseWorker1 created Publishers tables false");
        if(!createProductInfosTable()) throw new Exception("DatabaseWorker1 created ProductInfos tables false");
    }

    //LOAD
    public void load1(DbAdapterCache cache) throws Exception{
        loadCategories(cache);
        loadPeople(cache);
        loadPublishers(cache);
    }
    public void load2(DbAdapterCache cache) throws Exception{
        loadProductInfos(cache);
    }
    public void load3(DbAdapterCache cache) throws Exception{
        loadProducts(cache);
    }

    //CATEGORY

    public boolean createCategoriesTable() {
        String sql = "CREATE TABLE categories ("
                + "categoryId     INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name           TEXT      NOT NULL,"
                + "description    TEXT      NOT NULL,"
                + "productType    TEXT  NOT NULL"
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
            category.setCategoryId(rs.getInt("categoryId"));
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
                category.setCategoryId(generatedKeys.getInt(4));
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
            pstmt.setString(2, category.getDescription());
            pstmt.setString(3, category.getProductType().toString());
            pstmt.setLong(4, category.getCategoryId());
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
    public boolean deleteCategory(Category category) {
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

    public boolean createPeopleTable() {
        String sql = "CREATE TABLE people ("
                + "personId      INTEGER  PRIMARY KEY AUTOINCREMENT,"
                + "name          TEXT     NOT NULL,"
                + "dateOfBirth   TEXT     NOT NULL,"
                + "description   TEXT     NOT NULL,"
                + "job           TEXT     NOT NULL"
                + ");";
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_people_personId ON people(personId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void loadPeople(DbAdapterCache cache) throws Exception {
        String sql = "SELECT personId, name, dateOfBirth, description,job FROM people";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Person person;

        while (rs.next()) {
            person = new Person();
            person.setPersonId(rs.getInt("personId"));
            person.setName(rs.getString("name"));
            person.setDateOfBirth(LocalDate.parse(rs.getString("dateOfBirth")));
            person.setDescription(rs.getString("description"));
            person.setJob(JobOfPerson.valueOf(rs.getString("job")));

            cache.getPeople().add(person);
        }
            rs.close();
            stmt.close();
        }
        //Auto set id for staff after it was inserted
        //Return true if success, otherwise return false
        public boolean insertPerson(Person person){
            if (person.getPersonId() != 0) return false;
            String sql = "INSERT INTO people(name, dateOfBirth, description, job) VALUES(?,DATE(?),?,?)";

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
                    person.setPersonId(generatedKeys.getInt(5));
                } else throw new Exception("Creating staff failed, no ID obtained.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                return false;
            }
            return true;
        }
        //Return true if success, otherwise return false
        public boolean updatePerson (Person person){
            String sql = "UPDATE people SET name=?,dateOfBirth=DATE(?),description=?,job=? WHERE personId=?";

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
                +  "productInfoId  INTEGER NOT NULL,"
                +  "productType    TEXT    NOT NULL,"
                +  "state          TEXT    NOT NULL,"
                +  "importBillId   TEXT    NOT NULL,"
                +  "saleBillId     TEXT    NOT NULL,"
                +  "importCost     DOUBLE  NOT NULL,"
                +  "saleValue      DOUBLE  NOT NULL,"
                +  "trialFilename  TEXT    NOT NULL,"
                +  "placement      TEXT    NOT NULL"
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
        String sql = "SELECT productId, productInfoId, productType, state, importBillId, saleBillId, importCost, saleValue,trialFilename,placement FROM products";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        Product product;
        while (rs.next()) {
            product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.getProductInfo().setProductInfoId(rs.getInt("productInfoId"));
            product.setProductType(ProductType.valueOf(rs.getString("productType")));
            product.setState(ProductState.valueOf(rs.getString("productState")));
            product.getImportBill().setBillId(rs.getInt("importBillId"));
            product.getSaleBill().setBillId(rs.getInt("saleBillId"));
            product.setSaleValue(rs.getDouble("saleValue"));
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
        String sql = "INSERT INTO products(productInfoId, productType, productState, importBillId, saleBillId, importCost,saleValue, trialFilename,placement) VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, product.getProductInfo().getProductInfoId());
            pstmt.setString(2, product.getProductType().toString());
            pstmt.setString(3, product.getState().toString());
            pstmt.setInt(4, product.getImportBill().getBillId());
            pstmt.setInt(5, product.getSaleBill().getBillId());
            pstmt.setDouble(6, product.getImportCost());
            pstmt.setDouble(7, product.getSaleValue());
            pstmt.setString(8, product.getTrialFilename());
            pstmt.setString(9, product.getPlacement());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating product failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setProductId(generatedKeys.getInt(10));
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
        String sql = "UPDATE products SET productInfoId=?,productType=?,productState=?,importBillId=?,saleBillId=?,importCost=?,saleValue,trialFilename=?,placement=? WHERE productId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, product.getProductInfo().getProductInfoId());
            pstmt.setString(2, product.getProductType().toString());
            pstmt.setString(3, product.getState().toString());
            pstmt.setInt(4, product.getImportBill().getBillId());
            pstmt.setInt(5, product.getSaleBill().getBillId());
            pstmt.setDouble(6, product.getImportCost());
            pstmt.setDouble(7, product.getSaleValue());
            pstmt.setString(8, product.getTrialFilename());
            pstmt.setString(9, product.getPlacement());
            pstmt.setLong(10, product.getProductId());
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
                +  "publisherId    INTEGER PRIMARY KEY AUTOINCREMENT,"
                +  "name           TEXT    NOT NULL,"
                +  "address        TEXT    NOT NULL,"
                +  "description    TEXT    NOT NULL"
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
            publisher.setPublisherId(rs.getInt("publisherId"));
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
                publisher.setPublisherId(generatedKeys.getInt(4));
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

    //ProductInfo

    public boolean createProductInfosTable() {
        String sql = "CREATE TABLE productInfos ("
                +  "productInfoId     INTEGER  PRIMARY KEY AUTOINCREMENT,"
                +  "title             TEXT     NOT NULL,"
                +  "description       TEXT     NOT NULL,"
                +  "categoryId        INTEGER  NOT NULL,"
                +  "productType       TEXT     NOT NULL,"
                +  "releaseDate       TEXT     NOT NULL,"
                +  "currentSalePrice  DOUBLE   NOT NULL,"
                +  "publisherId       INTEGER  NOT NULL,"
                +  "contributors      TEXT     NOT NULL,"
                +  "rating            DOUBLE   NOT NULL,"
                +  "award             TEXT     NOT NULL"
                +  ");";
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_productInfos_productInfoId ON productInfos(productInfoId );");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public void loadProductInfos(DbAdapterCache cache) throws Exception{
        String sql = "SELECT productInfoId, title, description, categoryId, productType, releaseDate, currentSalePrice, publisherId, contributorsId, rating, award  FROM productInfos";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);
        ProductInfo productInfo = null;
        String[] contributorsId;
        String[] award;
        ArrayList<String> awards = new ArrayList<>();
        ArrayList<Person> contributors = new ArrayList<>();
        ObservableList<Person> peopleList = cache.getPeople();

        while (rs.next()) {
            if(rs.getString("productType").equals("BOOK")){
                productInfo = new BookInfo();
            }
            if(rs.getString("productType").equals("SONG")){
                productInfo = new MusicInfo();
            }
            if(rs.getString("productType").equals("FILM")){
                productInfo = new FilmInfo();
            }

            productInfo.setProductInfoId(rs.getInt("productInfoId"));
            productInfo.setTitle(rs.getString("name"));
            productInfo.setDescription(rs.getString("description"));
            productInfo.getCategory().setCategoryId(rs.getInt("categoryId"));
            productInfo.setProductType(ProductType.valueOf(rs.getString("productType")));
            productInfo.setReleaseDate(LocalDate.parse(rs.getString("releaseDate")));
            productInfo.setCurrentSalePrice(rs.getDouble("currentSalePrice"));
            productInfo.getPublisher().setPublisherId(rs.getInt("publisherId"));
            productInfo.setRating(rs.getDouble("rating"));
            contributorsId = rs.getString("contributorsId").split("_");
            //gan cho contributors
            for (String contributorIdString: contributorsId){
                for (Person person: peopleList){
                    if (person.getPersonId() == Long.parseLong(contributorIdString)){
                        contributors.add(person);
                        break;
                    }
                }
            }
            productInfo.setContributors(contributors);
            //gan cho awards
            award=rs.getString("awards").split("_");
            for(String i : award){
                awards.add(i);
            }
            productInfo.setAward(awards);

            //cache.getProductInfos().add(productInfo);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insertProductInfo(ProductInfo productInfo) {
        if(productInfo.getProductInfoId() != 0) return false;
        String sql = "INSERT INTO productInfos(title, description, categoryId, productType, releaseDate, currentSalePrice, publisherId, contributorsId, rating, award) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, productInfo.getTitle());
            pstmt.setString(2, productInfo.getDescription());
            pstmt.setLong(3, productInfo.getCategory().getCategoryId());
            pstmt.setString(4, productInfo.getProductType().toString());
            pstmt.setString(5, productInfo.getReleaseDate().toString());
            pstmt.setDouble(6, productInfo.getCurrentSalePrice());
            pstmt.setLong(7, productInfo.getPublisher().getPublisherId());
            String contributorsId="";
            for(Person person : productInfo.getContributors()){
                contributorsId+=(person.getPersonId()+"_");
            }
            pstmt.setString(8, contributorsId);//1 String cac contributorId,ngan cach boi dau _
            pstmt.setDouble(9, productInfo.getRating());
            String award="";
            for(String a : productInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(10, award);//1 String cac ten award,ngan cach boi dau _

            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Creating productInfo failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                productInfo.setProductInfoId(generatedKeys.getInt(11));
            }
            else throw new Exception("Creating productInfo failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean updateProductInfo(ProductInfo productInfo) {
        String sql = "UPDATE productInfos SET title=?, description=?, categoryId=?, productType=?, releaseDate=?, currentSalePrice=?, publisherId=?, contributorsId=?, rating=?, award=? WHERE productInfoId=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productInfo.getTitle());
            pstmt.setString(2, productInfo.getDescription());
            pstmt.setLong(3, productInfo.getCategory().getCategoryId());
            pstmt.setString(4, productInfo.getProductType().toString());
            pstmt.setString(5, productInfo.getReleaseDate().toString());
            pstmt.setDouble(6, productInfo.getCurrentSalePrice());
            pstmt.setLong(7, productInfo.getPublisher().getPublisherId());
            String contributorsId="";
            for(Person person : productInfo.getContributors()){
                contributorsId+=(person.getPersonId()+"_");
            }
            pstmt.setString(8, contributorsId);//1 String cac contributorId,ngan cach boi dau _
            pstmt.setDouble(9, productInfo.getRating());
            String award="";
            for(String a : productInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(10, award);//1 String cac ten award,ngan cach boi dau _
            pstmt.setLong(11, productInfo.getProductInfoId());

            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("ProductInfo (ID = " + productInfo.getProductInfoId() + ") does not exist in \"productInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //Return true if success, otherwise return false
    public boolean deleteProductInfo(ProductInfo productInfo) {
        String sql = "DELETE FROM productInfos WHERE productInfoId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, productInfo.getProductInfoId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("ProductInfo (ID = " + productInfo.getProductInfoId() + ") does not exist in \"productInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

}
*/
