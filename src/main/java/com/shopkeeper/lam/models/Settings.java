package com.shopkeeper.lam.models;

public class Settings {
    private double standardSalaryPerHour;
    private double clearingFeedbackDuration;

    public double getStandardSalaryPerHour() {
        return standardSalaryPerHour;
    }

    public void setStandardSalaryPerHour(double standardSalaryPerHour) {
        this.standardSalaryPerHour = standardSalaryPerHour;
    }

    public double getClearingFeedbackDuration() {
        return clearingFeedbackDuration;
    }

    public void setClearingFeedbackDuration(double clearingFeedbackDuration) {
        this.clearingFeedbackDuration = clearingFeedbackDuration;
    }
}
