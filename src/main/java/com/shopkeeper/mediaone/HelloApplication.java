package com.shopkeeper.mediaone;

import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
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
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.show();
//        Staff x = new Staff("Lionel Ronaldo", true, LocalDate.of(1985,6,12),
//                "ronaldo@outlook.com", "0952599852", "idol giới trẻ, giáo sư, bậc thầy sát gái", StaffState.Working);
//        x.setStaffId(2);
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        Customer x1 = new Customer("Trần Thị A", "xã X huyện Y tỉnh Z", "0986562561");
        Customer x2 = new Customer("Nguyễn Văn B", "xã A huyện B tỉnh C", "0969696969");
        Customer x3 = new Customer("Hoàng Xuân C", "xã VV huyện CC tỉnh LL", "0988963654");
        Customer x4 = new Customer("Lê Vũ D", "xã XYZ huyện XXX tỉnh XXX", "0989456258");
        Customer x5 = new Customer("Trịnh Anh E", "xã FGV huyện VBN tỉnh CSD", "0984568224");

        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllCustomers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        adapter.insertCustomer(x1);
        adapter.insertCustomer(x2);
        adapter.insertCustomer(x3);
        adapter.insertCustomer(x4);
        adapter.insertCustomer(x5);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllCustomers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        javafx.application.Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}