package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductInfoManager {
    private ProductInfoManager manager;
    public ProductInfoManager getManager() {
        return manager;
    }
    public ObservableList<MusicInfo> getAllMusicInfo() throws Exception {
        return DatabaseAdapter.getDbAdapter().getAllMusicInfos();
    }
    public ObservableList<FilmInfo> getAllFilmInfo() throws Exception {
        return DatabaseAdapter.getDbAdapter().getAllFilmInfos();
    }
    public ObservableList<BookInfo> getAllBookInfo() throws Exception {
        return DatabaseAdapter.getDbAdapter().getAllBookInfos();
    }
    public void add(ProductInfo productInfo) throws Exception {
        if (productInfo instanceof MusicInfo) {
            DatabaseAdapter.getDbAdapter().insertMusicInfo((MusicInfo) productInfo);
        }
        if (productInfo instanceof FilmInfo) {
            DatabaseAdapter.getDbAdapter().insertFilmInfo((FilmInfo) productInfo);
        }
        if (productInfo instanceof BookInfo) {
            DatabaseAdapter.getDbAdapter().insertBookInfo((BookInfo) productInfo);
        }
    }
    public void remove(ProductInfo productInfo) throws Exception {
        if (productInfo instanceof MusicInfo) {
            DatabaseAdapter.getDbAdapter().deleteMusicInfo((MusicInfo) productInfo);
        }
        if (productInfo instanceof FilmInfo) {
            DatabaseAdapter.getDbAdapter().deleteFilmInfo((FilmInfo) productInfo);
        }
        if (productInfo instanceof BookInfo) {
            DatabaseAdapter.getDbAdapter().deleteBookInfo((BookInfo) productInfo);
        }
    }
    public void update(ProductInfo productInfo) throws Exception {
        if (productInfo instanceof MusicInfo) {
            DatabaseAdapter.getDbAdapter().updateMusicInfo((MusicInfo) productInfo);
        }
        if (productInfo instanceof FilmInfo) {
            DatabaseAdapter.getDbAdapter().updateFilmInfo((FilmInfo) productInfo);
        }
        if (productInfo instanceof BookInfo) {
            DatabaseAdapter.getDbAdapter().updateBookInfo((BookInfo) productInfo);
        }
    }
    public ArrayList<ProductInfo> findByTitle(String title) throws Exception {
        ArrayList<ProductInfo> productInfos = new ArrayList<>();
        for(ProductInfo productInfo : DatabaseAdapter.getDbAdapter().getAllMusicInfos()){
            if(productInfo.getTitle().equalsIgnoreCase(title.trim())){
                productInfos.add(productInfo);
            }
        }
        for(ProductInfo productInfo : DatabaseAdapter.getDbAdapter().getAllFilmInfos()){
            if(productInfo.getTitle().equalsIgnoreCase(title.trim())){
                productInfos.add(productInfo);
            }
        }
        for(ProductInfo productInfo : DatabaseAdapter.getDbAdapter().getAllBookInfos()){
            if(productInfo.getTitle().equalsIgnoreCase(title.trim())){
                productInfos.add(productInfo);
            }
        }
        return productInfos;
    }
}
