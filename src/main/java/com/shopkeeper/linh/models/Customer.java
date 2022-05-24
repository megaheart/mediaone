package com.shopkeeper.linh.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.security.InvalidParameterException;
import java.util.*;
import java.time.*;


public class Customer {
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDefaultLocation() {
        return defaultLocation.get();
    }

    public StringProperty defaultLocationProperty() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation.set(defaultLocation);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        if(this.customerId > 0) throw new InvalidParameterException("customerId is able to be set only one time.");
        this.customerId = customerId;
    }

    private StringProperty name = new SimpleStringProperty();
    private StringProperty defaultLocation = new SimpleStringProperty();
    private StringProperty phoneNumber = new SimpleStringProperty();
    private long customerId;
    public Customer(){
        customerId = 0;
    }

    public Customer(String name, String defaultLocation, String phoneNumber){
        customerId = 0;
        this.name.set(name);
        this.defaultLocation.set(defaultLocation);
        this.phoneNumber.set(phoneNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('{'); sb.append('\n');
        sb.append("    customerId: "); sb.append(getCustomerId());sb.append(",\n");
        sb.append("    name: \""); sb.append(getName());sb.append("\",\n");
        sb.append("    defaultLocation: \""); sb.append(getDefaultLocation());sb.append("\",\n");
        sb.append("    phoneNumber: \""); sb.append(getPhoneNumber());sb.append("\"\n");
        sb.append('}');
        return sb.toString();
    }
}
