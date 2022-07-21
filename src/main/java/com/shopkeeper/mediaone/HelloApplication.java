package com.shopkeeper.mediaone;

import com.shopkeeper.lam.database.*;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.linh.models.*;
import com.shopkeeper.linh.windowfactories.FeedbackWindowFactory;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.functions.StaffManager;
import com.shopkeeper.minh.models.*;
import com.shopkeeper.minh.windowfactories.StaffWindowFactory;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StaffWindowFactory.getFactory().openWindow();
    }

    public static void main(String[] args) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Staff> staffs = adapter.getAllStaffs();
        StaffBill staffBill = null;
        Random random = new Random(0);
        double workHours;
        LocalDate from;
        for (Staff staff: staffs){
            int extra = random.nextInt(10);
            from = StaffManager.getManager().getFrom(staff);
            workHours = StaffManager.getManager().getWorkHours(staff);
            staffBill = new StaffBill("Lương tháng 4 cho " + staff.getName(), 20 * workHours, LocalDate.of(2022, 4, 30), true, "Không có ghi chú",
                    from, staff, 20, workHours);
            adapter.insertStaffBill(staffBill);
        }
        launch();
    }
}