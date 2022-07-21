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
    public void openProductManager(ActionEvent event){
        ManagerPage.getMain().start(new Stage());
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
        CustomerManagerWindowFactory.getFactory().openWindow();
    }
    public void setDataSeed(ActionEvent event){
        try {
            DataSeeder.SeedData();
        }
        catch (Exception exception){
            //exception.printStackTrace();
            throw new RuntimeException(exception);
        }

//        Stage stage = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(SeedingDataDialogController.class.getResource("seeding-data-dialog.fxml"));
//        Scene scene = null;
//        stage.setTitle("Tạo dữ liệu mẫu");
//        stage.setResizable(false);
//        stage.initStyle(StageStyle.UNDECORATED);
//        try {
//            scene = new Scene(fxmlLoader.load());
//        }
//        catch (IOException ioException){
//            ioException.printStackTrace();
//        }
//        if(scene == null) {
//            stage.close();
//            return;
//        }
//        stage.setScene(scene);
//        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, event1 -> {
//
//            stage.close();
//        });
//        stage.showAndWait();
    }

}
