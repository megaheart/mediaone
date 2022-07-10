package com.shopkeeper.mediaone;

import com.shopkeeper.lam.database.*;
import com.shopkeeper.lam.funtions.ProductInfoManager;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.lam.windowfactories.fileFxml.CustomerWindowFactory;
import com.shopkeeper.lam.windowfactories.fileFxml.ManagerWindowFactory;
import com.shopkeeper.linh.models.*;

import com.shopkeeper.linh.windowfactories.CustomerFeedbackWindowFactory;
import com.shopkeeper.linh.windowfactories.CustomerManagerWindowFactory;

import com.shopkeeper.linh.windowfactories.FeedbackWindowFactory;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*ManagerWindowFactory.getFactory().openWindow();
        *//*CustomerWindowFactory.getFactory().openWindow();*//*

        //javafx.application.Platform.exit();*/
       /* testProduct.insert();*/
        var adapter = DatabaseAdapter.getDbAdapter();
        var categories = adapter.getAllCategories();
        var publishers = adapter.getAllPublishers();
        var people = adapter.getAllPeople();
        int count = 0;
        for(var i:ProductInfoManager.getManager().getAllMusicInfo()){
            count++;
        }
        System.out.println(count);

        MusicInfo m = new MusicInfo("Lạc Trôi", "Lạc trôi là một bài hát của nam ca sĩ kiêm sáng tác nhạc Sơn Tùng M-TP được trích từ album phòng thu đầu tiên của anh, m-tp M-TP (2017). Nó được phát hành với vai trò là đĩa đơn mở đường trong album. Bài hát được sáng tác và thể hiện bởi chính Sơn Tùng với sự đồng hỗ trợ của nhà sản xuất Triple D. Ca khúc được phát hành lần đầu tiên trên hệ thống YouTube vào lúc ngày 1 tháng 1 năm 2017 giờ Việt Nam[1] và được phát hành trên hệ thống cửa hàng iTunes bởi công ty M-TP Entertainment và bởi Nhac.vn. Đây là ca khúc đầu tiên của Sơn Tùng M-TP trong năm 2017 cũng như ca khúc đầu tiên của Sơn Tùng sau khi rời khỏi WePro Entertainment và người quản lý cũ Nguyễn Quang Huy.",
                categories.get(0),
                LocalDate.of(2017, 1, 1), 500000, publishers.get(17), 5,
                new ArrayList<>(Arrays.asList("Top thịnh hành Youtube")),
                new ArrayList<>(Arrays.asList(people.get(4))),
                LocalTime.of(0, 4, 15));
        ProductInfoManager.getManager().addMusicInfo(m);
        count = 0;
        for(var i:ProductInfoManager.getManager().getAllMusicInfo()){
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        launch();
    }
}