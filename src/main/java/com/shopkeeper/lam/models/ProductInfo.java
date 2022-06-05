package com.shopkeeper.lam.models;

import com.shopkeeper.mediaone.models.IReferencedCounter;
import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.security.InvalidParameterException;
import java.util.*;
import java.time.*;
public abstract class ProductInfo implements IReferencedCounter {
    private int productInfoId;
    private String title;
    private String description;
    private Category category;
    private LocalDate releaseDate;
    private double currentSalePrice;
    private Publisher publisher;
    private double rating;
    private ArrayList<String> award;
    public ProductInfo(){productInfoId=0;}

    public ProductInfo(String title, String description, Category category, LocalDate releaseDate, double currentSalePrice, Publisher publisher, double rating, ArrayList<String> award) {
        productInfoId=0;
        this.title = title;
        this.description = description;
        this.category = category;
        this.releaseDate = releaseDate;
        this.currentSalePrice = currentSalePrice;
        this.publisher = publisher;
        this.rating = rating;
        this.award = award;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(int productInfoId) throws InvalidParameterException {
        if(this.productInfoId > 0) throw new InvalidParameterException("productInfoId is able to be set only one time.");
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('{'); sb.append('\n');
        sb.append("    tittle: \""); sb.append(getTitle());sb.append("\",\n");
        sb.append("    productInfoId: \""); sb.append(getProductInfoId());sb.append("\",\n");
        sb.append("    category: "); sb.append(getCategory());sb.append(",\n");
        sb.append("    releaseDate: \""); sb.append(getReleaseDate());sb.append("\",\n");
        sb.append("    currentSalePrice: \""); sb.append(getCurrentSalePrice());sb.append("\",\n");
        sb.append("    description: \""); sb.append(getDescription());sb.append("\",\n");
        sb.append("    publisher: "); sb.append(getPublisher());sb.append("\n");
        sb.append("    rating: "); sb.append(getRating());sb.append("\n");
        sb.append("    award: "); sb.append(getAward());sb.append("\n");
        sb.append('}');
        return sb.toString();
    }
    private int timesToBeReferenced;
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
