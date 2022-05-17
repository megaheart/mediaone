package com.shopkeeper.lam.models;

public class BillItem {
    private Product item;
    private double price;
    private double VAT;
    public BillItem(){}
    public BillItem(Product item,double price,double VAT){
        this.item=item;
        this.price=price;
        this.VAT=VAT;
    }
    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }
}
