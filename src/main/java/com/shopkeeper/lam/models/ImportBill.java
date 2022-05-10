package com.shopkeeper.lam.models;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ImportBill implements IBill {
        private String distributor;
        private BillType billType=BillType.Import;
        private ArrayList<BillItem> items;

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    @Override
    public BillType getBillType() {
        return billType;
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
    public ArrayList<Product> getProduct(){
        ArrayList<Product> products=new ArrayList<>();
        Iterator<BillItem> itr=items.iterator();
        while(itr.hasNext()){
            products.add(itr.next().getItem());
        }
        return products;
    }
    public boolean includeOf(Product item){
       return (getProduct().contains(item)?true : false);
    }

//    public double getPriceOf(Product item){
//
//        }

}
