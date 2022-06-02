package com.shopkeeper.minh.models;

import com.shopkeeper.linh.models.Staff;

import java.time.LocalTime;
import java.util.ArrayList;

public class Shift {
    private ArrayList<Staff> staffs;
    private int dateOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public int getDateOfWeek() {
        return dateOfWeek;
    }

    public void setDateOfWeek(int dateOfWeek) {
        this.dateOfWeek = dateOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }
}
