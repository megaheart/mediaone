package com.shopkeeper.mediaone.database;

import com.shopkeeper.lam.database.DbWorker1;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.linh.database.DbWorker2;
import com.shopkeeper.linh.models.*;
import com.shopkeeper.minh.database.DbWorker3;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseAdapter {
    private static DatabaseAdapter _adapter;
    public static DatabaseAdapter getDbAdapter() throws Exception {
        if(_adapter == null){
            _adapter = new DatabaseAdapter();
            _adapter.load();
        }
        return _adapter;
    }
    private DbAdapterCache cache;
    private DbWorker1 worker1;
    private DbWorker2 worker2;
    private DbWorker3 worker3;
    private DatabaseAdapter() throws Exception {
        File dbFile = new File("mediaone.db");
        cache = new DbAdapterCache();
        if(dbFile.exists() && !dbFile.isDirectory()) {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mediaone.db");
            worker1 = new DbWorker1(conn/*, cache*/);
            worker2 = new DbWorker2(conn/*, cache*/);
            worker3 = new DbWorker3(conn/*, cache*/);
        }
        else{
            //Create new database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mediaone.db");
            worker1 = new DbWorker1(conn/*, cache*/);
            worker2 = new DbWorker2(conn/*, cache*/);
            worker3 = new DbWorker3(conn/*, cache*/);
            //initialize all tables
            worker1.initializeTables();
            worker2.initializeTables();
            worker3.initializeTables();

        }
    }
    private void load() throws Exception{
        worker1.load1(cache);
        worker2.load1(cache);
        worker3.load1(cache);

    }
    //Linh
    //region Staffs Database
    public ObservableList<Staff> getAllStaffs(){
        return FXCollections.unmodifiableObservableList(cache.getStaffs());
    }
    public boolean insertStaff(Staff staff){
        if(worker2.insertStaff(staff)){
            cache.getStaffs().add(staff);
            return true;
        }
        return false;
    }
    public boolean updateStaff(Staff staff) throws Exception{
        if(cache.getStaffs().contains(staff))
            return worker2.updateStaff(staff);
        throw new Exception("staff is not in DbAdapter's cache");
    }
    public boolean deleteStaff(Staff staff) throws Exception{
        if(staff.countTimesToBeReferenced() != 0)  {
            System.err.println("Something have referenced to this staff.");
            return false;
        }
        int index = cache.getStaffs().indexOf(staff);
        if(index > -1){
            if(worker2.deleteStaff(staff)){
                cache.getStaffs().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("staff is not in DbAdapter's cache");

    }
    //endregion
    //region Settings
    public Settings getSettings(){
        return cache.getSettings();
    }
    public boolean updateSettings(Settings settings) throws Exception{
        if(cache.getSettings() == settings){
            return worker2.updateSettings(settings);
        }
        throw new Exception("settings is not in DbAdapter's cache");
    }
    public boolean resetSettings(Settings settings) throws Exception{
        if(cache.getSettings() == settings){
            return worker2.resetSettings(settings);
        }
        throw new Exception("settings is not in DbAdapter's cache");

    }
    //endregion
    //region Customers
    public ObservableList<Customer> getAllCustomers(){
        return FXCollections.unmodifiableObservableList(cache.getCustomers());
    }
    public boolean insertCustomer(Customer customer){
        if(worker2.insertCustomer(customer)){
            cache.getCustomers().add(customer);
            return true;
        }
        return false;
    }
    public boolean updateCustomer(Customer customer) throws Exception{
        if(cache.getCustomers().contains(customer))
            return worker2.updateCustomer(customer);
        throw new Exception("customer is not in DbAdapter's cache");
    }
    public boolean deleteCustomer(Customer customer) throws Exception{
        if(customer.countTimesToBeReferenced() != 0) {
            System.err.println("Something have referenced to this customer.");
            return false;
        }
        int index = cache.getCustomers().indexOf(customer);
        if(index > -1){
            if(worker2.deleteCustomer(customer)){
                cache.getCustomers().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("customer is not in DbAdapter's cache");

    }
    //endregion
    //region TextValue
    //Return true if success, otherwise return false
    public boolean setTextValue(String key, String value) {
        return worker2.setTextValue(key, value);
    }
    public String getTextValue(String key) {
        return worker2.getTextValue(key);
    }
    //endregion
    //region SaleBill
    public ObservableList<SaleBill> getAllSaleBills(){
        return FXCollections.unmodifiableObservableList(cache.getSaleBills());
    }
    public boolean insertSaleBill(SaleBill bill) throws Exception{
        if(!cache.getCustomers().contains(bill.getCustomer())){
            throw new Exception("Customer which is output of bill.getCustomer() is not in DbAdapter's cache");
        }
        if(worker2.insertSaleBill(bill)){
            bill.getCustomer().increaseTimesToBeReferenced();
            cache.getSaleBills().add(bill);
            return true;
        }
        return false;
    }
    public boolean updateSaleBill(SaleBill bill) throws Exception{
        if(!cache.getCustomers().contains(bill.getCustomer())){
            throw new Exception("Customer which is output of bill.getCustomer() is not in DbAdapter's cache");
        }
        if(cache.getSaleBills().contains(bill)){
            bill.getCustomer().increaseTimesToBeReferenced();
            return worker2.updateSaleBill(bill, cache.getCustomers().toArray(new Customer[cache.getCustomers().size()]));
        }
        throw new Exception("bill:SaleBill is not in DbAdapter's cache");
    }
    public boolean deleteSaleBill(SaleBill bill) throws Exception{
        int index = cache.getSaleBills().indexOf(bill);
        if(index > -1){
            if(worker2.deleteSaleBill(bill)){
                bill.getCustomer().decreaseTimesToBeReferenced();
                cache.getSaleBills().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("bill:SaleBill is not in DbAdapter's cache");

    }
    public ArrayList<Product> getItems(SaleBill bill){
        ArrayList<Product> products = new ArrayList<>();
        cache.getProducts().forEach(product -> {
            if(product.getSaleBill() == bill) products.add(product);
        });
        return products;
    }
    //endregion
    //region Feedback

    //endregion
    //Lam
    //region Category
    public ObservableList<Category> getAllCategories(){
        return FXCollections.unmodifiableObservableList(cache.getCategories());
    }
    public boolean insertCategory(Category category){
        if(worker1.insertCategory(category)){
            cache.getCategories().add(category);
            return true;
        }
        return false;
    }
    public boolean updateCategory(Category category) throws Exception{
        if(cache.getCategories().contains(category))
            return worker1.updateCategory(category);
        throw new Exception("category is not in DbAdapter's cache");
    }
    public boolean deleteCategory(Category category) throws Exception{
        if(category.countTimesToBeReferenced() != 0)  {
            System.err.println("Something have referenced to this category.");
            return false;
        }
        int index = cache.getCategories().indexOf(category);
        if(index > -1){
            if(worker1.deleteCategory(category)){
                cache.getCategories().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("category is not in DbAdapter's cache");

    }
    //endregion
    //region Publisher
    public ObservableList<Publisher> getAllPublishers(){
        return FXCollections.unmodifiableObservableList(cache.getPublishers());
    }
    public boolean insertPublisher(Publisher publisher){
        if(worker1.insertPublisher(publisher)){
            cache.getPublishers().add(publisher);
            return true;
        }
        return false;
    }
    public boolean updatePublisher(Publisher publisher) throws Exception{
        if(cache.getPublishers().contains(publisher))
            return worker1.updatePublisher(publisher);
        throw new Exception("publisher is not in DbAdapter's cache");
    }
    public boolean deletePublisher(Publisher publisher) throws Exception{
        if(publisher.countTimesToBeReferenced() != 0)  {
            System.err.println("Something have referenced to this publisher.");
            return false;
        }
        int index = cache.getPublishers().indexOf(publisher);
        if(index > -1){
            if(worker1.deletePublisher(publisher)){
                cache.getPublishers().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("publisher is not in DbAdapter's cache");

    }
    //endregion
    //region Person
    public ObservableList<Person> getAllPeople(){
        return FXCollections.unmodifiableObservableList(cache.getPeople());
    }
    public boolean insertPerson(Person person){
        if(worker1.insertPerson(person)){
            cache.getPeople().add(person);
            return true;
        }
        return false;
    }
    public boolean updatePerson(Person person) throws Exception{
        if(cache.getPeople().contains(person))
            return worker1.updatePerson(person);
        throw new Exception("person is not in DbAdapter's cache");
    }
    public boolean deletePerson(Person person) throws Exception{
        if(person.countTimesToBeReferenced() != 0)  {
            System.err.println("Something have referenced to this person.");
            return false;
        }
        int index = cache.getPeople().indexOf(person);
        if(index > -1){
            if(worker1.deletePerson(person)){
                cache.getPeople().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("person is not in DbAdapter's cache");

    }
    //endregion
    //region ProductInfo

    //endregion
    //region Product

    //endregion
    //Minh
    //region Feedback


    //endregion
    //region Feedback

    //endregion
    //region Feedback

    //endregion
    //region ImportBill
    public ObservableList<ImportBill> getAllImportBills(){
        return FXCollections.unmodifiableObservableList(cache.getImportBills());
    }
    public boolean insertImportBill(ImportBill bill) throws Exception{
        if(worker3.insertImportBill(bill)){
            cache.getImportBills().add(bill);
            return true;
        }
        return false;
    }
    public boolean updateImportBill(ImportBill bill) throws Exception{
        if(cache.getImportBills().contains(bill)){
            return worker3.updateImportBill(bill);
        }
        throw new Exception("bill:ImportBill is not in DbAdapter's cache");
    }
    public boolean deleteImportBill(ImportBill bill) throws Exception{
        int index = cache.getImportBills().indexOf(bill);
        if(index > -1){
            if(worker3.deleteImportBill(bill)){
                cache.getImportBills().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("bill:ImportBill is not in DbAdapter's cache");

    }
    public ArrayList<Product> getItems(ImportBill bill){
        ArrayList<Product> products = new ArrayList<>();
        cache.getProducts().forEach(product -> {
            if(product.getImportBill() == bill) products.add(product);
        });
        return products;
    }
    //endregion
    //region OtherBill
    public ObservableList<OtherBill> getAllOtherBills(){
        return FXCollections.unmodifiableObservableList(cache.getOtherBills());
    }
    public boolean insertOtherBill(OtherBill bill){
        if(worker3.insertOtherBill(bill)){
            cache.getOtherBills().add(bill);
            return true;
        }
        return false;
    }
    public boolean updateOtherBill(OtherBill bill) throws Exception{
        if(cache.getOtherBills().contains(bill))
            return worker3.updateOtherBill(bill);
        throw new Exception("bill is not in DbAdapter's cache");
    }
    public boolean deleteOtherBill(OtherBill bill) throws Exception{
        int index = cache.getOtherBills().indexOf(bill);
        if(index > -1){
            if(worker3.deleteOtherBill(bill)){
                cache.getOtherBills().remove(index, index + 1);
                return true;
            }
            return false;
        }
        throw new Exception("bill is not in DbAdapter's cache");

    }
    //endregion
}
