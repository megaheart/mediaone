package com.shopkeeper.lam.models;
import com.shopkeeper.mediaone.models.IReferencedCounter;
import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.security.InvalidParameterException;
import java.util.*;
import java.time.*;
import java.security.InvalidParameterException;

public class Category implements IReferencedCounter {
    private String name;
    private int categoryId;
    private ProductType productType;
    private String description;
    public Category(){
        categoryId = 0;
    }
    public Category(String name, String description, int categoryId, ProductType productType) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) throws InvalidParameterException {
        if(categoryId > 0) throw new InvalidParameterException("categoryId is able to be set only one time.");
        this.categoryId = categoryId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('{'); sb.append('\n');
        sb.append("    categoryId: \""); sb.append(getCategoryId());sb.append("\",\n");
        sb.append("    name: \""); sb.append(getName());sb.append("\",\n");
        sb.append("    productType: "); sb.append(getProductType());sb.append(",\n");
        sb.append("    description: \""); sb.append(getDescription());sb.append("\",\n");

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
