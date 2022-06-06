package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.FilmInfo;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class testFilmInfo {
    public void insert() throws Exception {

        var adapter = DatabaseAdapter.getDbAdapter();
        var categories = adapter.getAllCategories();
        var people = adapter.getAllPeople();
        var publishers = adapter.getAllPublishers();
        FilmInfo f1 = new FilmInfo("Em của ngày hôm qua", "nhạc hay, chất lượng, nghe rất phiêu", categories.get(3),
                LocalDate.of(2013, 6, 12), 500000, publishers.get(3), 5,
                new ArrayList<>(Arrays.asList("Cánh diều hâu", "Đạo nhạc Cực Căng", "Ahihi:)")),
                people.get(0),
                new ArrayList<>(Arrays.asList(people.get(3), people.get(2))),
                LocalTime.of(0, 3, 50));
        FilmInfo f2 = new FilmInfo("Kém duyên", ":)))) nghe phèn vl", categories.get(0),
                LocalDate.of(2020, 2, 14), 1000, publishers.get(2), 1,
                new ArrayList<>(Arrays.asList("Mâm xôi vàng", "Quay MV kiếm con rơi", "Ahihi:)")),
                people.get(0),
                new ArrayList<>(Arrays.asList(people.get(4), people.get(1))),
                LocalTime.of(0, 4, 30));
        for(var x : adapter.getAllFilmInfos()){
            System.out.println(x);
        }
        adapter.insertFilmInfo(f1);
        adapter.insertFilmInfo(f2);
        System.out.println("----------<><><><><>----------");
        for(var x : adapter.getAllFilmInfos()){
            System.out.println(x);
        }
    }
    public void update() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        var categories = adapter.getAllCategories();
        var people = adapter.getAllPeople();
        var publishers = adapter.getAllPublishers();
        var musics = adapter.getAllFilmInfos();
        for(var x : adapter.getAllFilmInfos()){
            System.out.println(x);
        }
        var m2 = musics.get(1);
        m2.setTitle("Ve ben anh");
        m2.setDescription("Mang bau ke em");
        m2.setCategory(categories.get(2));
        m2.setReleaseDate(LocalDate.of(2021, 6,1));
        m2.setCurrentSalePrice(2000);
        m2.setPublisher(publishers.get(1));
        m2.setRating(2);
        m2.setAward(new ArrayList<>(Arrays.asList("Mâm xôi gấc", "Hello kitty")));
        m2.setActors(new ArrayList<>(Arrays.asList(people.get(4), people.get(1), people.get(2))));
        m2.setDirector(people.get(3));
        m2.setTimeLimit(LocalTime.of(0,2,30));
        adapter.updateFilmInfo(m2);
        System.out.println("----------<><><><><>----------");
        for(var x : adapter.getAllFilmInfos()){
            System.out.println(x);
        }
    }
    public void delete() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllFilmInfos()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllFilmInfos().get(1);
        adapter.deleteFilmInfo(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllFilmInfos()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
