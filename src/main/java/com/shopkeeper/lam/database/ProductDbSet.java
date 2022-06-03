package com.shopkeeper.lam.database;
import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.mediaone.database.DbAdapterCache;
import com.shopkeeper.mediaone.database.ReadOnlyDbAdapterCache;
import javafx.collections.ObservableList;
import com.shopkeeper.lam.models.*;
import java.sql.*;
public class ProductDbSet {
    private Connection conn;
    private ReadOnlyDbAdapterCache readOnlyCache;
    private ObservableList<Product> list;
    public ProductDbSet(Connection conn, ReadOnlyDbAdapterCache cache, ObservableList<Product> products){
        this.conn = conn;
        this.list = products;
        this.readOnlyCache = cache;
    }
    public boolean createTable() {
        StringBuilder sqlBuilder = new StringBuilder("CREATE TABLE products (");
                sqlBuilder.append("productId      INTEGER PRIMARY KEY AUTOINCREMENT,");
                sqlBuilder.append("productInfoId  INTEGER NOT NULL,");
                sqlBuilder.append("productType    TEXT    NOT NULL,");
                sqlBuilder.append("state          TEXT    NOT NULL,");
                sqlBuilder.append("importBillId   TEXT    NOT NULL,");
                sqlBuilder.append("saleBillId     TEXT    NOT NULL,");
                sqlBuilder.append("importCost     DOUBLE  NOT NULL,");
                sqlBuilder.append("saleValue      DOUBLE  NOT NULL,");
                sqlBuilder.append("trialFilename  TEXT    NOT NULL,");
                sqlBuilder.append("placement      TEXT    NOT NULL");
                sqlBuilder.append(");");
        String sql = sqlBuilder.toString();
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
    public void load(DbAdapterCache cache) throws Exception{
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
            list.add(product);
        }

        rs.close();
        stmt.close();
    }
    //Auto set id for staff after it was inserted
    //Return true if success, otherwise return false
    public boolean insert(Product product) {
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
//Success
        list.add(product);
        return true;
    }
    //Return true if success, otherwise return false
    public boolean update(Product product) {
        if(!list.contains(product))
        {
            System.err.println("customer is not in DbAdapter's cache");
            return false;
        }
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
        if(product.countTimesToBeReferenced() != 0) {
            System.err.println("Something have referenced to this product.");
            return false;
        }
        int index = list.indexOf(product);
        if(index < 0){
            System.err.println("product is not in DbAdapter's cache");
            return false;
        }
        String sql = "DELETE FROM products WHERE productId = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, product.getProductId());
            int affected = pstmt.executeUpdate();
            if(affected == 0) throw new Exception("Product (ID = " + product.getProductId() + ") does not exist in \"products\" table.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
//When Success
        list.remove(index, index + 1);
        return true;
    }

}
