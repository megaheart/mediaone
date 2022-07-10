module com.shopkeeper.mediaone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires annotations;

    opens com.shopkeeper.mediaone to javafx.fxml;
    opens com.shopkeeper.linh.windowfactories.feedback to javafx.fxml;
    opens com.shopkeeper.linh.windowfactories to javafx.fxml;
    opens com.shopkeeper.linh.windowfactories.customer to javafx.fxml;
    opens com.shopkeeper.linh.windowfactories.payment to javafx.fxml;
    exports com.shopkeeper.mediaone;
    exports com.shopkeeper.vu.windowfactories;
    opens com.shopkeeper.vu.windowfactories to javafx.fxml;
    opens com.shopkeeper.minh.models to javafx.base;
    opens com.shopkeeper.lam.models to javafx.base;
}