package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

//PERSON

public class testPerson {
    public void insertPerson() throws Exception {
        Person[] x = new Person[30];
         x[1]=new Person("Bong Joon-ho", LocalDate.of(1969 ,9,14 ),"Bong Joon-ho là đạo diễn, nhà sản xuất và biên kịch phim người Hàn Quốc. Ông là một trong số ít các đạo diễn người châu Á chiến thắng giải Oscar cũng như là một trong những đạo diễn điện ảnh xuất sắc nhất thế giới hiện nay.",JobOfPerson.FILM_DIRECTOR);
         x[2]=new Person("Kate Winslet",LocalDate.of(1865 ,9,22),"Không biết",JobOfPerson.ACTOR);
         x[3]=new Person("Leonardo DiCaprio",LocalDate.of(1870 ,8,18 ),"Không biết",JobOfPerson.ACTOR);
         x[4]=new Person("James Francis Cameron",LocalDate.of(1954 ,8,16),"James Cameron đã thắng 3 giải Oscar trong tổng số 6 đề cử, cả 3 giải đó đều thắng nhờ bộ phim Titanic. Bộ phim Titanic đã thắng đến 11 giải Oscar năm 1998, biến bộ phim trở thành một trong những bộ phim thắng nhiều Oscar nhất từ trước đến giờ. Avatar cũng vô cùng thành công với 3 giải Oscar, đang nắm giữ danh hiệu bộ phim có doanh thu toàn cầu lớn nhất mọi thời đại. Sắp tới, James Cameron cũng đã lên kế hoạch thực hiện 4 phần tiếp theo của Avatar.",JobOfPerson.FILM_DIRECTOR);
         x[5]=new Person("Sơn Tùng MTP",LocalDate.of(1994 ,7,5),"hay nhat viet nam",JobOfPerson.SINGER);
         x[6]=new Person("Jack Grealish",LocalDate.of(3424,2,24),"Jack 5 củ",JobOfPerson.SINGER);
         x[7]=new Person("Cristiano Ronaldo",LocalDate.of(1985 ,2,5 ),"cao nhat viet nam",JobOfPerson.FOOTBALLER);
         x[8]=new Person("Tokuda Shigeo ",LocalDate.of(1934 ,8,18 ),"Tokuda Shigeo là nghệ danh của một nam diễn viên Nhat Ban",JobOfPerson.FOOTBALLER);
         x[9]=new Person("Elon Musk",LocalDate.of(1971 ,6,28 ),"Elon Reeve Musk FRS, là một kỹ sư, nhà tài phiệt, nhà phát minh, doanh nhân công nghệ và nhà từ thiện người Mỹ gốc Nam Phi.",JobOfPerson.CEO);
         x[10]=new Person("Bill Gates",LocalDate.of(1955 ,10,28 ),"William Henry \"Bill\" Gates III là một doanh nhân người Mỹ, nhà từ thiện, tác giả và chủ tịch tập đoàn Microsoft, hãng phần mềm mà ông cùng với Paul Allen đã sáng lập ra. ",JobOfPerson.CEO);
         x[11]=new Person("Huấn Hoa Hồng",LocalDate.of(1999,4,2),"Người hay lộn xào trên mạng",JobOfPerson.ACTOR);
         x[12] = new Person("Paul Pogba", LocalDate.of(1993, 3, 15), "Kẻ hủy diệt Manchester United,nghệ sĩ nhảy múa của nhà hát ", JobOfPerson.FOOTBALLER);
         x[13] = new Person("Nguyễn Xuân Thảo", LocalDate.of(1999, 4, 2), "Dạy toán ở Hust", JobOfPerson.TEACHER);
         x[14] = new Person("Lục Tiểu Linh Đồng ", LocalDate.of(1970, 4, 2), "Tác giả Tôn Ngộ Không", JobOfPerson.FILM_DIRECTOR);
         x[15] = new Person("Nguyễn Văn Thắng", LocalDate.of(1999, 4, 2), "Người giàu nhất thế giới", JobOfPerson.CEO);
         x[16] = new Person("Yua Mikami", LocalDate.of(1999, 4, 2), "Diễn viên nhật bản khá hot", JobOfPerson.CEO);
         x[17] = new Person("Châu Tinh Trì", LocalDate.of(1962, 6, 22 ), "Châu Tinh Trì là một nam diễn viên, đạo diễn, nhà biên kịch, nhà sản xuất người Hồng Kông gốc Hoa. Ngoài ra ông còn là cố vấn chính trị của Hội nghị Hiệp thương Chính trị Nhân dân Trung Quốc.", JobOfPerson.ACTOR);
         x[18] = new Person("Tố Hữu", LocalDate.of(1920, 10, 4), "Nhà thơ ", JobOfPerson.POET);
         x[19] = new Person("Nguyễn Du", LocalDate.of(1766, 1, 3 ), "Nguyễn Du tên tự là Tố Như, hiệu là Thanh Hiên, biệt hiệu là Hồng Sơn lạp hộ, Nam Hải điếu đồ, là một nhà thơ, nhà văn hóa lớn thời Lê mạt Nguyễn sơ ở Việt Nam.", JobOfPerson.POET);
         x[20] = new Person("Chủ tịch Hồ Chí Minh", LocalDate.of(1890, 5, 19 ), "Người vĩ đại nhất lịch sử VIệt Nam", JobOfPerson.LEGEND);
         x[21] = new Person("Nick Vujicic", LocalDate.of(1982 , 10, 4 ), "Nicholas James Vujicic is an Australian American Christian evangelist and motivational speaker born with tetra-amelia syndrome, a rare disorder characterised by the absence of arms and legs.", JobOfPerson.MOTIVATIONAL_SPEAKER);
         x[22] = new Person("Dale Carnegie", LocalDate.of(1888, 12, 24 ), "Dale Carnegie was an American writer and lecturer, and the developer of courses in self-improvement, salesmanship, corporate training, public speaking, and interpersonal skills.", JobOfPerson.MOTIVATIONAL_AUTHOR);
         x[23] = new Person("Đàm Vĩnh Hưng", LocalDate.of(1971, 10, 2 ), "Đàm Vĩnh Hưng tên khai sinh là Huỳnh Minh Hưng, còn có biệt danh Mr. Đàm, là một ca sĩ người Việt Nam. Anh đã giành được 2 giải Cống hiến. Bên cạnh thể loại nhạc trẻ, anh còn hát những ca khúc nhạc tiền chiến mang tính chất trữ tình cũng như nhạc Trịnh Công Sơn và nhạc vàng.", JobOfPerson.SINGER);
         x[24] = new Person("Ngô Mạnh Đạt", LocalDate.of(1950, 5, 19 ), "", JobOfPerson.ACTOR);
         x[25] = new Person("Song Kang-ho", LocalDate.of(1990, 4, 6 ), "", JobOfPerson.ACTOR);//kst
         x[26] = new Person("Lee Sun-kyun", LocalDate.of(1986, 5, 3 ), "", JobOfPerson.ACTOR);//kst
         x[27] = new Person("Lưu Trấn Vĩ", LocalDate.of(1920, 5, 19 ), "", JobOfPerson.FILM_DIRECTOR);
         x[28] = new Person("", LocalDate.of(1890, 5, 19 ), "", JobOfPerson.ACTOR);
         x[29] = new Person("", LocalDate.of(1890, 5, 19 ), "", JobOfPerson.ACTOR);




        var adapter = DatabaseAdapter.getDbAdapter();



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
