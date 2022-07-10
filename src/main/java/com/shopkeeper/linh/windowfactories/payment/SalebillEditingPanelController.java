package com.shopkeeper.linh.windowfactories.payment;

import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.windowfactories.utilities.CustomerToStringCell;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;

public class SalebillEditingPanelController {
    public static SalebillEditingPanelController getController(){
        FXMLLoader fxmlLoader = new FXMLLoader(SalebillEditingPanelController.class.getResource("salebill-editing-panel.fxml"));

        Parent template;
        try
        {
            template = fxmlLoader.load();
            return fxmlLoader.getController();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public SalebillEditingPanelController(){
        this.saleBillItems = FXCollections.observableArrayList();
    }
    public AnchorPane getContainer(){
        return container;
    }
    @FXML
    private AnchorPane container;
    @FXML
    private RadioButton chooseOldCustomerBtn;
    @FXML
    private RadioButton chooseNewCustomerBtn;
    @FXML
    private TextField titleTxt;
    @FXML
    private ComboBox<Customer> customerCombobox;
    @FXML
    private TextField customerNameTxt;
    @FXML
    private TextField locationTxt;
    @FXML
    private TextField phoneNumberTxt;
    @FXML
    private TextArea noteTxt;
    @FXML
    private Text totalPriceTxt;
    private SaleBill saleBill = null;
    private ObservableList<SaleBillItem> saleBillItems;
    private ObservableList<SaleBillItem> saleBillItemsDataContext;
    public void openPanel(SaleBill saleBill, ObservableList<SaleBillItem> saleBillItems){
        this.saleBillItemsDataContext = saleBillItems;
        this.saleBill = saleBill;
        resetPanel();
        container.setVisible(true);
    }
    @FXML
    private void closePanel(){
        container.setVisible(false);
    }
    @FXML
    private void resetPanel(){
        if(saleBill == null){
            titleTxt.setText("");
            customerNameTxt.setText("");
            locationTxt.setText("");
            noteTxt.setText("");
            phoneNumberTxt.setText("");
            customerCombobox.getSelectionModel().clearSelection();
            chooseOldCustomerBtn.setSelected(false);
            chooseNewCustomerBtn.setSelected(false);
        }
        else{
            titleTxt.setText(saleBill.getName());
            customerNameTxt.setText("");
            locationTxt.setText(saleBill.getLocation());
            noteTxt.setText(saleBill.getNote());
            customerCombobox.setValue(saleBill.getCustomer());
            chooseOldCustomerBtn.setSelected(true);
            chooseNewCustomerBtn.setSelected(false);
            phoneNumberTxt.setText(saleBill.getCustomer().getPhoneNumber());
        }
        saleBillItems.clear();
        if(saleBillItemsDataContext != null){
            for(var x : saleBillItemsDataContext){
                saleBillItems.add(x.clone());
            }
        }
    }
    @FXML
    private void saveChange(){
        StringBuilder errorsStringBuilder = new StringBuilder();

        Customer customer = null;
        if(chooseOldCustomerBtn.isSelected()){
            customer = customerCombobox.getValue();
            if(customer == null){
                errorsStringBuilder.append("- Chưa chọn khách hàng\n");
            }
        }
        else {
            String customerName = customerNameTxt.getText() == null? "" : customerNameTxt.getText().trim();
            if(customerName.length() == 0){
                errorsStringBuilder.append("- Không được bỏ trống tên khách hàng\n");
            }
        }
        try{
            String s = phoneNumberTxt.getText().trim();
            if(s.length() == 0) throw new NullPointerException();
            if(s.length() < 10 || s.length() > 12) throw new NumberFormatException();
            if(s.charAt(0) != '0' && s.charAt(0) != '8' && s.charAt(1) != '4'
                    && s.charAt(0) != '+' && s.charAt(1) != '8' && s.charAt(2) != '4') throw new NumberFormatException();
            long l = Long.parseLong(s);
        }
        catch (NumberFormatException e){
            errorsStringBuilder.append("- Số điện thoại không hợp lệ.\n");
        }
        catch (NullPointerException e){
            errorsStringBuilder.append("- Không được bỏ trống số điện thoại.\n");
        }
        String location = locationTxt.getText() == null ? "" : locationTxt.getText().trim();
        if(location.length() == 0){
            errorsStringBuilder.append("- Không được bỏ trống địa chỉ.\n");
        }
        if(this.saleBill == null){
            
            if(errorsStringBuilder.length() == 0){
                var adapter = DatabaseAdapter.getDbAdapter();
                SaleBill newSaleBill = new SaleBill();
                newSaleBill.setName(titleTxt.getText().trim());
                newSaleBill.setLocation(location);
                newSaleBill.setNote(noteTxt.getText().trim());
                newSaleBill.setTime(LocalDate.now());
                if(chooseOldCustomerBtn.isSelected()){
                    String pn = phoneNumberTxt.getText().trim();
                    newSaleBill.setCustomer(customer);
                    if(!customer.getPhoneNumber().equals(pn) || !location.equals(customer.getDefaultLocation())){
                        customer.setDefaultLocation(location);
                        customer.setPhoneNumber(pn);
                        adapter.updateCustomer(customer);
                    }
                }
                else {
                    customer = new Customer(customerNameTxt.getText().trim(), location, phoneNumberTxt.getText().trim());
                    adapter.insertCustomer(customer);
                }
                newSaleBill.setCustomer(customer);
                //salebill.price??????

                adapter.insertSaleBill(newSaleBill);
            }
        }
        else {
            var adapter = DatabaseAdapter.getDbAdapter();
            SaleBill newSaleBill = saleBill;
            newSaleBill.setName(titleTxt.getText().trim());
            newSaleBill.setLocation(location);
            newSaleBill.setNote(noteTxt.getText().trim());
            newSaleBill.setTime(LocalDate.now());
            if(chooseOldCustomerBtn.isSelected()){
                String pn = phoneNumberTxt.getText().trim();
                newSaleBill.setCustomer(customer);
                if(!customer.getPhoneNumber().equals(pn) || !location.equals(customer.getDefaultLocation())){
                    customer.setDefaultLocation(location);
                    customer.setPhoneNumber(pn);
                    adapter.updateCustomer(customer);
                }
            }
            else {
                customer = new Customer(customerNameTxt.getText().trim(), location, phoneNumberTxt.getText().trim());
                adapter.insertCustomer(customer);
            }
            newSaleBill.setCustomer(customer);
            //salebill.price??????

            adapter.updateSaleBill(newSaleBill);
        }
        if(errorsStringBuilder.length() == 0){
            closePanel();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Hoá đơn không hợp lệ");
            alert.setHeaderText("Hoá đơn không hợp lệ do vi phạm những điều sau:");
            alert.setContentText(errorsStringBuilder.toString());
            alert.showAndWait();
        }
    }
    @FXML
    private ComboBox<ProductInfo> productInfoComboBox;
    @FXML
    private TextField amountTxtBox;
    @FXML
    private Text maxAmountTxtBox;
    @FXML
    private void addSaleBillItem(){
        int amount;
        try {
            amount = Integer.parseInt(amountTxtBox.getText());
        }catch (NumberFormatException e){
            amount = 0;
        }
        if(amount < 1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Số lượng không hợp lệ");
            alert.setHeaderText("Số lượng không hợp lệ");
            alert.setContentText("Số lượng phải là một số nguyên dương (>=0)");
            alert.showAndWait();
        }
    }
    @FXML
    private ListView<SaleBillItem> saleBillItemListView;
    private final SaleBillItemRemoveListener listener = new SaleBillItemRemoveListener() {
        @Override
        public void remove(SaleBillItem item) {
            saleBillItems.remove(item);
        }
    };
    public void initialize()
    {
        customerCombobox.disableProperty().bind(chooseOldCustomerBtn.selectedProperty().not());
        customerNameTxt.disableProperty().bind(chooseNewCustomerBtn.selectedProperty().not());
        customerCombobox.setButtonCell(new CustomerToStringCell());
        customerCombobox.setCellFactory(new Callback<ListView<Customer>, ListCell<Customer>>() {
            @Override
            public ListCell<Customer> call(ListView<Customer> param) {
                return new CustomerToStringCell();
            }
        });
        customerCombobox.setItems(DatabaseAdapter.getDbAdapter().getAllCustomers());
        customerCombobox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                locationTxt.setText(newValue.getDefaultLocation());
                phoneNumberTxt.setText(newValue.getPhoneNumber());
            }
        });
        chooseOldCustomerBtn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                if(customerCombobox.getValue() != null){
                    locationTxt.setText(customerCombobox.getValue().getDefaultLocation());
                    phoneNumberTxt.setText(customerCombobox.getValue().getPhoneNumber());
                }
            }
        });
        chooseNewCustomerBtn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue && customerCombobox.getValue() != null){
                locationTxt.setText("");
                phoneNumberTxt.setText("");
            }
        });
        saleBillItemListView.setCellFactory(new Callback<ListView<SaleBillItem>, ListCell<SaleBillItem>>() {
            @Override
            public ListCell<SaleBillItem> call(ListView<SaleBillItem> param) {
                return new RemovableSaleBillItemListCell(listener);
            }
        });
        saleBillItemListView.setItems(saleBillItems);
    }
}
