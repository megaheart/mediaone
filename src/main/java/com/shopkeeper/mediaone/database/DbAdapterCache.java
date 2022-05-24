package com.shopkeeper.mediaone.database;

import java.util.ArrayList;
import com.shopkeeper.linh.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DbAdapterCache {
    private ObservableList<Staff> staffs;
    public ObservableList<Staff> getStaffs(){
        return staffs;
    }
    private Settings settings;
    public Settings getSettings(){
        return settings;
    }
    private ObservableList<Customer> customers;
    public ObservableList<Customer> getCustomers(){
        return customers;
    }
    public DbAdapterCache(){
        staffs = FXCollections.observableArrayList();
        settings = new Settings();
        customers = FXCollections.observableArrayList();
    }
}
