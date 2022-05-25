package com.shopkeeper.linh.models;


import com.shopkeeper.lam.models.Product;
import com.shopkeeper.lam.models.ProductInfo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.security.InvalidParameterException;
import java.util.*;
import java.time.*;


public class Feedback {
    private int feedbackId;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        if(this.feedbackId > 0) throw new InvalidParameterException("feedbackId is able to be set only one time.");
        this.feedbackId = feedbackId;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public FeedbackAbout getFeedbackAbout() {
        return feedbackAbout;
    }

    public void setFeedbackAbout(FeedbackAbout feedbackAbout) throws Exception{
        if(this.feedbackAbout != FeedbackAbout.Service)
            throw new Exception("feedbackAbout attribute can be set only one time.");
        this.feedbackAbout = feedbackAbout;
    }

    public FeedbackType getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(FeedbackType feedbackType) throws Exception {
        if(this.feedbackType != FeedbackType.Suggestions)
            throw new Exception("feedbackType attribute can be set only one time.");
        this.feedbackType = feedbackType;
    }

    public int getProductInfoRating() throws Exception{
        if(this.feedbackAbout != FeedbackAbout.ProductInfo)
            throw new Exception("Only feedback whose type is FeedbackAbout.ProductInfo has productInfoRating attribute.");
        return productInfoRating;
    }

    public void setProductInfoRating(int productInfoRating) throws Exception {
        if(this.feedbackAbout != FeedbackAbout.ProductInfo)
            throw new Exception("Only feedback whose type is FeedbackAbout.ProductInfo has productInfoRating attribute.");
        this.productInfoRating = productInfoRating;
    }

    public Staff getStaffTarget() throws Exception{
        if(this.feedbackAbout != FeedbackAbout.Staff)
            throw new Exception("Only feedback whose type is FeedbackAbout.Staff has staffTarget attribute.");
        return staffTarget;
    }

    public void setStaffTarget(Staff staffTarget) throws Exception{
        if(this.feedbackAbout != FeedbackAbout.Staff)
            throw new Exception("Only feedback whose type is FeedbackAbout.Staff has staffTarget attribute.");
        this.staffTarget = staffTarget;
    }

    public Product getProductTarget() throws Exception {
        if(this.feedbackAbout != FeedbackAbout.Product)
            throw new Exception("Only feedback whose type is FeedbackAbout.Product has productTarget attribute.");
        return productTarget;
    }

    public void setProductTarget(Product productTarget) throws Exception {
        if(this.feedbackAbout != FeedbackAbout.Product)
            throw new Exception("Only feedback whose type is FeedbackAbout.Product has productTarget attribute.");
        this.productTarget = productTarget;
    }

    public ProductInfo getProductInfoTarget() throws Exception {
        if(this.feedbackAbout != FeedbackAbout.ProductInfo)
            throw new Exception("Only feedback whose type is FeedbackAbout.ProductInfo has productInfoTarget attribute.");
        return productInfoTarget;
    }

    public void setProductInfoTarget(ProductInfo productInfoTarget) throws Exception {
        if(this.feedbackAbout != FeedbackAbout.ProductInfo)
            throw new Exception("Only feedback whose type is FeedbackAbout.ProductInfo has productInfoTarget attribute.");
        this.productInfoTarget = productInfoTarget;
    }

    public boolean isUseful() {
        return isUseful;
    }

    public void setUseful(boolean useful) {
        isUseful = useful;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    private StringProperty title = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();;
    private FeedbackAbout feedbackAbout;
    private FeedbackType feedbackType;

    private Product productTarget;
    private ProductInfo productInfoTarget;
    private int productInfoRating;
    private Staff staffTarget;
    private boolean isUseful;
    private LocalDate time;
    public Feedback(){
        feedbackId = 0;
        feedbackAbout = FeedbackAbout.Service;
        feedbackType = FeedbackType.Suggestions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('{'); sb.append('\n');
        sb.append("    feedbackId: "); sb.append(getFeedbackId());sb.append(",\n");
        sb.append("    title: \""); sb.append(getTitle());sb.append("\",\n");
        sb.append("    description: \""); sb.append(getDescription());sb.append("\",\n");
        sb.append("    type: "); sb.append(getFeedbackType());sb.append(",\n");
        sb.append("    about: "); sb.append(getFeedbackAbout());sb.append(",\n");
        switch (getFeedbackAbout()){
            case Staff:
                sb.append("    staff: {");
                sb.append("staffId: ");
                try {
                    sb.append(getStaffTarget().getStaffId());
                }
                catch (Exception e){
                    sb.append(e.getMessage());
                }
                sb.append(", name: \"");
                try {
                    sb.append(getStaffTarget().getName());
                }
                catch (Exception e){
                    sb.append(e.getMessage());
                }
                sb.append("\"},\n");
                break;
            case ProductInfo:
                sb.append("    productInfoTarget: {");
                sb.append("productInfoId: ");
                try {
                    sb.append(getProductInfoTarget().getProductInfoId());
                }
                catch (Exception e){
                    sb.append(e.getMessage());
                }
                sb.append(", title: \"");
                try {
                    sb.append(getProductInfoTarget().getTitle());
                }
                catch (Exception e){
                    sb.append(e.getMessage());
                }
                sb.append("\"},\n");
                sb.append("    productInfoRating: ");
                try {
                    sb.append(getProductInfoRating());
                }
                catch (Exception e){
                    sb.append(e.getMessage());
                }
                sb.append(",\n");
                break;
            case  Product:
                sb.append("    productTarget: {");
                sb.append("productId: ");
                try {
                    sb.append(getProductTarget().getProductId());
                }
                catch (Exception e){
                    sb.append(e.getMessage());
                }
                sb.append("},\n");
                break;
            case Service:
                //Do nothing
                break;
        }
        sb.append('}');
        return sb.toString();
    }
}
