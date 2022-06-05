package com.shopkeeper.mediaone.database;

import com.shopkeeper.lam.database.*;
import com.shopkeeper.lam.models.*;
import com.shopkeeper.linh.database.*;
import com.shopkeeper.linh.models.*;
import com.shopkeeper.minh.database.*;
import com.shopkeeper.minh.models.*;
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
    private ReadOnlyDbAdapterCache readOnlyCache;
    //Linh
    private StaffDbSet staffDbSet;
    private SettingsDbSet settingsDbSet;
    private CustomerDbSet customerDbSet;
    private TextValueDbSet textValueDbSet;
    private SaleBillDbSet saleBillDbSet;
    private FeedbackDbSet feedbackDbSet;
    //minh
    private ImportBillDbSet importBillDbSet;
    private OtherBillDbSet otherBillDbSet;
    private AttendanceDbSet attendanceDbSet;
    private ShiftDbSet shiftDbSet;
    private  StaffBillDbSet staffBillDbSet;
    //lam
    private PersonDbSet personDbSet;
    private CategoryDbSet categoryDbSet;
    private PublisherDbSet publisherDbSet;
    private BookInfoDbSet bookInfoDbSet;
    private FilmInfoDbSet filmInfoDbSet;
    private MusicInfoDbSet musicInfoDbSet;
    private ProductDbSet productDbSet;
    private DatabaseAdapter() throws Exception {
        File dbFile = new File("mediaone.db");
        cache = new DbAdapterCache();
        readOnlyCache = new ReadOnlyDbAdapterCache(cache);
        if(dbFile.exists() && !dbFile.isDirectory()) {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mediaone.db");
            //Lam
            personDbSet = new PersonDbSet(conn, readOnlyCache, cache.getPeople());
            categoryDbSet = new CategoryDbSet(conn, readOnlyCache, cache.getCategories());
            publisherDbSet = new PublisherDbSet(conn, readOnlyCache, cache.getPublishers());
            bookInfoDbSet = new BookInfoDbSet(conn, readOnlyCache, cache.getBookInfos());
            filmInfoDbSet = new FilmInfoDbSet(conn, readOnlyCache, cache.getFilmInfos());
            musicInfoDbSet = new MusicInfoDbSet(conn, readOnlyCache, cache.getMusicInfos());
            productDbSet = new ProductDbSet(conn, readOnlyCache, cache.getProducts());
            //Linh
            staffDbSet = new StaffDbSet(conn, readOnlyCache, cache.getStaffs());
            settingsDbSet = new SettingsDbSet(conn, readOnlyCache, cache.getSettings());
            customerDbSet = new CustomerDbSet(conn, readOnlyCache, cache.getCustomers());
            textValueDbSet = new TextValueDbSet(conn);
            saleBillDbSet = new SaleBillDbSet(conn, readOnlyCache, cache.getSaleBills());
            feedbackDbSet = new FeedbackDbSet(conn, readOnlyCache, cache.getFeedbacks());

            //Minh
            importBillDbSet = new ImportBillDbSet(conn, readOnlyCache, cache.getImportBills());
            otherBillDbSet = new OtherBillDbSet(conn, readOnlyCache, cache.getOtherBills());
            attendanceDbSet = new AttendanceDbSet(conn, readOnlyCache, cache.getAttendances());
            shiftDbSet = new ShiftDbSet(conn, readOnlyCache, cache.getShifts());
            staffBillDbSet = new StaffBillDbSet(conn, readOnlyCache, cache.getStaffBills());
        }
        else{
            //Create new database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:mediaone.db");
            //Lam
            personDbSet = new PersonDbSet(conn, readOnlyCache, cache.getPeople());
            categoryDbSet = new CategoryDbSet(conn, readOnlyCache, cache.getCategories());
            publisherDbSet = new PublisherDbSet(conn, readOnlyCache, cache.getPublishers());
            bookInfoDbSet = new BookInfoDbSet(conn, readOnlyCache, cache.getBookInfos());
            filmInfoDbSet = new FilmInfoDbSet(conn, readOnlyCache, cache.getFilmInfos());
            musicInfoDbSet = new MusicInfoDbSet(conn, readOnlyCache, cache.getMusicInfos());
            productDbSet = new ProductDbSet(conn, readOnlyCache, cache.getProducts());
            //Linh
            staffDbSet = new StaffDbSet(conn, readOnlyCache, cache.getStaffs());
            settingsDbSet = new SettingsDbSet(conn, readOnlyCache, cache.getSettings());
            customerDbSet = new CustomerDbSet(conn, readOnlyCache, cache.getCustomers());
            textValueDbSet = new TextValueDbSet(conn);
            saleBillDbSet = new SaleBillDbSet(conn, readOnlyCache, cache.getSaleBills());
            feedbackDbSet = new FeedbackDbSet(conn, readOnlyCache, cache.getFeedbacks());

            //Minh
            importBillDbSet = new ImportBillDbSet(conn, readOnlyCache, cache.getImportBills());
            otherBillDbSet = new OtherBillDbSet(conn, readOnlyCache, cache.getOtherBills());
            attendanceDbSet = new AttendanceDbSet(conn, readOnlyCache, cache.getAttendances());
            shiftDbSet = new ShiftDbSet(conn, readOnlyCache, cache.getShifts());
            staffBillDbSet = new StaffBillDbSet(conn, readOnlyCache, cache.getStaffBills());

            //initialize all tables
            //Lam
            if (!categoryDbSet.createTable()) throw new Exception("DatabaseWorker1 created Category tables false");
            if (!personDbSet.createTable()) throw new Exception("DatabaseWorker1 created People tables false");
            if(!productDbSet.createTable()) throw new Exception("DatabaseWorker1 created Products tables false");
            if(!publisherDbSet.createTable()) throw new Exception("DatabaseWorker1 created Publishers tables false");
            if(!musicInfoDbSet.createTable()) throw new Exception("DatabaseWorker1 created MusicInfos tables false");
            if(!filmInfoDbSet.createTable()) throw new Exception("DatabaseWorker1 created FilmInfos tables false");
            if(!bookInfoDbSet.createTable()) throw new Exception("DatabaseWorker1 created BookInfos tables false");
            //Linh
            if(!staffDbSet.createTable()) throw new Exception("DatabaseWorker2 created Staffs tables false");
            if(!settingsDbSet.createTable()) throw new Exception("DatabaseWorker2 created Settings tables false");
            if(!customerDbSet.createTable()) throw new Exception("DatabaseWorker2 created Customers tables false");
            if(!textValueDbSet.createTable()) throw new Exception("DatabaseWorker2 created TextValues tables false");
            if(!saleBillDbSet.createTable()) throw new Exception("DatabaseWorker2 created SaleBills tables false");
            if(!feedbackDbSet.createTable()) throw new Exception("DatabaseWorker2 created Feedbacks tables false");
            //Minh
            if(!otherBillDbSet.createTable()) throw new Exception("DatabaseWorker3 created OtherBills tables false");
            if(!importBillDbSet.createTable()) throw new Exception("DatabaseWorker3 created ImportBills tables false");
            if(!staffBillDbSet.createTable()) throw new Exception("DatabaseWorker3 created StaffBills tables false");
            if (!attendanceDbSet.createTable()) throw new Exception("DatabaseWorker3 created Attendances tables false");
            if (!shiftDbSet.createTable()) throw new Exception("DatabaseWorker3 created Shifts tables false");

        }
    }
    private void load() throws Exception{
        //Load 1
        staffDbSet.load();
        settingsDbSet.load();
        customerDbSet.load();

        //Load 2
        saleBillDbSet.load();
        //Load 3

        //Load 4


    }
    //-------------------Linh-------------------
    //region Staffs Database
    public ObservableList<Staff> getAllStaffs(){
        return readOnlyCache.getStaffs();
    }
    public boolean insertStaff(Staff staff){
        return staffDbSet.insert(staff);
    }
    public boolean updateStaff(Staff staff){
        return staffDbSet.update(staff);
    }
    public boolean deleteStaff(Staff staff){
        return staffDbSet.delete(staff);
    }
    //endregion
    //region Settings
    public Settings getSettings(){
        return readOnlyCache.getSettings();
    }
    public boolean updateSettings(Settings settings){
        return settingsDbSet.update(settings);
    }
    public boolean resetSettings(Settings settings){
        return settingsDbSet.reset(settings);

    }
    //endregion
    //region Customers
    public ObservableList<Customer> getAllCustomers(){
        return readOnlyCache.getCustomers();
    }
    public boolean insertCustomer(Customer customer){
        return customerDbSet.insert(customer);
    }
    public boolean updateCustomer(Customer customer){
        return  customerDbSet.update(customer);
    }
    public boolean deleteCustomer(Customer customer){
        return  customerDbSet.deleteCustomer(customer);
    }
    //endregion
    //region TextValue
    //Return true if success, otherwise return false
    public boolean setTextValue(String key, String value) {
        return textValueDbSet.set(key, value);
    }
    public String getTextValue(String key) {
        return textValueDbSet.get(key);
    }
    //endregion
    //region SaleBill
    public ObservableList<SaleBill> getAllSaleBills(){
        return readOnlyCache.getSaleBills();
    }
    public boolean insertSaleBill(SaleBill bill) throws Exception{
        return saleBillDbSet.insert(bill);
    }
    public boolean updateSaleBill(SaleBill bill) throws Exception{
        return saleBillDbSet.update(bill);
    }
    public boolean deleteSaleBill(SaleBill bill) throws Exception{
        return saleBillDbSet.delete(bill);
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
    //-------------------Lam-------------------
    //region Category
//    public ObservableList<Category> getAllCategories(){
//        return FXCollections.unmodifiableObservableList(cache.getCategories());
//    }
//    public boolean insertCategory(Category category){
//        if(worker1.insertCategory(category)){
//            cache.getCategories().add(category);
//            return true;
//        }
//        return false;
//    }
//    public boolean updateCategory(Category category) throws Exception{
//        if(cache.getCategories().contains(category))
//            return worker1.updateCategory(category);
//        throw new Exception("category is not in DbAdapter's cache");
//    }
//    public boolean deleteCategory(Category category) throws Exception{
//        if(category.countTimesToBeReferenced() != 0)  {
//            System.err.println("Something have referenced to this category.");
//            return false;
//        }
//        int index = cache.getCategories().indexOf(category);
//        if(index > -1){
//            if(worker1.deleteCategory(category)){
//                cache.getCategories().remove(index, index + 1);
//                return true;
//            }
//            return false;
//        }
//        throw new Exception("category is not in DbAdapter's cache");
//
//    }
    //endregion
    //region Publisher
//    public ObservableList<Publisher> getAllPublishers(){
//        return FXCollections.unmodifiableObservableList(cache.getPublishers());
//    }
//    public boolean insertPublisher(Publisher publisher){
//        if(worker1.insertPublisher(publisher)){
//            cache.getPublishers().add(publisher);
//            return true;
//        }
//        return false;
//    }
//    public boolean updatePublisher(Publisher publisher) throws Exception{
//        if(cache.getPublishers().contains(publisher))
//            return worker1.updatePublisher(publisher);
//        throw new Exception("publisher is not in DbAdapter's cache");
//    }
//    public boolean deletePublisher(Publisher publisher) throws Exception{
//        if(publisher.countTimesToBeReferenced() != 0)  {
//            System.err.println("Something have referenced to this publisher.");
//            return false;
//        }
//        int index = cache.getPublishers().indexOf(publisher);
//        if(index > -1){
//            if(worker1.deletePublisher(publisher)){
//                cache.getPublishers().remove(index, index + 1);
//                return true;
//            }
//            return false;
//        }
//        throw new Exception("publisher is not in DbAdapter's cache");
//
//    }
    //endregion
    //region Person
//    public ObservableList<Person> getAllPeople(){
//        return FXCollections.unmodifiableObservableList(cache.getPeople());
//    }
//    public boolean insertPerson(Person person){
//        if(worker1.insertPerson(person)){
//            cache.getPeople().add(person);
//            return true;
//        }
//        return false;
//    }
//    public boolean updatePerson(Person person) throws Exception{
//        if(cache.getPeople().contains(person))
//            return worker1.updatePerson(person);
//        throw new Exception("person is not in DbAdapter's cache");
//    }
//    public boolean deletePerson(Person person) throws Exception{
//        if(person.countTimesToBeReferenced() != 0)  {
//            System.err.println("Something have referenced to this person.");
//            return false;
//        }
//        int index = cache.getPeople().indexOf(person);
//        if(index > -1){
//            if(worker1.deletePerson(person)){
//                cache.getPeople().remove(index, index + 1);
//                return true;
//            }
//            return false;
//        }
//        throw new Exception("person is not in DbAdapter's cache");
//
//    }
    //endregion
    //region ProductInfo

    //endregion
    //region Product

    //endregion
    //-------------------Minh-------------------
    //region Feedback


    //endregion
    //region Feedback

    //endregion
    //region Feedback

    //endregion
    //region ImportBill
//    public ObservableList<ImportBill> getAllImportBills(){
//        return FXCollections.unmodifiableObservableList(cache.getImportBills());
//    }
//    public boolean insertImportBill(ImportBill bill) throws Exception{
//        if(worker3.insertImportBill(bill)){
//            cache.getImportBills().add(bill);
//            return true;
//        }
//        return false;
//    }
//    public boolean updateImportBill(ImportBill bill) throws Exception{
//        if(cache.getImportBills().contains(bill)){
//            return worker3.updateImportBill(bill);
//        }
//        throw new Exception("bill:ImportBill is not in DbAdapter's cache");
//    }
//    public boolean deleteImportBill(ImportBill bill) throws Exception{
//        int index = cache.getImportBills().indexOf(bill);
//        if(index > -1){
//            if(worker3.deleteImportBill(bill)){
//                cache.getImportBills().remove(index, index + 1);
//                return true;
//            }
//            return false;
//        }
//        throw new Exception("bill:ImportBill is not in DbAdapter's cache");
//
//    }
//    public ArrayList<Product> getItems(ImportBill bill){
//        ArrayList<Product> products = new ArrayList<>();
//        cache.getProducts().forEach(product -> {
//            if(product.getImportBill() == bill) products.add(product);
//        });
//        return products;
//    }
//    //endregion
//    //region OtherBill
//    public ObservableList<OtherBill> getAllOtherBills(){
//        return FXCollections.unmodifiableObservableList(cache.getOtherBills());
//    }
//    public boolean insertOtherBill(OtherBill bill){
//        if(worker3.insertOtherBill(bill)){
//            cache.getOtherBills().add(bill);
//            return true;
//        }
//        return false;
//    }
//    public boolean updateOtherBill(OtherBill bill) throws Exception{
//        if(cache.getOtherBills().contains(bill))
//            return worker3.updateOtherBill(bill);
//        throw new Exception("bill is not in DbAdapter's cache");
//    }
//    public boolean deleteOtherBill(OtherBill bill) throws Exception{
//        int index = cache.getOtherBills().indexOf(bill);
//        if(index > -1){
//            if(worker3.deleteOtherBill(bill)){
//                cache.getOtherBills().remove(index, index + 1);
//                return true;
//            }
//            return false;
//        }
//        throw new Exception("bill is not in DbAdapter's cache");
//
//    }
    //endregion
}
