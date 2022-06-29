package com.shopkeeper.lam.windowfactories.fileFxml;

import com.shopkeeper.mediaone.windowfactories.WindowFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window1 extends WindowFactory  {
    private static Window1 factory = new Window1();

    public static Window1 getFactory() {
        return factory;
    }
    public Window1(){
        {
            currentWindow = null;
        }
    }
    @Override
    public Stage createWindow()  {
        Stage stage = new Stage();
        Scene scene = null;
        try {
        Parent root = FXMLLoader.load(Window1.class.getResource("CustomerTheme.fxml"));
        stage.setTitle("Test");
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
