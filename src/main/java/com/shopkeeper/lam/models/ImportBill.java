package com.shopkeeper.lam.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public final class ImportBill implements IBill {
    private String distributor;
    private BillType billType=BillType.Import;
    private ArrayList<BillItem> items;

   //What the fuck
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


    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
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
    //trả về 1 ArrayList kiểu Product,tương ứng là thứ tư Product của từng BillItem trong ArrayList items
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
