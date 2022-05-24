package com.shopkeeper.minh.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public final class ImportBill implements IBill{
    private String name;
    private BillType billType;
    private double price;
    private String billId;
    private LocalDate time;
    private boolean isEffected;
    private String note;
    private String distributor;
    private BillType billType;
    private ArrayList<BillItem> items;

    public ImportBill(){
        billType = BillType.Import;
    }


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

    public String getBillId() {
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

    public ArrayList<BillItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BillItem> items) {
        this.items = items;
    }
    public ArrayList<Product> getProduct(){
        ArrayList<Product> products=new ArrayList<>();
        Iterator<BillItem> itr=items.iterator();
        while(itr.hasNext()){
            products.add(itr.next().getItem());
        }
        return products;
    }
    public boolean includeOf(Product item){
        return (getProduct().contains(item));
    }
    public double getPriceOf(Product item){
        if(!includeOf(item)){return 0;}
        else{
            return (items.get(getProduct().indexOf(item))).getPrice();//trả về giá của Product tương ứng trong ArrayList items
        }
    }
}
