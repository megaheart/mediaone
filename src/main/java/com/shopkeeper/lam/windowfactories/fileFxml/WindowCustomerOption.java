package com.shopkeeper.lam.windowfactories.fileFxml;

import com.shopkeeper.mediaone.windowfactories.WindowFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowCustomerOption extends WindowFactory {
    private static WindowCustomerOption factory = new WindowCustomerOption();

    public static WindowCustomerOption getFactory() {
        return factory;
    }
    public WindowCustomerOption(){
        {
            currentWindow = null;
        }
    }
    @Override
    public Stage createWindow()  {
        Stage stage = new Stage();
        Scene scene = null;
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("CustomerTheme.fxml"));
            stage.setTitle("Customer");
            stage.setResizable(false);

            scene  = new Scene(root);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        if(scene == null) {
            stage.close();
            return null;
        }
        stage.setScene(scene);
        return stage;
    }

    @Override
    public Stage openWindow() {
        if(currentWindow == null) currentWindow = createWindow();
        currentWindow.show();
        return currentWindow;
    }

    @Override
    public Stage closeWindow() {
        currentWindow.hide();
        return currentWindow;
    }
}
