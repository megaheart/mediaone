package com.shopkeeper.mediaone;

import com.shopkeeper.lam.database.*;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.linh.models.*;
import com.shopkeeper.linh.windowfactories.FeedbackWindowFactory;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.*;
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
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        FeedbackWindowFactory.getFactory().openWindow();
        //javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}