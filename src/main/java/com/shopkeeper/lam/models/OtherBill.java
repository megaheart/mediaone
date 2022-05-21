package com.shopkeeper.lam.models;

import java.time.LocalDate;

public class OtherBill implements IBill{
    public String name;
    BillType billType = BillType.Other;
    public double price;
    public String billId;
    public LocalDate time;
    public boolean isEffected;
    public String note;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBillType(BillType billType) {
        this.billType = billType;
    }
    public BillType getBillType() {
        return billType;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setBillId(String billId) {
        this.billId = billId;
    }
    @Override
    public String getBillId() {
        return billId;
    }
    public void setTime(LocalDate time) {
        this.time = time;
    }

    public LocalDate getTime() {
        return time;
    }
    public boolean getIsEffected() {
        return false;
    }
    public void setEffected(boolean effected) {
        isEffected = effected;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }
}
