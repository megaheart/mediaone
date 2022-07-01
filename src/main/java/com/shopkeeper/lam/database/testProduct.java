package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.Product;
import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.lam.models.ProductState;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.ImportBill;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class testProduct {
    public void insert() throws Exception {

        var adapter = DatabaseAdapter.getDbAdapter();
        var importBills = adapter.getAllImportBills();
        var saleBills = adapter.getAllSaleBills();
        var musics = adapter.getAllMusicInfos();
        var films = adapter.getAllFilmInfos();
        var books = adapter.getAllBookInfos();

        Product f1 = new Product(musics.get(0), ProductState.IMPORTING, null, null, 0, 0,
                "xnxx", "A18");
        Product f2 = new Product(musics.get(0), ProductState.ORDERED, importBills.get(0), null, 0, 0,
                "vlxx", "B3");
        Product f3 = new Product(films.get(0), ProductState.READY, null, saleBills.get(1), 0, 0,
                "bacxyz", "C2");
        Product f4 = new Product(films.get(0), ProductState.RETURNED, importBills.get(2), saleBills.get(2), 0, 0,
                "genksx", "D4");
        Product f5 = new Product(books.get(0), ProductState.SOLD, importBills.get(3), saleBills.get(2), 0, 0,
                "hello", "E6");
        Product f6 = new Product(books.get(0), ProductState.IMPORTING, null, null, 0, 0,
                "ahihi", "F1");

        for(var x : adapter.getAllProducts()){
            System.out.println(x);
        }
        adapter.insertProduct(f1);
        adapter.insertProduct(f2);
        adapter.insertProduct(f3);
        adapter.insertProduct(f4);
        adapter.insertProduct(f5);
        adapter.insertProduct(f6);
        System.out.println("----------<><><><><>----------");
        for(var x : adapter.getAllProducts()){
            System.out.println(x);
        }
    }
    public void update() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        var importBills = adapter.getAllImportBills();
        var saleBills = adapter.getAllSaleBills();
        var musics = adapter.getAllMusicInfos();
        var films = adapter.getAllFilmInfos();
        var books = adapter.getAllBookInfos();
        for(var x : adapter.getAllProducts()){
            System.out.println(x);
        }
        var m2 = adapter.getAllProducts().get(5);
        m2.setSaleBill(saleBills.get(4));
        m2.setImportCost(68);
        m2.setSaleValue(69);
        m2.setTrialFilename("jdsbnfn");
        m2.setPlacement("CC2");
        m2.setProductInfo(musics.get(0));
        m2.setState(ProductState.RETURNED);
        m2.setImportBill(importBills.get(4));
        adapter.updateProduct(m2);
        System.out.println("----------<><><><><>----------");
        for(var x : adapter.getAllProducts()){
            System.out.println(x);
        }
    }
    public void delete() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllProducts()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllProducts().get(5);
        adapter.deleteProduct(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllProducts()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
