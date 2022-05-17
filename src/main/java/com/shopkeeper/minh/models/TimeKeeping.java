package com.shopkeeper.minh.models;

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

    public ArrayList<Staff> getStaffsWork() {
        return staffsWork;
    }
}
