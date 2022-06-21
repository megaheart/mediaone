package com.shopkeeper.vu.windowfactories;

import com.shopkeeper.mediaone.windowfactories.WindowFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WarehouseWindowFactory extends WindowFactory {


    @Override
    protected Stage createWindow() {

        return null;
    }

    @Override
    public Stage openWindow() {
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(WarehouseWindowFactory.class.getResource("vu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1300, 700);
            stage.setTitle("Thống kê của hàng media");
            stage.getIcons().add(new Image(String.valueOf(WarehouseWindowFactory.class.getResource("img.png"))));
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Stage closeWindow() {
        return null;
    }
}