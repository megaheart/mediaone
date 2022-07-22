package com.shopkeeper.lam.database;

import com.shopkeeper.lam.models.Product;
import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.lam.models.ProductState;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.minh.models.ImportBill;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class testProduct {
    public static void insert() throws Exception {

        var adapter = DatabaseAdapter.getDbAdapter();
        var importBills = adapter.getAllImportBills();
        var saleBills = adapter.getAllSaleBills();
        var musics = adapter.getAllMusicInfos();
        var films = adapter.getAllFilmInfos();
        var books = adapter.getAllBookInfos();




        Product[] product = new Product[180];
        product[0] = new Product(books.get(0),ProductState.SOLD,importBills.get(0),saleBills.get(20),(int)importBills.get(0).getPrice()/3,150000,"link2","Không tồn tại");
        product[1] = new Product(books.get(0),ProductState.SOLD,importBills.get(0),saleBills.get(20),(int)importBills.get(0).getPrice()/3,150000,"link2","Không tồn tại");
        product[2] = new Product(books.get(0),ProductState.READY,importBills.get(0),null,(int)importBills.get(0).getPrice()/3,150000,"link2","B3");
        product[3] = new Product(books.get(1),ProductState.SOLD,importBills.get(1),saleBills.get(24),(int)importBills.get(1).getPrice()/3,150000,"link4","Không tồn tại");
        product[4] = new Product(books.get(1),ProductState.SOLD,importBills.get(1),saleBills.get(10),(int)importBills.get(1).getPrice()/3,150000,"link4","Không tồn tại");
        product[5] = new Product(books.get(1),ProductState.READY,importBills.get(1),null,(int)importBills.get(1).getPrice()/3,150000,"link4","D3");
        product[6] = new Product(books.get(2),ProductState.SOLD,importBills.get(2),saleBills.get(27),(int)importBills.get(2).getPrice()/3,150000,"link4","Không tồn tại");
        product[7] = new Product(books.get(2),ProductState.SOLD,importBills.get(2),saleBills.get(23),(int)importBills.get(2).getPrice()/3,150000,"link4","Không tồn tại");
        product[8] = new Product(books.get(2),ProductState.READY,importBills.get(2),null,(int)importBills.get(2).getPrice()/3,150000,"link4","B2");
        product[9] = new Product(books.get(3),ProductState.SOLD,importBills.get(3),saleBills.get(24),(int)importBills.get(3).getPrice()/3,50000,"link1","Không tồn tại");
        product[10] = new Product(books.get(3),ProductState.SOLD,importBills.get(3),saleBills.get(2),(int)importBills.get(3).getPrice()/3,50000,"link1","Không tồn tại");
        product[11] = new Product(books.get(3),ProductState.READY,importBills.get(3),null,(int)importBills.get(3).getPrice()/3,50000,"link1","E2");
        product[12] = new Product(books.get(4),ProductState.SOLD,importBills.get(4),saleBills.get(14),(int)importBills.get(4).getPrice()/3,150000,"link5","Không tồn tại");
        product[13] = new Product(books.get(4),ProductState.SOLD,importBills.get(4),saleBills.get(16),(int)importBills.get(4).getPrice()/3,150000,"link5","Không tồn tại");
        product[14] = new Product(books.get(4),ProductState.READY,importBills.get(4),null,(int)importBills.get(4).getPrice()/3,150000,"link5","B2");
        product[15] = new Product(books.get(5),ProductState.SOLD,importBills.get(5),saleBills.get(1),(int)importBills.get(5).getPrice()/3,150000,"link4","Không tồn tại");
        product[16] = new Product(books.get(5),ProductState.SOLD,importBills.get(5),saleBills.get(24),(int)importBills.get(5).getPrice()/3,150000,"link4","Không tồn tại");
        product[17] = new Product(books.get(5),ProductState.READY,importBills.get(5),null,(int)importBills.get(5).getPrice()/3,150000,"link4","D2");
        product[18] = new Product(books.get(6),ProductState.SOLD,importBills.get(6),saleBills.get(26),(int)importBills.get(6).getPrice()/3,50000,"link1","Không tồn tại");
        product[19] = new Product(books.get(6),ProductState.SOLD,importBills.get(6),saleBills.get(18),(int)importBills.get(6).getPrice()/3,50000,"link1","Không tồn tại");
        product[20] = new Product(books.get(6),ProductState.READY,importBills.get(6),null,(int)importBills.get(6).getPrice()/3,50000,"link1","C1");
        product[21] = new Product(books.get(7),ProductState.SOLD,importBills.get(7),saleBills.get(19),(int)importBills.get(7).getPrice()/3,150000,"link2","Không tồn tại");
        product[22] = new Product(books.get(7),ProductState.SOLD,importBills.get(7),saleBills.get(15),(int)importBills.get(7).getPrice()/3,150000,"link2","Không tồn tại");
        product[23] = new Product(books.get(7),ProductState.READY,importBills.get(7),null,(int)importBills.get(7).getPrice()/3,150000,"link2","B2");
        product[24] = new Product(books.get(8),ProductState.SOLD,importBills.get(8),saleBills.get(13),(int)importBills.get(8).getPrice()/3,100000,"link5","Không tồn tại");
        product[25] = new Product(books.get(8),ProductState.SOLD,importBills.get(8),saleBills.get(17),(int)importBills.get(8).getPrice()/3,100000,"link5","Không tồn tại");
        product[26] = new Product(books.get(8),ProductState.READY,importBills.get(8),null,(int)importBills.get(8).getPrice()/3,100000,"link5","E2");
        product[27] = new Product(books.get(9),ProductState.SOLD,importBills.get(9),saleBills.get(14),(int)importBills.get(9).getPrice()/3,150000,"link4","Không tồn tại");
        product[28] = new Product(books.get(9),ProductState.SOLD,importBills.get(9),saleBills.get(23),(int)importBills.get(9).getPrice()/3,150000,"link4","Không tồn tại");
        product[29] = new Product(books.get(9),ProductState.READY,importBills.get(9),null,(int)importBills.get(9).getPrice()/3,150000,"link4","B3");
        product[30] = new Product(books.get(10),ProductState.SOLD,importBills.get(10),saleBills.get(10),(int)importBills.get(10).getPrice()/3,50000,"link1","Không tồn tại");
        product[31] = new Product(books.get(10),ProductState.SOLD,importBills.get(10),saleBills.get(11),(int)importBills.get(10).getPrice()/3,50000,"link1","Không tồn tại");
        product[32] = new Product(books.get(10),ProductState.READY,importBills.get(10),null,(int)importBills.get(10).getPrice()/3,50000,"link1","D3");
        product[33] = new Product(books.get(11),ProductState.SOLD,importBills.get(11),saleBills.get(4),(int)importBills.get(11).getPrice()/3,100000,"link4","Không tồn tại");
        product[34] = new Product(books.get(11),ProductState.SOLD,importBills.get(11),saleBills.get(10),(int)importBills.get(11).getPrice()/3,100000,"link4","Không tồn tại");
        product[35] = new Product(books.get(11),ProductState.READY,importBills.get(11),null,(int)importBills.get(11).getPrice()/3,100000,"link4","D2");
        product[36] = new Product(books.get(12),ProductState.SOLD,importBills.get(12),saleBills.get(1),(int)importBills.get(12).getPrice()/3,150000,"link4","Không tồn tại");
        product[37] = new Product(books.get(12),ProductState.SOLD,importBills.get(12),saleBills.get(19),(int)importBills.get(12).getPrice()/3,150000,"link4","Không tồn tại");
        product[38] = new Product(books.get(12),ProductState.READY,importBills.get(12),null,(int)importBills.get(12).getPrice()/3,150000,"link4","D2");
        product[39] = new Product(books.get(13),ProductState.SOLD,importBills.get(13),saleBills.get(10),(int)importBills.get(13).getPrice()/3,150000,"link2","Không tồn tại");
        product[40] = new Product(books.get(13),ProductState.SOLD,importBills.get(13),saleBills.get(8),(int)importBills.get(13).getPrice()/3,150000,"link2","Không tồn tại");
        product[41] = new Product(books.get(13),ProductState.READY,importBills.get(13),null,(int)importBills.get(13).getPrice()/3,150000,"link2","A1");
        product[42] = new Product(books.get(14),ProductState.SOLD,importBills.get(14),saleBills.get(10),(int)importBills.get(14).getPrice()/3,100000,"link3","Không tồn tại");
        product[43] = new Product(books.get(14),ProductState.SOLD,importBills.get(14),saleBills.get(22),(int)importBills.get(14).getPrice()/3,100000,"link3","Không tồn tại");
        product[44] = new Product(books.get(14),ProductState.READY,importBills.get(14),null,(int)importBills.get(14).getPrice()/3,100000,"link3","A2");
        product[45] = new Product(books.get(15),ProductState.SOLD,importBills.get(15),saleBills.get(27),(int)importBills.get(15).getPrice()/3,50000,"link2","Không tồn tại");
        product[46] = new Product(books.get(15),ProductState.SOLD,importBills.get(15),saleBills.get(17),(int)importBills.get(15).getPrice()/3,50000,"link2","Không tồn tại");
        product[47] = new Product(books.get(15),ProductState.READY,importBills.get(15),null,(int)importBills.get(15).getPrice()/3,50000,"link2","C3");
        product[48] = new Product(books.get(16),ProductState.SOLD,importBills.get(16),saleBills.get(8),(int)importBills.get(16).getPrice()/3,100000,"link4","Không tồn tại");
        product[49] = new Product(books.get(16),ProductState.SOLD,importBills.get(16),saleBills.get(12),(int)importBills.get(16).getPrice()/3,100000,"link4","Không tồn tại");
        product[50] = new Product(books.get(16),ProductState.READY,importBills.get(16),null,(int)importBills.get(16).getPrice()/3,100000,"link4","C3");
        product[51] = new Product(books.get(17),ProductState.SOLD,importBills.get(17),saleBills.get(16),(int)importBills.get(17).getPrice()/3,150000,"link5","Không tồn tại");
        product[52] = new Product(books.get(17),ProductState.SOLD,importBills.get(17),saleBills.get(23),(int)importBills.get(17).getPrice()/3,150000,"link5","Không tồn tại");
        product[53] = new Product(books.get(17),ProductState.READY,importBills.get(17),null,(int)importBills.get(17).getPrice()/3,150000,"link5","D3");
        product[54] = new Product(books.get(18),ProductState.SOLD,importBills.get(18),saleBills.get(10),(int)importBills.get(18).getPrice()/3,100000,"link4","Không tồn tại");
        product[55] = new Product(books.get(18),ProductState.SOLD,importBills.get(18),saleBills.get(22),(int)importBills.get(18).getPrice()/3,100000,"link4","Không tồn tại");
        product[56] = new Product(books.get(18),ProductState.READY,importBills.get(18),null,(int)importBills.get(18).getPrice()/3,100000,"link4","C3");
        product[57] = new Product(books.get(19),ProductState.SOLD,importBills.get(19),saleBills.get(25),(int)importBills.get(19).getPrice()/3,100000,"link1","Không tồn tại");
        product[58] = new Product(books.get(19),ProductState.SOLD,importBills.get(19),saleBills.get(23),(int)importBills.get(19).getPrice()/3,100000,"link1","Không tồn tại");
        product[59] = new Product(books.get(19),ProductState.READY,importBills.get(19),null,(int)importBills.get(19).getPrice()/3,100000,"link1","C2");
        product[60] = new Product(films.get(0),ProductState.READY,importBills.get(20),null,(int)importBills.get(20).getPrice()/3,150000,"link5","Không tồn tại");
        product[61] = new Product(films.get(0),ProductState.SOLD,importBills.get(20),saleBills.get(6),(int)importBills.get(20).getPrice()/3,150000,"link5","Không tồn tại");
        product[62] = new Product(films.get(0),ProductState.READY,importBills.get(20),null,(int)importBills.get(20).getPrice()/3,150000,"link5","D2");
        product[63] = new Product(films.get(1),ProductState.READY,importBills.get(21),null,(int)importBills.get(21).getPrice()/3,150000,"link5","Không tồn tại");
        product[64] = new Product(films.get(1),ProductState.SOLD,importBills.get(21),saleBills.get(29),(int)importBills.get(21).getPrice()/3,150000,"link5","Không tồn tại");
        product[65] = new Product(films.get(1),ProductState.READY,importBills.get(21),null,(int)importBills.get(21).getPrice()/3,150000,"link5","C3");
        product[66] = new Product(films.get(2),ProductState.READY,importBills.get(22),null,(int)importBills.get(22).getPrice()/3,150000,"link2","Không tồn tại");
        product[67] = new Product(films.get(2),ProductState.SOLD,importBills.get(22),saleBills.get(12),(int)importBills.get(22).getPrice()/3,150000,"link2","Không tồn tại");
        product[68] = new Product(films.get(2),ProductState.READY,importBills.get(22),null,(int)importBills.get(22).getPrice()/3,150000,"link2","C3");
        product[69] = new Product(films.get(3),ProductState.READY,importBills.get(23),null,(int)importBills.get(23).getPrice()/3,150000,"link3","Không tồn tại");
        product[70] = new Product(films.get(3),ProductState.SOLD,importBills.get(23),saleBills.get(2),(int)importBills.get(23).getPrice()/3,150000,"link3","Không tồn tại");
        product[71] = new Product(films.get(3),ProductState.READY,importBills.get(23),null,(int)importBills.get(23).getPrice()/3,150000,"link3","B1");
        product[72] = new Product(films.get(4),ProductState.READY,importBills.get(24),null,(int)importBills.get(24).getPrice()/3,150000,"link3","Không tồn tại");
        product[73] = new Product(films.get(4),ProductState.SOLD,importBills.get(24),saleBills.get(28),(int)importBills.get(24).getPrice()/3,150000,"link3","Không tồn tại");
        product[74] = new Product(films.get(4),ProductState.READY,importBills.get(24),null,(int)importBills.get(24).getPrice()/3,150000,"link3","E2");
        product[75] = new Product(films.get(5),ProductState.READY,importBills.get(25),null,(int)importBills.get(25).getPrice()/3,100000,"link3","Không tồn tại");
        product[76] = new Product(films.get(5),ProductState.SOLD,importBills.get(25),saleBills.get(18),(int)importBills.get(25).getPrice()/3,100000,"link3","Không tồn tại");
        product[77] = new Product(films.get(5),ProductState.READY,importBills.get(25),null,(int)importBills.get(25).getPrice()/3,100000,"link3","C1");
        product[78] = new Product(films.get(6),ProductState.READY,importBills.get(26),null,(int)importBills.get(26).getPrice()/3,200000,"link2","Không tồn tại");
        product[79] = new Product(films.get(6),ProductState.SOLD,importBills.get(26),saleBills.get(7),(int)importBills.get(26).getPrice()/3,200000,"link2","Không tồn tại");
        product[80] = new Product(films.get(6),ProductState.READY,importBills.get(26),null,(int)importBills.get(26).getPrice()/3,200000,"link2","C3");
        product[81] = new Product(films.get(7),ProductState.READY,importBills.get(27),null,(int)importBills.get(27).getPrice()/3,50000,"link1","Không tồn tại");
        product[82] = new Product(films.get(7),ProductState.SOLD,importBills.get(27),saleBills.get(20),(int)importBills.get(27).getPrice()/3,50000,"link1","Không tồn tại");
        product[83] = new Product(films.get(7),ProductState.READY,importBills.get(27),null,(int)importBills.get(27).getPrice()/3,50000,"link1","C1");
        product[84] = new Product(films.get(8),ProductState.READY,importBills.get(28),null,(int)importBills.get(28).getPrice()/3,200000,"link1","Không tồn tại");
        product[85] = new Product(films.get(8),ProductState.SOLD,importBills.get(28),saleBills.get(22),(int)importBills.get(28).getPrice()/3,200000,"link1","Không tồn tại");
        product[86] = new Product(films.get(8),ProductState.READY,importBills.get(28),null,(int)importBills.get(28).getPrice()/3,200000,"link1","A2");
        product[87] = new Product(films.get(9),ProductState.READY,importBills.get(29),null,(int)importBills.get(29).getPrice()/3,150000,"link2","Không tồn tại");
        product[88] = new Product(films.get(9),ProductState.SOLD,importBills.get(29),saleBills.get(13),(int)importBills.get(29).getPrice()/3,150000,"link2","Không tồn tại");
        product[89] = new Product(films.get(9),ProductState.READY,importBills.get(29),null,(int)importBills.get(29).getPrice()/3,150000,"link2","A1");
        product[90] = new Product(films.get(10),ProductState.READY,importBills.get(30),null,(int)importBills.get(30).getPrice()/3,100000,"link5","Không tồn tại");
        product[91] = new Product(films.get(10),ProductState.SOLD,importBills.get(30),saleBills.get(9),(int)importBills.get(30).getPrice()/3,100000,"link5","Không tồn tại");
        product[92] = new Product(films.get(10),ProductState.READY,importBills.get(30),null,(int)importBills.get(30).getPrice()/3,100000,"link5","A3");
        product[93] = new Product(films.get(11),ProductState.READY,importBills.get(31),null,(int)importBills.get(31).getPrice()/3,50000,"link3","Không tồn tại");
        product[94] = new Product(films.get(11),ProductState.SOLD,importBills.get(31),saleBills.get(2),(int)importBills.get(31).getPrice()/3,50000,"link3","Không tồn tại");
        product[95] = new Product(films.get(11),ProductState.READY,importBills.get(31),null,(int)importBills.get(31).getPrice()/3,50000,"link3","C3");
        product[96] = new Product(films.get(12),ProductState.READY,importBills.get(32),null,(int)importBills.get(32).getPrice()/3,100000,"link4","Không tồn tại");
        product[97] = new Product(films.get(12),ProductState.SOLD,importBills.get(32),saleBills.get(21),(int)importBills.get(32).getPrice()/3,100000,"link4","Không tồn tại");
        product[98] = new Product(films.get(12),ProductState.READY,importBills.get(32),null,(int)importBills.get(32).getPrice()/3,100000,"link4","E2");
        product[99] = new Product(films.get(13),ProductState.READY,importBills.get(33),null,(int)importBills.get(33).getPrice()/3,200000,"link5","Không tồn tại");
        product[100] = new Product(films.get(13),ProductState.SOLD,importBills.get(33),saleBills.get(5),(int)importBills.get(33).getPrice()/3,200000,"link5","Không tồn tại");
        product[101] = new Product(films.get(13),ProductState.READY,importBills.get(33),null,(int)importBills.get(33).getPrice()/3,200000,"link5","C2");
        product[102] = new Product(films.get(14),ProductState.READY,importBills.get(34),null,(int)importBills.get(34).getPrice()/3,200000,"link1","Không tồn tại");
        product[103] = new Product(films.get(14),ProductState.SOLD,importBills.get(34),saleBills.get(15),(int)importBills.get(34).getPrice()/3,200000,"link1","Không tồn tại");
        product[104] = new Product(films.get(14),ProductState.READY,importBills.get(34),null,(int)importBills.get(34).getPrice()/3,200000,"link1","A2");
        product[105] = new Product(films.get(15),ProductState.READY,importBills.get(35),null,(int)importBills.get(35).getPrice()/3,100000,"link2","Không tồn tại");
        product[106] = new Product(films.get(15),ProductState.SOLD,importBills.get(35),saleBills.get(14),(int)importBills.get(35).getPrice()/3,100000,"link2","Không tồn tại");
        product[107] = new Product(films.get(15),ProductState.READY,importBills.get(35),null,(int)importBills.get(35).getPrice()/3,100000,"link2","A3");
        product[108] = new Product(films.get(16),ProductState.READY,importBills.get(36),null,(int)importBills.get(36).getPrice()/3,200000,"link5","Không tồn tại");
        product[109] = new Product(films.get(16),ProductState.SOLD,importBills.get(36),saleBills.get(15),(int)importBills.get(36).getPrice()/3,200000,"link5","Không tồn tại");
        product[110] = new Product(films.get(16),ProductState.READY,importBills.get(36),null,(int)importBills.get(36).getPrice()/3,200000,"link5","C3");
        product[111] = new Product(films.get(17),ProductState.READY,importBills.get(37),null,(int)importBills.get(37).getPrice()/3,200000,"link1","Không tồn tại");
        product[112] = new Product(films.get(17),ProductState.SOLD,importBills.get(37),saleBills.get(29),(int)importBills.get(37).getPrice()/3,200000,"link1","Không tồn tại");
        product[113] = new Product(films.get(17),ProductState.READY,importBills.get(37),null,(int)importBills.get(37).getPrice()/3,200000,"link1","E2");
        product[114] = new Product(films.get(18),ProductState.READY,importBills.get(38),null,(int)importBills.get(38).getPrice()/3,200000,"link2","Không tồn tại");
        product[115] = new Product(films.get(18),ProductState.SOLD,importBills.get(38),saleBills.get(3),(int)importBills.get(38).getPrice()/3,200000,"link2","Không tồn tại");
        product[116] = new Product(films.get(18),ProductState.READY,importBills.get(38),null,(int)importBills.get(38).getPrice()/3,200000,"link2","A1");
        product[117] = new Product(films.get(19),ProductState.READY,importBills.get(39),null,(int)importBills.get(39).getPrice()/3,100000,"link1","Không tồn tại");
        product[118] = new Product(films.get(19),ProductState.SOLD,importBills.get(39),saleBills.get(23),(int)importBills.get(39).getPrice()/3,100000,"link1","Không tồn tại");
        product[119] = new Product(films.get(19),ProductState.READY,importBills.get(39),null,(int)importBills.get(39).getPrice()/3,100000,"link1","A2");
        product[120] = new Product(musics.get(0),ProductState.READY,importBills.get(40),null,(int)importBills.get(40).getPrice()/3,50000,"link4","E2");
        product[121] = new Product(musics.get(0),ProductState.SOLD,importBills.get(40),saleBills.get(25),(int)importBills.get(40).getPrice()/3,50000,"link4","Không tồn tại");
        product[122] = new Product(musics.get(0),ProductState.IMPORTING,null,null,0,0,"link4","Không tồn tại");
        product[123] = new Product(musics.get(1),ProductState.READY,importBills.get(41),null,(int)importBills.get(41).getPrice()/3,100000,"link2","C3");
        product[124] = new Product(musics.get(1),ProductState.SOLD,importBills.get(41),saleBills.get(10),(int)importBills.get(41).getPrice()/3,100000,"link2","Không tồn tại");
        product[125] = new Product(musics.get(1),ProductState.IMPORTING,null,null,0,0,"link2","Không tồn tại");
        product[126] = new Product(musics.get(2),ProductState.READY,importBills.get(42),null,(int)importBills.get(42).getPrice()/3,30000,"link5","A1");
        product[127] = new Product(musics.get(2),ProductState.SOLD,importBills.get(42),saleBills.get(17),(int)importBills.get(42).getPrice()/3,30000,"link5","Không tồn tại");
        product[128] = new Product(musics.get(2),ProductState.IMPORTING,null,null,0,0,"link5","Không tồn tại");
        product[129] = new Product(musics.get(3),ProductState.READY,importBills.get(43),null,(int)importBills.get(43).getPrice()/3,30000,"link1","D1");
        product[130] = new Product(musics.get(3),ProductState.SOLD,importBills.get(43),saleBills.get(16),(int)importBills.get(43).getPrice()/3,30000,"link1","Không tồn tại");
        product[131] = new Product(musics.get(3),ProductState.IMPORTING,null,null,0,0,"link1","Không tồn tại");
        product[132] = new Product(musics.get(4),ProductState.READY,importBills.get(44),null,(int)importBills.get(44).getPrice()/3,30000,"link5","B2");
        product[133] = new Product(musics.get(4),ProductState.SOLD,importBills.get(44),saleBills.get(16),(int)importBills.get(44).getPrice()/3,30000,"link5","Không tồn tại");
        product[134] = new Product(musics.get(4),ProductState.IMPORTING,null,null,0,0,"link5","Không tồn tại");
        product[135] = new Product(musics.get(5),ProductState.READY,importBills.get(45),null,(int)importBills.get(45).getPrice()/3,50000,"link4","C3");
        product[136] = new Product(musics.get(5),ProductState.SOLD,importBills.get(45),saleBills.get(20),(int)importBills.get(45).getPrice()/3,50000,"link4","Không tồn tại");
        product[137] = new Product(musics.get(5),ProductState.IMPORTING,null,null,0,0,"link4","Không tồn tại");
        product[138] = new Product(musics.get(6),ProductState.READY,importBills.get(46),null,(int)importBills.get(46).getPrice()/3,100000,"link2","D2");
        product[139] = new Product(musics.get(6),ProductState.SOLD,importBills.get(46),saleBills.get(28),(int)importBills.get(46).getPrice()/3,100000,"link2","Không tồn tại");
        product[140] = new Product(musics.get(6),ProductState.IMPORTING,null,null,0,0,"link2","Không tồn tại");
        product[141] = new Product(musics.get(7),ProductState.READY,importBills.get(47),null,(int)importBills.get(47).getPrice()/3,30000,"link4","C1");
        product[142] = new Product(musics.get(7),ProductState.SOLD,importBills.get(47),saleBills.get(20),(int)importBills.get(47).getPrice()/3,30000,"link4","Không tồn tại");
        product[143] = new Product(musics.get(7),ProductState.IMPORTING,null,null,0,0,"link4","Không tồn tại");
        product[144] = new Product(musics.get(8),ProductState.READY,importBills.get(48),null,(int)importBills.get(48).getPrice()/3,50000,"link4","B2");
        product[145] = new Product(musics.get(8),ProductState.SOLD,importBills.get(48),saleBills.get(22),(int)importBills.get(48).getPrice()/3,50000,"link4","Không tồn tại");
        product[146] = new Product(musics.get(8),ProductState.IMPORTING,null,null,0,0,"link4","Không tồn tại");
        product[147] = new Product(musics.get(9),ProductState.READY,importBills.get(49),null,(int)importBills.get(49).getPrice()/3,50000,"link3","E1");
        product[148] = new Product(musics.get(9),ProductState.SOLD,importBills.get(49),saleBills.get(7),(int)importBills.get(49).getPrice()/3,50000,"link3","Không tồn tại");
        product[149] = new Product(musics.get(9),ProductState.IMPORTING,null,null,0,0,"link3","Không tồn tại");
        product[150] = new Product(musics.get(10),ProductState.READY,importBills.get(50),null,(int)importBills.get(50).getPrice()/3,30000,"link2","D2");
        product[151] = new Product(musics.get(10),ProductState.SOLD,importBills.get(50),saleBills.get(25),(int)importBills.get(50).getPrice()/3,30000,"link2","Không tồn tại");
        product[152] = new Product(musics.get(10),ProductState.IMPORTING,null,null,0,0,"link2","Không tồn tại");
        product[153] = new Product(musics.get(11),ProductState.READY,importBills.get(51),null,(int)importBills.get(51).getPrice()/3,50000,"link5","E1");
        product[154] = new Product(musics.get(11),ProductState.SOLD,importBills.get(51),saleBills.get(29),(int)importBills.get(51).getPrice()/3,50000,"link5","Không tồn tại");
        product[155] = new Product(musics.get(11),ProductState.IMPORTING,null,null,0,0,"link5","Không tồn tại");
        product[156] = new Product(musics.get(12),ProductState.READY,importBills.get(52),null,(int)importBills.get(52).getPrice()/3,50000,"link1","A2");
        product[157] = new Product(musics.get(12),ProductState.SOLD,importBills.get(52),saleBills.get(29),(int)importBills.get(52).getPrice()/3,50000,"link1","Không tồn tại");
        product[158] = new Product(musics.get(12),ProductState.IMPORTING,null,null,0,0,"link1","Không tồn tại");
        product[159] = new Product(musics.get(13),ProductState.READY,importBills.get(53),null,(int)importBills.get(53).getPrice()/3,50000,"link1","B3");
        product[160] = new Product(musics.get(13),ProductState.SOLD,importBills.get(53),saleBills.get(10),(int)importBills.get(53).getPrice()/3,50000,"link1","Không tồn tại");
        product[161] = new Product(musics.get(13),ProductState.IMPORTING,null,null,0,0,"link1","Không tồn tại");
        product[162] = new Product(musics.get(14),ProductState.READY,importBills.get(54),null,(int)importBills.get(54).getPrice()/3,30000,"link1","C1");
        product[163] = new Product(musics.get(14),ProductState.SOLD,importBills.get(54),saleBills.get(18),(int)importBills.get(54).getPrice()/3,30000,"link1","Không tồn tại");
        product[164] = new Product(musics.get(14),ProductState.IMPORTING,null,null,0,0,"link1","Không tồn tại");
        product[165] = new Product(musics.get(15),ProductState.READY,importBills.get(55),null,(int)importBills.get(55).getPrice()/3,100000,"link5","C3");
        product[166] = new Product(musics.get(15),ProductState.SOLD,importBills.get(55),saleBills.get(23),(int)importBills.get(55).getPrice()/3,100000,"link5","Không tồn tại");
        product[167] = new Product(musics.get(15),ProductState.IMPORTING,null,null,0,0,"link5","Không tồn tại");
        product[168] = new Product(musics.get(16),ProductState.READY,importBills.get(56),null,(int)importBills.get(56).getPrice()/3,50000,"link4","D3");
        product[169] = new Product(musics.get(16),ProductState.SOLD,importBills.get(56),saleBills.get(18),(int)importBills.get(56).getPrice()/3,50000,"link4","Không tồn tại");
        product[170] = new Product(musics.get(16),ProductState.IMPORTING,null,null,0,0,"link4","Không tồn tại");
        product[171] = new Product(musics.get(17),ProductState.READY,importBills.get(57),null,(int)importBills.get(57).getPrice()/3,100000,"link5","A2");
        product[172] = new Product(musics.get(17),ProductState.SOLD,importBills.get(57),saleBills.get(11),(int)importBills.get(57).getPrice()/3,100000,"link5","Không tồn tại");
        product[173] = new Product(musics.get(17),ProductState.IMPORTING,null,null,0,0,"link5","Không tồn tại");
        product[174] = new Product(musics.get(18),ProductState.READY,importBills.get(58),null,(int)importBills.get(58).getPrice()/3,30000,"link2","B1");
        product[175] = new Product(musics.get(18),ProductState.SOLD,importBills.get(58),saleBills.get(15),(int)importBills.get(58).getPrice()/3,30000,"link2","Không tồn tại");
        product[176] = new Product(musics.get(18),ProductState.IMPORTING,null,null,0,0,"link2","Không tồn tại");
        product[177] = new Product(musics.get(19),ProductState.READY,importBills.get(59),null,(int)importBills.get(59).getPrice()/3,100000,"link4","D1");
        product[178] = new Product(musics.get(19),ProductState.SOLD,importBills.get(59),saleBills.get(1),(int)importBills.get(59).getPrice()/3,100000,"link4","Không tồn tại");
        product[179] = new Product(musics.get(19),ProductState.IMPORTING,null,null,0,0,"link4","Không tồn tại");

        for (var x : product){
            adapter.insertProduct(x);
        }



    }

}
