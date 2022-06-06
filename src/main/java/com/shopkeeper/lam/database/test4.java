package com.shopkeeper.lam.database;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;

//MUSICINFO
public class test4 {
    public void insertMusicInfo() throws Exception {
    MusicInfo EDM = new MusicInfo();
    MusicInfo POP = new MusicInfo();
    var adapter = DatabaseAdapter.getDbAdapter();
        for(var x : adapter.getAllCategories()){
        System.out.println(x);
    }
        adapter.insertMusicInfo(EDM);
        adapter.insertMusicInfo(POP);
        System.out.println("----------<><><><><>----------");
        for(var x :adapter.getAllCategories()){
        System.out.println(x);}
    }
}

