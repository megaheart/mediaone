package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

//PERSON

public class testPerson {
    public void insertPerson() throws Exception {
        Person[] x = new Person[31];
         x[1]=new Person("Bong Joon-ho", LocalDate.of(1969 ,9,14 ),"Bong Joon-ho là đạo diễn, nhà sản xuất và biên kịch phim người Hàn Quốc. Ông là một trong số ít các đạo diễn người châu Á chiến thắng giải Oscar cũng như là một trong những đạo diễn điện ảnh xuất sắc nhất thế giới hiện nay.",JobOfPerson.FILM_DIRECTOR);
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
        var adapter = DatabaseAdapter.getDbAdapter();
         for(int i=1;i<=30;i++){
             adapter.insertPerson(x[i]);
         }






    }
    public void updatePerson() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPeople()){
            System.out.println(x);
        }
        var y=adapter.getAllPeople().get(3);
        y.setName("Kujou Sara");
        y.setDescription("tuong quan Inazuma");

        adapter.updatePerson(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllPeople() ){
            System.out.println(x);
        }
    }
    public void deletePeople() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPeople()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllPeople().get(3);
        adapter.deletePerson(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllPeople()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
