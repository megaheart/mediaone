package com.shopkeeper.mediaone;

import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
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
//        Staff x = new Staff("Lionel Ronaldo", true, LocalDate.of(1985,6,12),
//                "ronaldo@outlook.com", "0952599852", "idol giới trẻ, giáo sư, bậc thầy sát gái", StaffState.Working);
//        x.setStaffId(2);
        var adapter = DatabaseAdapter.getDbAdapter();

        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}