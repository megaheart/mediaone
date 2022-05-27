package com.shopkeeper.lam.models;

public final class BookInfo extends ProductInfo{
    public ProductInfo productInfo;

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
}
