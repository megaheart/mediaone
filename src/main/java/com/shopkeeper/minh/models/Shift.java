package com.shopkeeper.minh.models;

import com.shopkeeper.linh.models.Staff;

import java.security.InvalidParameterException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Shift {
    private ArrayList<Staff> staffs;
    private int dateOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public Shift(){
        startTime = null;
        endTime = null;
    }

    public Shift(ArrayList<Staff> staffs, int dateOfWeek, LocalTime startTime, LocalTime endTime){
        this.staffs = staffs;
        this.dateOfWeek = dateOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

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
        if (this.startTime != null){
            throw new InvalidParameterException("startTime is able to be set only one time.");
        }
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (this.endTime != null){
            throw new InvalidParameterException("endTime is able to be set only one time.");
        }
        this.endTime = endTime;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }

}
