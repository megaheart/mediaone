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
    public void insert() throws Exception {

        var adapter = DatabaseAdapter.getDbAdapter();
        var importBills = adapter.getAllImportBills();
        var saleBills = adapter.getAllSaleBills();
        var musics = adapter.getAllMusicInfos();
        var films = adapter.getAllFilmInfos();
        var books = adapter.getAllBookInfos();




        Product[] product = new Product[180];
        //Book
        product[0] = new Product(books.get(0), ProductState.RETURNED, importBills.get(0), saleBills.get(12), importBills.get(0).getPrice() / 3, 50000, "B2", "link4");
        product[1] = new Product(books.get(0), ProductState.RETURNED, importBills.get(0), saleBills.get(15), importBills.get(0).getPrice() / 3, 100000, "A1", "link4");
        product[2] = new Product(books.get(0), ProductState.IMPORTING, importBills.get(0), saleBills.get(17), importBills.get(0).getPrice() / 3, 50000, "A3", "link4");
        product[3] = new Product(books.get(1), ProductState.RETURNED, importBills.get(1), saleBills.get(10), importBills.get(1).getPrice() / 3, 100000, "B1", "link3");
        product[4] = new Product(books.get(1), ProductState.READY, importBills.get(1), saleBills.get(0), importBills.get(1).getPrice() / 3, 100000, "B3", "link2");
        product[5] = new Product(books.get(1), ProductState.READY, importBills.get(1), saleBills.get(18), importBills.get(1).getPrice() / 3, 100000, "A1", "link2");
        product[6] = new Product(books.get(2), ProductState.READY, importBills.get(2), saleBills.get(11), importBills.get(2).getPrice() / 3, 100000, "E2", "link1");
        product[7] = new Product(books.get(2), ProductState.ORDERED, importBills.get(2), saleBills.get(8), importBills.get(2).getPrice() / 3, 50000, "A1", "link4");
        product[8] = new Product(books.get(2), ProductState.ORDERED, importBills.get(2), saleBills.get(16), importBills.get(2).getPrice() / 3, 100000, "B3", "link4");
        product[9] = new Product(books.get(3), ProductState.RETURNED, importBills.get(3), saleBills.get(18), importBills.get(3).getPrice() / 3, 100000, "B1", "link2");
        product[10] = new Product(books.get(3), ProductState.READY, importBills.get(3), saleBills.get(18), importBills.get(3).getPrice() / 3, 100000, "C1", "link3");
        product[11] = new Product(books.get(3), ProductState.ORDERED, importBills.get(3), saleBills.get(16), importBills.get(3).getPrice() / 3, 50000, "E2", "link1");
        product[12] = new Product(books.get(4), ProductState.RETURNED, importBills.get(4), saleBills.get(4), importBills.get(4).getPrice() / 3, 100000, "D2", "link5");
        product[13] = new Product(books.get(4), ProductState.IMPORTING, importBills.get(4), saleBills.get(11), importBills.get(4).getPrice() / 3, 100000, "A1", "link5");
        product[14] = new Product(books.get(4), ProductState.RETURNED, importBills.get(4), saleBills.get(2), importBills.get(4).getPrice() / 3, 100000, "C3", "link3");
        product[15] = new Product(books.get(5), ProductState.IMPORTING, importBills.get(5), saleBills.get(4), importBills.get(5).getPrice() / 3, 100000, "D3", "link3");
        product[16] = new Product(books.get(5), ProductState.ORDERED, importBills.get(5), saleBills.get(6), importBills.get(5).getPrice() / 3, 100000, "D3", "link4");
        product[17] = new Product(books.get(5), ProductState.IMPORTING, importBills.get(5), saleBills.get(3), importBills.get(5).getPrice() / 3, 100000, "B3", "link3");
        product[18] = new Product(books.get(6), ProductState.ORDERED, importBills.get(6), saleBills.get(9), importBills.get(6).getPrice() / 3, 50000, "E2", "link4");
        product[19] = new Product(books.get(6), ProductState.READY, importBills.get(6), saleBills.get(12), importBills.get(6).getPrice() / 3, 100000, "C2", "link4");
        product[20] = new Product(books.get(6), ProductState.READY, importBills.get(6), saleBills.get(4), importBills.get(6).getPrice() / 3, 50000, "B3", "link4");
        product[21] = new Product(books.get(7), ProductState.IMPORTING, importBills.get(7), saleBills.get(15), importBills.get(7).getPrice() / 3, 100000, "A1", "link1");
        product[22] = new Product(books.get(7), ProductState.READY, importBills.get(7), saleBills.get(7), importBills.get(7).getPrice() / 3, 100000, "C2", "link2");
        product[23] = new Product(books.get(7), ProductState.IMPORTING, importBills.get(7), saleBills.get(2), importBills.get(7).getPrice() / 3, 100000, "A2", "link1");
        product[24] = new Product(books.get(8), ProductState.RETURNED, importBills.get(8), saleBills.get(6), importBills.get(8).getPrice() / 3, 50000, "C3", "link1");
        product[25] = new Product(books.get(8), ProductState.RETURNED, importBills.get(8), saleBills.get(8), importBills.get(8).getPrice() / 3, 50000, "E2", "link2");
        product[26] = new Product(books.get(8), ProductState.READY, importBills.get(8), saleBills.get(9), importBills.get(8).getPrice() / 3, 50000, "A3", "link4");
        product[27] = new Product(books.get(9), ProductState.IMPORTING, importBills.get(9), saleBills.get(5), importBills.get(9).getPrice() / 3, 100000, "A3", "link4");
        product[28] = new Product(books.get(9), ProductState.IMPORTING, importBills.get(9), saleBills.get(11), importBills.get(9).getPrice() / 3, 50000, "B2", "link5");
        product[29] = new Product(books.get(9), ProductState.RETURNED, importBills.get(9), saleBills.get(7), importBills.get(9).getPrice() / 3, 100000, "D1", "link5");
        product[30] = new Product(books.get(10), ProductState.READY, importBills.get(10), saleBills.get(16), importBills.get(10).getPrice() / 3, 100000, "C2", "link1");
        product[31] = new Product(books.get(10), ProductState.IMPORTING, importBills.get(10), saleBills.get(8), importBills.get(10).getPrice() / 3, 100000, "B3", "link1");
        product[32] = new Product(books.get(10), ProductState.IMPORTING, importBills.get(10), saleBills.get(2), importBills.get(10).getPrice() / 3, 50000, "D2", "link1");
        product[33] = new Product(books.get(11), ProductState.ORDERED, importBills.get(11), saleBills.get(7), importBills.get(11).getPrice() / 3, 50000, "D3", "link2");
        product[34] = new Product(books.get(11), ProductState.RETURNED, importBills.get(11), saleBills.get(0), importBills.get(11).getPrice() / 3, 50000, "C1", "link3");
        product[35] = new Product(books.get(11), ProductState.ORDERED, importBills.get(11), saleBills.get(10), importBills.get(11).getPrice() / 3, 100000, "D2", "link5");
        product[36] = new Product(books.get(12), ProductState.IMPORTING, importBills.get(12), saleBills.get(16), importBills.get(12).getPrice() / 3, 100000, "A2", "link3");
        product[37] = new Product(books.get(12), ProductState.IMPORTING, importBills.get(12), saleBills.get(6), importBills.get(12).getPrice() / 3, 50000, "A2", "link1");
        product[38] = new Product(books.get(12), ProductState.READY, importBills.get(12), saleBills.get(3), importBills.get(12).getPrice() / 3, 50000, "E2", "link5");
        product[39] = new Product(books.get(13), ProductState.ORDERED, importBills.get(13), saleBills.get(3), importBills.get(13).getPrice() / 3, 100000, "B2", "link4");
        product[40] = new Product(books.get(13), ProductState.RETURNED, importBills.get(13), saleBills.get(8), importBills.get(13).getPrice() / 3, 50000, "C1", "link3");
        product[41] = new Product(books.get(13), ProductState.IMPORTING, importBills.get(13), saleBills.get(7), importBills.get(13).getPrice() / 3, 100000, "A2", "link4");
        product[42] = new Product(books.get(14), ProductState.ORDERED, importBills.get(14), saleBills.get(6), importBills.get(14).getPrice() / 3, 50000, "B3", "link2");
        product[43] = new Product(books.get(14), ProductState.IMPORTING, importBills.get(14), saleBills.get(0), importBills.get(14).getPrice() / 3, 50000, "A3", "link2");
        product[44] = new Product(books.get(14), ProductState.ORDERED, importBills.get(14), saleBills.get(14), importBills.get(14).getPrice() / 3, 100000, "C3", "link5");
        product[45] = new Product(books.get(15), ProductState.RETURNED, importBills.get(15), saleBills.get(13), importBills.get(15).getPrice() / 3, 50000, "C1", "link2");
        product[46] = new Product(books.get(15), ProductState.IMPORTING, importBills.get(15), saleBills.get(11), importBills.get(15).getPrice() / 3, 100000, "A1", "link1");
        product[47] = new Product(books.get(15), ProductState.READY, importBills.get(15), saleBills.get(14), importBills.get(15).getPrice() / 3, 50000, "C1", "link2");
        product[48] = new Product(books.get(16), ProductState.IMPORTING, importBills.get(16), saleBills.get(18), importBills.get(16).getPrice() / 3, 100000, "B2", "link4");
        product[49] = new Product(books.get(16), ProductState.IMPORTING, importBills.get(16), saleBills.get(3), importBills.get(16).getPrice() / 3, 100000, "C3", "link5");
        product[50] = new Product(books.get(16), ProductState.IMPORTING, importBills.get(16), saleBills.get(15), importBills.get(16).getPrice() / 3, 100000, "E2", "link3");
        product[51] = new Product(books.get(17), ProductState.ORDERED, importBills.get(17), saleBills.get(10), importBills.get(17).getPrice() / 3, 100000, "C2", "link4");
        product[52] = new Product(books.get(17), ProductState.READY, importBills.get(17), saleBills.get(5), importBills.get(17).getPrice() / 3, 100000, "D3", "link4");
        product[53] = new Product(books.get(17), ProductState.ORDERED, importBills.get(17), saleBills.get(12), importBills.get(17).getPrice() / 3, 100000, "B2", "link4");
        product[54] = new Product(books.get(18), ProductState.READY, importBills.get(18), saleBills.get(17), importBills.get(18).getPrice() / 3, 50000, "E1", "link2");
        product[55] = new Product(books.get(18), ProductState.IMPORTING, importBills.get(18), saleBills.get(10), importBills.get(18).getPrice() / 3, 100000, "E2", "link1");
        product[56] = new Product(books.get(18), ProductState.ORDERED, importBills.get(18), saleBills.get(9), importBills.get(18).getPrice() / 3, 100000, "C3", "link3");
        product[57] = new Product(books.get(19), ProductState.IMPORTING, importBills.get(19), saleBills.get(4), importBills.get(19).getPrice() / 3, 100000, "C2", "link2");
        product[58] = new Product(books.get(19), ProductState.IMPORTING, importBills.get(19), saleBills.get(1), importBills.get(19).getPrice() / 3, 100000, "D3", "link4");
        product[59] = new Product(books.get(19), ProductState.ORDERED, importBills.get(19), saleBills.get(11), importBills.get(19).getPrice() / 3, 100000, "D1", "link5");
        product[60] = new Product(films.get(0), ProductState.RETURNED, importBills.get(20), saleBills.get(12), importBills.get(20).getPrice() / 3, 50000, "E1", "link2");
        product[61] = new Product(films.get(0), ProductState.IMPORTING, importBills.get(20), saleBills.get(15), importBills.get(20).getPrice() / 3, 150000, "D2", "link1");
        product[62] = new Product(films.get(0), ProductState.ORDERED, importBills.get(20), saleBills.get(4), importBills.get(20).getPrice() / 3, 50000, "B3", "link4");
        product[63] = new Product(films.get(1), ProductState.IMPORTING, importBills.get(21), saleBills.get(2), importBills.get(21).getPrice() / 3, 50000, "B3", "link4");
        product[64] = new Product(films.get(1), ProductState.RETURNED, importBills.get(21), saleBills.get(9), importBills.get(21).getPrice() / 3, 50000, "A2", "link5");
        product[65] = new Product(films.get(1), ProductState.READY, importBills.get(21), saleBills.get(12), importBills.get(21).getPrice() / 3, 100000, "B1", "link4");
        product[66] = new Product(films.get(2), ProductState.ORDERED, importBills.get(22), saleBills.get(12), importBills.get(22).getPrice() / 3, 50000, "A2", "link3");
        product[67] = new Product(films.get(2), ProductState.ORDERED, importBills.get(22), saleBills.get(5), importBills.get(22).getPrice() / 3, 50000, "B1", "link2");
        product[68] = new Product(films.get(2), ProductState.ORDERED, importBills.get(22), saleBills.get(15), importBills.get(22).getPrice() / 3, 150000, "C2", "link2");
        product[69] = new Product(films.get(3), ProductState.RETURNED, importBills.get(23), saleBills.get(0), importBills.get(23).getPrice() / 3, 100000, "A1", "link3");
        product[70] = new Product(films.get(3), ProductState.RETURNED, importBills.get(23), saleBills.get(14), importBills.get(23).getPrice() / 3, 100000, "E1", "link3");
        product[71] = new Product(films.get(3), ProductState.RETURNED, importBills.get(23), saleBills.get(17), importBills.get(23).getPrice() / 3, 100000, "A1", "link1");
        product[72] = new Product(films.get(4), ProductState.RETURNED, importBills.get(24), saleBills.get(8), importBills.get(24).getPrice() / 3, 50000, "A2", "link4");
        product[73] = new Product(films.get(4), ProductState.ORDERED, importBills.get(24), saleBills.get(16), importBills.get(24).getPrice() / 3, 100000, "D2", "link3");
        product[74] = new Product(films.get(4), ProductState.RETURNED, importBills.get(24), saleBills.get(13), importBills.get(24).getPrice() / 3, 50000, "A2", "link3");
        product[75] = new Product(films.get(5), ProductState.ORDERED, importBills.get(25), saleBills.get(13), importBills.get(25).getPrice() / 3, 100000, "D3", "link5");
        product[76] = new Product(films.get(5), ProductState.READY, importBills.get(25), saleBills.get(14), importBills.get(25).getPrice() / 3, 100000, "D1", "link2");
        product[77] = new Product(films.get(5), ProductState.ORDERED, importBills.get(25), saleBills.get(16), importBills.get(25).getPrice() / 3, 100000, "C3", "link1");
        product[78] = new Product(films.get(6), ProductState.ORDERED, importBills.get(26), saleBills.get(5), importBills.get(26).getPrice() / 3, 100000, "A3", "link3");
        product[79] = new Product(films.get(6), ProductState.ORDERED, importBills.get(26), saleBills.get(10), importBills.get(26).getPrice() / 3, 100000, "E1", "link5");
        product[80] = new Product(films.get(6), ProductState.IMPORTING, importBills.get(26), saleBills.get(3), importBills.get(26).getPrice() / 3, 100000, "C3", "link1");
        product[81] = new Product(films.get(7), ProductState.RETURNED, importBills.get(27), saleBills.get(8), importBills.get(27).getPrice() / 3, 150000, "C1", "link3");
        product[82] = new Product(films.get(7), ProductState.RETURNED, importBills.get(27), saleBills.get(4), importBills.get(27).getPrice() / 3, 150000, "A2", "link4");
        product[83] = new Product(films.get(7), ProductState.ORDERED, importBills.get(27), saleBills.get(0), importBills.get(27).getPrice() / 3, 100000, "E1", "link2");
        product[84] = new Product(films.get(8), ProductState.READY, importBills.get(28), saleBills.get(9), importBills.get(28).getPrice() / 3, 100000, "C3", "link5");
        product[85] = new Product(films.get(8), ProductState.READY, importBills.get(28), saleBills.get(7), importBills.get(28).getPrice() / 3, 150000, "C2", "link1");
        product[86] = new Product(films.get(8), ProductState.ORDERED, importBills.get(28), saleBills.get(13), importBills.get(28).getPrice() / 3, 150000, "D3", "link2");
        product[87] = new Product(films.get(9), ProductState.IMPORTING, importBills.get(29), saleBills.get(18), importBills.get(29).getPrice() / 3, 50000, "C2", "link4");
        product[88] = new Product(films.get(9), ProductState.RETURNED, importBills.get(29), saleBills.get(17), importBills.get(29).getPrice() / 3, 50000, "A3", "link3");
        product[89] = new Product(films.get(9), ProductState.ORDERED, importBills.get(29), saleBills.get(0), importBills.get(29).getPrice() / 3, 50000, "C2", "link4");
        product[90] = new Product(films.get(10), ProductState.ORDERED, importBills.get(30), saleBills.get(15), importBills.get(30).getPrice() / 3, 100000, "D1", "link3");
        product[91] = new Product(films.get(10), ProductState.ORDERED, importBills.get(30), saleBills.get(10), importBills.get(30).getPrice() / 3, 50000, "D1", "link4");
        product[92] = new Product(films.get(10), ProductState.ORDERED, importBills.get(30), saleBills.get(18), importBills.get(30).getPrice() / 3, 50000, "B2", "link4");
        product[93] = new Product(films.get(11), ProductState.IMPORTING, importBills.get(31), saleBills.get(3), importBills.get(31).getPrice() / 3, 50000, "D1", "link4");
        product[94] = new Product(films.get(11), ProductState.RETURNED, importBills.get(31), saleBills.get(1), importBills.get(31).getPrice() / 3, 100000, "A3", "link5");
        product[95] = new Product(films.get(11), ProductState.READY, importBills.get(31), saleBills.get(3), importBills.get(31).getPrice() / 3, 100000, "A2", "link4");
        product[96] = new Product(films.get(12), ProductState.IMPORTING, importBills.get(32), saleBills.get(18), importBills.get(32).getPrice() / 3, 150000, "D3", "link1");
        product[97] = new Product(films.get(12), ProductState.READY, importBills.get(32), saleBills.get(4), importBills.get(32).getPrice() / 3, 50000, "B3", "link5");
        product[98] = new Product(films.get(12), ProductState.ORDERED, importBills.get(32), saleBills.get(12), importBills.get(32).getPrice() / 3, 100000, "E1", "link4");
        product[99] = new Product(films.get(13), ProductState.READY, importBills.get(33), saleBills.get(15), importBills.get(33).getPrice() / 3, 50000, "C1", "link1");
        product[100] = new Product(films.get(13), ProductState.READY, importBills.get(33), saleBills.get(4), importBills.get(33).getPrice() / 3, 150000, "D3", "link2");
        product[101] = new Product(films.get(13), ProductState.ORDERED, importBills.get(33), saleBills.get(5), importBills.get(33).getPrice() / 3, 100000, "D1", "link5");
        product[102] = new Product(films.get(14), ProductState.ORDERED, importBills.get(34), saleBills.get(9), importBills.get(34).getPrice() / 3, 150000, "E1", "link1");
        product[103] = new Product(films.get(14), ProductState.ORDERED, importBills.get(34), saleBills.get(5), importBills.get(34).getPrice() / 3, 50000, "B2", "link5");
        product[104] = new Product(films.get(14), ProductState.RETURNED, importBills.get(34), saleBills.get(14), importBills.get(34).getPrice() / 3, 50000, "D3", "link4");
        product[105] = new Product(films.get(15), ProductState.RETURNED, importBills.get(35), saleBills.get(8), importBills.get(35).getPrice() / 3, 150000, "C1", "link2");
        product[106] = new Product(films.get(15), ProductState.IMPORTING, importBills.get(35), saleBills.get(11), importBills.get(35).getPrice() / 3, 150000, "E1", "link4");
        product[107] = new Product(films.get(15), ProductState.ORDERED, importBills.get(35), saleBills.get(13), importBills.get(35).getPrice() / 3, 100000, "C1", "link1");
        product[108] = new Product(films.get(16), ProductState.IMPORTING, importBills.get(36), saleBills.get(17), importBills.get(36).getPrice() / 3, 150000, "C1", "link3");
        product[109] = new Product(films.get(16), ProductState.ORDERED, importBills.get(36), saleBills.get(4), importBills.get(36).getPrice() / 3, 50000, "E1", "link5");
        product[110] = new Product(films.get(16), ProductState.ORDERED, importBills.get(36), saleBills.get(0), importBills.get(36).getPrice() / 3, 150000, "C1", "link5");
        product[111] = new Product(films.get(17), ProductState.READY, importBills.get(37), saleBills.get(6), importBills.get(37).getPrice() / 3, 50000, "A3", "link2");
        product[112] = new Product(films.get(17), ProductState.RETURNED, importBills.get(37), saleBills.get(3), importBills.get(37).getPrice() / 3, 150000, "B3", "link1");
        product[113] = new Product(films.get(17), ProductState.ORDERED, importBills.get(37), saleBills.get(4), importBills.get(37).getPrice() / 3, 50000, "B1", "link1");
        product[114] = new Product(films.get(18), ProductState.RETURNED, importBills.get(38), saleBills.get(4), importBills.get(38).getPrice() / 3, 100000, "A3", "link3");
        product[115] = new Product(films.get(18), ProductState.ORDERED, importBills.get(38), saleBills.get(5), importBills.get(38).getPrice() / 3, 50000, "B2", "link5");
        product[116] = new Product(films.get(18), ProductState.IMPORTING, importBills.get(38), saleBills.get(2), importBills.get(38).getPrice() / 3, 100000, "C2", "link1");
        product[117] = new Product(films.get(19), ProductState.READY, importBills.get(39), saleBills.get(16), importBills.get(39).getPrice() / 3, 150000, "A1", "link4");
        product[118] = new Product(films.get(19), ProductState.IMPORTING, importBills.get(39), saleBills.get(16), importBills.get(39).getPrice() / 3, 50000, "A2", "link5");
        product[119] = new Product(films.get(19), ProductState.READY, importBills.get(39), saleBills.get(8), importBills.get(39).getPrice() / 3, 100000, "B3", "link3");
        product[120] = new Product(musics.get(0), ProductState.IMPORTING, importBills.get(40), saleBills.get(4), importBills.get(40).getPrice() / 3, 50000, "D1", "link4");
        product[121] = new Product(musics.get(0), ProductState.IMPORTING, importBills.get(40), saleBills.get(13), importBills.get(40).getPrice() / 3, 50000, "E2", "link2");
        product[122] = new Product(musics.get(0), ProductState.ORDERED, importBills.get(40), saleBills.get(6), importBills.get(40).getPrice() / 3, 50000, "B2", "link2");
        product[123] = new Product(musics.get(1), ProductState.ORDERED, importBills.get(41), saleBills.get(10), importBills.get(41).getPrice() / 3, 50000, "A3", "link2");
        product[124] = new Product(musics.get(1), ProductState.ORDERED, importBills.get(41), saleBills.get(2), importBills.get(41).getPrice() / 3, 30000, "C1", "link2");
        product[125] = new Product(musics.get(1), ProductState.RETURNED, importBills.get(41), saleBills.get(11), importBills.get(41).getPrice() / 3, 50000, "B1", "link2");
        product[126] = new Product(musics.get(2), ProductState.RETURNED, importBills.get(42), saleBills.get(1), importBills.get(42).getPrice() / 3, 50000, "D3", "link2");
        product[127] = new Product(musics.get(2), ProductState.ORDERED, importBills.get(42), saleBills.get(0), importBills.get(42).getPrice() / 3, 30000, "E1", "link2");
        product[128] = new Product(musics.get(2), ProductState.READY, importBills.get(42), saleBills.get(9), importBills.get(42).getPrice() / 3, 30000, "D1", "link1");
        product[129] = new Product(musics.get(3), ProductState.RETURNED, importBills.get(43), saleBills.get(11), importBills.get(43).getPrice() / 3, 50000, "E1", "link1");
        product[130] = new Product(musics.get(3), ProductState.ORDERED, importBills.get(43), saleBills.get(1), importBills.get(43).getPrice() / 3, 30000, "A1", "link4");
        product[131] = new Product(musics.get(3), ProductState.READY, importBills.get(43), saleBills.get(7), importBills.get(43).getPrice() / 3, 50000, "B3", "link2");
        product[132] = new Product(musics.get(4), ProductState.RETURNED, importBills.get(44), saleBills.get(15), importBills.get(44).getPrice() / 3, 30000, "C3", "link4");
        product[133] = new Product(musics.get(4), ProductState.READY, importBills.get(44), saleBills.get(0), importBills.get(44).getPrice() / 3, 50000, "A1", "link3");
        product[134] = new Product(musics.get(4), ProductState.ORDERED, importBills.get(44), saleBills.get(16), importBills.get(44).getPrice() / 3, 50000, "E1", "link5");
        product[135] = new Product(musics.get(5), ProductState.READY, importBills.get(45), saleBills.get(6), importBills.get(45).getPrice() / 3, 50000, "B2", "link2");
        product[136] = new Product(musics.get(5), ProductState.RETURNED, importBills.get(45), saleBills.get(2), importBills.get(45).getPrice() / 3, 30000, "B1", "link3");
        product[137] = new Product(musics.get(5), ProductState.RETURNED, importBills.get(45), saleBills.get(7), importBills.get(45).getPrice() / 3, 50000, "A2", "link2");
        product[138] = new Product(musics.get(6), ProductState.RETURNED, importBills.get(46), saleBills.get(4), importBills.get(46).getPrice() / 3, 30000, "C2", "link3");
        product[139] = new Product(musics.get(6), ProductState.IMPORTING, importBills.get(46), saleBills.get(17), importBills.get(46).getPrice() / 3, 30000, "A1", "link1");
        product[140] = new Product(musics.get(6), ProductState.RETURNED, importBills.get(46), saleBills.get(3), importBills.get(46).getPrice() / 3, 50000, "B2", "link2");
        product[141] = new Product(musics.get(7), ProductState.READY, importBills.get(47), saleBills.get(6), importBills.get(47).getPrice() / 3, 30000, "A1", "link5");
        product[142] = new Product(musics.get(7), ProductState.ORDERED, importBills.get(47), saleBills.get(7), importBills.get(47).getPrice() / 3, 30000, "A2", "link3");
        product[143] = new Product(musics.get(7), ProductState.READY, importBills.get(47), saleBills.get(17), importBills.get(47).getPrice() / 3, 50000, "A1", "link3");
        product[144] = new Product(musics.get(8), ProductState.ORDERED, importBills.get(48), saleBills.get(1), importBills.get(48).getPrice() / 3, 30000, "D3", "link5");
        product[145] = new Product(musics.get(8), ProductState.RETURNED, importBills.get(48), saleBills.get(14), importBills.get(48).getPrice() / 3, 50000, "B3", "link5");
        product[146] = new Product(musics.get(8), ProductState.READY, importBills.get(48), saleBills.get(10), importBills.get(48).getPrice() / 3, 50000, "A3", "link1");
        product[147] = new Product(musics.get(9), ProductState.READY, importBills.get(49), saleBills.get(9), importBills.get(49).getPrice() / 3, 50000, "A1", "link4");
        product[148] = new Product(musics.get(9), ProductState.RETURNED, importBills.get(49), saleBills.get(0), importBills.get(49).getPrice() / 3, 30000, "A3", "link1");
        product[149] = new Product(musics.get(9), ProductState.RETURNED, importBills.get(49), saleBills.get(11), importBills.get(49).getPrice() / 3, 50000, "E2", "link1");
        product[150] = new Product(musics.get(10), ProductState.IMPORTING, importBills.get(50), saleBills.get(9), importBills.get(50).getPrice() / 3, 30000, "B3", "link2");
        product[151] = new Product(musics.get(10), ProductState.RETURNED, importBills.get(50), saleBills.get(5), importBills.get(50).getPrice() / 3, 50000, "B2", "link4");
        product[152] = new Product(musics.get(10), ProductState.IMPORTING, importBills.get(50), saleBills.get(11), importBills.get(50).getPrice() / 3, 30000, "A2", "link3");
        product[153] = new Product(musics.get(11), ProductState.IMPORTING, importBills.get(51), saleBills.get(13), importBills.get(51).getPrice() / 3, 50000, "A1", "link3");
        product[154] = new Product(musics.get(11), ProductState.READY, importBills.get(51), saleBills.get(1), importBills.get(51).getPrice() / 3, 30000, "B2", "link4");
        product[155] = new Product(musics.get(11), ProductState.ORDERED, importBills.get(51), saleBills.get(3), importBills.get(51).getPrice() / 3, 30000, "D3", "link4");
        product[156] = new Product(musics.get(12), ProductState.RETURNED, importBills.get(52), saleBills.get(14), importBills.get(52).getPrice() / 3, 50000, "B3", "link2");
        product[157] = new Product(musics.get(12), ProductState.ORDERED, importBills.get(52), saleBills.get(10), importBills.get(52).getPrice() / 3, 30000, "E2", "link4");
        product[158] = new Product(musics.get(12), ProductState.ORDERED, importBills.get(52), saleBills.get(7), importBills.get(52).getPrice() / 3, 50000, "B1", "link1");
        product[159] = new Product(musics.get(13), ProductState.RETURNED, importBills.get(53), saleBills.get(15), importBills.get(53).getPrice() / 3, 50000, "D2", "link3");
        product[160] = new Product(musics.get(13), ProductState.RETURNED, importBills.get(53), saleBills.get(0), importBills.get(53).getPrice() / 3, 50000, "B3", "link1");
        product[161] = new Product(musics.get(13), ProductState.READY, importBills.get(53), saleBills.get(3), importBills.get(53).getPrice() / 3, 30000, "D1", "link5");
        product[162] = new Product(musics.get(14), ProductState.IMPORTING, importBills.get(54), saleBills.get(6), importBills.get(54).getPrice() / 3, 50000, "C3", "link2");
        product[163] = new Product(musics.get(14), ProductState.RETURNED, importBills.get(54), saleBills.get(6), importBills.get(54).getPrice() / 3, 50000, "D2", "link3");
        product[164] = new Product(musics.get(14), ProductState.IMPORTING, importBills.get(54), saleBills.get(7), importBills.get(54).getPrice() / 3, 30000, "B3", "link1");
        product[165] = new Product(musics.get(15), ProductState.ORDERED, importBills.get(55), saleBills.get(5), importBills.get(55).getPrice() / 3, 30000, "B1", "link1");
        product[166] = new Product(musics.get(15), ProductState.READY, importBills.get(55), saleBills.get(7), importBills.get(55).getPrice() / 3, 50000, "A3", "link1");
        product[167] = new Product(musics.get(15), ProductState.READY, importBills.get(55), saleBills.get(0), importBills.get(55).getPrice() / 3, 50000, "B1", "link3");
        product[168] = new Product(musics.get(16), ProductState.READY, importBills.get(56), saleBills.get(7), importBills.get(56).getPrice() / 3, 30000, "A2", "link3");
        product[169] = new Product(musics.get(16), ProductState.RETURNED, importBills.get(56), saleBills.get(11), importBills.get(56).getPrice() / 3, 30000, "E1", "link3");
        product[170] = new Product(musics.get(16), ProductState.IMPORTING, importBills.get(56), saleBills.get(11), importBills.get(56).getPrice() / 3, 30000, "B1", "link5");
        product[171] = new Product(musics.get(17), ProductState.ORDERED, importBills.get(57), saleBills.get(12), importBills.get(57).getPrice() / 3, 50000, "B1", "link4");
        product[172] = new Product(musics.get(17), ProductState.ORDERED, importBills.get(57), saleBills.get(12), importBills.get(57).getPrice() / 3, 50000, "C3", "link5");
        product[173] = new Product(musics.get(17), ProductState.RETURNED, importBills.get(57), saleBills.get(15), importBills.get(57).getPrice() / 3, 30000, "C2", "link4");
        product[174] = new Product(musics.get(18), ProductState.ORDERED, importBills.get(58), saleBills.get(14), importBills.get(58).getPrice() / 3, 50000, "B1", "link3");
        product[175] = new Product(musics.get(18), ProductState.IMPORTING, importBills.get(58), saleBills.get(11), importBills.get(58).getPrice() / 3, 50000, "E1", "link5");
        product[176] = new Product(musics.get(18), ProductState.ORDERED, importBills.get(58), saleBills.get(4), importBills.get(58).getPrice() / 3, 30000, "D2", "link5");
        product[177] = new Product(musics.get(19), ProductState.ORDERED, importBills.get(59), saleBills.get(17), importBills.get(59).getPrice() / 3, 30000, "B2", "link4");
        product[178] = new Product(musics.get(19), ProductState.ORDERED, importBills.get(59), saleBills.get(10), importBills.get(59).getPrice() / 3, 30000, "C1", "link5");
        product[179] = new Product(musics.get(19), ProductState.RETURNED, importBills.get(59), saleBills.get(7), importBills.get(59).getPrice() / 3, 50000, "B1", "link3");

        for (var x : product){
            adapter.insertProduct(x);
        }



    }
    public void update() throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        var importBills = adapter.getAllImportBills();
        var saleBills = adapter.getAllSaleBills();
        var musics = adapter.getAllMusicInfos();
        var films = adapter.getAllFilmInfos();
        var books = adapter.getAllBookInfos();
        for(var x : adapter.getAllProducts()){
            System.out.println(x);
        }
        var m2 = adapter.getAllProducts().get(5);
        m2.setSaleBill(saleBills.get(4));
        m2.setImportCost(68);
        m2.setSaleValue(69);
        m2.setTrialFilename("jdsbnfn");
        m2.setPlacement("CC2");
        m2.setProductInfo(musics.get(0));
        m2.setState(ProductState.RETURNED);
        m2.setImportBill(importBills.get(4));
        adapter.updateProduct(m2);
        System.out.println("----------<><><><><>----------");
        for(var x : adapter.getAllProducts()){
            System.out.println(x);
        }
    }
    public void delete() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var x:adapter.getAllProducts()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
        var y = adapter.getAllProducts().get(5);
        adapter.deleteProduct(y);
        System.out.println("----------<><><><><>----------");
        for(var x:adapter.getAllProducts()){
            //Nếu như các ô đã triển khai override thuộc tính toString() cho
            // của ô rồi thì viết thế này
            System.out.println(x);
            //Còn nếu không các ô phải in từng thuộc tính 1 ra
        }
    }
}
