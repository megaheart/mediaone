package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.lam.models.ProductType;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

public class test2 {

            //CATEGORY

            public void insertCategories() throws Exception{
                //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
                Category x1 = new Category("Harry Potter", "hello", 123, ProductType.BOOK);
                Category x2 = new Category("Sakura", "hello", 223, ProductType.SONG);
                Category x3 = new Category("How to watch Youtube", "hello", 323, ProductType.BOOK);
                Category x4 = new Category("Attack on titan", "hello", 423, ProductType.FILM);

                var adapter = DatabaseAdapter.getDbAdapter();
                for(var x:adapter.getAllCategories()){
                    //Nếu như các ô đã triển khai override thuộc tính toString() cho
                    // của ô rồi thì viết thế này
                    System.out.println(x);
                    //Còn nếu không các ô phải in từng thuộc tính 1 ra
                }
                adapter.insertCategory(x1);
                adapter.insertCategory(x2);

                adapter.insertCategory(x3);

                adapter.insertCategory(x4);


                System.out.println("----------<><><><><>----------");
            for(var x:adapter.getAllCategories()){
                System.out.println(x);
            }
        }
        public void updateCategories() throws Exception{
            var adapter = DatabaseAdapter.getDbAdapter();
            for(var x:adapter.getAllCategories()){
                System.out.println(x);
            }
            var x4 = adapter.getAllCategories().get(3);
            //Update toàn bộ các thuộc tính trừ ID
            x4.setName("XXXXXXXXXX");
            x4.setProductType(ProductType.BOOK);
            x4.setDescription("Cực kì bí ẩn");
            adapter.updateCategory(x4);

            for(var x:adapter.getAllCategories()){
                System.out.println(x);
            }
        }
        public void deleteCategories() throws Exception{
            var adapter = DatabaseAdapter.getDbAdapter();
            for(var x:adapter.getAllCategories()){
                System.out.println(x);
            }
            var x3 = adapter.getAllCategories().get(2);
            adapter.deleteCategory(x3);
            for(var x:adapter.getAllCategories()){
                System.out.println(x);
            }
        }
    }


