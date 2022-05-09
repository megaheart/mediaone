package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.Person;
import java.time.LocalDate;
import java.time.LocalDate;

public class test {
    public static void main(String[] args){
        Person p = new Person();
        LocalDate lc;
        p.setDateOfBirth(LocalDate.of(2000,12,1));
        System.out.println( p.getAge());
    }
}
