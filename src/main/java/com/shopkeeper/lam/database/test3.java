package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;


//PUBLISHER


public class test3 {
    public void insertPublisher() throws Exception {
        Publisher p1 = new Publisher("Kim Dong","Viet Nam",3434,"xuat ban Doremon");
        Publisher p2 = new Publisher("Hoyoverse","Trung Quoc",3343,"genshin,honkai");
        Publisher p3 = new Publisher("Garena","Trung Quoc",355,"LOL,FIFA 4");

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
    }
    public void updatePublisher() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPublishers()){
            System.out.println(x);
        }
        var y=adapter.getAllPublishers().get(2);
        y.setName("Bo giao duc");
        y.setDescription("ko biet noi gi");
        adapter.updatePublisher(y);
        for(var x:adapter.getAllPublishers() ){
            System.out.println(x);
        }
    }
    public void deleteCategories() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPublishers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllPublishers().get(2);
        adapter.deletePublisher(y);
        for(var x:adapter.getAllPublishers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
