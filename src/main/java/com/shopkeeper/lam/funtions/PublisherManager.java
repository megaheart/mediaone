package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.Publisher;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Locale;

public class PublisherManager {
    private PublisherManager manager;

    public PublisherManager getManager() {
        return manager;
    }

    public ObservableList<Publisher> getAll() throws Exception {
        return DatabaseAdapter.getDbAdapter().getAllPublishers();
    }
    public void add(Publisher publisher) throws Exception {
        DatabaseAdapter.getDbAdapter().insertPublisher(publisher);
    }
    public void update(Publisher publisher) throws Exception{
        DatabaseAdapter.getDbAdapter().updatePublisher(publisher);
    }
    public Publisher findById(int id) throws Exception {
        for(Publisher publisher:DatabaseAdapter.getDbAdapter().getAllPublishers()){
            if(publisher.getPublisherId()==id){
                return publisher;
            }
        }
        return null;
    }
    public ArrayList<Publisher> findByName(String name) throws Exception {
        ArrayList<Publisher> publishers = new ArrayList<>();
        for(Publisher publisher:DatabaseAdapter.getDbAdapter().getAllPublishers()){
            if(publisher.getName().equals(name)){
                publishers.add(publisher);
            }
        }
        return publishers;
    }
    public ArrayList<Publisher> findAdvanceBy(String subName) throws Exception {
        ArrayList<Publisher> publishers=new ArrayList<>();
        for(Publisher publisher:DatabaseAdapter.getDbAdapter().getAllPublishers()){
            if(publisher.getName().toLowerCase().equals(subName.toLowerCase())){
                publishers.add(publisher);
            }
        }
        return publishers;
    }
}
