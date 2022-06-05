package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

//PERSON

public class test2 {
    public void insertPerson() throws Exception {
        Person x1=new Person("Lam", LocalDate.of(2002,1,24),"thich choi genshin",1232,JobOfPerson.WRITER);
        Person x2=new Person("Kamisato Ayaka",LocalDate.of(2000,4,13),"the best",23124,JobOfPerson.ACTOR);
        Person x3=new Person("Emi Fukada",LocalDate.of(2323,4,2),"dien vien phim gi do",23442,JobOfPerson.ACTOR);
        Person x4=new Person("DOREMON",LocalDate.of(3424,23,4),"meo may den tu tuong lai",545,JobOfPerson.ACTOR);
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
    }
    public void updatePerson() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPeople()){
            System.out.println(x);
        }
        var y=adapter.getAllPeople().get(3);
        y.setName("Kujou Sara");
        y.setDescription("tuong quan Inazuma");

        adapter.updatePerson(y);
        for(var x:adapter.getAllPeople() ){
            System.out.println(x);
        }
    }
    public void deletePeople() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPeople()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllPeople().get(3);
        adapter.deletePerson(y);
        for(var x:adapter.getAllPeople()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
