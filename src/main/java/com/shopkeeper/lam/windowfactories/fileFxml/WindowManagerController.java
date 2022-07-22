package com.shopkeeper.lam.windowfactories.fileFxml;

import com.shopkeeper.hung.windowfactories.ManagerPage;
import com.shopkeeper.linh.models.Feedback;
import com.shopkeeper.linh.seeders.DataSeeder;
import com.shopkeeper.linh.windowfactories.CustomerManagerWindowFactory;
import com.shopkeeper.linh.windowfactories.FeedbackWindowFactory;
import com.shopkeeper.linh.windowfactories.PaymentWindowFactory;
import com.shopkeeper.linh.windowfactories.SeedingDataDialogController;
import com.shopkeeper.minh.windowfactories.StaffWindowFactory;
import com.shopkeeper.vu.windowfactories.AccountantWindowFactory;
import com.shopkeeper.vu.windowfactories.WarehouseManagerWindowFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class WindowManagerController  {

    @FXML
    Button productManager,staffManager,feedbackManager,stockManager,paymentManager,revenueManager,dataSeed,customer;
    public void openProductManager(){
        ManagerPage.getMain().start(new Stage());
    }
    public void openStaffManager(){
        StaffWindowFactory.getFactory().openWindow();
    }
    public void openFeedbackManager(){
        FeedbackWindowFactory.getFactory().openWindow();
    }
    public void openStockManager(){
        WarehouseManagerWindowFactory.getFactory().openWindow();
    }
    public void openPaymentManager(){
        PaymentWindowFactory.getFactory().openWindow();
    }
    public void openRevenueManager(){
        AccountantWindowFactory.getFactory().openWindow();
    }
    public void openCustomerManager(){
        CustomerManagerWindowFactory.getFactory().openWindow();
    }
    public void setDataSeed(){
        try {
            DataSeeder.SeedData();
        }
        catch (Exception exception){
            //exception.printStackTrace();
            throw new RuntimeException(exception);
        }

    }

}
