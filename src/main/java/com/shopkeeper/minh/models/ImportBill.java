package com.shopkeeper.minh.models;

import com.shopkeeper.mediaone.models.BillType;
import com.shopkeeper.mediaone.models.IBill;
import java.time.LocalDate;

public final class ImportBill implements IBill{
    private String name;
    private double price;
    private int billId;
    private LocalDate time;
    private boolean isEffected;
    private String note;
    private String distributor;

    public ImportBill(){

    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public BillType getBillType() {
        return BillType.Import;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getBillId() {
        return billId;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean getIsEffected() {
        return isEffected;
    }

    public void setIsEffected(boolean isEffected) {
        this.isEffected = isEffected;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }


}
