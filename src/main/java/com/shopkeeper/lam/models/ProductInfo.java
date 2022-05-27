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
    public String title;
    public long productInfoId;
    public String description;
    public Category category;
    public ProductType productType;
    public LocalDate releaseDate;
    public double currentSalePrice;
    public Publisher publisher;
    public ArrayList<Person> contributors;
    public double rating;
    public ArrayList<String> award;
    public ProductInfo(){productInfoId=0;}

    public ProductInfo(String title, long productInfoId, String description, Category category, ProductType productType, LocalDate releaseDate, double currentSalePrice, Publisher publisher, ArrayList<Person> contributors, double rating, ArrayList<String> award) {
        this.title = title;
        this.productInfoId = productInfoId;
        this.description = description;
        this.category = category;
        this.productType = productType;
        this.releaseDate = releaseDate;
        this.currentSalePrice = currentSalePrice;
        this.publisher = publisher;
        this.contributors = contributors;
        this.rating = rating;
        this.award = award;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(long productInfoId) throws InvalidParameterException {
        if(productInfoId > 0) throw new InvalidParameterException("productInfoId is able to be set only one time.");
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('{'); sb.append('\n');
        sb.append("    tittle: \""); sb.append(getTitle());sb.append("\",\n");
        sb.append("    productInfoId: \""); sb.append(getProductInfoId());sb.append("\",\n");
        sb.append("    category: "); sb.append(getCategory());sb.append(",\n");
        sb.append("    productType: "); sb.append(getProductType());sb.append(",\n");
        sb.append("    releaseDate: \""); sb.append(getReleaseDate());sb.append("\",\n");
        sb.append("    currentSalePrice: \""); sb.append(getCurrentSalePrice());sb.append("\",\n");
        sb.append("    description: \""); sb.append(getDescription());sb.append("\",\n");
        sb.append("    publisher: "); sb.append(getPublisher());sb.append("\n");
        sb.append("    contributors: "); sb.append(getContributors());sb.append("\n");
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
