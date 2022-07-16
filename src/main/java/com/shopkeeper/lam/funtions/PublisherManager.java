package com.shopkeeper.lam.funtions;

import com.shopkeeper.lam.models.Publisher;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Locale;

public class PublisherManager {
    private PublisherManager manager;

    public PublisherManager getManager() {

        if (manager == null){
            manager = new PublisherManager();
        }
        return manager;
    }

    public ObservableList<Publisher> getAll() throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        return DatabaseAdapter.getDbAdapter().getAllPublishers();
    }
    public void add(Publisher publisher) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        adapter.insertPublisher(publisher);
    }
    public void update(Publisher publisher) throws Exception{
        var adapter = DatabaseAdapter.getDbAdapter();
        adapter.updatePublisher(publisher);
    }

    // find publisher by id
    public Publisher findById(int id) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        for(Publisher publisher:adapter.getAllPublishers()){
            if(publisher.getPublisherId()==id){
                return publisher;
            }
        }
        return null;
    }

    //find the publisher by name
    public ArrayList<Publisher> findByName(String name) throws Exception {
        ArrayList<Publisher> publishers = new ArrayList<>();
        var adapter = DatabaseAdapter.getDbAdapter();
        for(Publisher publisher:adapter.getAllPublishers()){
            if(publisher.getName().equalsIgnoreCase(name.trim())){
                publishers.add(publisher);
            }
        }
        return publishers;
    }

    //find the name of publisher by the subName,ignore the space at start and end
    public ArrayList<Publisher> findAdvanceBy(String subName) throws Exception {
        ArrayList<Publisher> publishers=new ArrayList<>();
        var adapter = DatabaseAdapter.getDbAdapter();
        for(Publisher publisher:adapter.getAllPublishers()){
            if(publisher.getName().toLowerCase().contains(subName.trim().toLowerCase())){
                publishers.add(publisher);
            }
        }
        return publishers;
    }
}
