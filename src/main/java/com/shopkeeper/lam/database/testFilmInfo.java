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
        FilmInfo f1 = new FilmInfo("Thánh bài", "Thánh bài nhại theo phim Thần bài (1989), một trong những phim về thể loại cờ bạc nổi tiếng của đạo diễn Vương Tinh. Trong phim điện ảnh Hồng Kông này, Châu Tinh Trì thủ vai chính và vươn lên vị trí ngôi sao hàng đầu của phim hài Hồng Kông cũng như định hình phong cách diễn của mình từ đó về sau.", categories.get(1),
                LocalDate.of(1989, 1, 1), 500000, publishers.get(22), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 3, 50));
        FilmInfo f2 = new FilmInfo("Titanic", "Titanic là một bộ phim điện ảnh lãng mạn thảm họa sử thi của Mỹ phát hành năm 1997, do James Cameron làm đạo diễn, viết kịch bản, đồng sản xuất, đồng biên tập và hỗ trợ tài chính một phần.", categories.get(10),
                LocalDate.of(1911, 11, 1), 100000, publishers.get(23), 5,
                new ArrayList<>(Arrays.asList("Quả cầu vàng", "giải Broadcast Film Critics Association", "Producer Guild of America")),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f3 = new FilmInfo("Tuyệt đỉnh Kung-fu","Tuyệt đỉnh Kungfu là một bộ phim hài hước - hành động - võ thuật Hồng Kông, được công chiếu vào năm 2004. Phim được sản xuất kiêm đạo diễn và diễn viên chính bởi Châu Tinh Trì. Phim là một sự nhai lại khôi hài và là một lòng tôn kính tới thể loại tiểu thuyết võ hiệp Kim Dung.",
                categories.get(1),LocalDate.of(1941, 1, 12),
                150000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16))),
                LocalTime.of(2, 4, 30));
        FilmInfo f4 = new FilmInfo("Ký sinh trùng","Ký sinh trùng là một bộ phim điện ảnh hài kịch đen của Hàn Quốc ra mắt năm 2019 do Bong Joon-ho làm đạo diễn, đồng sản xuất kiêm viết kịch bản, với sự tham gia của dàn diễn viên gồm Song Kang-ho, Lee Sun-kyun, Cho Yeo-jeong, Choi Woo-sik, Park So-dam, Lee Jung-eun, Park Myung-hoon và Jang Hye-jin.",
                categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Best Film Not In The English Language","Giải Oscar")),
                people.get(0),
                new ArrayList<>(Arrays.asList(people.get(25), people.get(24))),
                LocalTime.of(2, 4, 30));
        FilmInfo f5 = new FilmInfo("Thần ăn","Thần ăn là một bộ phim Hồng Kông do Châu Tinh Trì và Lý Lực Trì đạo diễn, tác phẩm được công chiếu lần đầu năm 1996. Là một phim hài về ẩm thực, bộ phim nói về những cuộc thi nấu ăn ở Hồng Kông để tranh vị trí \"Thần ăn\". Dàn diễn viên chính của phim gồm có Châu Tinh Trì, Mạc Văn Úy, Cốc Đức Chiêu và Ngô Mạnh Đạt.",
                categories.get(0),LocalDate.of(1910, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 4, 30));
        FilmInfo f6 = new FilmInfo("Đội bóng thiếu lâm","Đội bóng Thiếu Lâm là một bộ phim hài - hành động - võ thuật xen lẫn với chính kịch về đề tài thể thao của Hồng Kông ra mắt năm 2001 do Châu Tinh Trì làm đạo diễn kiêm đồng viết kịch bản, Dương Quốc Huy sản xuất với phần chỉ đạo võ thuật của Trình Tiểu Đông.",
                categories.get(0),LocalDate.of(1910, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 4, 30));
        FilmInfo f7 = new FilmInfo("Tây du ký: Mối tình ngoại truyện","Tây du ký: Mối tình ngoại truyện là một bộ phim hành động - cổ trang - kỳ ảo xen lẫn với hài chính kịch ra mắt năm 2013 do Hồng Kông - Trung Quốc hợp tác sản xuất.",
                categories.get(23),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f8 = new FilmInfo("Mỹ nhân ngư","Mỹ nhân ngư là phim điện ảnh thuộc thể loại hài chính kịch xen lẫn với hình sự - phiêu lưu - kỳ ảo của Hồng Kông - Trung Quốc ra mắt năm 2016 do Châu Tinh Trì làm đạo diễn, viết kịch bản và đồng sản xuất, với sự góp mặt của các diễn viên chính gồm Lâm Doãn, Đặng Siêu, Trương Vũ Kỳ và La Chí Tường.",
                categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 4, 30));
        FilmInfo f9 = new FilmInfo("Quốc Sản 007","Quốc Sản 007 là một bộ phim hành động - hài hước của Hồng Kông do Châu Tinh Trì và Lý Lực Trì đồng đạo diễn. Châu Tinh Trì thủ vai chính trong phim. Bộ phim do hãng Win's Movie Production Ltd sản xuất, công chiếu lần đầu tiên vào năm 1994. Bộ phim giễu nhại lại loạt phim James Bond và nhân vật điệp viên 007. ",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16))),
                LocalTime.of(2, 4, 30));
        FilmInfo f10 = new FilmInfo("Trường học Uy Long I","Trường học Uy Long I là một bộ phim hài hước - hành động Hồng Kông của đạo diễn Trần Gia Thượng và diễn viên Châu Tinh Trì, được sản xuất vào năm 1991. Tiếp sau sự thành công của bộ phim này đã tạo tiền đề cho sự thành công của các phần tiếp theo là Trường học Uy Long II và Trường học Uy Long III.",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 4, 30));
        FilmInfo f11 = new FilmInfo("Trường học Uy Long II","Trường học Uy Long II là một bộ phim hài hước - hành động Hồng Kông của đạo diễn Trần Gia Thượng và diễn viên Châu Tinh Trì, được sản xuất vào năm 1991. Tiếp sau sự thành công của bộ phim này đã tạo tiền đề cho sự thành công của các phần tiếp theo là Trường học Uy Long III.",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 4, 30));
        FilmInfo f12 = new FilmInfo("Quan xẩm lốc cốc","Sau khi rơi vào lưới tình và nỗ lực vạch trần những hành vi sai trái, gã quan thối nát đương đầu với đám tội phạm xấu xa và có được những mánh khóe mới tại lầu xanh.",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 4, 30));
        FilmInfo f13 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList("Không biết")),
                people.get(26),
                new ArrayList<>(Arrays.asList(people.get(16), people.get(23))),
                LocalTime.of(2, 4, 30));
        FilmInfo f14 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList()),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f15 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList()),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f16 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList()),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f17 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList()),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f18 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList()),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f19 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList()),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
        FilmInfo f20 = new FilmInfo("","",categories.get(0),LocalDate.of(1911, 11, 1),
                50000,publishers.get(22),5,
                new ArrayList<>(Arrays.asList()),
                people.get(3),
                new ArrayList<>(Arrays.asList(people.get(1), people.get(2))),
                LocalTime.of(2, 4, 30));
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
