package com.shopkeeper.lam.models;
import java.time.LocalDate;
import java.util.ArrayList;
public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private String description;
    private String personId;
    private ArrayList<JobOfPerson> jobs;
    public Person(){ }
    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setJobs(ArrayList<JobOfPerson> jobs) {
        this.jobs = jobs;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<JobOfPerson> getJobs() {
        return jobs;
    }
    public int getAge(){
        LocalDate local  = LocalDate.now();

        return local.getYear()-getDateOfBirth().getYear();
    }
}
