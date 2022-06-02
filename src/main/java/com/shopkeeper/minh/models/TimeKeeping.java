package com.shopkeeper.minh.models;

import com.shopkeeper.linh.models.Staff;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class TimeKeeping {
    private LocalDateTime time;
    private Duration duration;
    private ArrayList<Staff> staffsWork;
    private ArrayList<Staff> staffsAbsentee;

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    public ArrayList<Staff> getStaffsAbsentee() {
        return staffsAbsentee;
    }

    public void setStaffsWork(ArrayList<Staff> staffsWork) {
        this.staffsWork = staffsWork;
    }

    public void setStaffsAbsentee(ArrayList<Staff> staffsAbsentee) {
        this.staffsAbsentee = staffsAbsentee;
    }

    public ArrayList<Staff> getStaffsWork() {
        return staffsWork;
    }
}
