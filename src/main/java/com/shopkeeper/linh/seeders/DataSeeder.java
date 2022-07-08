package com.shopkeeper.linh.seeders;

import com.shopkeeper.lam.database.*;
import com.shopkeeper.linh.models.Feedback;
import com.shopkeeper.minh.models.OtherBill;

public class DataSeeder {
    public static void SeedData() throws Exception{
        //load 1
        CustomerSeeder.SeedData();
        StaffSeeder.SeedData();

        new testCategory().insertCategory();
        new testPublisher().insertPublisher();
        new testPerson().insertPerson();
        new testImportBill().insert();

        new com.shopkeeper.minh.test().insertOtherBills();
        //load 2
        SaleBillSeeder.SeedData();
        new testBookInfo().insert();
        new testMusicInfo().insert();
        new testFilmInfo().insert();

        new com.shopkeeper.minh.test().insertShift();
        new com.shopkeeper.minh.test().insertAttendances();
        new com.shopkeeper.minh.test().insertAttendancesJune();

        //load 3
        new testProduct().insert();
        //load 4
        FeedbackSeeder.SeedData();
    }
}
