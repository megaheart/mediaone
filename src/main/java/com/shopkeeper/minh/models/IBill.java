package com.shopkeeper.minh.models;

import java.time.LocalDate;

public interface IBill {
    String getName();
    BillType getBillType();
    double getPrice();
    String getBillId();
    LocalDate getTime();
    boolean getIsEffected();
    String getNote();
}
