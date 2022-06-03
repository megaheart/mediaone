package com.shopkeeper.minh;

import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;

import com.shopkeeper.mediaone.database.DatabaseAdapter;
import java.time.LocalDate;

public class test {
    public void insertOtherBills() throws Exception {
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        OtherBill x1 = new OtherBill("Hoa don 1", 1000, LocalDate.of(2022, 6, 2), true, "day la hoa don 1");
        OtherBill x2 = new OtherBill("Hoa don 2", 2000, LocalDate.of(2022, 6, 3), false, "day la hoa don 2");
        OtherBill x3 = new OtherBill("Hoa don 3", 3000, LocalDate.of(2022, 6, 4), true, "day la hoa don 3");
        OtherBill x4 = new OtherBill("Hoa don 4", 4000, LocalDate.of(2022, 6, 5), false, "day la hoa don 4");
        OtherBill x5 = new OtherBill("Hoa don 5", 5000, LocalDate.of(2022, 6, 6), true, "day la hoa don 5");

        var adapter = DatabaseAdapter.getDbAdapter();
        for (var x : adapter.getAllOtherBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        adapter.insertOtherBill(x1);
        adapter.insertOtherBill(x2);
        adapter.insertOtherBill(x3);
        adapter.insertOtherBill(x4);
        adapter.insertOtherBill(x5);

        System.out.println("----------<><><><><>----------");
        for (var x : adapter.getAllOtherBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }

    public void updateOtherBills() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for (var x : adapter.getAllOtherBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        var x4 = adapter.getAllOtherBills().get(3);
        //Update toàn bộ các thuộc tính trừ ID
        x4.setName("XXXXXXXXXX");
        x4.setIsEffected(true);
        x4.setPrice(4500);
        x4.setNote("Updated bill");
        x4.setTime(LocalDate.of(2022, 6, 14));
        adapter.updateOtherBill(x4);

        for (var x : adapter.getAllOtherBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }

    public void deleteOtherBills() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for (var x : adapter.getAllOtherBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var x3 = adapter.getAllOtherBills().get(2);
        adapter.deleteOtherBill(x3);
        for (var x : adapter.getAllOtherBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }

    public void insertImportBills() throws Exception {
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        ImportBill x1 = new ImportBill("Hoa don 1", 1000, LocalDate.of(2022, 6, 2), true, "day la hoa don 1", "Japan");
        ImportBill x2 = new ImportBill("Hoa don 2", 2000, LocalDate.of(2022, 6, 3), false, "day la hoa don 2", "China");
        ImportBill x3 = new ImportBill("Hoa don 3", 3000, LocalDate.of(2022, 6, 4), true, "day la hoa don 3", "USA");
        ImportBill x4 = new ImportBill("Hoa don 4", 4000, LocalDate.of(2022, 6, 5), false, "day la hoa don 4", "Vietnam");
        ImportBill x5 = new ImportBill("Hoa don 5", 5000, LocalDate.of(2022, 6, 6), true, "day la hoa don 5", "Thailand");

        var adapter = DatabaseAdapter.getDbAdapter();
        for (var x : adapter.getAllImportBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        adapter.insertImportBill(x1);
        adapter.insertImportBill(x2);
        adapter.insertImportBill(x3);
        adapter.insertImportBill(x4);
        adapter.insertImportBill(x5);

        System.out.println("----------<><><><><>----------");
        for (var x : adapter.getAllImportBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }

    public void updateImportBills() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for (var x : adapter.getAllImportBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        var x4 = adapter.getAllImportBills().get(3);
        //Update toàn bộ các thuộc tính trừ ID
        x4.setName("XXXXXXXXXX");
        x4.setIsEffected(true);
        x4.setPrice(4500);
        x4.setNote("Updated bill");
        x4.setTime(LocalDate.of(2022, 6, 14));
        x4.setDistributor("Taiwan");
        adapter.updateImportBill(x4);

        for (var x : adapter.getAllImportBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }

    public void deleteImportBills() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for (var x : adapter.getAllImportBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var x3 = adapter.getAllImportBills().get(2);
        adapter.deleteImportBill(x3);
        for (var x : adapter.getAllImportBills()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
