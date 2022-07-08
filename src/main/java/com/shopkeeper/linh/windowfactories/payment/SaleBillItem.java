package com.shopkeeper.linh.windowfactories.payment;

import com.shopkeeper.lam.models.ProductInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SaleBillItem {
    public SaleBillItem(ProductInfo productInfo, int amount){
        this.amount = amount;
        this.productInfo = productInfo;
    }
    private ProductInfo productInfo;
    private int amount;
//    private IntegerProperty index = new SimpleIntegerProperty();
//
//    public int getIndex() {
//        return index.get();
//    }

//    public IntegerProperty indexProperty() {
//        return index;
//    }
//
//    public void setIndex(int index) {
//        this.index.set(index);
//    }
//
    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int value) {
        amount = value;
    }
    public double getPrice() {
        return amount *  productInfo.getCurrentSalePrice();
    }
}
