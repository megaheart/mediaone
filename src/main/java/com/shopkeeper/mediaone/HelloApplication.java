package com.shopkeeper.mediaone;

import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
<<<<<<< HEAD
import com.shopkeeper.minh.models.*;
=======
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;
>>>>>>> dd8c67d3cc86ee0b5ebec766b62d0fd6ef1b9168
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< HEAD

=======
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.show();
>>>>>>> dd8c67d3cc86ee0b5ebec766b62d0fd6ef1b9168
        var adapter = DatabaseAdapter.getDbAdapter();

        var x3 = adapter.getAllShifts().get(1);
        adapter.deleteShift(x3);


        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}