package com.shopkeeper.lam.models;

public final class FilmInfo extends ProductInfo{
    private ProductInfo productInfor;

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
}
