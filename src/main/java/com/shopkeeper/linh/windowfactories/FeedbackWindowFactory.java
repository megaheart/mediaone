package com.shopkeeper.linh.windowfactories;

import com.shopkeeper.mediaone.windowfactories.WindowFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedbackWindowFactory  extends WindowFactory {
    private static FeedbackWindowFactory factory = new FeedbackWindowFactory();
    public static FeedbackWindowFactory getFactory(){
        return factory;
    }
    private FeedbackWindowFactory(){
        currentWindow = null;
    }
    @Override
    protected Stage createWindow() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FeedbackWindowFactory.class.getResource("feedback-window.fxml"));
        Scene scene = null;
        stage.setTitle("Quản lý phản hồi");
        stage.setResizable(false);
        try {
            scene = new Scene(fxmlLoader.load());
        }
        catch (IOException ioException){
            System.err.println(ioException.getMessage());
            ioException.printStackTrace();
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
