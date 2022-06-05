package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

//CATEGORY

public class test1 {
    public void insertCategory() throws Exception {
        Category honor = new Category("Kinh di","phim rat dang so,khong danh cho tre em duoi 18 tuoi",1244343);
        Category comedy = new Category("Phim hai","phim rat buon cuoi",213232);
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllCategories()){
            System.out.println(x);
        }
        adapter.insertCategory(honor);
        adapter.insertCategory(comedy);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllCategories()){
            System.out.println(x);
        }
    }
    public void updateCategory() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllCategories()){
            System.out.println(x);
        }
        var y=adapter.getAllCategories().get(1);
        y.setName("anime");
        y.setDescription("hay nhat the gioi");
        adapter.updateCategory(y);
        for(var x:adapter.getAllCategories() ){
            System.out.println(x);
        }
    }
    public void deleteCategories() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllCategories()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllCategories().get(1);
        adapter.deleteCategory(y);
        for(var x:adapter.getAllCategories()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
