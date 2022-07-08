package com.shopkeeper.vu.windowfactories;

import com.shopkeeper.mediaone.windowfactories.WindowFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AccountantWindowFactory extends WindowFactory {

    private  static AccountantWindowFactory factory = new AccountantWindowFactory();
    private static AccountantWindowFactory getFactory(){
        return  factory;
    }
    private AccountantWindowFactory(){
        currentWindow=null;
    }
    @Override
    protected Stage createWindow() {
        try{
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(AccountantWindowFactory.class.getResource("AWF.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1300, 700);
            stage.setTitle("Thống kê của hàng media");
            stage.getIcons().add(new Image(String.valueOf(AccountantWindowFactory.class.getResource("img.png"))));
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Stage openWindow() {
        if(currentWindow==null) currentWindow = createWindow();
        currentWindow.show();
        return currentWindow;
    }

    @Override
    public Stage closeWindow() {
        if(currentWindow==null) return null;
        currentWindow.hide();
        return currentWindow;
    }
}