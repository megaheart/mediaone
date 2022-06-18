package com.shopkeeper.minh.functions;

import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.Attendance;
import com.shopkeeper.minh.models.Shift;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class StaffManager {
    private static StaffManager manager;

    private StaffManager(){}

    public static StaffManager getManager(){
        if (manager == null){
            manager = new StaffManager();
        }
        return manager;
    }

    public ObservableList<Staff> getAll() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        return FXCollections.unmodifiableObservableList(adapter.getAllStaffs());
    }

    public void add(Staff staff) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        adapter.insertStaff(staff);
    }

    public void remove(Staff staff) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        adapter.deleteStaff(staff);
    }

    public void update(Staff staff) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        adapter.updateStaff(staff);
    }

    public Staff findById(long staffId) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Staff> staffs = adapter.getAllStaffs();

        for (Staff staff: staffs){
            if (staff.getStaffId() == staffId) return staff;
        }

        System.out.println("No staff has that Id");
        return null;
    }

    public ArrayList<Staff> findByName(String s) throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Staff> listOfStaffs = adapter.getAllStaffs();

        ArrayList<Staff> staffs = new ArrayList<>();

        for (Staff staff: listOfStaffs)
            if (staff.getName().contains(s)) staffs.add(staff);

        return staffs;
    }

    public ArrayList<Staff> findByEmail(String s) throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Staff> listOfStaffs = adapter.getAllStaffs();

        ArrayList<Staff> staffs = new ArrayList<>();

        for (Staff staff: listOfStaffs)
            if (staff.getEmail().contains(s)) staffs.add(staff);

        return staffs;
    }

    public ObservableList<Shift> getShiftList() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        return FXCollections.unmodifiableObservableList(adapter.getAllShifts());
    }


}
