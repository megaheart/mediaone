package com.shopkeeper.mediaone;

import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;
import com.shopkeeper.minh.models.StaffBill;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
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

        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}