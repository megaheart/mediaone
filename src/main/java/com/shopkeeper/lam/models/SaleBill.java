package com.shopkeeper.lam.models;

import java.time.LocalDate;
import java.util.ArrayList;

public final class SaleBill implements IBill {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public BillType getBillType() {
        return null;
    }

    @Override
    public String getBillId() {
        return null;
    }

    @Override
    public LocalDate getTime() {
        return null;
    }

    @Override
    public boolean getIsEffected() {
        return false;
    }

    @Override
    public String getNote() {
        return null;
    }


    private Customer customer;
    private String location;
    private BillType billType = BillType.Sale;
    private ArrayList<BillItem> items;
    private double VAT;
    private boolean isPaid;
    /* to be continue */

}
