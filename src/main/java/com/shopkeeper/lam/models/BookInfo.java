package com.shopkeeper.lam.models;

import java.time.LocalDate;
import java.util.ArrayList;

public final class BookInfo extends ProductInfo{
    private ArrayList<Person> authors;//tac gia
    private int numberOfPage;//so trang cua sach

    public BookInfo(){
        super();
    }

    public BookInfo(String title, int productInfoId, String description, Category category, LocalDate releaseDate, double currentSalePrice, Publisher publisher, ArrayList<Person> authors, double rating, ArrayList<String> award) {
        super(title, productInfoId, description, category, releaseDate, currentSalePrice, publisher,rating, award);
        this.authors=authors;
    }

    public ArrayList<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }
}
