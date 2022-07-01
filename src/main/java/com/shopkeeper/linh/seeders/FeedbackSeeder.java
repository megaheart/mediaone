package com.shopkeeper.linh.seeders;

import com.shopkeeper.linh.models.Feedback;
import com.shopkeeper.linh.models.FeedbackType;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

public class FeedbackSeeder {
    public static void SeedData(){
        var adapter = DatabaseAdapter.getDbAdapter();
        var products = adapter.getAllProducts();
        var musics = adapter.getAllMusicInfos();
        var films = adapter.getAllFilmInfos();
        var books = adapter.getAllBookInfos();
        var staffs = adapter.getAllStaffs();

        Feedback[] list = {
                new Feedback("Dịch vụ", "Quá chuẩn chỉnh nuôn",
                        FeedbackType.Satisfied, true, LocalDate.of(2022,3,25)),
                new Feedback("Sản phẩm", "Haizz chán đ*o chịu đc",
                        FeedbackType.Unsatisfied, products.get(3), false, LocalDate.of(2021, 3, 18)),
                new Feedback("Nhạc/Phim/Sách", "Thiếu miêu tả về sếp",
                        FeedbackType.Suggestions, musics.get(0), 5, true, LocalDate.of(2019, 10, 15)),
                new Feedback("Nhân viên", "Anh có info ko cho em xin",
                        FeedbackType.Satisfied, staffs.get(0), false, LocalDate.of(2020, 1, 3))
        };
        for(var x : list){
            adapter.insertFeedback(x);
        }
    }
}
