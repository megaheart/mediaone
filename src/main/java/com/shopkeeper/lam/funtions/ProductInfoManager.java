package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductInfoManager {
    private ProductInfoManager manager;
    public ProductInfoManager getManager() {
        if (manager == null){
            manager = new ProductInfoManager();
        }
        return manager;
    }
    public ObservableList<MusicInfo> getAllMusicInfo() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        return adapter.getAllMusicInfos();
    }
    public ObservableList<FilmInfo> getAllFilmInfo() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        return adapter.getAllFilmInfos();
    }
    public ObservableList<BookInfo> getAllBookInfo() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        return adapter.getAllBookInfos();
    }
    public void add(ProductInfo productInfo) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        if (productInfo instanceof MusicInfo) {
            adapter.insertMusicInfo((MusicInfo) productInfo);
        }
        if (productInfo instanceof FilmInfo) {
            adapter.insertFilmInfo((FilmInfo) productInfo);
        }
        if (productInfo instanceof BookInfo) {
            adapter.insertBookInfo((BookInfo) productInfo);
        }
    }
    public void remove(ProductInfo productInfo) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        if (productInfo instanceof MusicInfo) {
            adapter.deleteMusicInfo((MusicInfo) productInfo);
        }
        if (productInfo instanceof FilmInfo) {
            adapter.deleteFilmInfo((FilmInfo) productInfo);
        }
        if (productInfo instanceof BookInfo) {
            adapter.deleteBookInfo((BookInfo) productInfo);
        }
    }
    public void update(ProductInfo productInfo) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        if (productInfo instanceof MusicInfo) {
            adapter.updateMusicInfo((MusicInfo) productInfo);
        }
        if (productInfo instanceof FilmInfo) {
            adapter.updateFilmInfo((FilmInfo) productInfo);
        }
        if (productInfo instanceof BookInfo) {
            adapter.updateBookInfo((BookInfo) productInfo);
        }
    }
    public ArrayList<ProductInfo> findByTitle(String title) throws Exception {
        ArrayList<ProductInfo> productInfos = new ArrayList<>();
        var adapter = DatabaseAdapter.getDbAdapter();
        for(ProductInfo productInfo : adapter.getAllMusicInfos()){
            if(productInfo.getTitle().equalsIgnoreCase(title.trim())){
                productInfos.add(productInfo);
            }
        }
        for(ProductInfo productInfo : adapter.getAllFilmInfos()){
            if(productInfo.getTitle().equalsIgnoreCase(title.trim())){
                productInfos.add(productInfo);
            }
        }
        for(ProductInfo productInfo : adapter.getAllBookInfos()){
            if(productInfo.getTitle().equalsIgnoreCase(title.trim())){
                productInfos.add(productInfo);
            }
        }
        return productInfos;
    }
}
