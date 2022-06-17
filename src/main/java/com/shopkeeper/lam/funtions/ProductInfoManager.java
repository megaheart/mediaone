package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.BookInfo;
import com.shopkeeper.lam.models.FilmInfo;
import com.shopkeeper.lam.models.MusicInfo;
import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

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
}
