package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.Category;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryManager {
    private CategoryManager manager;

    public CategoryManager getManager() {
        return manager;
    }

    public ObservableList<Category> getAll() throws Exception {
        return DatabaseAdapter.getDbAdapter().getAllCategories();
    }
    public void add(Category category) throws Exception {
        DatabaseAdapter.getDbAdapter().insertCategory(category);
    }
    public void update(Category category) throws Exception{
        DatabaseAdapter.getDbAdapter().updateCategory(category);
    }
    public Category findById(int id) throws Exception {
        for(Category category:DatabaseAdapter.getDbAdapter().getAllCategories()){
            if(category.getCategoryId()==id){
                return category;
            }
        }
        return null;
    }

    //return the list of category by the name,ignore the space at start and end
    public ArrayList<Category> findByName(String name) throws Exception {
        ArrayList<Category> categories = new ArrayList<>();
        for(Category category:DatabaseAdapter.getDbAdapter().getAllCategories()){
            if(category.getName().equalsIgnoreCase(name.trim())){
                categories.add(category);
            }
        }
        return categories;
    }

    //return the list of categories by the subName,ignore the space at start and end
    public ArrayList<Category> findAdvanceBy(String subName) throws Exception {
        ArrayList<Category> categories=new ArrayList<>();
        for(Category category:DatabaseAdapter.getDbAdapter().getAllCategories()){
            if(category.getName().toLowerCase().contains(subName.trim().toLowerCase())){
                categories.add(category);
            }
        }
        return categories;
    }
}
