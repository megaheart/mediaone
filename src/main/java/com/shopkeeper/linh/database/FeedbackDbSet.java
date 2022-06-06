package com.shopkeeper.linh.database;

import com.shopkeeper.linh.models.Feedback;
import com.shopkeeper.linh.models.FeedbackAbout;
import com.shopkeeper.linh.models.FeedbackType;
import com.shopkeeper.mediaone.database.DbAdapterCache;
import com.shopkeeper.mediaone.database.ReadOnlyDbAdapterCache;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class FeedbackDbSet {
    private Connection conn;
    private ReadOnlyDbAdapterCache readOnlyCache;
    private ObservableList<Feedback> list;
    public FeedbackDbSet(Connection conn, ReadOnlyDbAdapterCache cache, ObservableList<Feedback> saleBills){
        this.conn = conn;
        this.list = saleBills;
        this.readOnlyCache = cache;
    }
    public boolean createTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE feedbacks (");
        sqlBuilder.append("feedbackId  INTEGER PRIMARY KEY AUTOINCREMENT,");
        sqlBuilder.append("title                 TEXT        NOT NULL,");
        sqlBuilder.append("description           TEXT        NOT NULL,");
        sqlBuilder.append("feedbackAbout         TEXT        NOT NULL,");
        sqlBuilder.append("feedbackType          TEXT        NOT NULL,");
        sqlBuilder.append("productTargetId       TEXT        NOT NULL,");
        sqlBuilder.append("productInfoType       TEXT        NOT NULL,");
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
    public void load() throws Exception{
        String sql = "SELECT feedbackId, title, description, feedbackAbout, feedbackType, productTargetId, productInfoTargetId, productInfoRating, staffTargetId, isUseful, time, productInfoType FROM feedbacks";
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
            list.add(feedback);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insert(Feedback feedback) {
        if(feedback.getFeedbackId() != 0) return false;
        String sql = "INSERT INTO feedbacks(title, description, feedbackAbout, feedbackType, productTargetId, productInfoTargetId, productInfoRating, staffTargetId, isUseful, time, productInfoType) VALUES(?,?,?,?,?,?,?,?,?,DATE(?))";

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
                    pstmt.setString(11, "");//productInfoType
                    break;
                case ProductInfo:
                    pstmt.setInt(5, 0);//productTarget
                    pstmt.setLong(6, feedback.getProductInfoTarget().getProductInfoId());//productInfoTarget
                    pstmt.setInt(7, feedback.getProductInfoRating());//productInfoRating
                    pstmt.setLong(8, 0);//staffTarget
                    //pstmt.setString(11, "");//productInfoType
                    break;
                case  Product:
                    pstmt.setLong(5, feedback.getProductTarget().getProductId());//productTarget
                    pstmt.setString(6, "");//productInfoTarget
                    pstmt.setInt(7, 0);//productInfoRating
                    pstmt.setLong(8, 0);//staffTarget
                    pstmt.setString(11, "");//productInfoType
                    break;
                case Service:
                    pstmt.setLong(5, 0);//productTarget
                    pstmt.setString(6, "");//productInfoTarget
                    pstmt.setInt(7, 0);//productInfoRating
                    pstmt.setLong(8, 0);//staffTarget
                    pstmt.setString(11, "");//productInfoType
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
    public boolean update(Feedback feedback) {
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
    public boolean delete(Feedback feedback) {
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
}
