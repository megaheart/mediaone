package com.shopkeeper.hung.windowfactories;

import com.shopkeeper.hung.windowfactories.fxml.MainPageController2;
import com.shopkeeper.lam.models.ProductInfo;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Objects;

public class MainPage2 extends Application {
    private static final MainPage2 mainPage  = new MainPage2();

    public static MainPage2 getMain(){
        return mainPage;
    }
    public MainPage2(){
        for(int i=0;i<20;i++)
            reqs[i]=new PaymentRequest();
    }
    private PaymentRequest[] reqs  = new PaymentRequest[20];
    private Integer requestNumber=1;
    public ObservableList<Pair<ProductInfo, Integer>> getChosenProduct(){
        return reqs[requestNumber-1].getChosenProduct();
    }

    public void pay(){
        requestNumber++;
    }
    public void addProductToCart(ProductInfo productInfo, Integer integer){
        reqs[requestNumber-1].addProductToCart(productInfo, integer);
    }
    private int getNumberOfRequest(){
        return this.requestNumber;
    }
    private ObservableList<Pair<ProductInfo , Integer >> getRequest(int i){
        return reqs[i-1].getChosenProduct();
    }


    @Override
    public void start(Stage stage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/main-page-2.fxml"));
            Scene scene = new Scene(loader.load());
            MainPageController2 controller = loader.getController();
            controller.setRoot(loader.getRoot());


            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Customer");
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("customer.png"))));
//            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        }catch(Exception e){
            System.out.println("bug main: " +e);
        }
    }
    public static void main(String... args){
        try{
            launch();
        }
        catch(Exception e){
            System.out.println("bug main: "+e);
        }
    }
}
