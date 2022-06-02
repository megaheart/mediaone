package com.shopkeeper.lam.models;

import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.mediaone.models.IReferencedCounter;
import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.security.InvalidParameterException;
import java.util.*;
import java.time.*;
public class Product implements IReferencedCounter {
    public int productId;
    public ProductInfo productInfo;
    public ProductType productType;
    public ProductState state;
    public ImportBill importBill;
    public SaleBill saleBill;
    public double importCost;
    public double saleValue;
    public String trialFilename;
    public String placement;
    public Product(){productId = 0;}

    public Product(int productId, ProductInfo productInfo, ProductType productType, ProductState state, ImportBill importBill, SaleBill saleBill, double importCost, double saleValue, String trialFilename, String placement) {
        this.productId = productId;
        this.productInfo = productInfo;
        this.productType = productType;
        this.state = state;
        this.importBill = importBill;
        this.saleBill = saleBill;
        this.importCost = importCost;
        this.saleValue = saleValue;
        this.trialFilename = trialFilename;
        this.placement = placement;
    }

    public SaleBill getSaleBill() {
        return saleBill;
    }

    public void setSaleBill(SaleBill saleBill) {
        this.saleBill = saleBill;
    }

    public double getImportCost() {
        return importCost;
    }



    public void setImportCost(double importCost) {
        this.importCost = importCost;
    }

    public double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    public String getTrialFilename() {
        return trialFilename;
    }

    public void setTrialFilename(String trialFilename) {
        this.trialFilename = trialFilename;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) throws InvalidParameterException {
        if(productId > 0) throw new InvalidParameterException("productId is able to be set only one time.");
        this.productId = productId;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductState getState() {
        return state;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public ImportBill getImportBill() {
        return importBill;
    }

    public void setImportBill(ImportBill importBill){
        this.importBill=importBill;
    }
    private int timesToBeReferenced;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('{'); sb.append('\n');
        sb.append("    productId: \""); sb.append(getProductId());sb.append("\",\n");
        sb.append("    productInfo: \""); sb.append(getProductInfo());sb.append("\",\n");
        sb.append("    productType: "); sb.append(getProductType());sb.append(",\n");
        sb.append("    productState: \""); sb.append(getState());sb.append("\",\n");
        sb.append("    importBill: \""); sb.append(getImportBill());sb.append("\",\n");
        sb.append("    saleBill: \""); sb.append(getSaleBill());sb.append("\",\n");
        sb.append('}');
        return sb.toString();
    }
    @Override
    public int countTimesToBeReferenced() {
        return timesToBeReferenced;
    }

    @Override
    public void increaseTimesToBeReferenced() {
        timesToBeReferenced++;
    }

    @Override
    public void decreaseTimesToBeReferenced() throws Exception {
        if(timesToBeReferenced == 0) throw new Exception("cannot decreaseTimesToBeReferenced() when countTimesToBeReferenced() = 0");
        timesToBeReferenced--;
    }
}
