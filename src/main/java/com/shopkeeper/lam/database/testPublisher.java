package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;


//PUBLISHER


public class testPublisher {
    public void insertPublisher() throws Exception {
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
         p[16] = new Publisher("Nhà xuất bản Học viện Nông nghiệp", "Trường Đại học Nông nghiệp Hà Nội - Thị trấn Trâu Quỳ, huyện Gia Lâm, Hà Nội", "");
         p[17] = new Publisher("Nhà xuất bản Hồng Đức", "65 Tràng Thi, Hà Nội", "");
         p[18] = new Publisher("Nhà xuất bản Khoa học Tự nhiên và Công nghệ", "Nhà A16 - Số 18 Hoàng Quốc Việt, Cầu Giấy, Hà Nội", "");
         p[19] = new Publisher("Nhà xuất bản Khoa học và Kỹ thuật", "Số 70 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội", "");
         p[20] = new Publisher("Nhà xuất bản Khoa học xã hội", "26 Lý Thường Kiệt, Hà Nội", "");
         p[21] = new Publisher("Nhà xuất bản Kinh tế thành phố Hồ Chí Minh", "279 Nguyễn Tri Phương - P.5 - Q.10 - TP. Hồ Chí Minh", "");
         p[22] = new Publisher("DATVIET MEDIA - CÔNG TY TNHH ĐẤT VIỆT PROLAB", "Số 43, đường Giải Phóng, Phường Đồng Tâm, Quận Hai Bà Trưng, Tp Hà Nội (TPHN)", "DATVIET MEDIA hoạt động trong lĩnh vực quảng cáo truyền thông " );
         p[23] = new Publisher("Sony", "Minato City, Tokyo, Japan", "Sony Group Corporation, commonly known as Sony and stylized as SONY, is a Japanese multinational conglomerate corporation headquartered in Kōnan, Minato, Tokyo, Japan");
         p[24] = new Publisher("CGV ", "", " Tính đến nay, CGV đang có mặt ở 26 tỉnh thành với 75 cụm rạp và khoảng 445 màn hình, đến năm 2020, CGV dự định sẽ đạt được 96 cụm rạp");
         p[25] = new Publisher("Công ty TNHH Thắng Việt", "Số 13, Đường 26, Khu Dân Cư An Lạc, P. Bình Trị Đông B, Q. Bình Tân,Tp. Hồ Chí Minh", "");
         p[26] = new Publisher("Công Ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành", "142 Pasteur, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Công ty Cổ Phần Văn Hóa Tổng Hợp Bến Thành là một trong những công ty chuyên phân phối băng đĩa nhạc, in sang băng-đĩa cam kết chất lượng và giá cả phải chăng  ");
         p[27] = new Publisher("Công Ty Cổ Phần Sản Xuất Thương Mại Những Gương Mặt Âm Nhạc", "90 Đề Thám, P. Cầu Ông Lãnh, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Công ty Cổ Phần Sản Xuất Thương Mại Những Gương Mặt Âm Nhạc chuyên sản xuất băng đĩa nhạc, sản xuất chương trình và nhà cung cấp phòng thu. Công ty luôn đem đến cho thính giả những sản phẩm âm nhạc đặc sắc nhất, ghi lại dấu ấn trong lòng người nghe nhất");
         p[28] = new Publisher("Công Ty Maxell Asia", "Phòng 15, TầngM, Cao ốc Sun Wah, 115 Nguyễn Huệ, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Văn phòng Đại Diện – Công ty Maxell Asia cung cấp băng đĩa nhạc, nhận in sang băng đĩa nhiều nhiều khách hàng tin tưởng và cho nhiều phản hồi tốt từ chất lượng sản phẩm đến dịch vụ");
         p[29] = new Publisher("Công Ty TNHH Thương Mại Kim Như", "151/4 Tôn Thất Đạm, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM), Việt Nam", "Công ty TNHH Thương Mại Kim Thư Nằm trong top những cơ sở bán đĩa phim chất lượng sản phẩm, uy tín ở TP. Hồ Chí Minh, chuyên cung cấp đĩa trắng nhập khẩu từ các hãng đĩa DVD danh tiếng như Maxell, Sony, Verbatim, Kachi, Melody… được nhiều người thích coi phim , phòng game, dân IT sử dụng.");


        var adapter = DatabaseAdapter.getDbAdapter();

        for(Publisher pi : p){
            adapter.insertPublisher(pi);
        }
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
