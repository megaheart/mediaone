package com.shopkeeper.lam.database;
import com.shopkeeper.mediaone.database.DbAdapterCache;
import com.shopkeeper.mediaone.database.ReadOnlyDbAdapterCache;
import javafx.collections.ObservableList;
import com.shopkeeper.lam.models.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FilmInfoDbSet {
    private Connection conn;
    private ReadOnlyDbAdapterCache readOnlyCache;
    private ObservableList<FilmInfo> list;
    public FilmInfoDbSet(Connection conn, ReadOnlyDbAdapterCache cache, ObservableList<FilmInfo> filmInfos){
        this.conn = conn;
        this.list = filmInfos;
        this.readOnlyCache = cache;
    }
    public boolean createTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE filmInfos (");
        sqlBuilder.append("productInfoId     INTEGER  PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("title             TEXT     NOT NULL,");
        sqlBuilder.append("description       TEXT     NOT NULL,");
        sqlBuilder.append("categoryId        INTEGER  NOT NULL,");
        sqlBuilder.append("releaseDate       TEXT     NOT NULL,");
        sqlBuilder.append("currentSalePrice  DOUBLE   NOT NULL,");
        sqlBuilder.append("publisherId       INTEGER  NOT NULL,");
        sqlBuilder.append("rating            DOUBLE   NOT NULL,");
        sqlBuilder.append("award             TEXT     NOT NULL");
        sqlBuilder.append("directorId        TEXT     NOT NULL");
        sqlBuilder.append("actorsId          TEXT     NOT NULL,");
        sqlBuilder.append("timeLimit         TEXT     NOT NULL");
        sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_filmInfos_productInfoId ON filmInfos(productInfoId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void load(DbAdapterCache cache) throws Exception {
        String sql = "SELECT productInfoId, title, description,categoryId,releaseDate,currentSalePrice,publisherId,rating,award,directorId,actorsId,timeLimit FROM filmInfos";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        FilmInfo productInfo = null;
        String[] actorsId;
        String[] award;
        ArrayList<String> awards = new ArrayList<>();
        ArrayList<Person> actors = new ArrayList<>();
        ObservableList<Person> peopleList = cache.getPeople();
        while (rs.next()) {
            productInfo = new FilmInfo();
            productInfo.setProductInfoId(rs.getInt("productInfoId"));
            productInfo.setTitle(rs.getString("title"));
            productInfo.setDescription(rs.getString("description"));
            productInfo.getCategory().setCategoryId(rs.getInt("categoryId"));
            productInfo.setReleaseDate(LocalDate.parse(rs.getString("releaseDate")));
            productInfo.setCurrentSalePrice(rs.getDouble("currentSalePrice"));
            productInfo.getPublisher().setPublisherId(rs.getInt("publisherId"));
            productInfo.setRating(rs.getDouble("rating"));
            actorsId = rs.getString("actorsId").split("_");
            productInfo.setTimeLimit(LocalTime.parse(rs.getString("timeLimit")));
            productInfo.getDirector().setPersonId(rs.getInt("directorId"));
            //gan cho actors
            for (String actorsIdString: actorsId){
                for (Person person: peopleList){
                    if (person.getPersonId() == Integer.parseInt(actorsIdString)){
                        actors.add(person);
                        break;
                    }
                }
            }
            productInfo.setActors(actors);
            //gan cho awards
            award=rs.getString("awards").split("_");
            for(String i : award){
                awards.add(i);
            }
            productInfo.setAward(awards);
            list.add((FilmInfo) productInfo);
        }

        rs.close();
        stmt.close();
    }

    public boolean insert(FilmInfo filmInfo) {
        if(filmInfo.getProductInfoId() != 0) return false;
        String sql = "INSERT INTO filmInfos(title, description, categoryId,releaseDate,currentSalePrice,publisherId,rating,award,directorId,actorsId,timeLimit ) VALUES(?,?,?,DATE(?),?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, filmInfo.getTitle());
            pstmt.setString(2, filmInfo.getDescription());
            pstmt.setInt(3,filmInfo.getCategory().getCategoryId());
            pstmt.setString(4, filmInfo.getReleaseDate().toString());
            pstmt.setDouble(5,filmInfo.getCurrentSalePrice());
            pstmt.setInt(6, filmInfo.getPublisher().getPublisherId());
            pstmt.setDouble(7, filmInfo.getRating());
            String award="";
            for(String a : filmInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(8, award);//1 String cac ten award,ngan cach boi dau _
            pstmt.setInt(9, filmInfo.getDirector().getPersonId());
            String actorsId="";
            for(Person person : filmInfo.getActors()){
                actorsId+=(person.getPersonId()+"_");
            }
            pstmt.setString(10, actorsId);//1 String cac contributorId,ngan cach boi dau _
            pstmt.setString(11, filmInfo.getTimeLimit().toString());

            int affected = pstmt.executeUpdate();
            if (affected == 0) throw new Exception("Creating filmInfo failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                filmInfo.setProductInfoId(generatedKeys.getInt(12));
            } else throw new Exception("Creating filmInfo failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        list.add(filmInfo);
        return true;
    }
    public boolean update(FilmInfo filmInfo) {
        if(!list.contains(filmInfo))
        {
            System.err.println("filmInfo is not in DbAdapter's cache");
            return false;
        }
        String sql = "UPDATE filmInfos SET title=?, description=?, categoryId=?,releaseDate=DATE(?),currentSalePrice=?,publisherId=?,rating=?,award=?,dicrectorId=?,actorsId=?,timeLimit=?  WHERE productInfo=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, filmInfo.getTitle());
            pstmt.setString(2, filmInfo.getDescription());
            pstmt.setInt(3,filmInfo.getCategory().getCategoryId());
            pstmt.setString(4, filmInfo.getReleaseDate().toString());
            pstmt.setDouble(5,filmInfo.getCurrentSalePrice());
            pstmt.setInt(6, filmInfo.getPublisher().getPublisherId());
            pstmt.setDouble(7, filmInfo.getRating());
            String award="";
            for(String a : filmInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(8, award);//1 String cac ten award,ngan cach boi dau _
            pstmt.setInt(9, filmInfo.getDirector().getPersonId());

            String actorsId="";
            for(Person person : filmInfo.getActors()){
                actorsId+=(person.getPersonId()+"_");
            }
            pstmt.setString(10, actorsId);//1 String cac contributorId,ngan cach boi dau _
            pstmt.setString(11, filmInfo.getTimeLimit().toString());
            pstmt.setInt(12,filmInfo.getProductInfoId());
            int affected = pstmt.executeUpdate();
            if (affected == 0)
                throw new Exception("filmInfo (ID = " + filmInfo.getProductInfoId() + ") does not exist in \"filmInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean delete(FilmInfo filmInfo) {
        if(filmInfo.countTimesToBeReferenced() != 0) {
            System.err.println("Something have referenced to this filmInfo.");
            return false;
        }
        int index = list.indexOf(filmInfo);
        if(index < 0){
            System.err.println("filmInfo is not in DbAdapter's cache");
            return false;
        }

        String sql = "DELETE FROM filmInfos WHERE productInfoId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(12, filmInfo.getProductInfoId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("FilmInfo (ID = " + filmInfo.getProductInfoId() + ") does not exist in \"filmInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        //When Success
        list.remove(index, index + 1);
        return true;
    }
}
