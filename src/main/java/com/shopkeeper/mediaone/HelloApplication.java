package com.shopkeeper.mediaone;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.lam.models.JobOfPerson;
import com.shopkeeper.lam.models.Person;
import com.shopkeeper.lam.models.Publisher;
import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.show();


        Person x1=new Person("Lam", LocalDate.of(2002,1,24),"thich choi genshin", JobOfPerson.WRITER);
        Person x2=new Person("Kamisato Ayaka",LocalDate.of(2000,4,13),"the best",JobOfPerson.ACTOR);
        Person x3=new Person("Emi Fukada",LocalDate.of(2323,4,2),"dien vien phim gi do",JobOfPerson.ACTOR);
        Person x4=new Person("DOREMON",LocalDate.of(3424,3,4),"meo may den tu tuong lai",JobOfPerson.ACTOR);
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllPeople()){
            System.out.println(x);
        }
        adapter.insertPerson(x1);
        adapter.insertPerson(x2);
        adapter.insertPerson(x3);
        adapter.insertPerson(x4);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllPeople()){
            System.out.println(x);
        }
        /*Category honor = new Category("Kinh di","phim rat dang so,khong danh cho tre em duoi 18 tuoi");
        Category comedy = new Category("Phim hai","phim rat buon cuoi");
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllCategories()){
            System.out.println(x);
        }
        adapter.insertCategory(honor);
        adapter.insertCategory(comedy);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllCategories()){
            System.out.println(x);
        }*/
       /* Publisher p1 = new Publisher("Kim Dong","Viet Nam","xuat ban Doremon");
        Publisher p2 = new Publisher("Hoyoverse","Trung Quoc","genshin,honkai");
        Publisher p3 = new Publisher("Garena","Trung Quoc","LOL,FIFA 4");

        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllPublishers()){
            System.out.println(x);
        }
        adapter.insertPublisher(p1);
        adapter.insertPublisher(p2);
        adapter.insertPublisher(p3);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllPublishers()){
            System.out.println(x);
        }
*/
        /*var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPeople()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllPeople().get(5);
        adapter.deletePerson(y);
        for(var x:adapter.getAllPeople()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }*/
        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}