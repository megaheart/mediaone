package com.shopkeeper.lam.database;
import com.shopkeeper.mediaone.database.DbAdapterCache;
import com.shopkeeper.mediaone.database.ReadOnlyDbAdapterCache;
import javafx.collections.ObservableList;
import com.shopkeeper.lam.models.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class BookInfoDbSet {
    private Connection conn;
    private ReadOnlyDbAdapterCache readOnlyCache;
    private ObservableList<BookInfo> list;
    public BookInfoDbSet(Connection conn, ReadOnlyDbAdapterCache cache, ObservableList<BookInfo> bookInfos){
        this.conn = conn;
        this.list = bookInfos;
        this.readOnlyCache = cache;
    }
    public boolean createTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE bookInfos (");
        sqlBuilder.append("productInfoId     INTEGER  PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("title             TEXT     NOT NULL,");
        sqlBuilder.append("description       TEXT     NOT NULL,");
        sqlBuilder.append("categoryId        INTEGER  NOT NULL,");
        sqlBuilder.append("releaseDate       TEXT     NOT NULL,");
        sqlBuilder.append("currentSalePrice  DOUBLE   NOT NULL,");
        sqlBuilder.append("publisherId       INTEGER  NOT NULL,");
        sqlBuilder.append("rating            DOUBLE   NOT NULL,");
        sqlBuilder.append("award             TEXT     NOT NULL,");
        sqlBuilder.append("authorsId         TEXT     NOT NULL,");
        sqlBuilder.append("numberOfPage      TEXT     NOT NULL");
        sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_bookInfos_productInfoId ON bookInfos(productInfoId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void load() throws Exception {
        String sql = "SELECT productInfoId, title, description,categoryId,releaseDate,currentSalePrice,publisherId,rating,award,authorsId,numberOfPage FROM bookInfos";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        BookInfo productInfo = null;
        String[] authorsId;
        String[] award;
        ArrayList<String> awards = new ArrayList<>();
        ArrayList<Person> authors = new ArrayList<>();
        ObservableList<Person> peopleList = readOnlyCache.getPeople();
        while (rs.next()) {
            productInfo = new BookInfo();
            productInfo.setProductInfoId(rs.getInt("productInfoId"));
            productInfo.setTitle(rs.getString("title"));
            productInfo.setDescription(rs.getString("description"));
            productInfo.getCategory().setCategoryId(rs.getInt("categoryId"));
            productInfo.setReleaseDate(LocalDate.parse(rs.getString("releaseDate")));
            productInfo.setCurrentSalePrice(rs.getDouble("currentSalePrice"));
            productInfo.getPublisher().setPublisherId(rs.getInt("publisherId"));
            productInfo.setRating(rs.getDouble("rating"));
            productInfo.setNumberOfPage(rs.getInt("numberOfPage"));
            authorsId = rs.getString("authorsId").split("_");
            //gan cho awards
            award=rs.getString("awards").split("_");
            for(String i : award){
                awards.add(i);
            }
            productInfo.setAward(awards);
            for (String authorIdString: authorsId){
                for (Person person: peopleList){
                    if (person.getPersonId() == Integer.parseInt(authorIdString)){
                        authors.add(person);
                        break;
                    }
                }
            }
            productInfo.setAuthors(authors);

            list.add(productInfo);
        }
        rs.close();
        stmt.close();
    }

    public boolean insert(BookInfo bookInfo) {
        if(bookInfo.getProductInfoId() != 0) return false;
        String sql = "INSERT INTO categories(title, description, categoryId,releaseDate,currentSalePrice,publisherId,rating,award,authorsId,numberOfPage ) VALUES(?,?,?,DATE(?),?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, bookInfo.getTitle());
            pstmt.setString(2, bookInfo.getDescription());
            pstmt.setInt(3,bookInfo.getCategory().getCategoryId());
            pstmt.setString(4, bookInfo.getReleaseDate().toString());
            pstmt.setDouble(5,bookInfo.getCurrentSalePrice());
            pstmt.setInt(6, bookInfo.getPublisher().getPublisherId());
            pstmt.setDouble(7, bookInfo.getRating());
            String award="";
            for(String a : bookInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(8, award);
            String authorsId="";
            for(Person person : bookInfo.getAuthors()){
                authorsId+=(person.getPersonId()+"_");
            }
            pstmt.setString(9, authorsId);
            pstmt.setInt(10, bookInfo.getNumberOfPage());
            int affected = pstmt.executeUpdate();
            if (affected == 0) throw new Exception("Creating bookInfo failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                bookInfo.setProductInfoId(generatedKeys.getInt(1));
            } else throw new Exception("Creating bookInfo failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        list.add(bookInfo);
        return true;
    }
    public boolean update(BookInfo bookInfo) {
        if(!list.contains(bookInfo))
        {
            System.err.println("bookInfo is not in DbAdapter's cache");
            return false;
        }
        String sql = "UPDATE bookInfos SET title=?, description=?, categoryId=?,releaseDate=DATE(?),currentSalePrice=?,publisherId=?,rating=?,award=?,authorsId=?,numberOfPage=?  WHERE productInfo=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bookInfo.getTitle());
            pstmt.setString(2, bookInfo.getDescription());
            pstmt.setInt(3,bookInfo.getCategory().getCategoryId());
            pstmt.setString(4, bookInfo.getReleaseDate().toString());
            pstmt.setDouble(5,bookInfo.getCurrentSalePrice());
            pstmt.setInt(6, bookInfo.getPublisher().getPublisherId());
            pstmt.setDouble(7, bookInfo.getRating());
            String award="";
            for(String a : bookInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(8, award);
            String authorsId="";
            for(Person person : bookInfo.getAuthors()){
                authorsId+=(person.getPersonId()+"_");
            }
            pstmt.setString(9, authorsId);
            pstmt.setInt(10, bookInfo.getNumberOfPage());

            pstmt.setInt(11,bookInfo.getProductInfoId());
            int affected = pstmt.executeUpdate();
            if (affected == 0)
                throw new Exception("bookInfo (ID = " + bookInfo.getProductInfoId() + ") does not exist in \"bookInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean delete(BookInfo bookInfo) {
        if(bookInfo.countTimesToBeReferenced() != 0) {
            System.err.println("Something have referenced to this bookInfo.");
            return false;
        }
        int index = list.indexOf(bookInfo);
        if(index < 0){
            System.err.println("bookInfo is not in DbAdapter's cache");
            return false;
        }

        String sql = "DELETE FROM bookInfos WHERE productInfoId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookInfo.getProductInfoId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("bookInfo (ID = " + bookInfo.getProductInfoId() + ") does not exist in \"bookInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        //When Success
        list.remove(index, index + 1);
        return true;
    }
}
