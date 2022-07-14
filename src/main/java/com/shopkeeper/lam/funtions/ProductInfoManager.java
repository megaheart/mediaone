package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ProductInfoManager {
    private static ProductInfoManager manager;
    private ObservableList<BookInfo> listBookInfo = DatabaseAdapter.getDbAdapter().getAllBookInfos();
    private ObservableList<MusicInfo> listMusicInfo = DatabaseAdapter.getDbAdapter().getAllMusicInfos();
    private ObservableList<FilmInfo> listFilmInfo = DatabaseAdapter.getDbAdapter().getAllFilmInfos();



   /* public void addMusicInfo(MusicInfo musicInfo) {
        listMusicInfo.add(musicInfo);
    }
    public void addBookInfo(BookInfo bookInfo) {
        listBookInfo.add(bookInfo);
    }
    public void addFilmInfo(FilmInfo filmInfo) {
        listFilmInfo.add(filmInfo);
    }*/
    public void setListBookInfo(ObservableList<BookInfo> listBookInfo) {
        this.listBookInfo = listBookInfo;
    }

    public void setListMusicInfo(ObservableList<MusicInfo> listMusicInfo) {
        this.listMusicInfo = listMusicInfo;
    }

    public void setListFilmInfo(ObservableList<FilmInfo> listFilmInfo) {
        this.listFilmInfo = listFilmInfo;
    }

    public ObservableList<BookInfo> getListBookInfo() {
        return listBookInfo;
    }
    public ObservableList<MusicInfo> getListMusicInfo() {
        return listMusicInfo;
    }

    public ObservableList<FilmInfo> getListFilmInfo() {
        return listFilmInfo;
    }

    public static ProductInfoManager getManager() {
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
    public  void update(ProductInfo productInfo) throws Exception {
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

    public MusicInfo findMusicInfoById(int id){
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var musicInfo : adapter.getAllMusicInfos()){
            if(musicInfo.getProductInfoId() == id){
                return musicInfo;
            }
        }
        return null;
    }
    public FilmInfo findFilmInfoById(int id){
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var filmInfo : adapter.getAllFilmInfos()){
            if(filmInfo.getProductInfoId() == id){
                return filmInfo;
            }
        }
        return null;
    }
    public BookInfo findBookInfoById(int id){
        var adapter = DatabaseAdapter.getDbAdapter();
        for(var bookInfo : adapter.getAllBookInfos()){
            if(bookInfo.getProductInfoId() == id){
                return bookInfo;
            }
        }
        return null;
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
