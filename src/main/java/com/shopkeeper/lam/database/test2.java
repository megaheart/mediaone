package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

//PERSON

public class test2 {
    public void insertPerson() throws Exception {
        Person x1=new Person("Lam", LocalDate.of(2002,1,24),"thich choi genshin",JobOfPerson.WRITER);
        Person x2=new Person("Kamisato Ayaka",LocalDate.of(2000,4,13),"the best",JobOfPerson.ACTOR);
        Person x3=new Person("Emi Fukada",LocalDate.of(2323,4,2),"dien vien phim gi do",JobOfPerson.ACTOR);
        Person x4=new Person("DOREMON",LocalDate.of(3424,2,24),"meo may den tu tuong lai",JobOfPerson.ACTOR);
        Person x5=new Person("Son Tung",LocalDate.of(2323,4,2),"hay nhat viet nam",JobOfPerson.SINGER);
        Person x6=new Person("Jack",LocalDate.of(3424,2,24),"Jack 5 củ",JobOfPerson.SINGER);
        Person x7=new Person("Cristiano Ronaldo",LocalDate.of(2323,4,2),"cao nhat viet nam",JobOfPerson.FOOTBALLER);
        Person x8=new Person("Tokuda",LocalDate.of(1997,4,2),"dien phim Nhat Ban",JobOfPerson.FOOTBALLER);
        Person x9=new Person("Elon Musk",LocalDate.of(2323,4,2),"người giàu nhất thế giới",JobOfPerson.CEO);
        Person x10=new Person("Bill Gates",LocalDate.of(2323,4,2),"người giàu nhất thế giới trước năm 2020",JobOfPerson.CEO);
        Person x11=new Person("Huan Hoa Hong",LocalDate.of(1999,4,2),"Người hay lộn xào trên mạng",JobOfPerson.ACTOR);
        Person x12 = new Person("Paul Pogba", LocalDate.of(1999, 4, 2), "Kẻ hủy diệt Manchester United,nghệ sĩ nhảy múa của nhà hát ", JobOfPerson.FOOTBALLER);
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllPeople()){
            System.out.println(x);
        }
        adapter.insertPerson(x1);
        adapter.insertPerson(x2);
        adapter.insertPerson(x3);
        adapter.insertPerson(x4);
        adapter.insertPerson(x5);
        adapter.insertPerson(x6);
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
        System.out.println("----------<><><><><>----------");
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
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllPeople()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
