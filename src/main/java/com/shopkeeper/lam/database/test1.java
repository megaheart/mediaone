package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

//CATEGORY

public class test1 {
    public void insertCategory() throws Exception {
        Category honor = new Category("Kinh di","phim rat dang so,khong danh cho tre em duoi 18 tuoi");
        Category comedy = new Category("Phim hai","phim rat buon cuoi");
        Category x3 = new Category("EDM","nhac rat cang");
        Category x4 = new Category("Light novel","truyen chu wibu");
        Category x5 = new Category("Trinh tham","truyen/phim co noi dung giai do, toi pham, pha an");
        Category x6 = new Category("R18","dành cho lứa tuổi 18 trở lên ");
        Category x7 = new Category("12+","Dành cho lứa tuổi trên 12");
        Category x8 = new Category();
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllCategories()){
            System.out.println(x);
        }
        adapter.insertCategory(honor);
        adapter.insertCategory(comedy);
        adapter.insertCategory(x3);
        adapter.insertCategory(x4);
        adapter.insertCategory(x5);
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
        System.out.println("----------<><><><><>----------");
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
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllCategories()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }

}
