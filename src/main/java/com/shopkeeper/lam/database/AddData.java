package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.ImportBill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AddData {
    public void insert() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        var categories = adapter.getAllCategories();
        var people = adapter.getAllPeople();
        var publishers = adapter.getAllPublishers();

        //Add person
        Person[] x = new Person[31];
        x[1]=new Person("Bong Joon-ho", LocalDate.of(1969 ,9,14 ),"Bong Joon-ho là đạo diễn, nhà sản xuất và biên kịch phim người Hàn Quốc. Ông là một trong số ít các đạo diễn người châu Á chiến thắng giải Oscar cũng như là một trong những đạo diễn điện ảnh xuất sắc nhất thế giới hiện nay.", JobOfPerson.FILM_DIRECTOR);
        x[2]=new Person("Kate Winslet",LocalDate.of(1865 ,9,22),"Không biết",JobOfPerson.ACTOR);
        x[3]=new Person("Leonardo DiCaprio",LocalDate.of(1870 ,8,18 ),"Không biết",JobOfPerson.ACTOR);
        x[4]=new Person("James Francis Cameron",LocalDate.of(1954 ,8,16),"James Cameron đã thắng 3 giải Oscar trong tổng số 6 đề cử, cả 3 giải đó đều thắng nhờ bộ phim Titanic. Bộ phim Titanic đã thắng đến 11 giải Oscar năm 1998, biến bộ phim trở thành một trong những bộ phim thắng nhiều Oscar nhất từ trước đến giờ. Avatar cũng vô cùng thành công với 3 giải Oscar, đang nắm giữ danh hiệu bộ phim có doanh thu toàn cầu lớn nhất mọi thời đại. Sắp tới, James Cameron cũng đã lên kế hoạch thực hiện 4 phần tiếp theo của Avatar.",JobOfPerson.FILM_DIRECTOR);
        x[5]=new Person("Sơn Tùng MTP",LocalDate.of(1994 ,7,5),"hay nhat viet nam",JobOfPerson.SINGER);
        x[6]=new Person("Michael Bay",LocalDate.of(1965 ,2,17),"Michael Benjamin Bay is an American film director and producer. He is best known for making big-budget, high-concept action films characterized by fast cutting, stylistic cinematography and visuals, and extensive use of special effects, including frequent depictions of explosions",JobOfPerson.FILM_DIRECTOR);
        x[7]=new Person("Shia LaBeouf",LocalDate.of(1985 ,2,5 ),"Diễn viên trong Tranformer",JobOfPerson.ACTOR);
        x[8]=new Person("Josh Duhamel ",LocalDate.of(1934 ,8,18 ),"Diễn viên trong Tranformer",JobOfPerson.ACTOR);
        x[9]=new Person("Alan Walker",LocalDate.of(1997 ,8,24 ),"Alan Olav Walker, thường được biết đến với nghệ danh Alan Walker là một nam DJ và nhà sản xuất thu âm người Na Uy gốc Anh. Vào năm 2015, Alan bắt đầu trở nên nổi tiếng trên phạm vi quốc tế sau khi phát hành đĩa đơn \"Faded\" và nhận được chứng nhận bạch kim tại 14 quốc gia.",JobOfPerson.MUSICIAN);
        x[10]=new Person("Bill Gates",LocalDate.of(1955 ,10,28 ),"William Henry Bill Gates III là một doanh nhân người Mỹ, nhà từ thiện, tác giả và chủ tịch tập đoàn Microsoft, hãng phần mềm mà ông cùng với Paul Allen đã sáng lập ra. ",JobOfPerson.CEO);
        x[11]=new Person("Joss Whedon",LocalDate.of(1964 ,6,23),"Joseph Hill Whedon là nam biên kịch, đạo diễn, nhà sản xuất phim người Mỹ.",JobOfPerson.FILM_DIRECTOR);
        x[12] = new Person("Robert John Downey, Jr", LocalDate.of(1965, 4, 4), "Robert John Downey, Jr (sinh ngày 4 tháng 4 năm 1965) là một diễn viên người Mỹ. Tham gia diễn xuất từ khi mới 5 tuổi trong phim Pound của cha ông. Ông tham gia các phim như Less Than Zero, Air America, Natural Born Killers, Soapdish, The Singing Detective, Kiss Kiss Bang Bang, A Scanner Darkly, Gothika, Zodiac, Tropic Thunder, Sherlock Holmes, Sherlock Holmes: Trò chơi của bóng đêm,... Downey nổi tiếng toàn cầu vai diễn Tony Stark / Người Sắt trong các bộ phim thuộc Vũ trụ Điện ảnh Marvel như Iron Man (2008), Iron Man 2 (2010), The Avengers (2012), Iron Man 3 (2013), Avengers: Age of Ultron (2015), Captain America: Civil War (2016), Avengers: Infinity War (2018) và đặc biệt là siêu bom tấn Avengers: Endgame (2019). Ông cũng tham gia 3 series truyền hình là: Saturday Night Live, Ally McBeal và Family Guy.", JobOfPerson.ACTOR);
        x[13] = new Person("Chris Evans", LocalDate.of(1981, 6, 13), "Christopher Robert Chris Evans (sinh ngày 13 tháng 6 năm 1981) là một nam diễn viên, nhà sản xuất và đạo diễn người Mỹ. Được biết đến với vai diễn Steve Rogers / Đội trưởng Mỹ trong Vũ trụ Điện ảnh Marvel (MCU), Evans bắt đầu sự nghiệp của mình với các vai diễn trong phim truyền hình, chẳng hạn như trong Opposite Sex vào năm 2000. Sau khi xuất hiện trong một số bộ phim dành cho tuổi teen bao gồm Not Another Teen Movie năm 2001, anh đã được chú ý cho vai diễn nhân vật Johnny Storm / Human Torch của Marvel Comics trong Fantastic Four năm 2005 và phần tiếp theo của nó là Fantastic Four: Rise of the Silver Surfer (2007). Evans tiếp tục xuất hiện trong các bộ phim chuyển thể từ truyện tranh và tiểu thuyết đồ họa: TMNT (2007), Scott Pilgrim vs. the World (2010) và Snowpiercer (2013).", JobOfPerson.ACTOR);
        x[14] = new Person("Mark Alan Ruffalo", LocalDate.of(1970, 4, 2), "Mark Alan Ruffalo (/ˈrʌfəloʊ/, sinh ngày 22 tháng 11 năm 1967)[1] là một diễn viên, đạo diễn, nhà sản xuất phim Mỹ. Anh tham gia diễn xuất lần đầu trong một tập của CBS Summer Playhouse (1989), tiếp theo là một số vai diễn nhỏ. Anh thuộc nhóm các diễn viên ban đầu của This Is Our Youth (1996), trong đó ông được đề cử giải Independent Spirit, sau các vai diễn của anh trong 13 Going on 30 (2004), Eternal Sunshine of the Spotless Mind (2004), Zodiac (2007) and What Doesn't Kill You (2008). In 2010, he starred in the psychological thriller Shutter Island và hài kịch The Kids Are All Right và nhờ vở này anh đã nhận được đề cử cho giải SAG, giải BAFTA, và giải Oscar cho nam diễn viên phụ xuất sắc nhất.", JobOfPerson.ACTOR);
        x[15] = new Person("Chris Hemsworth", LocalDate.of(1983, 8, 11), "Christopher “Chris” Hemsworth[1] (sinh ngày 11 tháng 8 năm 1983) là một diễn viên người Úc. Anh được biết đến nhiều nhất qua vai diễn Thần Sấm Thor trong các bộ phim thuộc Vũ trụ Điện ảnh Marvel như Thor (2011), The Avengers (2012), Thor: The Dark World (2013), Avengers: Age of Ultron (2015), Thor: Ragnarok (2017), Avengers: Infinity War (2018), Avengers: Endgame (2019) và sắp tới là Thor: Love and Thunder (2022) cũng như trong series truyền hình What If...? chiếu trên Disney+. Vai diễn này đã giúp anh trở thành một trong những diễn viên hàng đầu và được trả cát-xê cao nhất thế giới.", JobOfPerson.ACTOR);
        x[16] = new Person("Sam Raimi", LocalDate.of(1959, 10, 23), "Samuel M. Raimi là một nhà làm phim và diễn viên người Mỹ. Ông được biết đến với việc tạo ra bộ ba Spider-Man và loạt phim Evil Dead.", JobOfPerson.FILM_DIRECTOR);
        x[17] = new Person("Châu Tinh Trì", LocalDate.of(1962, 6, 22 ), "Châu Tinh Trì là một nam diễn viên, đạo diễn, nhà biên kịch, nhà sản xuất người Hồng Kông gốc Hoa. Ngoài ra ông còn là cố vấn chính trị của Hội nghị Hiệp thương Chính trị Nhân dân Trung Quốc.", JobOfPerson.ACTOR);
        x[18] = new Person("Kiyoshi Hikawa", LocalDate.of(1977, 9, 6), "Kiyoshi Hikawa (氷川 き よ し Hikawa Kiyoshi) là một ca sĩ enka người Nhật sinh ngày 6 tháng 9 năm 1977 tại Minami-ku, Fukuoka, Nhật Bản. [1] Tên thật của anh là Kiyoshi Yamada (山田 清 志 Yamada Kiyoshi) [1] và anh được biết đến như là \"Hoàng tử của Enka\" (演 歌 界 の 貴 公子 Enkakai no Kikōshi) do tuổi trẻ và sự nổi tiếng của anh", JobOfPerson.SINGER);
        x[19] = new Person("Nguyễn Du", LocalDate.of(1766, 1, 3 ), "Nguyễn Du tên tự là Tố Như, hiệu là Thanh Hiên, biệt hiệu là Hồng Sơn lạp hộ, Nam Hải điếu đồ, là một nhà thơ, nhà văn hóa lớn thời Lê mạt Nguyễn sơ ở Việt Nam.", JobOfPerson.POET);
        x[20] = new Person("Chủ tịch Hồ Chí Minh", LocalDate.of(1890, 5, 19 ), "Người vĩ đại nhất lịch sử VIệt Nam", JobOfPerson.LEGEND);
        x[21] = new Person("Nick Vujicic", LocalDate.of(1982 , 10, 4 ), "Nicholas James Vujicic is an Australian American Christian evangelist and motivational speaker born with tetra-amelia syndrome, a rare disorder characterised by the absence of arms and legs.", JobOfPerson.MOTIVATIONAL_SPEAKER);
        x[22] = new Person("Dale Carnegie", LocalDate.of(1888, 12, 24 ), "Dale Carnegie was an American writer and lecturer, and the developer of courses in self-improvement, salesmanship, corporate training, public speaking, and interpersonal skills.", JobOfPerson.MOTIVATIONAL_AUTHOR);
        x[23] = new Person("Đàm Vĩnh Hưng", LocalDate.of(1971, 10, 2 ), "Đàm Vĩnh Hưng tên khai sinh là Huỳnh Minh Hưng, còn có biệt danh Mr. Đàm, là một ca sĩ người Việt Nam. Anh đã giành được 2 giải Cống hiến. Bên cạnh thể loại nhạc trẻ, anh còn hát những ca khúc nhạc tiền chiến mang tính chất trữ tình cũng như nhạc Trịnh Công Sơn và nhạc vàng.", JobOfPerson.SINGER);
        x[24] = new Person("Ngô Mạnh Đạt", LocalDate.of(1950, 5, 19 ), "Ngô Mạnh Đạt là cố diễn viên kỳ cựu của điện ảnh Hồng Kông với nhiều vai phụ đặc sắc. Ông cùng với Châu Tinh Trì là một cặp đôi ăn ý trong nhiều phim hài từ cuối thập niên 1980 cho đến tận thập niên 2000.", JobOfPerson.ACTOR);
        x[25] = new Person("Song Kang-ho", LocalDate.of(1967, 1, 17 ), "Đây là một tên người Triều Tiên, họ là Song. Song Kang-ho (Hàn ngôn: 송강호, Hán-Việt: Tống Khang Hạo; sinh ngày 17 tháng 1 năm 1967) là một nam diễn viên nổi tiếng người Hàn Quốc.\n", JobOfPerson.ACTOR);//kst
        x[26] = new Person("Park So-dam", LocalDate.of(1991, 9, 8 ), "Park So-dam là nữ diễn viên Hàn Quốc. Cô được nhiều người biết đến vào năm 2015 nhờ vai nữ sinh bị quỷ ám trong Mục sư và vai Eun Ha-won trong bộ phim truyền hình Hàn Quốc Lọ Lem và bốn chàng hiệp sĩ.", JobOfPerson.ACTOR);//kst
        x[27] = new Person("Lưu Trấn Vĩ", LocalDate.of(1920, 5, 19 ), "", JobOfPerson.FILM_DIRECTOR);
        x[28] = new Person("Tobey Maguire", LocalDate.of(1975, 6, 27 ), "Tobias Vincent Tobey Maguire (sinh ngày 27 tháng 6 năm 1975) là một diễn viên và nhà sản xuất điện ảnh Mỹ. Anh đã bắt đầu sự nghiệp của mình vào cuối những năm 1980. Anh được biết đến nhiều nhất với vai diễn Peter Parker / Người Nhện trong bộ ba phim Spider-Man (2002–2007) của Sam Raimi cũng như thể hiện lại vai diễn này trong Spider-Man: No Way Home (2021), vai diễn này đã mang về cho anh Kỷ lục Guinness Thế giới về \"sự nghiệp đóng vai một nhân vật Marvel lâu nhất\" (cùng với Willem Dafoe với vai Norman Osborn / Green Goblin). Anh cũng tham gia diễn xuất trong các bộ phim như Pleasantville (1998), Ride with the Devil (1999), The Cider House Rules (1999), Wonder Boys (2000), Seabiscuit (2003), The Good German (2006), Tropic Thunder (2008), and Brothers (2009) và The Great Gatsby (2013).", JobOfPerson.ACTOR);
        x[29] = new Person("Jon Favreau", LocalDate.of(1966, 10, 19 ), "Jonathan Kolia Jon Favreau là một diễn viên, người đóng hài kịch và nhà làm phim người Mỹ. Là một diễn viên, ông được biết đến nhiều nhất với những vai diễn trong Rudy, Swingers, Very Bad Things, The Break-Up và Siêu đầu bếp.", JobOfPerson.FILM_DIRECTOR);
        x[30] = new Person("Taylor Swift", LocalDate.of(1989, 12, 13 ), "Taylor Alison Swift là một nữ ca sĩ kiêm sáng tác nhạc người Mỹ. Những đĩa nhạc trải dài trên nhiều thể loại khác nhau và các sáng tác tự sự, thường lấy cảm hứng từ cuộc sống cá nhân của chính cô, đã nhận được sự tán dương rộng rãi của giới truyền thông và giới phê bình.", JobOfPerson.SINGER);

        for(int i=1;i<=30;i++){
            adapter.insertPerson(x[i]);
        }

        //add category
        Category x1 = new Category("EDM","Nhạc nhảy điện tử, còn được biết đến với thuật ngữ: EDM, được mô tả như một thể loại nhạc có tiết tấu mạnh kế thừa từ nhạc disco của những năm 1970 và ở một vài khía cạnh nào đó, nó cũng là những thể nghiệm của nhạc Pop, hay còn gọi là Nhạc POP thể nghiệm của các nhạc sĩ/ca sĩ tiền phong");//music
        Category x2 = new Category("Tình ca ","các ca khúc viết về tình yêu");
        Category x3 = new Category("Nhạc Pop","Nhạc Pop thường được phân biệt với các thể loại khác nhờ một số đặc điểm về phong cách nghệ thuật như: nhịp nhảy hay nhịp phách, những giai điệu đơn giản dễ nghe, cùng với một số đoạn trong bài hát được lặp đi lặp lại.");
        Category x4 = new Category("Nhạc đồng quê","Chịu nhiều ảnh hưởng từ những hệ thống nhạc khác như Blues, Jazz. Loại nhạc này thường mang giai điệu trầm buồn. Nguồn gốc của nhạc country xuất phát từ những người dân Anh nhập cư đến nước Mỹ. Họ mang theo các ca khúc Ballad Celtic với phần lời theo lối kể chuyện mộc mạc, bình dân.");
        Category x5 = new Category("Nhạc Rock","Dựa trên tiết tấu của ca ba loại nhạc(Blues, Jazz, Country) nhưng Rock lại có tiết tấu mạnh và nhanh hơn, thường được sử dụng cho các loại nhạc cụ điện tử, phổ biến là Guitar điện phối hợp cùng với đó là guitar bass và trống");
        Category x6 = new Category("Nhạc Dance","Nhạc Dance, hay gọi dân dã là nhạc vũ trường, là một loạt các thể loại nhạc có âm mạnh thường được dùng trong các tụ điểm vũ trường, hộp đêm, phát triển từ thể loại nhạc disco thập niên 1970");
        Category x7 = new Category("Nhạc Blues","Những ca khúc nhạc Blues thường mang đến sự buồn bã, ảm đạm, sâu lắng cho người nghe. Blues là dòng nhạc xuất hiện gần như sớm nhất trong cộng đồng người da đen sống tại Mỹ");
        Category x8 = new Category("Nhạc Jazz","Jazz là một nét văn hoá bản xứ ban đầu chỉ của riêng người Mỹ và đã được tạo ra bởi người Mỹ. Âm nhạc phương Tây và châu Phi là nơi đã gieo hạt nên Jazz, nhưng chính văn hoá Mỹ mới là nơi Jazz nảy mầm và phát triển");
        Category x9 = new Category("Nhạc R&B","R&B là viết tắt của Rhythm and Blues. Thể loại nhạc này có nguồn gốc từ cộng đồng người Phi da đen này đã phát sinh từ đầu thế kỉ 20 và trở thành một loại nhạc phổ biến trên nhiều quốc gia vào khoảng thập niên 40");
        Category x10 = new Category("Nhạc không lời","Nhạc không có lời hát nhưng rất hay,êm tai,thích thợp để thư giãn đầu óc");
        Category x11 = new Category("Nhạc Piano","Loại nhạc đánh đàn piano");
        Category x12 = new Category("Nhạc trữ tình","Nhạc trữ tình là một khái niệm vay mượn từ Trung Quốc. Chữ \"trữ tình\", có nghĩa là mô tả tình cảm.");

        //film
        Category x13 = new Category("Kinh di","phim rat dang so,khong danh cho tre em duoi 18 tuoi");//film
        Category x14 = new Category("Comedy","Thể loại gây hài hước cho người đọc hoặc xem");//film
        Category x15 = new Category("Lãng mạn","Thể loại về tình yêu");//Music,book,film
        Category x16 = new Category("Kịch","là dòng phim thường mang tính tự sự về cuộc đời của một hay nhiều nhân vật. Phim là sự kết hợp của các yếu tố tâm lý xã hội, bi – hài tạo nên một tổng thể mang lại nhiều cảm xúc đan xen lẫn nhau cho người xem.");//Music,book,film
        Category x17 = new Category("Dảk","Thể loại mà nhiều người chết hoặc NTR");//film,book
        Category x18 = new Category("Hành động","có những cuộc chiến nảy lửa,tình tiết kịch tính");//film,book
        Category x19 = new Category("Khoa học viễn tưởng","là thể loại phim với chủ đề tưởng tượng, không có thật như phép thuật, các hiện tượng thần kỳ, siêu nhiên");//film,book
        Category x20 = new Category("Lịch sử","phim có bối cảnh trong lịch sử");
        Category x21 = new Category("Phim tài liệu","là phim ghi lại các hình ảnh thực tế, không có yếu tố hư cấu và thường được sử dụng làm tài liệu giảng dạy hay lưu giữ các sự kiện mang tính chất lịch sử.");
        Category x22 = new Category("Phim ca nhạc","Trong các thể loại phim thì Musical là dạng phim mà nhân vật có ít hoặc không có lời thoại. Thay vào đó là phần âm nhạc được lồng ghép vào bên trong");
        Category x23 = new Category("Phim gia đình","là các phim có nội dung hướng đến đối tượng là mọi thế hệ trong gia đình. Kịch bản phim thường nhẹ nhàng, giải trí có có kết cục có hậu");
        Category x24 = new Category("Phim cổ trang","đây cũng là một thể loại phim đặc trưng của châu Á. Phim cổ trang cơ bản được chia làm hai nhánh nhỏ. Một là, phim tái hiện lại chính xác một sự kiện có thật trong lịch sử. Hai là, phim chỉ dựa trên bối cảnh hay nhân vật lịch sử kết hợp với các yếu tố hư cấu khác");

        //book
        Category x25 = new Category("Light novel","là một dòng tiểu thuyết có nguồn gốc từ Nhật Bản. \"Light\" trong \"light novel\" nghĩa là ngắn, nhẹ về số lượng từ ngữ. Light novel thường được gọi tắt là ranobe hay rainobe.");//book
        Category x26 = new Category("Trinh thám","truyen/phim co noi dung giai do, toi pham, pha an");//book
        Category x27 = new Category("18+","dành cho lứa tuổi 18 trở lên ");
        Category x28 = new Category("12+","Dành cho lứa tuổi trên 12");//Music,book,film
        Category x29 = new Category("Bi kịch","nội dung có những tình tiết bi kịch");//film.book
        Category x30 = new Category("Phiêu lưu"," kể về các chuyến du hành mạo hiểm bao gồm những cuộc tìm kiếm các vùng đất mới, truy tìm kho báu");//book,film
        Category x31 = new Category("Bí ẩn","thường kể về quá trình điều tra một bí ẩn chưa được khám phá");//film
        Category x32 = new Category("Tiểu thuyết lãng mạn","là một trong số các thể loại sách phổ biến nhất khi so về doanh số bán sách. Tiểu thuyết lãng mạn sở hữu một quy mô kinh doanh đa dạng nhất trong thị trường sách, các tác phẩm này được trưng bày khắp nơi từ các quầy thanh toán ở cửa hàng tạp hóa, đến các ấn phẩm định kỳ của nhà xuất bản trên nền tảng trực tuyến, cũng như thông qua các dịch vụ tự xuất bản.");
        Category x33 = new Category("Giả tưởng và khoa học viễn tưởng","Sách giả tưởng thường diễn ra trong một khoảng thời gian khác với thời gian hiện tại của chúng ta. Chúng thường có các sinh vật huyền bí, từ pháp sư / phù thuỷ cho đến những thây ma không có thật");
        Category x34 = new Category("Kinh dị, giật gân","Các thể loại sách này bao gồm các ấn phẩm thường có mối liên hệ mật thiết đến những thể loại sách Mystery và đôi khi là giả tưởng – Fantasy, yếu tố ly kỳ và kinh dị tạo nên sự hồi hộp và điểm nổi bật của thể loại sách phổ biến này. ");
        Category x35 = new Category("Sách truyền cảm hứng","Nhiều cuốn sách về self-help liên quan đến các bài học thành công trong kinh doanh hoặc bí quyết kinh doanh hiện đang đứng dầu trong các danh sách Best Sellers của thị trường này.");
        Category x36 = new Category("Tiểu sử, tự truyện và hồi ký","Đây là các thể loại sách phi hư cấu dùng để kể những câu chuyện về cuộc đời của một người.");

        Category x37 = new Category("Unkown","Bằng cách nào đó,chúng tôi không biết được thể loại là gì");

        adapter.insertCategory(x1);
        adapter.insertCategory(x2);
        adapter.insertCategory(x3);
        adapter.insertCategory(x4);
        adapter.insertCategory(x5);
        adapter.insertCategory(x6);
        adapter.insertCategory(x7);
        adapter.insertCategory(x8);
        adapter.insertCategory(x9);
        adapter.insertCategory(x10);
        adapter.insertCategory(x11);
        adapter.insertCategory(x12);
        adapter.insertCategory(x13);
        adapter.insertCategory(x14);
        adapter.insertCategory(x15);
        adapter.insertCategory(x16);
        adapter.insertCategory(x17);
        adapter.insertCategory(x18);
        adapter.insertCategory(x19);
        adapter.insertCategory(x20);
        adapter.insertCategory(x21);
        adapter.insertCategory(x22);
        adapter.insertCategory(x23);
        adapter.insertCategory(x24);
        adapter.insertCategory(x25);
        adapter.insertCategory(x26);
        adapter.insertCategory(x27);
        adapter.insertCategory(x28);
        adapter.insertCategory(x29);
        adapter.insertCategory(x30);
        adapter.insertCategory(x31);
        adapter.insertCategory(x32);
        adapter.insertCategory(x33);
        adapter.insertCategory(x34);
        adapter.insertCategory(x35);
        adapter.insertCategory(x36);
        adapter.insertCategory(x37);

        //add publishers
        Publisher[] p = new Publisher[30];
        p[0] = new Publisher("Kim Dong","Hà Nội","Nhà xuất bản Kim Đồng là nhà xuất bản chuyên về sách văn học thiếu nhi của Việt Nam được thành lập vào ngày 15 tháng 6 năm 1956 tại Hà Nội.");
        p[1] = new Publisher("Hoyoverse","Shanghai, China","miHoYo Co., Ltd. is a Chinese video game developer based in Shanghai, China. Founded in 2012 by three students from Shanghai Jiao Tong University, miHoYo currently employs 4,000 people.");
        p[2] = new Publisher("Garena","Trung Quốc","LOL,FIFA 4");
        p[3] = new Publisher("HolyWood","USA",":)))");
        p[4] = new Publisher("WibuIsYou","Japan","We can make you be wibu.");
        p[5] = new Publisher("Giáo dục và đào tạo","Việt Nam","xuất bản sách giáo dục");
        p[6] = new Publisher("Bách Khoa Hà Nội","Đại học Bách Khoa Hà Nội","xuất bản sách cho sinh viên Bách Khoa hoặc trường khác");
        p[7] = new Publisher("Nhà xuất bản trẻ","161B Lý Chính Thắng-Phường 7-Quận 3-Thành Phố Hồ Chí Minh","xuất bản truyện tranh,sách phục vụ thanh niên,thiếu nhi");
        p[8] = new Publisher("Nhà xuất bản tổng hợp TPHCM","Số 6/86 Duy Tân-Cầu Giấy-Hà Nội","Sách về chính trị,lịch sử,giáo trình,...");
        p[9] = new Publisher("Nhà xuất bản chính trị Quốc gia","Số 6/86 DUy Tân Cầu Giấy Hà Nội","Xuất bản sách chính trị,lý luận và pháp luật");
        p[10] = new Publisher("Công Thương","Tầng 4, Tòa nhà Bộ Công Thương, số 655 Phạm Văn Đồng, quận Bắc Từ Liêm, Hà Nội","Xuất bản sách chính trị,lý luận và pháp luật");
        p[11] = new Publisher("Công an nhân dân", "92 Nguyễn Du, quận Hai Bà Trưng, TP. Hà Nội", "Không");
        p[12] = new Publisher("Nhà xuất bản Dân trí", "Số 9, ngõ 26, phố Hoàng Cầu, quận Đống Đa, thành phố Hà Nội", "");
        p[13] = new Publisher("Nhà xuất bản Giao thông vận tải", "80B Trần Hưng Đạo, Quận Hoàn Kiếm, Thành phố Hà Nội", "");
        p[14] = new Publisher("Nhà xuất bản Giáo dục Việt Nam", "81 Trần Hưng Đạo - Q. Hoàn KIếm - Hà Nội", "");
        p[15] = new Publisher("Nhà xuất bản Hàng hải", "484 Lạch Tray, Ngô Quyền, Hải Phòng", "");
        p[16] = new Publisher("Big Machine Records", "Nashville, Tennessee, Hoa Kỳ", "Big Machine Records là một hãng thu âm độc lập của Mỹ, được phân phối bởi Universal Music Group và chuyên về các nghệ sĩ nhạc đồng quê và nhạc pop. Big Machine có trụ sở đặt tại Nashville, Tinnessee.");
        p[17] = new Publisher("MTP Entertainment", "Thành phố Hồ Chí Minh, Việt Nam", "M-TP Entertainment có tên đầy đủ là Công ty trách nhiệm hữu hạn M-TP Entertainment (M-TP Entertainment Ltd) là một công ty giải trí, sản xuất âm nhạc đồng thời là hãng đĩa thu âm do nam ca sĩ người Việt Nam Sơn Tùng M-TP thành lập vào ngày 8 tháng 11 năm 2016. Tên công ty được đặt theo nghệ danh khác của Sơn Tùng M-TP là M-TP.[6]Trong tự truyện \"Chạm tới giấc mơ\", Sơn Tùng M-TP cho biết việc thành lập M-TP Entertainment là bước đi giúp anh trở thành một nhà sản xuất âm nhạc thay vì ca sĩ đơn thuần. Sơn Tùng M-TP cũng muốn công ty của mình trở thành một lò đào tạo nghệ sĩ mới.[7][6]. Tuy nhiên, Sơn Tùng M-TP xác định chỉ là chủ sở hữu và làm công việc gắn với chuyên môn âm nhạc. Những công việc khác như kinh doanh, marketing, truyền thông sẽ do cộng sự của anh đảm nhận[8]");
        p[18] = new Publisher("Nhà xuất bản Khoa học Tự nhiên và Công nghệ", "Nhà A16 - Số 18 Hoàng Quốc Việt, Cầu Giấy, Hà Nội", "");
        p[19] = new Publisher("CJ Entertainment", "Seoul,Hàn Quốc", "CJ E&M Film Division (CJ E&M Pictures), trước đây là CJ Entertainment (tiếng Hàn: 씨제이엔터테인먼트, CJ엔터테인먼트), là một công ty giải trí của Hàn Quốc tham gia vào các lĩnh vực triển lãm, sản xuất, đầu tư, phân phối phim. Đây là công ty giải trí lớn nhất ở Hàn Quốc và là một công ty con của tập đoàn CJ");
        p[20] = new Publisher("Universal Pictures", "Universal City, California, Hoa Kỳ", "Universal Pictures là một công ty sản xuất và phân phối phim của Mỹ thuộc sở hữu của Comcast thông qua bộ phận NBCUniversal Phim và Giải trí của NBCUniversal. Được thành lập vào năm 1912 bởi Carl Laemmle, Mark Dintenfass, Charles O. Baumann, Adam Kessel, Pat Powers, William Swanson, David Horsley, Robert H. ");
        p[21] = new Publisher("Marvel Entertainment", " Thành phố New York, Tiểu bang New York, Hoa Kỳ", "Marvel Entertainment, LLC là một công ty giải trí của Mỹ được thành lập vào tháng 6 năm 1998 và có trụ sở tại thành phố New York, được thành lập nhờ sự sáp nhập của Marvel Entertainment Group, Inc. và ToyBiz.");
        p[22] = new Publisher("DATVIET MEDIA - CÔNG TY TNHH ĐẤT VIỆT PROLAB", "Số 43, đường Giải Phóng, Phường Đồng Tâm, Quận Hai Bà Trưng, Tp Hà Nội (TPHN)", "DATVIET MEDIA hoạt động trong lĩnh vực quảng cáo truyền thông " );
        p[23] = new Publisher("Sony", "Minato City, Tokyo, Japan", "Sony Group Corporation, commonly known as Sony and stylized as SONY, is a Japanese multinational conglomerate corporation headquartered in Kōnan, Minato, Tokyo, Japan");
        p[24] = new Publisher("CGV ", "", " Tính đến nay, CGV đang có mặt ở 26 tỉnh thành với 75 cụm rạp và khoảng 445 màn hình, đến năm 2020, CGV dự định sẽ đạt được 96 cụm rạp");
        p[25] = new Publisher("Công ty TNHH Thắng Việt", "Số 13, Đường 26, Khu Dân Cư An Lạc, P. Bình Trị Đông B, Q. Bình Tân,Tp. Hồ Chí Minh", "");
        p[26] = new Publisher("Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành", "142 Pasteur, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Công ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành là một trong những công ty chuyên phân phối băng đĩa nhạc, in sang băng-đĩa cam kết chất lượng và giá cả phải chăng  ");
        p[27] = new Publisher("Công Ty Cổ Phần Sản Xuất Thương Mại Những Gương Mặt Âm Nhạc", "90 Đề Thám, P. Cầu Ông Lãnh, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Công ty Cổ Phần Sản Xuất Thương Mại Những Gương Mặt Âm Nhạc chuyên sản xuất băng đĩa nhạc, sản xuất chương trình và nhà cung cấp phòng thu. Công ty luôn đem đến cho thính giả những sản phẩm âm nhạc đặc sắc nhất, ghi lại dấu ấn trong lòng người nghe nhất");
        p[28] = new Publisher("Công Ty Maxell Asia", "Phòng 15, TầngM, Cao ốc Sun Wah, 115 Nguyễn Huệ, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Văn phòng Đại Diện – Công ty Maxell Asia cung cấp băng đĩa nhạc, nhận in sang băng đĩa nhiều nhiều khách hàng tin tưởng và cho nhiều phản hồi tốt từ chất lượng sản phẩm đến dịch vụ");
        p[29] = new Publisher("Công Ty TNHH Thương Mại Kim Như", "151/4 Tôn Thất Đạm, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Công ty TNHH Thương Mại Kim Thư Nằm trong top những cơ sở bán đĩa phim chất lượng sản phẩm, uy tín ở TP. Hồ Chí Minh, chuyên cung cấp đĩa trắng nhập khẩu từ các hãng đĩa DVD danh tiếng như Maxell, Sony, Verbatim, Kachi, Melody… được nhiều người thích coi phim , phòng game, dân IT sử dụng.");


        for(Publisher pi : p){
            adapter.insertPublisher(pi);
        }
        //Add BookInfo
        BookInfo[] b = new BookInfo[20];
        b[0] = new BookInfo("Cuộc sống không giới hạn", "CÂU CHUYỆN DIỆU KỲ CỦA CHÀNG TRAI ĐẶC BIỆT NHẤT HÀNH TINH Nick sinh ra mắc hội chứng Tetra-amelia bẩm sinh, một rối loạn gen hiếm gặp gây ra sự thiếu hụt chân, tay. Điều đó đồng nghĩa với việc anh có rất ít hy vọng để sống một cuộc đời bình thường. ... ",
                categories.get(34), LocalDate.of(2007, 8, 31), 60000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(20))),
                120);
        b[1] = new BookInfo("Đừng Bao Giờ Từ Bỏ Khát Vọng", "“Đừng bao giờ từ bỏ khát vọng” là quyển sách thứ hai của Nick Vujicic. Nguồn cảm hứng để anh viết cuốn sách này đến từ những người thuộc mọi lứa tuổi trên khắp thế giới, những người anh đã cho lời khuyên và hướng dẫn họ đương đầu với những thách thức trong cuộc sống.",
                categories.get(34), LocalDate.of(2012, 10, 2), 50000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(20))),
                98);
        b[2] = new BookInfo("Sống Cho Điều Ý Nghĩa Hơn", "Sau hai cuốn tự truyện gây sốt cho độc giả: Cuộc Sống Không Giới Hạn và Đừng Bao Giờ Từ Bỏ Khát Vọng, một lần nữa độc giả Việt Nam lại được hội ngộ cùng Nick Vujicic thông qua tác phẩm Limitless – Sống Cho Điều Ý Nghĩa Hơn. Tựa sách được đặt từ ý nghĩa của bài hát nổi tiếng nhất của Nick Something More, do Công ty Văn hóa Sáng tạo Trí Việt – First News ấn hành vào ngày 16/05/2013 nhân sự kiện chàng trai đặc biệt nhất hành tinh Nick Vujicic sang thăm Việt Nam và gặp gỡ, trò chuyện cùng mọi người.",
                categories.get(34), LocalDate.of(2013, 5, 16), 500000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(20))),
                80);
        b[3] = new BookInfo("Cái Ôm Diệu Kỳ", "Với Cái Ôm Diệu Kỳ, một cuốn sách dành cho trẻ em, lứa tuổi bắt đầu nhận thức và tiếp thu các vấn đề trong cuộc sống, thông qua câu chuyện của Nick, chúng tôi hy vọng đây sẽ là nguồn cảm hứng bất tận giúp các em biết yêu thương những người xung quanh, biết đứng dậy sau những vấp ngã và vượt qua những giới hạn của bản thân để trở thành người có ích và sống cho những điều ý nghĩa hơn, giống như tên của một cuốn sách được xuất bản trước đây của Nick.",
                categories.get(34), LocalDate.of(2013, 5, 7), 390000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(20))),
                76);
        b[4] = new BookInfo("Đứng Dậy Mạnh Mẽ", "Nếu bạn bị bắt nạt, bạn sẽ thấy nó gây tổn thương cho bạn. Quả là khó chịu đựng khi cảm thấy tình trạng bị bắt nạt dường như như sẽ không bao giờ chịu chấm dứt. Là người thỉnh thoảng phải chịu đựng sự bắt nạt suốt những năm mới lớn cho đến khi trưởng thành, tôi muốn mang đến cho bạn niềm hy vọng và cảm giác bình yên. Bạn có thể vươn lên, vượt qua chuyện đó.Với cuốn sách này, tác giả hy vọng “khi gấp cuốn sách lại bạn đọc có thể cảm thấy tự tin hơn, mạnh mẽ hơn, được chuẩn bị tốt hơn để đương đầu không chỉ với sự bắt nạt mà những thách thức khác trong cuộc sống.",
                categories.get(34), LocalDate.of(2007, 8, 31), 100000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(20))),
                150);
        b[5] = new BookInfo("Nhật ký trong tù", "Nhật ký trong tù là tập thơ chữ Hán gồm 134 bài theo thể Đường luật do Hồ Chí Minh sáng tác trong thời gian bị chính quyền Tưởng Giới Thạch bắt giam ở Quảng Tây, Trung Quốc, từ ngày 29 tháng 8 năm 1942 đến ngày 10 tháng 9 năm 1943.",
                categories.get(35), LocalDate.of(1943, 10, 19), 100000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(19))),
                163);
        b[6] = new BookInfo("Bản án chế độ thực dân Pháp", "Bản án chế độ thực dân Pháp (tiếng Pháp: Le Procès de la colonisation française) là một tác phẩm chính luận do Nguyễn Ái Quốc viết bằng tiếng Pháp và được xuất bản lần đầu ở Paris năm 1925 trên một tờ báo của Quốc tế Cộng sản có tên Imprékor, tại Việt Nam được xuất bản lần đầu năm 1946.",
                categories.get(35), LocalDate.of(1946, 10, 19), 100000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(19))),
                133);
        b[7] = new BookInfo("Con đường phía trước (The Road Ahead)", "Bill Gates - Con Đường Phía Trước là cuốn sách độc đáo và nổi tiếng do chính tay Bill Gates viết. Cuốn sách đã lập kỷ lục được bình chọn là cuốn sách bán chạy nhất nhiều tháng liền khi phát hành tại Mỹ, là cuốn sách không thể thiếu cho bất cứ ai quan tâm đến công nghệ thông tin.",
                categories.get(34), LocalDate.of(1995, 11, 24), 100000, publishers.get(15), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(9))),
                163);
        b[8] = new BookInfo("Tốc Độ Tư Duy (Business @ the Speed of Thought)", "",
                categories.get(34), LocalDate.of(1999, 10, 19), 100000, publishers.get(17), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(9))),
                220);
        b[9] = new BookInfo("How to Prevent the Next Pandemic", "How to Prevent the Next Pandemic is a 2022 book by Bill Gates. In it, Gates details the COVID-19 pandemic and how to prevent another pandemic, including proposing a \"Global Epidemic Response and Mobilization\" team with annual funding of $1 billion. ",
                categories.get(34), LocalDate.of(2022, 5, 19), 150000, publishers.get(16), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(9))),
                173);
        b[10] = new BookInfo("Bill Gates Quotes: Bill Gates, Quotes, Quotations, Famous", "\" The Best Bill Gates Quotation Book ever Published. Special Edition This book of Bill Gates quotes contains only the rarest and most valuable quotations ever recorded about Bill Gates, authored by a team of experienced researchers",
                categories.get(34), LocalDate.of(2016, 6, 4), 120000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(9))),
                169);
        b[11] = new BookInfo("How to Avoid a Climate Disaster", "How to Avoid a Climate Disaster: The Solutions We Have and the Breakthroughs We Need is a 2021 book by Bill Gates. In it, Gates presents what he learned in over a decade of studying climate change and investing in innovations to address global warming and recommends strategies to tackle it.",
                categories.get(34), LocalDate.of(2021, 2, 16), 130000, publishers.get(11), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(9))),
                180);
        b[12] = new BookInfo("The Art of Avatar", "The Art of Avatar is a film production art book released on November 30, 2009, by Abrams Books.",
                categories.get(29), LocalDate.of(2009, 11, 30), 200000, publishers.get(8), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(3))),
                300);
        b[13] = new BookInfo("Battleship Bismarck: A Design and Operational History", "“A complete operational history of the Bismarck . . . with period photos [and] underwater photography of the wreck, allowing a forensic analysis of the damage.”",
                categories.get(27), LocalDate.of(2019, 11, 30), 200000, publishers.get(17), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(3))),
                300);
        b[14] = new BookInfo("Ghosts of the Titanic", "Using the latest technology to penetrate the \"Titanic's\" watery grave, the author of \"Her Name, Titanic\" recreates those last, horrifying moments on board the doomed ship and uncovers fascinating secrets about ocean life.",
                categories.get(29), LocalDate.of(2000, 1, 1), 50000, publishers.get(11), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(3))),
                200);
        b[15] = new BookInfo("Dr. Horrible", "Revisit the smash-hit web musical Dr. Horrible's Sing-Along Blog with the stories that started it all by Zack Whedon and a brand-new story by Joss Whedon set after the events of the web series! ",
                categories.get(30), LocalDate.of(2019, 6, 25), 200000, publishers.get(10), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(10))),
                300);
        b[16] = new BookInfo("Astonishing X-Men - Volume 1: Gifted", "Dream-team creators Joss Whedon and John Cassaday present a brand-new era for the X-Men! Cyclops and Emma Frost re-form the X-Men with the express purpose of \"astonishing\" the world.",
                categories.get(30), LocalDate.of(2004, 1, 1), 50000, publishers.get(12), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(10))),
                100);
        b[17] = new BookInfo("Astonishing X-Men: Torn. Vol. 3", "Emma Frost's erratic behavior has the X-Men spinning in a non-stop downward spiral. Will an unlikely union be the final straw? After secretly lying in wait for months, the new Hellfire Club makes its move! Plus: The X-Man destined to destroy the Breakworld stands revealed! Who is it, and what will be their fate?",
                categories.get(30), LocalDate.of(2007, 2, 14), 100000, publishers.get(14), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(10))),
                100);
        b[18] = new BookInfo("Chạm tới giấc mơ", "TTO - Chạm tới giấc mơ là tên tự truyện đầu tiên của ca sĩ Sơn Tùng M-TP, chính thức phát hành vào ngày 30-9. Sơn Tùng cho hay anh đã ấp ủ viết tự truyện này từ rất lâu với mục đích truyền cảm hứng đến giới trẻ, khuyến khích các bạn dám nghĩ, dám làm để theo đuổi ước mơ của mình.",
                categories.get(35), LocalDate.of(2017, 9, 30), 80000, publishers.get(4), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(4))),
                120);
        b[19] = new BookInfo("Đắc nhân tâm", "Đắc nhân tâm, tên tiếng Anh là How to Win Friends and Influence People là một quyển sách nhằm tự giúp bản thân bán chạy nhất từ trước đến nay. Quyển sách này do Dale Carnegie viết và đã được xuất bản lần đầu vào năm 1936, nó đã được bán 15 triệu bản trên khắp thế giới.",
                categories.get(34), LocalDate.of(1936, 10, 19), 70000, publishers.get(6), 5,
                new ArrayList<>(Arrays.asList("Không biết")),
                new ArrayList<>(Arrays.asList(people.get(21))),
                291);
        for(BookInfo v : b){
            adapter.insertBookInfo(v);
        }

        ImportBill[] bookBills = new ImportBill[20];
        ImportBill[] filmBills = new ImportBill[20];
        ImportBill[] musicBills = new ImportBill[20];

        //music
        musicBills[0] = new ImportBill("Đĩa nhạc Lạc Trôi", 100000, LocalDate.of(2021,12,4), true, "3 đĩa", "Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành");
        musicBills[1] = new ImportBill("Đĩa nhạc Hãy trao cho anh", 100000, LocalDate.of(2021,11,3), true, "3 đĩa", "Tổng Công Ty Văn Hóa Sài Gòn");
        musicBills[2] = new ImportBill("Đĩa nhạc Nơi này có anh", 100000, LocalDate.of(2021,6,5), true, "3 đĩa", "Công Ty Maxell Asia");
        musicBills[3] = new ImportBill("Đĩa nhạc Chạy ngay đi ", 100000, LocalDate.of(2022,2,1), true, "3 đĩa", "Tổng Công Ty Văn Hóa Sài Gòn");
        musicBills[4] = new ImportBill("Đĩa nhạc Chúng ta không thuộc về nhau", 100000, LocalDate.of(2021,12,5), true, "3 đĩa", "Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành");
        musicBills[5] = new ImportBill("Đĩa nhạc Có chắc yêu là đây", 100000, LocalDate.of(2021,12,6), true, "3 đĩa", "Công Ty Maxell Asia");
        musicBills[6] = new ImportBill("Đĩa nhạc Âm thầm bên em", 100000, LocalDate.of(2021,11,7), true, "3 đĩa", "Công Ty Maxell Asia");
        musicBills[7] = new ImportBill("Đĩa nhạc Lâu Đài Tình Ái", 100000, LocalDate.of(2021,10,3), true, "3 đĩa", "Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành");
        musicBills[8] = new ImportBill("Đĩa nhạc Blank Space", 100000, LocalDate.of(2021,11,9), true, "3 đĩa", "Tổng Công Ty Văn Hóa Sài Gòn");
        musicBills[9] = new ImportBill("Đĩa nhạc I Knew You Were Trouble", 100000, LocalDate.of(2021,5,4), true, "3 đĩa", "Công Ty Maxell Asia");
        musicBills[10] = new ImportBill("Đĩa nhạc Love Story", 100000, LocalDate.of(2021,8,4), true, "3 đĩa", "Tổng Công Ty Văn Hóa Sài Gòn");
        musicBills[11] = new ImportBill("Đĩa nhạc Lover", 100000, LocalDate.of(2022,5,4), true, "3 đĩa", "Tổng Công Ty Văn Hóa Sài Gòn");
        musicBills[12] = new ImportBill("Đĩa nhạc You Belong with Me", 100000, LocalDate.of(6,12,4), true, "3 đĩa", "Tổng Công Ty Văn Hóa Sài Gòn");
        musicBills[13] = new ImportBill("Đĩa nhạc Shake It Off", 100000, LocalDate.of(2022,3,4), true, "3 đĩa", "Công Ty Maxell Asia");
        musicBills[14] = new ImportBill("Đĩa nhạc Bad Blood", 100000, LocalDate.of(2022,2,4), true, "3 đĩa", "Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành");
        musicBills[15] = new ImportBill("Đĩa nhạc Sakura Sakura", 100000, LocalDate.of(2022,5,4), true, "3 đĩa", "Công Ty Maxell Asia");
        musicBills[16] = new ImportBill("Đĩa nhạc Faded", 100000, LocalDate.of(2022,12,5), true, "3 đĩa", "Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành");
        musicBills[17] = new ImportBill("Đĩa nhạc On my way", 100000, LocalDate.of(2022,4,4), true, "3 đĩa", "Tổng Công Ty Văn Hóa Sài Gòn");
        musicBills[18] = new ImportBill("Đĩa nhạc Sing Me to Sleep", 100000, LocalDate.of(2022,6,4), true, "3 đĩa", "Công Ty Maxell Asia");
        musicBills[19] = new ImportBill("Đĩa nhạc The Spectre", 100000, LocalDate.of(2022,7,1), true, "3 đĩa", "Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành");

        //film
        filmBills[0]=new ImportBill("Đĩa phim Thánh bài", 100000, LocalDate.of(2021,5,13), true, "3 đĩa", "Công Ty Cổ Phần Truyền Thông Trí Việt");
        filmBills[1]=new ImportBill("Đĩa phim Titanic", 100000, LocalDate.of(2021,3,23), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[2]=new ImportBill("Đĩa phim Tuyệt đỉnh Kung-fu", 50000, LocalDate.of(2021,8,3), true, "3 đĩa", "Công Ty Cổ Phần Truyền Thông Trí Việt");
        filmBills[3]=new ImportBill("Đĩa phim Ký sinh trùng", 100000, LocalDate.of(2021,3,5), true, "3 đĩa", "Hồ Gươm Audio - Công Ty Cổ Phần Mỹ Thuật Và Vật Phẩm Văn Hóa");
        filmBills[4]=new ImportBill("Đĩa phim Người Nhện 2", 100000, LocalDate.of(2021,8,6), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[5]=new ImportBill("Đĩa phim Đội bóng thiếu lâm", 80000, LocalDate.of(2021,1,1), true, "3 đĩa", "Hồ Gươm Audio - Công Ty Cổ Phần Mỹ Thuật Và Vật Phẩm Văn Hóa");
        filmBills[6]=new ImportBill("Đĩa phim Người Nhện 3", 100000, LocalDate.of(2021,2,12), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[7]=new ImportBill("Đĩa phim Mỹ nhân ngư", 100000, LocalDate.of(2021,9,4), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[8]=new ImportBill("Đĩa phim Người Sắt", 100000, LocalDate.of(2021,6,16), true, "3 đĩa", "Công Ty Cổ Phần Truyền Thông Trí Việt");
        filmBills[9]=new ImportBill("Đĩa phim Người sắt 2", 250000, LocalDate.of(2021,11,3), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[10]=new ImportBill("Đĩa phim Spider-Man", 205000, LocalDate.of(2021,4,3), true, "3 đĩa", "Hồ Gươm Audio - Công Ty Cổ Phần Mỹ Thuật Và Vật Phẩm Văn Hóa");
        filmBills[11]=new ImportBill("Đĩa phim Avengers: Infinity War", 120000, LocalDate.of(2021,2,23), true, "3 đĩa", "Công Ty Cổ Phần Truyền Thông Trí Việt");
        filmBills[12]=new ImportBill("Đĩa phim Rô-bốt đại chiến", 120000, LocalDate.of(2022,5,22), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[13]=new ImportBill("Đĩa phim Transformers: Revenge of the Fallen", 200000, LocalDate.of(2022,1,21), true, "3 đĩa", "Hồ Gươm Audio - Công Ty Cổ Phần Mỹ Thuật Và Vật Phẩm Văn Hóa");
        filmBills[14]=new ImportBill("Đĩa phim Transformers: Dark of the Moon", 200000, LocalDate.of(2021,6,23), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[15]=new ImportBill("Đĩa phim Transformers: Age of Extinction", 200000, LocalDate.of(2022,2,12), true, "3 đĩa", "Công Ty Cổ Phần Truyền Thông Trí Việt");
        filmBills[16]=new ImportBill("Đĩa phim Transformers: The Last Knight", 200000, LocalDate.of(2022,5,17), true, "3 đĩa", "Công Ty TNHH Webbing Green Vina");
        filmBills[17]=new ImportBill("Đĩa phim Biệt đội siêu anh hùng", 200000, LocalDate.of(2022,3,3), true, "3 đĩa", "Hồ Gươm Audio - Công Ty Cổ Phần Mỹ Thuật Và Vật Phẩm Văn Hóa");
        filmBills[18]=new ImportBill("Đĩa phim Avengers: Đế chế Ultron", 200000, LocalDate.of(2022,6,19), true, "3 đĩa", "Công Ty Cổ Phần Truyền Thông Trí Việt");
        filmBills[19]=new ImportBill("Đĩa phim Avengers: Endgame", 200000, LocalDate.of(2022,5,3), true, "3 đĩa", "Hồ Gươm Audio - Công Ty Cổ Phần Mỹ Thuật Và Vật Phẩm Văn Hóa");

        //book
        bookBills[0] = new ImportBill("Sách Cuộc sống không giới hạn", 50000, LocalDate.of(2021,9,1), true, "3 sách", "Nhà xuất bản Giáo dục Việt Nam");
        bookBills[1] = new ImportBill("Sách Đừng Bao Giờ Từ Bỏ Khát Vọng", 50000, LocalDate.of(2021,12,1), true, "3 sách", "Nhà xuất bản Giáo dục Việt Nam");
        bookBills[2] = new ImportBill("Sách Sống Cho Điều Ý Nghĩa Hơn", 50000, LocalDate.of(2021,12,1), true, "3 sách", "Nhà xuất bản Giáo dục Việt Nam");
        bookBills[3] = new ImportBill("Sách Cái Ôm Diệu Kỳ", 50000, LocalDate.of(2021,2,5), true, "3 sách", "Nhà xuất bản Giáo dục Việt Nam");
        bookBills[4] = new ImportBill("Sách Đứng Dậy Mạnh Mẽ", 50000, LocalDate.of(2021,11,11), true, "3 sách", "Nhà xuất bản Giáo dục Việt Nam");
        bookBills[5] = new ImportBill("Sách Nhật ký trong tù", 50000, LocalDate.of(2021,6,16), true, "3 sách", "Nhà xuất bản Giáo dục Việt Nam");
        bookBills[6] = new ImportBill("Sách Bản án chế độ thực dân Pháp", 50000, LocalDate.of(2021,1,11), true, "3 sách", "Nhà xuất bản Giáo dục Việt Nam");
        bookBills[7] = new ImportBill("Sách Con đường phía trước (The Road Ahead)", 50000, LocalDate.of(2021,10,1), true, "3 sách", "Nhà xuất bản Dân trí");
        bookBills[8] = new ImportBill("Sách Tốc Độ Tư Duy", 50000, LocalDate.of(2021,1,11), true, "3 sách", "Nhà xuất bản Dân trí");
        bookBills[9] = new ImportBill("Sách How to Prevent the Next Pandemic", 50000, LocalDate.of(2021,11,1), true, "3 sách", "Nhà xuất bản tổng hợp TPHCM");
        bookBills[10] = new ImportBill("Sách Bill Gates Quotes: Bill Gates, Quotes, Quotations, Famous", 50000, LocalDate.of(2022,1,1), true, "3 sách", "Nhà xuất bản tổng hợp TPHCM");
        bookBills[11] = new ImportBill("Sách How to Avoid a Climate Disaster", 50000, LocalDate.of(2021,6,16), true, "3 sách", "Nhà xuất bản Dân trí");
        bookBills[12] = new ImportBill("Sách The Art of Avatar", 50000, LocalDate.of(2021,1,19), true, "3 sách", "Nhà xuất bản tổng hợp TPHCM");
        bookBills[13] = new ImportBill("Sách Battleship Bismarck: A Design and Operational History", 50000, LocalDate.of(2022,7,1), true, "3 sách", "Nhà xuất bản Dân trí");
        bookBills[14] = new ImportBill("Sách Ghosts of the Titanic", 50000, LocalDate.of(2021,12,10), true, "3 sách", "Nhà xuất bản Dân trí");
        bookBills[15] = new ImportBill("Sách Dr. Horrible", 50000, LocalDate.of(2021,12,12), true, "3 sách", "Nhà xuất bản Dân trí");
        bookBills[16] = new ImportBill("Sách Astonishing X-Men - Volume 1: Gifted", 50000, LocalDate.of(2022,1,19), true, "3 sách", "Nhà xuất bản Dân trí");
        bookBills[17] = new ImportBill("Sách Astonishing X-Men: Torn. Vol. 3", 50000, LocalDate.of(2021,10,13), true, "3 sách", "Nhà xuất bản tổng hợp TPHCM");
        bookBills[18] = new ImportBill("Sách Chạm tới giấc mơ", 50000, LocalDate.of(2021,9,16), true, "3 sách", "Nhà xuất bản tổng hợp TPHCM");
        bookBills[19] = new ImportBill("Sách Đắc nhân tâm", 50000, LocalDate.of(2021,6,21), true, "3 sách", "Nhà xuất bản tổng hợp TPHCM");

        for(int i=0;i<=19;i++){
            adapter.insertImportBill(musicBills[i]);
        }
        for(int i=0;i<=19;i++){
            adapter.insertImportBill(filmBills[i]);
        }
        for(int i=0;i<=19;i++){
            adapter.insertImportBill(bookBills[i]);
        }
    }
}
