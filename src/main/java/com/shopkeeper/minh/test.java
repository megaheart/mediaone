package com.shopkeeper.minh;

import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.functions.StaffManager;
import com.shopkeeper.minh.models.*;

import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class test {
    public void insertOtherBills() throws Exception {
        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        OtherBill x1 = new OtherBill("Vận chuyển", 1000, LocalDate.of(2022, 6, 2), true, "Không có ghi chú");
        OtherBill x2 = new OtherBill("Vận chuyển", 2000, LocalDate.of(2022, 6, 3), false, "Không có ghi chú");
        OtherBill x3 = new OtherBill("Chi phí mặt bằng", 3000, LocalDate.of(2022, 6, 4), true, "Không có ghi chú");
        OtherBill x4 = new OtherBill("Chi phí mặt bằng", 4000, LocalDate.of(2022, 6, 5), false, "Không có ghi chú");
        OtherBill x5 = new OtherBill("Chi phí mặt bằng", 5000, LocalDate.of(2022, 6, 6), true, "Không có ghi chú");
        OtherBill x6 = new OtherBill("Vận chuyển", 1000, LocalDate.of(2022, 6, 2), true, "Không có ghi chú");
        OtherBill x7 = new OtherBill("Vận chuyển", 2000, LocalDate.of(2022, 6, 3), false, "Không có ghi chú");
        OtherBill x8 = new OtherBill("Chi phí mặt bằng", 3000, LocalDate.of(2022, 6, 4), true, "Không có ghi chú");
        OtherBill x9 = new OtherBill("Chi phí mặt bằng", 4000, LocalDate.of(2022, 6, 5), false, "Không có ghi chú");
        OtherBill x10 = new OtherBill("Chi phí mặt bằng", 5000, LocalDate.of(2022, 6, 6), true, "Không có ghi chú");
        OtherBill x11 = new OtherBill("Vận chuyển", 1000, LocalDate.of(2022, 6, 2), true, "Không có ghi chú");
        OtherBill x12 = new OtherBill("Vận chuyển", 2000, LocalDate.of(2022, 6, 3), false, "Không có ghi chú");
        OtherBill x13 = new OtherBill("Vận chuyển", 3000, LocalDate.of(2022, 6, 4), true, "Không có ghi chú");
        OtherBill x14 = new OtherBill("Vận chuyển", 4000, LocalDate.of(2022, 6, 5), false, "Không có ghi chú");
        OtherBill x15 = new OtherBill("Chi phí mặt bằng", 5000, LocalDate.of(2022, 6, 6), true, "Không có ghi chú");

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

        Staff x1 = new Staff("Linh đẹp trai", true, LocalDate.of(2002, 3, 27), "linhdeptrai@mail.com",
                "0962256452", "cái j cũng như bòi trừ mỗi cái đẹp trai", StaffState.Interviewing);
        Staff x2 = new Staff("Lâm lão luyện", true, LocalDate.of(2002, 1, 24), "lamidol@mail.com",
                "0956565656", "thông thạo 7 C/C++, chấp mọi loại thuật toán", StaffState.Working);
        Staff x3 = new Staff("Minh thông", true, LocalDate.of(2002, 11, 6), "minhidol@mail.com",
                "0988888888", "trên thông thiên văn dưới tường địa lý", StaffState.Demited);
        Staff x4 = new Staff("Lóng thị lánh", false, LocalDate.of(2002, 10, 24), "longlanh@mail.com",
                "0969696969", "đẹp gái, đáng yêu nhưng hơi láo", StaffState.Unreliable);
        Staff x5 = new Staff("Mỹ Ngọc Kim Chi", false, LocalDate.of(2002, 11, 24), "kimchidangyeu@mail.com",
                "0966996699", "ngôk nghêk nên ko tuyển", StaffState.NotEmployed);

        // Staff x6 = new Staff("Mỹ Ngọc", false, LocalDate.of(2002, 11,24), "kimchidangyeu@mail.com",
        //       "0966996699", "ngôk nghêk nên ko tuyển", StaffState.NotEmployed);

        for (var x : adapter.getAllStaffs()) {
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
        for (var x : adapter.getAllStaffs()) {
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }

        //Tạo 5 đối tượng mẫu với đầy đủ thuộc tính (trừ ID)
        StaffBill s1 = new StaffBill("Hoa don 1", 1000, LocalDate.of(2022, 6, 2), true, "day la hoa don 1", LocalDate.of(2022, 6, 3), x1, 10, 2);
        StaffBill s2 = new StaffBill("Hoa don 2", 2000, LocalDate.of(2022, 6, 3), false, "day la hoa don 2", LocalDate.of(2022, 6, 4), x2, 20, 3);
        StaffBill s3 = new StaffBill("Hoa don 3", 3000, LocalDate.of(2022, 6, 4), true, "day la hoa don 3", LocalDate.of(2022, 6, 5), x3, 30, 2.5);
        StaffBill s4 = new StaffBill("Hoa don 4", 4000, LocalDate.of(2022, 6, 5), false, "day la hoa don 4", LocalDate.of(2022, 6, 6), x4, 40, 4.5);
        StaffBill s5 = new StaffBill("Hoa don 5", 5000, LocalDate.of(2022, 6, 6), true, "day la hoa don 5", LocalDate.of(2022, 6, 7), x5, 50, 3.5);
        // StaffBill s6 = new StaffBill("Hoa don 6", 6000, LocalDate.of(2022, 6, 7), false, "day la hoa don 6", LocalDate.of(2022, 6, 8), x6, 6000, 6);

        adapter.insertStaffBill(s1);
        adapter.insertStaffBill(s2);
        adapter.insertStaffBill(s3);
        adapter.insertStaffBill(s4);
        adapter.insertStaffBill(s5);
    }

    public void insertAttendances() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        Random random = new Random(0);
        int numOfStaffs;
        int staffIndex;
        LocalDateTime now;
        Attendance attendance;
        ArrayList<Staff> staffs;
        Shift shift;
        Staff staff;

        for (int i = 1; i <= 30; i++){
            now = LocalDateTime.of(2022, 5, i, 8, 0);
            shift = StaffManager.getManager().getCurrentShift(now);
            numOfStaffs = random.nextInt(4);

            staffs = new ArrayList<>();

            for (int j = 1; j <= numOfStaffs; j++){
                staffIndex = random.nextInt(3);
                staff = shift.getStaffs().get(staffIndex);
                if (!staffs.contains(staff)) staffs.add(staff);
            }

            attendance = StaffManager.getManager().getAttendace(now, staffs);
            if (attendance != null) adapter.insertAttendance(attendance);

            now = LocalDateTime.of(2022, 5, i, 13, 0);
            shift = StaffManager.getManager().getCurrentShift(now);
            numOfStaffs = random.nextInt(4);

            staffs = new ArrayList<>();

            for (int j = 1; j <= numOfStaffs; j++){
                staffIndex = random.nextInt(3);
                staff = shift.getStaffs().get(staffIndex);
                if (!staffs.contains(staff)) staffs.add(staff);
            }

            attendance = StaffManager.getManager().getAttendace(now, staffs);
            if (attendance != null) adapter.insertAttendance(attendance);
            now = LocalDateTime.of(2022, 5, i, 20, 0);
            shift = StaffManager.getManager().getCurrentShift(now);
            numOfStaffs = random.nextInt(4);

            staffs = new ArrayList<>();

            for (int j = 1; j <= numOfStaffs; j++){
                staffIndex = random.nextInt(3);
                staff = shift.getStaffs().get(staffIndex);
                if (!staffs.contains(staff)) staffs.add(staff);
            }

            attendance = StaffManager.getManager().getAttendace(now, staffs);
            if (attendance != null) adapter.insertAttendance(attendance);
        }

    }

    public void insertAttendancesJune() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        Random random = new Random(1);
        int numOfStaffs;
        int staffIndex;
        LocalDateTime now;
        Attendance attendance;
        ArrayList<Staff> staffs;
        Shift shift;
        Staff staff;

        for (int i = 1; i <= 30; i++){
            now = LocalDateTime.of(2022, 6, i, 8, 0);
            shift = StaffManager.getManager().getCurrentShift(now);
            numOfStaffs = random.nextInt(4);

            staffs = new ArrayList<>();

            for (int j = 1; j <= numOfStaffs; j++){
                staffIndex = random.nextInt(3);
                staff = shift.getStaffs().get(staffIndex);
                if (!staffs.contains(staff)) staffs.add(staff);
            }

            attendance = StaffManager.getManager().getAttendace(now, staffs);
            if (attendance != null) adapter.insertAttendance(attendance);

            now = LocalDateTime.of(2022, 6, i, 13, 0);
            shift = StaffManager.getManager().getCurrentShift(now);
            numOfStaffs = random.nextInt(4);

            staffs = new ArrayList<>();

            for (int j = 1; j <= numOfStaffs; j++){
                staffIndex = random.nextInt(3);
                staff = shift.getStaffs().get(staffIndex);
                if (!staffs.contains(staff)) staffs.add(staff);
            }

            attendance = StaffManager.getManager().getAttendace(now, staffs);
            if (attendance != null) adapter.insertAttendance(attendance);
            now = LocalDateTime.of(2022, 6, i, 20, 0);
            shift = StaffManager.getManager().getCurrentShift(now);
            numOfStaffs = random.nextInt(4);

            staffs = new ArrayList<>();

            for (int j = 1; j <= numOfStaffs; j++){
                staffIndex = random.nextInt(3);
                staff = shift.getStaffs().get(staffIndex);
                if (!staffs.contains(staff)) staffs.add(staff);
            }

            attendance = StaffManager.getManager().getAttendace(now, staffs);
            if (attendance != null) adapter.insertAttendance(attendance);
        }
    }


    public void insertShift() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();

        ArrayList<Staff> staffs;
        Shift shift;
        ObservableList<Staff> staffObservableList = adapter.getAllStaffs();
        Random random = new Random(0);

        for (int i = 1; i <= 7; i++){
            staffs = new ArrayList<>();
            staffs.add(staffObservableList.get(random.nextInt(30)));
            staffs.add(staffObservableList.get(random.nextInt(30)));
            staffs.add(staffObservableList.get(random.nextInt(30)));
            shift = new Shift(staffs, i, LocalTime.of(7, 0), LocalTime.of(12, 0));
            adapter.insertShift(shift);
            staffs = new ArrayList<>();
            staffs.add(staffObservableList.get(random.nextInt(30)));
            staffs.add(staffObservableList.get(random.nextInt(30)));
            staffs.add(staffObservableList.get(random.nextInt(30)));
            shift = new Shift(staffs, i, LocalTime.of(12, 0), LocalTime.of(17, 0));
            adapter.insertShift(shift);
            staffs = new ArrayList<>();
            staffs.add(staffObservableList.get(random.nextInt(30)));
            staffs.add(staffObservableList.get(random.nextInt(30)));
            staffs.add(staffObservableList.get(random.nextInt(30)));
            shift = new Shift(staffs, i, LocalTime.of(17, 0), LocalTime.of(22, 0));
            adapter.insertShift(shift);
        }


    }


}

