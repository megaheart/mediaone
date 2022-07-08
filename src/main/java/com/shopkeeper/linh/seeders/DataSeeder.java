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


        //load 2
        SaleBillSeeder.SeedData();
        new testBookInfo().insert();
        new testMusicInfo().insert();
        new testFilmInfo().insert();

        //load 3

        //load 4
        FeedbackSeeder.SeedData();
    }
}
