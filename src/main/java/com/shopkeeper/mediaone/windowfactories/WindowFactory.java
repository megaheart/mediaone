package com.shopkeeper.mediaone.windowfactories;

import javafx.stage.Stage;

public abstract class WindowFactory {
    protected Stage currentWindow;

    protected abstract Stage createWindow();

    public abstract Stage openWindow();

    public abstract Stage closeWindow();
}
