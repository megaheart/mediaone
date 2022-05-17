package com.shopkeeper.lam.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class SaleBill implements IBill {
    private Customer customer;
    private String location;
    private BillType billType = BillType.Sale;
    private ArrayList<BillItem> items;
    private double VAT;
    private boolean isPaid;
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
        return billType;
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

    public Customer getCustomer() {
        return customer;
    }
    public ArrayList<Product> getProduct(){
        ArrayList<Product> newArray= new ArrayList<>();
        Iterator<BillItem> it=items.iterator();
        while(it.hasNext()){
            newArray.add(it.next().getItem());
        }
        return newArray;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public ArrayList<BillItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BillItem> items) {
        this.items = items;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean includeOf(Product item){
        if(getProduct().contains(item)){
            return true;
        }
        return false;
    }
    public BillItem billContains(Product item){
        Iterator<BillItem> it=items.iterator();
        while(it.hasNext()){
            if(it.next().getItem()==item){
                return it.next();
            }
        }
        return new BillItem();
    }
    public double getPriceOf(Product item){
        if(includeOf(item)){
             return billContains(item).getPrice();
        }
        return 0;
    }




}
