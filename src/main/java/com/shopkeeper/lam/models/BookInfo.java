package com.shopkeeper.lam.models;

import java.time.LocalDate;
import java.util.ArrayList;

public final class BookInfo extends ProductInfo{
    public BookInfo(){
        productType=ProductType.BOOK;
    }

    public BookInfo(String title, int productInfoId, String description, Category category, LocalDate releaseDate, double currentSalePrice, Publisher publisher, ArrayList<Person> contributors, double rating, ArrayList<String> award) {
        super(title, productInfoId, description, category, releaseDate, currentSalePrice, publisher, contributors, rating, award);
        this.productType=ProductType.BOOK;
    }
}
