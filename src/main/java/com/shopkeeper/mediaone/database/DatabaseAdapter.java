package com.shopkeeper.mediaone.database;

import com.shopkeeper.linh.database.DbWorker2;
import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.Settings;
import com.shopkeeper.linh.models.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseAdapter {
    private static DatabaseAdapter _adapter;
    public static DatabaseAdapter getDbAdapter() throws Exception {
        if(_adapter == null){
            _adapter = new DatabaseAdapter();
            _adapter.load();
        }
        return _adapter;
    }
    private DbAdapterCache cache;
    private DbWorker2 worker2;
    private DatabaseAdapter() throws Exception {
        File dbFile = new File("mediaone.db");
        cache = new DbAdapterCache();
        if(dbFile.exists() && !dbFile.isDirectory()) {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mediaone.db");
            worker2 = new DbWorker2(conn/*, cache*/);

        }
        else{
            //Create new database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mediaone.db");
            worker2 = new DbWorker2(conn/*, cache*/);
            //initialize all tables
            worker2.initializeTables();

        }
    }
    private void load() throws Exception{
        worker2.load1(cache);


    }
    //region Staffs Database
    public ObservableList<Staff> getAllStaffs(){
        return FXCollections.unmodifiableObservableList(cache.getStaffs());
    }
    public boolean insertStaff(Staff staff){
        if(worker2.insertStaff(staff)){
            cache.getStaffs().add(staff);
            return true;
        }
        return false;
    }
    public boolean updateStaff(Staff staff) throws Exception{
        if(cache.getStaffs().contains(staff))
            return worker2.updateStaff(staff);
        throw new Exception("staff is not in DbAdapter's cache");
    }
    public boolean deleteStaff(Staff staff) throws Exception{
        if(cache.getStaffs().remove(staff)){
            return worker2.deleteStaff(staff);
        }
        throw new Exception("staff is not in DbAdapter's cache");

    }
    //endregion
    //region Settings
    public Settings getSettings(){
        return cache.getSettings();
    }
    public boolean updateSettings(Settings settings) throws Exception{
        if(cache.getSettings() == settings){
            return worker2.updateSettings(settings);
        }
        throw new Exception("settings is not in DbAdapter's cache");
    }
    public boolean resetSettings(Settings settings) throws Exception{
        if(cache.getSettings() == settings){
            return worker2.resetSettings(settings);
        }
        throw new Exception("settings is not in DbAdapter's cache");

    }
    //endregion
    //region Customers
    public ObservableList<Customer> getAllCustomers(){
        return FXCollections.unmodifiableObservableList(cache.getCustomers());
    }
    public boolean insertCustomer(Customer customer){
        if(worker2.insertCustomer(customer)){
            cache.getCustomers().add(customer);
            return true;
        }
        return false;
    }
    public boolean updateCustomer(Customer customer) throws Exception{
        if(cache.getCustomers().contains(customer))
            return worker2.updateCustomer(customer);
        throw new Exception("customer is not in DbAdapter's cache");
    }
    public boolean deleteCustomer(Customer customer) throws Exception{
        if(cache.getCustomers().remove(customer)){
            return worker2.deleteCustomer(customer);
        }
        throw new Exception("customer is not in DbAdapter's cache");

    }
    //endregion
    //region TextValue
    //Return true if success, otherwise return false
    public boolean setTextValue(String key, String value) {
        return worker2.setTextValue(key, value);
    }
    public String getTextValue(String key) {
        return worker2.getTextValue(key);
    }
    //endregion
    //region Feedback

    //endregion
}
