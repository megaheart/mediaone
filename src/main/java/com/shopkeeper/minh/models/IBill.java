package com.shopkeeper.minh.models;

import java.time.LocalDate;

public interface IBill {
    public String getName();
    public BillType getBillType();
    public double getPrice();
    public String getBillId();
    public LocalDate getTime();
    public boolean getIsEffected();
    public String getNote();
}
