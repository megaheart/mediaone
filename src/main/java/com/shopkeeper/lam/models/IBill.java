package com.shopkeeper.lam.models;

import java.time.LocalDate;

public interface IBill {
    public abstract String getName();
    public abstract double getPrice();
    public abstract BillType getBillType();
    public abstract String getBillId();
    public abstract LocalDate getTime();
    public abstract boolean getIsEffected();
    public abstract String getNote();

}
