package com.shopkeeper.lam.models;

public final class SongInfor extends ProductInfor {
    private ProductInfor productInfor;

    public ProductInfor getProductInfor() {
        return productInfor;
    }

    public void setProductInfor(ProductInfor productInfor) {
        this.productInfor = productInfor;
    }
}
