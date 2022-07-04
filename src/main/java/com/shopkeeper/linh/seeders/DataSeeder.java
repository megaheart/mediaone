package com.shopkeeper.linh.seeders;

import com.shopkeeper.linh.models.Feedback;

public class DataSeeder {
    public static void SeedData(){
        //load 1
        CustomerSeeder.SeedData();
        StaffSeeder.SeedData();

        //load 2
        SaleBillSeeder.SeedData();

        //load 3

        //load 4
        FeedbackSeeder.SeedData();
    }
}
