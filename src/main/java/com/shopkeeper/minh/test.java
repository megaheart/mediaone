package com.shopkeeper.minh;

import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;

import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.StaffBill;

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

    public void insertStaffBills() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();

        Staff x1 = new Staff("Linh đẹp trai", true, LocalDate.of(2002, 3,27), "linhdeptrai@mail.com",
                "0962256452", "cái j cũng như bòi trừ mỗi cái đẹp trai", StaffState.Interviewing);
        Staff x2 = new Staff("Lâm lão luyện", true, LocalDate.of(2002, 1,24), "lamidol@mail.com",
                "0956565656", "thông thạo 7 C/C++, chấp mọi loại thuật toán", StaffState.Working);
        Staff x3 = new Staff("Minh thông", true, LocalDate.of(2002, 11,6), "minhidol@mail.com",
                "0988888888", "trên thông thiên văn dưới tường địa lý", StaffState.Demited);
        Staff x4 = new Staff("Lóng thị lánh", false, LocalDate.of(2002, 10,24), "longlanh@mail.com",
                "0969696969", "đẹp gái, đáng yêu nhưng hơi láo", StaffState.Unreliable);
        Staff x5 = new Staff("Mỹ Ngọc Kim Chi", false, LocalDate.of(2002, 11,24), "kimchidangyeu@mail.com",
                "0966996699", "ngôk nghêk nên ko tuyển", StaffState.NotEmployed);

        // Staff x6 = new Staff("Mỹ Ngọc", false, LocalDate.of(2002, 11,24), "kimchidangyeu@mail.com",
        //       "0966996699", "ngôk nghêk nên ko tuyển", StaffState.NotEmployed);

        adapter.insertStaff(x1);
        adapter.insertStaff(x2);
        adapter.insertStaff(x3);
        adapter.insertStaff(x4);
        adapter.insertStaff(x5);

        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        StaffBill s1 = new StaffBill("Hoa don 1", 1000, LocalDate.of(2022, 6, 2), true, "day la hoa don 1", LocalDate.of(2022, 6, 3), x1, 1000, 2);
        StaffBill s2 = new StaffBill("Hoa don 2", 2000, LocalDate.of(2022, 6, 3), false, "day la hoa don 2", LocalDate.of(2022, 6, 4), x2, 2000, 3);
        StaffBill s3 = new StaffBill("Hoa don 3", 3000, LocalDate.of(2022, 6, 4), true, "day la hoa don 3", LocalDate.of(2022, 6, 5), x3, 3000, 2.5);
        StaffBill s4 = new StaffBill("Hoa don 4", 4000, LocalDate.of(2022, 6, 5), false, "day la hoa don 4", LocalDate.of(2022, 6, 6), x4, 4000, 4.5);
        StaffBill s5 = new StaffBill("Hoa don 5", 5000, LocalDate.of(2022, 6, 6), true, "day la hoa don 5", LocalDate.of(2022, 6, 7), x5, 5000, 3.5);
        // StaffBill s6 = new StaffBill("Hoa don 6", 6000, LocalDate.of(2022, 6, 7), false, "day la hoa don 6", LocalDate.of(2022, 6, 8), x6, 6000, 6);

        adapter.insertStaffBill(s1);
        adapter.insertStaffBill(s2);
        adapter.insertStaffBill(s3);
        adapter.insertStaffBill(s4);
        adapter.insertStaffBill(s5);

    }
}
