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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(String productInfoId) {
        this.productInfoId = productInfoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getCurrentSalePrice() {
        return currentSalePrice;
    }

    public void setCurrentSalePrice(double currentSalePrice) {
        this.currentSalePrice = currentSalePrice;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public ArrayList<Person> getContributors() {
        return contributors;
    }

    public void setContributors(ArrayList<Person> contributors) {
        this.contributors = contributors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getAward() {
        return award;
    }

    public void setAward(ArrayList<String> award) {
        this.award = award;
    }
}
