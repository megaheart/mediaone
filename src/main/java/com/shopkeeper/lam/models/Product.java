package com.shopkeeper.lam.models;

public class Product {
    private String productId;
    private ProductInfo productInfo;
    private ProductType productType;
    private ProductState state;
    private ImportBill importBill;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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

    public void setImportBill(ImportBill importBill) {
        this.importBill = importBill;
    }
}
