package com.shopkeeper.linh.windowfactories.payment;

import com.shopkeeper.lam.models.Product;
import com.shopkeeper.lam.models.ProductInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class SaleBillItem {
    public SaleBillItem(ProductInfo productInfo){
        this.productInfo = productInfo;
        products = FXCollections.observableArrayList();
    }
    private ProductInfo productInfo;
    private ObservableList<Product> products;

    public ObservableList<Product> getProducts() {
        return products;
    }
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
        return products.size();
    }
    public double getPrice() {
        return products.size() *  getPricePerProduct();
    }
    public double getPricePerProduct() {
        if(products.size() == 0) return 0;
        if(products.get(0).getSaleBill() != null) return products.get(0).getSaleValue();
        else return productInfo.getCurrentSalePrice();
    }
    public SaleBillItem clone(){
        var x = new SaleBillItem(productInfo);
        x.products = FXCollections.observableArrayList(this.products);
        return x;
    }
}
