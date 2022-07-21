package com.shopkeeper.hung.windowfactories.windowfactories;

import com.shopkeeper.hung.windowfactories.PaymentRequest;
import com.shopkeeper.hung.windowfactories.fxml.MainPageController;
import com.shopkeeper.lam.models.ProductInfo;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

public class MainPage extends Application {
    private static final MainPage mainPage  = new MainPage();

    public static MainPage getMain(){
        return mainPage;
    }
    public MainPage(){
        for(int i=0;i<20;i++)
            reqs[i]=new com.shopkeeper.hung.windowfactories.PaymentRequest();
    }
    private com.shopkeeper.hung.windowfactories.PaymentRequest[] reqs  = new PaymentRequest[20];
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/main-page.fxml"));
            Scene scene = new Scene(loader.load());
            MainPageController controller = loader.getController();
            controller.setRoot(loader.getRoot());


            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.setResizable(false);
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
