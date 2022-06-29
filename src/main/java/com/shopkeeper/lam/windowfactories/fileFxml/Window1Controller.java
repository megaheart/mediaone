package com.shopkeeper.lam.windowfactories.fileFxml;

import com.shopkeeper.lam.funtions.PersonManager;
import com.shopkeeper.lam.models.Person;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.mediaone.database.DbAdapterCache;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Window1Controller implements Initializable {
    @FXML
    AnchorPane a1, a2;
    @FXML
    VBox a3;
    @FXML
    Button search;

    @FXML
    TextField searchField;
    @FXML
    ComboBox typeOfProduct;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        a1.toFront();
        a3.setVisible(false);
        typeOfProduct.getItems().addAll("Sách", "Phim", "Âm nhạc","Tất cả");
        search.setOnAction(event -> {
                a2.toFront();
            });
        String[] possibleNames = {"fuck"};
        try {

            for(Person person : DatabaseAdapter.getDbAdapter().getAllPeople()) {
                Button label = new Button(person.getName());

                a3.getChildren().addAll(label);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
   /* public void search(KeyEvent event) {
        a3.getChildren().clear();
        if (event.getCode().equals(KeyCode.ENTER)) {
            try {
                ObservableList<Person> people =  DatabaseAdapter.getDbAdapter().getAllPeople();
                for (Person person : people) {
                    Label label = new Label(person.getName());
                    label.setVisible(true);
                    a3.getChildren().addAll(label);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public void searchByClick(ActionEvent event) {
        a3.getChildren().clear();
        try {
            ObservableList<Person> people =  DatabaseAdapter.getDbAdapter().getAllPeople();
            for (Person person : people) {
                Label label = new Label(person.getName());
                label.setVisible(true);
                a3.getChildren().add(label);
                System.out.println(person.getName());
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }*/

}
