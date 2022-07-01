package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.BookInfo;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class testBookInfo {
    public void insert() throws Exception {

        var adapter = DatabaseAdapter.getDbAdapter();
        var categories = adapter.getAllCategories();
        var people = adapter.getAllPeople();
        var publishers = adapter.getAllPublishers();
        BookInfo b1 = new BookInfo("Em của ngày hôm qua", "nhạc hay, chất lượng, nghe rất phiêu", categories.get(3),
                LocalDate.of(2013, 6, 12), 500000, publishers.get(3), 5,
                new ArrayList<>(Arrays.asList("Cánh diều hâu", "Đạo nhạc Cực Căng", "Ahihi:)")),
                new ArrayList<>(Arrays.asList(people.get(3), people.get(2))),
                50);
        BookInfo b2 = new BookInfo("Kém duyên", ":)))) nghe phèn vl", categories.get(0),
                LocalDate.of(2020, 2, 14), 1000, publishers.get(2), 1,
                new ArrayList<>(Arrays.asList("Mâm xôi vàng", "Quay MV kiếm con rơi", "Ahihi:)")),
                new ArrayList<>(Arrays.asList(people.get(4), people.get(1))),
                100);
        BookInfo b3 = new BookInfo("Đắc nhân tâm", "Đắc nhân tâm (Được lòng người), tên tiếng Anh là How to Win Friends and Influence People là một quyển sách nhằm tự giúp bản thân (self-help) bán chạy nhất từ trước đến nay. Quyển sách này do Dale Carnegie viết và đã được xuất bản lần đầu vào năm 1936, nó đã được bán 15 triệu bản trên khắp thế giới.[1][2] Nó cũng là quyển sách bán chạy nhất của New York Times trong 10 năm. Tác phẩm được đánh giá là cuốn sách đầu tiên và hay nhất trong thể loại này, có ảnh hưởng thay đổi cuộc đời đối với hàng triệu người trên thế giới.", categories.get(0),
                LocalDate.of(2022, 2, 14), 100000, publishers.get(2), 1,
                new ArrayList<>(Arrays.asList("Mâm xôi vàng", "Quay MV kiếm con rơi", "Ahihi:)")),
                new ArrayList<>(Arrays.asList(people.get(4), people.get(1))),
                100);
        for(var x : adapter.getAllBookInfos()){
            System.out.println(x);
        }
        adapter.insertBookInfo(b1);
        adapter.insertBookInfo(b2);
        System.out.println("----------<><><><><>----------");
        for(var x : adapter.getAllBookInfos()){
            System.out.println(x);
        }
    }
    public void update() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        var categories = adapter.getAllCategories();
        var people = adapter.getAllPeople();
        var publishers = adapter.getAllPublishers();
        var musics = adapter.getAllBookInfos();
        for(var x : adapter.getAllBookInfos()){
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
        m2.setAuthors(new ArrayList<>(Arrays.asList(people.get(4), people.get(1), people.get(2))));
        m2.setNumberOfPage(69);
        adapter.updateBookInfo(m2);
        System.out.println("----------<><><><><>----------");
        for(var x : adapter.getAllBookInfos()){
            System.out.println(x);
        }
    }
    public void delete() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllBookInfos()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllBookInfos().get(1);
        adapter.deleteBookInfo(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllBookInfos()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
