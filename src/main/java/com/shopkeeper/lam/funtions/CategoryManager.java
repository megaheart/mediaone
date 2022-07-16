package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryManager {
    private CategoryManager manager;

    public CategoryManager getManager() {
        if (manager == null){
            manager = new CategoryManager();
        }
        return manager;
    }

    public ObservableList<Category> getAll() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        return DatabaseAdapter.getDbAdapter().getAllCategories();
    }
    public void add(Category category) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        adapter.insertCategory(category);
    }
    public void update(Category category) throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        adapter.updateCategory(category);
    }
    public Category findById(int id) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(Category category:adapter.getAllCategories()){
            if(category.getCategoryId()==id){
                return category;
            }
        }
        return null;
    }

    //return the list of category by the name,ignore the space at start and end
    public ArrayList<Category> findByName(String name) throws Exception {
        ArrayList<Category> categories = new ArrayList<>();
        var adapter = DatabaseAdapter.getDbAdapter();
        for(Category category:adapter.getAllCategories()){
            if(category.getName().equalsIgnoreCase(name.trim())){
                categories.add(category);
            }
        }
        return categories;
    }

    //return the list of categories by the subName,ignore the space at start and end
    public ArrayList<Category> findAdvanceBy(String subName) throws Exception {
        ArrayList<Category> categories=new ArrayList<>();
        var adapter = DatabaseAdapter.getDbAdapter();
        for(Category category:adapter.getAllCategories()){
            if(category.getName().toLowerCase().contains(subName.trim().toLowerCase())){
                categories.add(category);
            }
        }
        return categories;
    }
}
