package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

import java.time.LocalDate;

//PERSON

public class test2 {
    public void insertPerson() throws Exception {
        //Đạo diễn phim ký sinh trùng
        Person x1=new Person("Bong Joon-ho", LocalDate.of(1969 ,9,14 ),"Bong Joon-ho là đạo diễn, nhà sản xuất và biên kịch phim người Hàn Quốc. Ông là một trong số ít các đạo diễn người châu Á chiến thắng giải Oscar cũng như là một trong những đạo diễn điện ảnh xuất sắc nhất thế giới hiện nay.",JobOfPerson.FILM_DIRECTOR);
        Person x2=new Person("Higuchi Shinji",LocalDate.of(1965 ,9,22),"Đạo diễn phim Attack On Titan",JobOfPerson.FILM_DIRECTOR);
        Person x3=new Person("Emi Fukada",LocalDate.of(1998 ,8,18 ),"Diễn viên người Nhật,khá nổi tiếng ở VIệt Nam",JobOfPerson.ACTOR);
        Person x4=new Person("James Francis Cameron",LocalDate.of(1954 ,8,16),"James Cameron đã thắng 3 giải Oscar trong tổng số 6 đề cử, cả 3 giải đó đều thắng nhờ bộ phim Titanic. Bộ phim Titanic đã thắng đến 11 giải Oscar năm 1998, biến bộ phim trở thành một trong những bộ phim thắng nhiều Oscar nhất từ trước đến giờ. Avatar cũng vô cùng thành công với 3 giải Oscar, đang nắm giữ danh hiệu bộ phim có doanh thu toàn cầu lớn nhất mọi thời đại. Sắp tới, James Cameron cũng đã lên kế hoạch thực hiện 4 phần tiếp theo của Avatar.",JobOfPerson.FILM_DIRECTOR);
        Person x5=new Person("Sơn Tùng MTP",LocalDate.of(1994 ,7,5),"hay nhat viet nam",JobOfPerson.SINGER);
        Person x6=new Person("Jack Grealish",LocalDate.of(3424,2,24),"Jack 5 củ",JobOfPerson.SINGER);
        Person x7=new Person("Cristiano Ronaldo",LocalDate.of(1985 ,2,5 ),"cao nhat viet nam",JobOfPerson.FOOTBALLER);
        Person x8=new Person("Tokuda Shigeo ",LocalDate.of(1934 ,8,18 ),"Tokuda Shigeo là nghệ danh của một nam diễn viên Nhat Ban",JobOfPerson.FOOTBALLER);
        Person x9=new Person("Elon Musk",LocalDate.of(1971 ,6,28 ),"Elon Reeve Musk FRS, là một kỹ sư, nhà tài phiệt, nhà phát minh, doanh nhân công nghệ và nhà từ thiện người Mỹ gốc Nam Phi.",JobOfPerson.CEO);
        Person x10=new Person("Bill Gates",LocalDate.of(1955 ,10,28 ),"William Henry \"Bill\" Gates III là một doanh nhân người Mỹ, nhà từ thiện, tác giả và chủ tịch tập đoàn Microsoft, hãng phần mềm mà ông cùng với Paul Allen đã sáng lập ra. ",JobOfPerson.CEO);
        Person x11=new Person("Huấn Hoa Hồng",LocalDate.of(1999,4,2),"Người hay lộn xào trên mạng",JobOfPerson.ACTOR);
        Person x12 = new Person("Paul Pogba", LocalDate.of(1999, 4, 2), "Kẻ hủy diệt Manchester United,nghệ sĩ nhảy múa của nhà hát ", JobOfPerson.FOOTBALLER);
        Person x13 = new Person("Nguyễn Xuân Thảo", LocalDate.of(1999, 4, 2), "Dạy toán ở Hust", JobOfPerson.TEACHER);
        Person x14 = new Person("Lục Tiểu Linh Đồng ", LocalDate.of(1970, 4, 2), "Tác giả Tôn Ngộ Không", JobOfPerson.FILM_DIRECTOR);
        Person x15 = new Person("Nguyễn Văn Thắng", LocalDate.of(1999, 4, 2), "Người giàu nhất thế giới", JobOfPerson.CEO);
        Person x16 = new Person("Yua Mikami", LocalDate.of(1999, 4, 2), "Diễn viên nhật bản khá hot", JobOfPerson.CEO);
        Person x17 = new Person("Châu Tinh Trì", LocalDate.of(1999, 4, 2), "Diễn viên hài Trung Quốc", JobOfPerson.CEO);
        Person x18 = new Person("Tố Hữu", LocalDate.of(1999, 4, 2), "Nhà thơ ", JobOfPerson.POET);
        Person x19 = new Person("Nguyễn Du", LocalDate.of(1766, 1, 3 ), "Nguyễn Du tên tự là Tố Như, hiệu là Thanh Hiên, biệt hiệu là Hồng Sơn lạp hộ, Nam Hải điếu đồ, là một nhà thơ, nhà văn hóa lớn thời Lê mạt Nguyễn sơ ở Việt Nam.", JobOfPerson.POET);
        Person x20 = new Person("Chủ tịch Hồ Chí Minh", LocalDate.of(1890, 5, 19 ), "Người vĩ đại nhất lịch sử VIệt Nam", JobOfPerson.LEGEND);
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllPeople()){
            System.out.println(x);
        }
        adapter.insertPerson(x1);
        adapter.insertPerson(x2);
        adapter.insertPerson(x3);
        adapter.insertPerson(x4);
        adapter.insertPerson(x5);
        adapter.insertPerson(x6);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllPeople()){
            System.out.println(x);
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
