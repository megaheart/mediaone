package com.shopkeeper.linh;

import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

public class test {
    public void insertStaffs() throws Exception{
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
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
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllStaffs()){
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
