package com.shopkeeper.minh.models;


import com.shopkeeper.mediaone.database.DatabaseAdapter;
import java.time.LocalDate;


public class test {
    public void insertOtherBills() throws Exception{
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        OtherBill x1 = new OtherBill("Hoa don 1", 1000, LocalDate.of(2022, 6, 2), true, "day la hoa don 1");
        OtherBill x2 = new OtherBill("Hoa don 2", 2000, LocalDate.of(2022, 6, 3), false, "day la hoa don 2");
        OtherBill x3 = new OtherBill("Hoa don 3", 3000, LocalDate.of(2022, 6, 4), true, "day la hoa don 3");
        OtherBill x4 = new OtherBill("Hoa don 4", 4000, LocalDate.of(2022, 6, 5), false, "day la hoa don 4");
        OtherBill x5 = new OtherBill("Hoa don 5", 5000, LocalDate.of(2022, 6, 6), true, "day la hoa don 5");

        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.ge){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        adapter.insertStaff(x1);
        adapter.insertStaff(x2);
        adapter.insertStaff(x3);
        adapter.insertStaff(x4);
        adapter.insertStaff(x5);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllStaffs()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
    public void updateStaffs() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllStaffs()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        var x4 = adapter.getAllStaffs().get(3);
        //Update toàn bộ các thuộc tính trừ ID
        x4.setName("XXXXXXXXXX");
        x4.setIsMale(true);
        x4.setDateOfBirth(LocalDate.of(2003,2,28));
        x4.setEmail("XXXXX@mail.com");
        x4.setPhoneNumber("yyyyyyyyyyy");
        x4.setDescription("Cực kì bí ẩn");
        x4.setState(StaffState.Working);
        adapter.updateStaff(x4);

        for(var x:adapter.getAllStaffs()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
    public void deleteStaffs() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllStaffs()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var x3 = adapter.getAllStaffs().get(2);
        adapter.deleteStaff(x3);
        for(var x:adapter.getAllStaffs()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
