package com.shopkeeper.lam.models;

public class FilmInfor extends ProductInfor{
    private ProductInfor productInfor;

    public ProductInfor getProductInfor() {
        return productInfor;
    }

    public void setProductInfor(ProductInfor productInfor) {
        this.productInfor = productInfor;
    }
}
