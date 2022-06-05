package com.shopkeeper.lam.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public final class MusicInfo extends ProductInfo {
    private ArrayList<Person> musicians;//danh sach ca si/nhac si
    private LocalTime timeLimit ;//thoi luong dia nhac
    public MusicInfo(){
        super();

    }
    public MusicInfo(String title, int productInfoId, String description, Category category, LocalDate releaseDate, double currentSalePrice, Publisher publisher, ArrayList<Person> musicians, double rating, ArrayList<String> award,LocalTime timeLimit) {
        super(title, productInfoId, description, category, releaseDate, currentSalePrice, publisher, rating, award);
        this.musicians=musicians;
        this.timeLimit=timeLimit;
    }

    public ArrayList<Person> getMusicians() {
        return musicians;
    }

    public void setMusicians(ArrayList<Person> musicians) {
        this.musicians = musicians;
    }

    public LocalTime getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalTime timeLimit) {
        this.timeLimit = timeLimit;
    }
}
