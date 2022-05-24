package com.shopkeeper.lam.models;

import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.minh.models.ImportBill;

public class Product {
    private int productId;
    private ProductInfo productInfo;
    private ProductType productType;
    private ProductState state;
    private ImportBill importBill;
    private SaleBill saleBill;
    private double importCost;

    public SaleBill getSaleBill() {
        return saleBill;
    }

    public void setSaleBill(SaleBill saleBill) {
        this.saleBill = saleBill;
    }

    public double getImportCost() {
        return importCost;
    }

    private double saleValue;
    private String trialFilename;
    private String placement;

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

    public void setProductId(int productId) {
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

}
