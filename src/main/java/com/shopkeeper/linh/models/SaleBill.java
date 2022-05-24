package com.shopkeeper.linh.models;

import com.shopkeeper.mediaone.models.BillItem;
import com.shopkeeper.mediaone.models.BillType;
import com.shopkeeper.mediaone.models.IBill;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.security.InvalidParameterException;
import java.util.*;
import java.time.*;



public class SaleBill implements IBill {
    @Override
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Customer getCustomer() {
        return customer.get();
    }

    public ObjectProperty<Customer> customerProperty() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer.set(customer);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    @Override
    public BillType getBillType() {
        return billType.get();
    }

    public ObjectProperty<BillType> billTypeProperty() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType.set(billType);
    }

    public ObservableList<BillItem> getItems() {
        return items;
    }

    public double getVAT() {
        return VAT.get();
    }

    public DoubleProperty VATProperty() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT.set(VAT);
    }

    public boolean getIsPaid() {
        return isPaid.get();
    }

    public BooleanProperty isPaidProperty() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid.set(isPaid);
    }

    @Override
    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    @Override
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        if(this.billId > 0) throw new InvalidParameterException("feedbackId is able to be set only one time.");
        this.billId = billId;
    }

    @Override
    public LocalDate getTime() {
        return time.get();
    }

    public ObjectProperty<LocalDate> timeProperty() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time.set(time);
    }
    @Override
    public boolean getIsEffected() {
        return effected.get();
    }

    public BooleanProperty isEffectedProperty() {
        return effected;
    }

    public void setIsEffected(boolean effected) {
        this.effected.set(effected);
    }
    @Override
    public String getNote() {
        return note.get();
    }

    public StringProperty noteProperty() {
        return note;
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<Customer> customer = new SimpleObjectProperty<Customer>();
    private StringProperty location = new SimpleStringProperty();
    private ObjectProperty<BillType> billType = new SimpleObjectProperty<BillType>();
    private ObservableList<BillItem> items;
    private DoubleProperty VAT = new SimpleDoubleProperty();
    private BooleanProperty isPaid = new SimpleBooleanProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private int billId;
    private ObjectProperty<LocalDate> time = new SimpleObjectProperty<LocalDate>();

    private BooleanProperty effected = new SimpleBooleanProperty();
    private StringProperty note = new SimpleStringProperty();
    public SaleBill(){
        items = FXCollections.observableArrayList();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}