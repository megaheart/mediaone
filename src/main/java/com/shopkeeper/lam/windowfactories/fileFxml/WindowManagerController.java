package com.shopkeeper.lam.windowfactories.fileFxml;

import com.shopkeeper.linh.models.Feedback;
import com.shopkeeper.linh.windowfactories.FeedbackWindowFactory;
import com.shopkeeper.linh.windowfactories.PaymentWindowFactory;
import com.shopkeeper.minh.windowfactories.StaffWindowFactory;
import com.shopkeeper.vu.windowfactories.AccountantWindowFactory;
import com.shopkeeper.vu.windowfactories.WarehouseManagerWindowFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class WindowManagerController  {

    @FXML
    Button productManager,staffManager,feedbackManager,stockManager,paymentManager,revenueManager,dataSeed,customer;
    public void openProductManager(ActionEvent event){

    }
    public void openStaffManager(ActionEvent event){
        StaffWindowFactory.getFactory().openWindow();
    }
    public void openFeedbackManager(ActionEvent event){
        FeedbackWindowFactory.getFactory().openWindow();
    }
    public void openStockManager(ActionEvent event){
        WarehouseManagerWindowFactory.getFactory().openWindow();
    }
    public void openPaymentManager(ActionEvent event){
        PaymentWindowFactory.getFactory().openWindow();
    }
    public void openRevenueManager(ActionEvent event){
        AccountantWindowFactory.getFactory().openWindow();
    }
    public void openCustomerManager(ActionEvent event){

    }
    public void setDataSeed(ActionEvent event){

    }

}
