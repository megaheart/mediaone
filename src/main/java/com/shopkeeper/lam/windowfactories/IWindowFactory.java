package com.shopkeeper.lam.windowfactories;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public interface IWindowFactory {
    public Stage currentWindow = null;
    public Stage createWindow();
    public Stage openWindow();
    public Stage closeWindow();


}
