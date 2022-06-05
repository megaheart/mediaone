package com.shopkeeper.lam.database;
import com.shopkeeper.mediaone.database.DbAdapterCache;
import com.shopkeeper.mediaone.database.ReadOnlyDbAdapterCache;
import javafx.collections.ObservableList;
import com.shopkeeper.lam.models.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MusicInfoDbSet {
    private Connection conn;
    private ReadOnlyDbAdapterCache readOnlyCache;
    private ObservableList<MusicInfo> list;
    public MusicInfoDbSet(Connection conn, ReadOnlyDbAdapterCache cache, ObservableList<MusicInfo> musicInfos){
        this.conn = conn;
        this.list = musicInfos;
        this.readOnlyCache = cache;
    }
    public boolean createTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE musicInfos (");
        sqlBuilder.append("productInfoId     INTEGER  PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("title             TEXT     NOT NULL,");
        sqlBuilder.append("description       TEXT     NOT NULL,");
        sqlBuilder.append("categoryId        INTEGER  NOT NULL,");
        sqlBuilder.append("releaseDate       TEXT     NOT NULL,");
        sqlBuilder.append("currentSalePrice  DOUBLE   NOT NULL,");
        sqlBuilder.append("publisherId       INTEGER  NOT NULL,");
        sqlBuilder.append("rating            DOUBLE   NOT NULL,");
        sqlBuilder.append("award             TEXT     NOT NULL");
        sqlBuilder.append("musiciansId       TEXT     NOT NULL,");
        sqlBuilder.append("timeLimit         TEXT     NOT NULL");
        sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
        try (Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            //Indexes
            stmt.execute("CREATE UNIQUE INDEX idx_musicInfos_productInfoId ON musicInfos(productInfoId);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void load(DbAdapterCache cache) throws Exception {
        String sql = "SELECT productInfoId, title, description,categoryId,releaseDate,currentSalePrice,publisherId,rating,award,musiciansId,timeLimit FROM musicInfos";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        MusicInfo productInfo = null;
        String[] musiciansId;
        String[] award;
        ArrayList<String> awards = new ArrayList<>();
        ArrayList<Person> musicians = new ArrayList<>();
        ObservableList<Person> peopleList = cache.getPeople();
        while (rs.next()) {
            productInfo = new MusicInfo();
            productInfo.setProductInfoId(rs.getInt("productInfoId"));
            productInfo.setTitle(rs.getString("title"));
            productInfo.setDescription(rs.getString("description"));
            productInfo.getCategory().setCategoryId(rs.getInt("categoryId"));
            productInfo.setReleaseDate(LocalDate.parse(rs.getString("releaseDate")));
            productInfo.setCurrentSalePrice(rs.getDouble("currentSalePrice"));
            productInfo.getPublisher().setPublisherId(rs.getInt("publisherId"));
            productInfo.setRating(rs.getDouble("rating"));
            musiciansId = rs.getString("musiciansId").split("_");
            productInfo.setTimeLimit(LocalTime.parse(rs.getString("timeLimit")));
            //gan cho musicians
            for (String musiciansIdString: musiciansId){
                for (Person person: peopleList){
                    if (person.getPersonId() == Integer.parseInt(musiciansIdString)){
                        musicians.add(person);
                        break;
                    }
                }
            }
            productInfo.setMusicians(musicians);
            //gan cho awards
            award=rs.getString("awards").split("_");
            for(String i : award){
                awards.add(i);
            }
            productInfo.setAward(awards);
            list.add((MusicInfo) productInfo);
        }

        rs.close();
        stmt.close();
    }

    public boolean insert(MusicInfo musicInfo) {
        if(musicInfo.getProductInfoId() != 0) return false;
        String sql = "INSERT INTO musicInfos(title, description, categoryId,releaseDate,currentSalePrice,publisherId,rating,award,musiciansId,timeLimit ) VALUES(?,?,?,DATE(?),?,?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, musicInfo.getTitle());
            pstmt.setString(2, musicInfo.getDescription());
            pstmt.setInt(3,musicInfo.getCategory().getCategoryId());
            pstmt.setString(4, musicInfo.getReleaseDate().toString());
            pstmt.setDouble(5,musicInfo.getCurrentSalePrice());
            pstmt.setInt(6, musicInfo.getPublisher().getPublisherId());
            pstmt.setDouble(7, musicInfo.getRating());
            String award="";
            for(String a : musicInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(8, award);//1 String cac ten award,ngan cach boi dau _
            String musiciansId="";
            for(Person person : musicInfo.getMusicians()){
                musiciansId+=(person.getPersonId()+"_");
            }
            pstmt.setString(9, musiciansId);//1 String cac contributorId,ngan cach boi dau _
            pstmt.setString(10, musicInfo.getTimeLimit().toString());

            int affected = pstmt.executeUpdate();
            if (affected == 0) throw new Exception("Creating musicInfo failed, no rows affected.");
            //Auto set ID
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                musicInfo.setProductInfoId(generatedKeys.getInt(11));
            } else throw new Exception("Creating musicInfo failed, no ID obtained.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        list.add(musicInfo);
        return true;
    }
    public boolean update(MusicInfo musicInfo) {
        if(!list.contains(musicInfo))
        {
            System.err.println("musicInfo is not in DbAdapter's cache");
            return false;
        }
        String sql = "UPDATE musicInfos SET title=?, description=?, categoryId=?,releaseDate=DATE(?),currentSalePrice=?,publisherId=?,rating=?,award=?,musiciansId=?,timeLimit=?  WHERE productInfo=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, musicInfo.getTitle());
            pstmt.setString(2, musicInfo.getDescription());
            pstmt.setInt(3,musicInfo.getCategory().getCategoryId());
            pstmt.setString(4, musicInfo.getReleaseDate().toString());
            pstmt.setDouble(5,musicInfo.getCurrentSalePrice());
            pstmt.setInt(6, musicInfo.getPublisher().getPublisherId());
            pstmt.setDouble(7, musicInfo.getRating());
            String award="";
            for(String a : musicInfo.getAward()){
                award+=(a+"_");
            }
            pstmt.setString(8, award);//1 String cac ten award,ngan cach boi dau _
            String musiciansId="";
            for(Person person : musicInfo.getMusicians()){
                musiciansId+=(person.getPersonId()+"_");
            }
            pstmt.setString(9, musiciansId);//1 String cac contributorId,ngan cach boi dau _
            pstmt.setString(10, musicInfo.getTimeLimit().toString());
            pstmt.setInt(11,musicInfo.getProductInfoId());
            int affected = pstmt.executeUpdate();
            if (affected == 0)
                throw new Exception("musicInfo (ID = " + musicInfo.getProductInfoId() + ") does not exist in \"musicInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean delete(MusicInfo musicInfo) {
        if(musicInfo.countTimesToBeReferenced() != 0) {
            System.err.println("Something have referenced to this musicInfo.");
            return false;
        }
        int index = list.indexOf(musicInfo);
        if(index < 0){
            System.err.println("musicInfo is not in DbAdapter's cache");
            return false;
        }

        String sql = "DELETE FROM musicInfos WHERE productInfoId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(11, musicInfo.getProductInfoId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("MusicInfo (ID = " + musicInfo.getProductInfoId() + ") does not exist in \"musicInfos\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

        //When Success
        list.remove(index, index + 1);
        return true;
    }
}
