package com.shopkeeper.mediaone;

import com.shopkeeper.lam.windowfactories.fileFxml.CustomerWindowFactory;
import com.shopkeeper.lam.windowfactories.fileFxml.ManagerWindowFactory;
import com.shopkeeper.linh.seeders.DataSeeder;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ManagerWindowFactory.getFactory().openWindow();
        CustomerWindowFactory.getFactory().openWindow();
        //javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}