package com.shopkeeper.linh;

import com.shopkeeper.linh.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class test {
    public void insertStaff() throws Exception{
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
    public void insertCustomers() throws Exception{
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
    }
    public void updateCustomers() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllCustomers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        var x4 = adapter.getAllCustomers().get(6);
        //Update toàn bộ các thuộc tính trừ ID
        x4.setName("XXXXXXXXXX");
        x4.setDefaultLocation("HHHHHHHHHHH");
        x4.setPhoneNumber("yyyyyyyyyyy");
        adapter.updateCustomer(x4);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllCustomers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
    public void deleteCustomers() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllCustomers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var x3 = adapter.getAllCustomers().get(6);
        adapter.deleteCustomer(x3);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllCustomers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
    public void updateSettings() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        var x = adapter.getSettings();
        System.out.println(x);
        x.setClearingFeedbackDuration(25);
        x.setStandardSalaryPerHour(300000);
        adapter.updateSettings(x);
        System.out.println("----------<><><><><>----------");
        System.out.println(x);
    }
    public void resetSettings()  throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        var x = adapter.getSettings();
        System.out.println(x);
        adapter.resetSettings(x);
        System.out.println("----------<><><><><>----------");
        System.out.println(x);
    }
    public void insertSaleBill() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        var customers = adapter.getAllCustomers();
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        SaleBill x1 = new SaleBill("Hoa don ban hang 1", customers.get(0), "xã XX huyện YY tỉnh ZZ", false, 500000,
                LocalDate.of(2022,5,23), false, "Mua ko tra tien");
        SaleBill x2 = new SaleBill("Hoa don ban hang 2", customers.get(1), "xã A huyện B tỉnh C", false, 400000,
                LocalDate.of(2021,4,30), true, "Quyt A con");
        SaleBill x3 = new SaleBill("Hoa don ban hang 3", customers.get(2), "xã C huyện F tỉnh D", true, 690000,
                LocalDate.of(2020,2,29), false, "Xin loi hoa don ko dc cong nhan");
        SaleBill x4 = new SaleBill("Hoa don ban hang 4", customers.get(3), "xã M huyện N tỉnh Z", true, 90000,
                LocalDate.of(2022,5,23), true, "Mua ko tra tien");
        SaleBill x5 = new SaleBill("Hoa don ban hang 5", customers.get(4), "xã H huyện T tỉnh J", false, 100000,
                LocalDate.of(2022,5,23), false, "Mua ko tra tien");

        for(var x:adapter.getAllSaleBills()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        adapter.insertSaleBill(x1);
        adapter.insertSaleBill(x2);
        adapter.insertSaleBill(x3);
        adapter.insertSaleBill(x4);
        adapter.insertSaleBill(x5);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllSaleBills()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
    public void updateSaleBills() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllSaleBills()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        var x4 = adapter.getAllSaleBills().get(3);
        //Update toàn bộ các thuộc tính trừ ID

//        x4.setName(String name);
//        x4.setCustomer(Customer customer);
//        x4.setLocation(String location);
//        x4.setIsPaid(boolean isPaid);
//        x4.setPrice(double price);
//        x4.setTime(LocalDate time);
//        x4.setIsEffected(boolean effected);
//        x4.setNote(String note);

        adapter.updateSaleBill(x4);

        for(var x:adapter.getAllSaleBills()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
    public void deleteSaleBills() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllSaleBills()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var x3 = adapter.getAllSaleBills().get(2);
        adapter.deleteSaleBill(x3);
        for(var x:adapter.getAllSaleBills()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
