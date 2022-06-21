package com.shopkeeper.lam.funtions;
import com.shopkeeper.lam.database.PersonDbSet;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class PersonManager {
    private static PersonManager manager;

    public static PersonManager getManager() {
        return manager;
    }
    public ObservableList<Person> getAll() throws Exception {
        return DatabaseAdapter.getDbAdapter().getAllPeople();
    }
    public void add(Person person) throws Exception {
        DatabaseAdapter.getDbAdapter().insertPerson(person);
    }
    public void remove(Person person) throws Exception {
        DatabaseAdapter.getDbAdapter().deletePerson(person);
    }
    public void update(Person person) throws Exception {
        DatabaseAdapter.getDbAdapter().updatePerson(person);
    }
    public Person findById(int id) throws Exception {
        for (Person person : DatabaseAdapter.getDbAdapter().getAllPeople()){
            if(person.getPersonId()==id){
                return person;
            }
        }
        return null;
    }
    public ArrayList<Person> findByName(String name) throws Exception {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : DatabaseAdapter.getDbAdapter().getAllPeople()) {
            if (person.getName().equalsIgnoreCase(name.trim())) {
                people.add(person);
            }
        }
        return people;
    }
    public ArrayList<Person> findByJob(JobOfPerson job) throws Exception {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : DatabaseAdapter.getDbAdapter().getAllPeople()) {
            if (person.getJob().equals(job)) {
                people.add(person);
            }
        }
        return people;
    }
}
