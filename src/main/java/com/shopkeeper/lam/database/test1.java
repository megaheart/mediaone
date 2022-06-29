package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

//CATEGORY

public class test1 {
    public void insertCategory() throws Exception {
        Category honor = new Category("Kinh di","phim rat dang so,khong danh cho tre em duoi 18 tuoi");//film,book
        Category comedy = new Category("Comedy","Thể loại gây hài hước cho người đọc hoặc xem");//film,book
        Category x3 = new Category("EDM","Nhạc nhảy điện tử, còn được biết đến với thuật ngữ: EDM, được mô tả như một thể loại nhạc có tiết tấu mạnh kế thừa từ nhạc disco của những năm 1970 và ở một vài khía cạnh nào đó, nó cũng là những thể nghiệm của nhạc Pop, hay còn gọi là Nhạc POP thể nghiệm của các nhạc sĩ/ca sĩ tiền phong");//music
        Category x4 = new Category("Light novel","là một dòng tiểu thuyết có nguồn gốc từ Nhật Bản. \"Light\" trong \"light novel\" nghĩa là ngắn, nhẹ về số lượng từ ngữ. Light novel thường được gọi tắt là ranobe hay rainobe.");//book
        Category x5 = new Category("Trinh thám","truyen/phim co noi dung giai do, toi pham, pha an");//book
        Category x6 = new Category("18+","dành cho lứa tuổi 18 trở lên ");//Music,book,film
        Category x7 = new Category("12+","Dành cho lứa tuổi trên 12");//Music,book,film
        Category x8 = new Category("Lãng mạn","Thể loại về tình yêu");//Music,book,film
        Category x9 = new Category("Kịch","là dòng phim thường mang tính tự sự về cuộc đời của một hay nhiều nhân vật. Phim là sự kết hợp của các yếu tố tâm lý xã hội, bi – hài tạo nên một tổng thể mang lại nhiều cảm xúc đan xen lẫn nhau cho người xem.");//Music,book,film
        Category x10 = new Category("Dảk","Thể loại mà nhiều người chết hoặc NTR");//film,book
        Category x11 = new Category("Bi kịch","nội dung có những tình tiết bi kịch");//film.book
        Category x12 = new Category("Hành động","có những cuộc chiến nảy lửa,tình tiết kịch tính");//film,book
        Category x13 = new Category("Khoa học viễn tưởng","là thể loại phim với chủ đề tưởng tượng, không có thật như phép thuật, các hiện tượng thần kỳ, siêu nhiên");//film,book
        Category x14 = new Category("Lịch sử","phim có bối cảnh trong lịch sử");
        Category x15 = new Category("Phiêu lưu"," kể về các chuyến du hành mạo hiểm bao gồm những cuộc tìm kiếm các vùng đất mới, truy tìm kho báu");//book,film
        Category x16 = new Category("Bí ẩn","thường kể về quá trình điều tra một bí ẩn chưa được khám phá");//film
        Category x17 = new Category("Phim tài liệu","là phim ghi lại các hình ảnh thực tế, không có yếu tố hư cấu và thường được sử dụng làm tài liệu giảng dạy hay lưu giữ các sự kiện mang tính chất lịch sử.");
        Category x18 = new Category("Phim ca nhạc","Trong các thể loại phim thì Musical là dạng phim mà nhân vật có ít hoặc không có lời thoại. Thay vào đó là phần âm nhạc được lồng ghép vào bên trong");
        Category x19 = new Category("Phim gia đình","là các phim có nội dung hướng đến đối tượng là mọi thế hệ trong gia đình. Kịch bản phim thường nhẹ nhàng, giải trí có có kết cục có hậu");
        Category x20 = new Category("Phim người lớn"," là các phim chỉ dành cho đối tượng là người trưởng thành");
        Category x21 = new Category("Phim tội phạm","là những bộ phim có bối cảnh là các hoạt động tội ác, nội dung thường bao gồm các tình tiết liên quan đến các hành động trái pháp luật hay tổ chức tội phạm");
        Category x22 = new Category("Phim chiến tranh","là thể loại phim liên quan đến các cuộc chiến, thường được liên kết chặt chẽ với các sự kiện diễn ra trong thế kỷ 20 và có trọng tâm là các cảnh chiến đấu.");
        Category x23 = new Category("Phim cổ trang","đây cũng là một thể loại phim đặc trưng của châu Á. Phim cổ trang cơ bản được chia làm hai nhánh nhỏ. Một là, phim tái hiện lại chính xác một sự kiện có thật trong lịch sử. Hai là, phim chỉ dựa trên bối cảnh hay nhân vật lịch sử kết hợp với các yếu tố hư cấu khác");
        Category x24 = new Category("Tình ca ","các ca khúc viết về tình yêu");
        Category x25 = new Category("Nhạc Pop","Nhạc Pop thường được phân biệt với các thể loại khác nhờ một số đặc điểm về phong cách nghệ thuật như: nhịp nhảy hay nhịp phách, những giai điệu đơn giản dễ nghe, cùng với một số đoạn trong bài hát được lặp đi lặp lại.");
        Category x26 = new Category("Nhạc đồng quê","Chịu nhiều ảnh hưởng từ những hệ thống nhạc khác như Blues, Jazz. Loại nhạc này thường mang giai điệu trầm buồn. Nguồn gốc của nhạc country xuất phát từ những người dân Anh nhập cư đến nước Mỹ. Họ mang theo các ca khúc Ballad Celtic với phần lời theo lối kể chuyện mộc mạc, bình dân.");
        Category x27 = new Category("Nhạc Rock","Dựa trên tiết tấu của ca ba loại nhạc(Blues, Jazz, Country) nhưng Rock lại có tiết tấu mạnh và nhanh hơn, thường được sử dụng cho các loại nhạc cụ điện tử, phổ biến là Guitar điện phối hợp cùng với đó là guitar bass và trống");
        Category x28 = new Category("Nhạc Dance","Nhạc Dance, hay gọi dân dã là nhạc vũ trường, là một loạt các thể loại nhạc có âm mạnh thường được dùng trong các tụ điểm vũ trường, hộp đêm, phát triển từ thể loại nhạc disco thập niên 1970");
        Category x29 = new Category("Nhạc Blues","Những ca khúc nhạc Blues thường mang đến sự buồn bã, ảm đạm, sâu lắng cho người nghe. Blues là dòng nhạc xuất hiện gần như sớm nhất trong cộng đồng người da đen sống tại Mỹ");
        Category x30 = new Category("Nhạc Jazz","Jazz là một nét văn hoá bản xứ ban đầu chỉ của riêng người Mỹ và đã được tạo ra bởi người Mỹ. Âm nhạc phương Tây và châu Phi là nơi đã gieo hạt nên Jazz, nhưng chính văn hoá Mỹ mới là nơi Jazz nảy mầm và phát triển");
        Category x31 = new Category("Nhạc R&B","R&B là viết tắt của Rhythm and Blues. Thể loại nhạc này có nguồn gốc từ cộng đồng người Phi da đen này đã phát sinh từ đầu thế kỉ 20 và trở thành một loại nhạc phổ biến trên nhiều quốc gia vào khoảng thập niên 40");
        Category x32 = new Category("Nhạc không lời","Nhạc không có lời hát nhưng rất hay,êm tai,thích thợp để thư giãn đầu óc");
        Category x33 = new Category("Nhạc Piano","Loại nhạc đánh đàn piano");
        Category x34 = new Category("Tiểu thuyết lãng mạn","là một trong số các thể loại sách phổ biến nhất khi so về doanh số bán sách. Tiểu thuyết lãng mạn sở hữu một quy mô kinh doanh đa dạng nhất trong thị trường sách, các tác phẩm này được trưng bày khắp nơi từ các quầy thanh toán ở cửa hàng tạp hóa, đến các ấn phẩm định kỳ của nhà xuất bản trên nền tảng trực tuyến, cũng như thông qua các dịch vụ tự xuất bản.");
        Category x35 = new Category("Giả tưởng và khoa học viễn tưởng","Sách giả tưởng thường diễn ra trong một khoảng thời gian khác với thời gian hiện tại của chúng ta. Chúng thường có các sinh vật huyền bí, từ pháp sư / phù thuỷ cho đến những thây ma không có thật");
        Category x36 = new Category("Kinh dị, giật gân","Các thể loại sách này bao gồm các ấn phẩm thường có mối liên hệ mật thiết đến những thể loại sách Mystery và đôi khi là giả tưởng – Fantasy, yếu tố ly kỳ và kinh dị tạo nên sự hồi hộp và điểm nổi bật của thể loại sách phổ biến này. ");
        Category x37 = new Category("Sách truyền cảm hứng","Nhiều cuốn sách về self-help liên quan đến các bài học thành công trong kinh doanh hoặc bí quyết kinh doanh hiện đang đứng dầu trong các danh sách Best Sellers của thị trường này.");
        Category x38 = new Category("Tiểu sử, tự truyện và hồi ký","Đây là các thể loại sách phi hư cấu dùng để kể những câu chuyện về cuộc đời của một người.");
        Category x39 = new Category("Truyện ngắn","là văn xuôi ngắn gọn, tốt, ngắn hơn đáng kể so với tiểu thuyết.");
        Category x40 = new Category("Sách dạy nấu ăn","Các thể loại sách này, theo truyền thống được viết bởi các đầu bếp chuyên nghiệp hoặc thậm chí những người nổi tiếng yêu thích của bạn, sách dạy nấu ăn cung cấp một bộ sưu tập các công thức nấu ăn hấp dẫn, cụ thể cho một chủ đề, ẩm thực hoặc trải nghiệm do tác giả lựa chọn.");
        Category x41 = new Category("Bài luận","Các thể loại sách này thông thường được viết ở ngôi thứ nhất, người viết sử dụng kinh nghiệm cá nhân của chính họ để phản ánh về một chủ đề hoặc chủ đề cho người đọc.");
        Category x42 = new Category("Sách lịch sử","Những cuốn sách này ghi lại và bố cục một thời điểm cụ thể, với mục tiêu giáo dục và cung cấp thông tin cho người đọc, về mọi nơi trên thế giới tại bất kỳ thời điểm nào. Thể loại sách lịch sử cực kỳ hấp dẫn đối với những người yêu thích tìm hiểu về các nhân vật, triều đại trong quá khứ.");
        Category x43 = new Category("Sách văn học","Sách văn học là một trong những loại sách mà chúng ta tiếp xúc khá nhiều trong cuộc sống từ khi còn trên ghế nhà trường. Hiểu một cách đơn giản thì đây là một thể loại sách tái hiện lại những câu chuyện, những bình diện khác nhau của cuộc sống. Ở đó có những sự kiện, có diễn biến, có con người,... dưới ngòi bút của tác giả thông qua các kiểu diễn đạt khác nhau tạo nên những tác phẩm văn học giá trị.");
        Category x44 = new Category("Tiểu thuyết","Tiểu thuyết là một thể loại văn xuôi có hư cấu, thông qua nhân vật, hoàn cảnh, sự việc để phản ánh bức tranh xã hội rộng lớn và những vấn đề của cuộc sống con người, biểu hiện tính chất tường thuật, tính chất kể chuyện bằng ngôn ngữ văn xuôi theo những chủ đề xác định");
        Category x45 = new Category("Anime"," là thuật ngữ tiếng Nhật mô tả các loại hoạt hình vẽ tay và máy tính có nguồn gốc từ Nhật Bản hoặc có sự gắn kết mật thiết với Nhật Bản");
        Category x46 = new Category("Sách tâm lý","Sách tâm lý học được hiểu là những cuốn sách nghiên cứu, phân tích về các hiện tượng tâm lý hoặc tinh thần nảy sinh trong não người.");




        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllCategories()){
            System.out.println(x);
        }
        adapter.insertCategory(honor);
        adapter.insertCategory(comedy);
        adapter.insertCategory(x3);
        adapter.insertCategory(x4);
        adapter.insertCategory(x5);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllCategories()){
            System.out.println(x);
        }
    }
    public void updateCategory() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllCategories()){
            System.out.println(x);
        }
        var y=adapter.getAllCategories().get(1);
        y.setName("anime");
        y.setDescription("hay nhat the gioi");
        adapter.updateCategory(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllCategories() ){
            System.out.println(x);
        }
    }
    public void deleteCategories() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllCategories()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllCategories().get(1);
        adapter.deleteCategory(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllCategories()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }

}
