package com.shopkeeper.linh.windowfactories;

import com.shopkeeper.mediaone.windowfactories.WindowFactory;
import javafx.stage.Stage;

public class PaymentWindowFactory extends WindowFactory {
    private static PaymentWindowFactory factory = new PaymentWindowFactory();
    public static PaymentWindowFactory getFactory(){
        return factory;
    }
    private PaymentWindowFactory(){
        currentWindow = null;
    }
    @Override
    protected Stage createWindow() {
        Stage stage = new Stage();

        return stage;
    }

    @Override
    public Stage openWindow() {
        return null;
    }

    @Override
    public Stage closeWindow() {
        return null;
    }
}
