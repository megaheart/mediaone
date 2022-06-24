package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;


//PUBLISHER


public class test3 {
    public void insertPublisher() throws Exception {
        Publisher p1 = new Publisher("Kim Dong","Viet Nam","xuat ban truyện,sách như Doremon,Conan,...");
        Publisher p2 = new Publisher("Hoyoverse","Trung Quốc","xuất bản sách về genshin,honkai");
        Publisher p3 = new Publisher("Garena","Trung Quốc","LOL,FIFA 4");
        Publisher p4 = new Publisher("HolyWood","USA",":)))");
        Publisher p5 = new Publisher("WibuIsYou","Japan","We can make you be wibu.");
        Publisher p6 = new Publisher("Nhà xuất bản giáo dục và đào tạo","Việt Nam","xuất bản sách giáo dục");
        Publisher p7 = new Publisher("Nhà xuất bản Bách Khoa Hà Nội","Đại học Bách Khoa Hà Nội","xuất bản sách cho sinh viên Bách Khoa hoặc trường khác");
        Publisher p8 = new Publisher("Nhà xuất bản trẻ","161B Lý Chính Thắng-Phường 7-Quận 3-Thành Phố Hồ Chí Minh","xuất bản truyện tranh,sách phục vụ thanh niên,thiếu nhi");
        Publisher p9 = new Publisher("Nhà xuất bản tổng hợp TPHCM","Số 6/86 Duy Tân-Cầu Giấy-Hà Nội","Sách về chính trị,lịch sử,giáo trình,...");
        Publisher p10 = new Publisher("Nhà xuất bản chính trị Quốc gia","Số 6/86 DUy Tân Cầu Giấy Hà Nội","Xuất bản sách chính trị,lý luận và pháp luật");

        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllPublishers()){
            System.out.println(x);
        }
        adapter.insertPublisher(p1);
        adapter.insertPublisher(p2);
        adapter.insertPublisher(p3);
        adapter.insertPublisher(p4);
        adapter.insertPublisher(p5);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllPublishers()){
            System.out.println(x);
        }
    }
    public void updatePublisher() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPublishers()){
            System.out.println(x);
        }
        var y=adapter.getAllPublishers().get(2);
        y.setName("Bo giao duc");
        y.setDescription("ko biet noi gi");
        adapter.updatePublisher(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllPublishers() ){
            System.out.println(x);
        }
    }
    public void deletePublisher() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllPublishers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllPublishers().get(2);
        adapter.deletePublisher(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllPublishers()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
