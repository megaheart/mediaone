package com.shopkeeper.mediaone;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.lam.models.JobOfPerson;
import com.shopkeeper.lam.models.Person;
import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Person x1=new Person("Lam", LocalDate.of(2002,1,24),"thich choi genshin", JobOfPerson.WRITER);
        Person x2=new Person("Kamisato Ayaka",LocalDate.of(2000,4,13),"the best",JobOfPerson.ACTOR);
        Person x3=new Person("Emi Fukada",LocalDate.of(2323,4,2),"dien vien phim gi do",JobOfPerson.ACTOR);
        Person x4=new Person("DOREMON",LocalDate.of(3424,23,4),"meo may den tu tuong lai",JobOfPerson.ACTOR);
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


        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}