package com.shopkeeper.lam.models;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ProductInfo {
    private String title;
    private String productInfoId;
    private String description;
    private Category category;
    private ProductType productType;
    private LocalDate releaseDate;
    private double currentSalePrice;
    private Publisher publisher;
    private ArrayList<Person> contributors;
    private double rating;
    private ArrayList<String> award;

}
