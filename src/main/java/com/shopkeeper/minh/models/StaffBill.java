package com.shopkeeper.minh.models;

import java.time.LocalDate;

import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.mediaone.models.BillType;
import com.shopkeeper.mediaone.models.IBill;

public final class StaffBill implements IBill {
    private String name;
    private BillType billType;
    private double price;
    private int billId;
    private LocalDate time;
    private boolean isEffected;
    private String note;
    private LocalDate from;
    private Staff staff;
    public double standardSalaryPerHour;
    public double workHours;

    public StaffBill(){
        billType = BillType.Staff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getBillId() {
        return billId;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean getIsEffected() {
        return isEffected;
    }

    public void setIsEffected(boolean isEffected) {
        this.isEffected = isEffected;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getFrom() {
        return from;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public double getStandardSalaryPerHour() {
        return standardSalaryPerHour;
    }

    public void setStandardSalaryPerHour(double standardSalaryPerHour) {
        this.standardSalaryPerHour = standardSalaryPerHour;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public double calculateSalary(){
        return standardSalaryPerHour * workHours;
    }
}
