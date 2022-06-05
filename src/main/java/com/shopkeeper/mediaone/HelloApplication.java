package com.shopkeeper.mediaone;

import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.show();
        var adapter = DatabaseAdapter.getDbAdapter();

        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}