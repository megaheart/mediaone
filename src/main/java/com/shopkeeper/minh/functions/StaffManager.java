package com.shopkeeper.minh.functions;

import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.Attendance;
import com.shopkeeper.minh.models.Shift;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

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

    public void setUpShiftList(Shift[] shifts) throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Shift> shiftObservableList = adapter.getAllShifts();

        for (Shift shift: shiftObservableList) adapter.deleteShift(shift);
        for (Shift shift: shifts) adapter.insertShift(shift);
    }

    public void changeStaffsAtShift(LocalTime startTime, LocalTime endTime, int dateOfWeek, Staff[] staffs) throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Shift> shiftObservableList = adapter.getAllShifts();
        ArrayList<Staff> staffArrayList = new ArrayList<>(Arrays.asList(staffs));
        Shift newShift = new Shift(staffArrayList, dateOfWeek, startTime, endTime);


        for (Shift shift: shiftObservableList){
            if (shift.getDateOfWeek() == dateOfWeek && shift.getStartTime().equals(startTime) && shift.getEndTime().equals(endTime)){
                adapter.deleteShift(shift);
                break;
            }
        }
        adapter.insertShift(newShift);
    }

    public Attendance punchIn(Staff[] staffs) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        Shift currentShift = null;
        LocalDateTime now = LocalDateTime.now();
        Attendance attendance;
        ArrayList<Staff> workingStaffs = new ArrayList<>();
        ArrayList<Staff> absenteeStaffs = new ArrayList<>();
        ObservableList<Shift> shifts = adapter.getAllShifts();
        Duration duration;

        for (Shift shift: shifts) {
            if (shift.getDateOfWeek() == now.getDayOfWeek().getValue() && now.toLocalTime().isAfter(shift.getStartTime()) && now.toLocalTime().isBefore(shift.getEndTime())) {
                currentShift = shift;
                break;
            }
        }

        if (currentShift == null) return null;

        for (Staff staff: staffs){
            if (staff.getState() == StaffState.Working) workingStaffs.add(staff);
        }

        if (workingStaffs.size() == 0) return null;

        duration = Duration.between(currentShift.getStartTime(), currentShift.getEndTime());

        for (Staff staff: currentShift.getStaffs()){
            if ((!Arrays.asList(staffs).contains(staff)) || staff.getState() != StaffState.Working) absenteeStaffs.add(staff);
        }

        attendance = new Attendance(now, duration, workingStaffs, absenteeStaffs);
        adapter.insertAttendance(attendance);

        return attendance;
    }
}
