package com.shopkeeper.linh.windowfactories;

import com.shopkeeper.lam.models.BookInfo;
import com.shopkeeper.lam.models.FilmInfo;
import com.shopkeeper.lam.models.MusicInfo;
import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.linh.windowfactories.payment.CustomerComboBoxOptions;
import com.shopkeeper.linh.windowfactories.payment.SaleBillListCell;
import com.shopkeeper.linh.windowfactories.payment.SaleBillListOrder;
import com.shopkeeper.linh.windowfactories.payment.SaleBillObservableList;
import com.shopkeeper.linh.windowfactories.utilities.ComboBoxOption;
import com.shopkeeper.linh.windowfactories.utilities.ComboBoxOptionList;
import com.shopkeeper.linh.windowfactories.utilities.CustomerToStringCell;
import com.shopkeeper.linh.windowfactories.utilities.DefaultListCell;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.time.LocalDate;

public class PaymentWindowController {
    //region SaleBill Filter Panel
    @FXML
    private TextField filterSubnameTxtBox;
    @FXML
    private TextField filterFromValueTxt;
    @FXML
    private TextField filterToValueTxt;
    @FXML
    private GridPane filterPanel;
    @FXML
    private ComboBox<ComboBoxOption<Customer>> customerCombobox;
    @FXML
    private TextField filterLocationTxt;
    @FXML
    private DatePicker filterFromDateBox;
    @FXML
    private DatePicker filterToDateBox;
    @FXML
    private void resetFilterPanel(){
        filterSubnameTxtBox.setText("");
        filterFromValueTxt.setText("");
        filterToValueTxt.setText("");
        filterLocationTxt.setText("");
        customerCombobox.getSelectionModel().selectFirst();
        filterFromDateBox.setValue(null);
        filterToDateBox.setValue(null);
    }
    @FXML
    private void filterList(){
        String fromValueString = filterFromValueTxt.getText();
        String toValueString = filterToValueTxt.getText();
        fromValueString = fromValueString == null?"":fromValueString.trim();
        toValueString = toValueString == null?"":toValueString.trim();
        StringBuilder valueRangeErrorsSb = new StringBuilder();
        double fromValue = 0;
        double toValue = Double.MAX_VALUE;
        if(fromValueString.length() > 0){
            try{
                fromValue = Double.parseDouble(filterFromValueTxt.getText());
            }
            catch (NumberFormatException e){
                valueRangeErrorsSb.append("- Giá trị " + filterFromValueTxt.getText() + " không phải là số.\n");
            }
        }
        if(toValueString.length() > 0){
            try{
                toValue = Double.parseDouble(filterToValueTxt.getText());
            }
            catch (NumberFormatException e){
                valueRangeErrorsSb.append("- Giá trị " + filterToValueTxt.getText() + " không phải là số.\n");
            }
        }
        if(valueRangeErrorsSb.length() > 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Phạm vi giá trị hóa đơn không hợp lệ");
            alert.setHeaderText("Phạm vi giá trị hóa đơn không hợp lệ do vi phạm những điều sau:");
            alert.setContentText(valueRangeErrorsSb.toString());
            alert.showAndWait();
            return;
        }
        FilteredList<SaleBill> filteredList = new FilteredList<>(saleBillFullList);
        if(fromValue != 0 || toValue != Double.MAX_VALUE){
            final double _fromValue = fromValue;
            final double _toValue = toValue;
            filteredList = filteredList.filtered(saleBill -> {
                if(saleBill.getPrice() < _fromValue) return false;
                if(saleBill.getPrice() > _toValue) return false;
                return true;
            });
        }
        if(!ComboBoxOption.isSelectAllOption(customerCombobox.getValue())){
            Customer customer = customerCombobox.getValue().getValue();
            filteredList = filteredList.filtered(saleBill -> {
                return saleBill.getCustomer() == customer;
            });
        }
        LocalDate fromDate = filterFromDateBox.getValue();
        LocalDate toDate = filterToDateBox.getValue();
        if(fromDate != null || toDate != null){
            filteredList = filteredList.filtered(saleBill -> {
                if(fromDate != null && saleBill.getTime().compareTo(fromDate) < 0) return false;
                if(toDate != null && saleBill.getTime().compareTo(toDate) > 0) return false;
                return true;
            });
        }

        String subName = filterSubnameTxtBox.getText();
        if(subName != null && (subName = subName.trim()).length() != 0){
            final String _subName = subName;
            filteredList = filteredList.filtered(saleBill -> {
                return saleBill.getName().contains(_subName);
            });
        }
        String subLocationString = filterLocationTxt.getText();
        if(subLocationString != null && (subLocationString = subLocationString.trim()).length() != 0){
            final String _subLocationString = subLocationString;
            filteredList = filteredList.filtered(saleBill -> {
                return saleBill.getLocation().contains(_subLocationString);
            });
        }
        saleBillList = new SaleBillObservableList(filteredList);
        saleBillList.setOrder(orderCombobox.getValue().getValue());
        saleBillListView.setItems(saleBillList);
    }
    @FXML
    private void closeFilterPanel(){
        filterPanel.setVisible(false);
        saleBillList = saleBillFullList;
        saleBillList.setOrder(orderCombobox.getValue().getValue());
        saleBillListView.setItems(saleBillList);
    }
    @FXML
    private void openFilterPanel(){
        filterPanel.setVisible(true);
    }

    private void initializeSaleBillFilterPanel(){
        var adapter = DatabaseAdapter.getDbAdapter();
        filterPanel.managedProperty().bind(filterPanel.visibleProperty());
        filterPanel.setVisible(false);
        customerCombobox.setItems(new CustomerComboBoxOptions(adapter.getAllCustomers()));
        customerCombobox.setButtonCell(new DefaultListCell<>());
        customerCombobox.setCellFactory(new Callback<ListView<ComboBoxOption<Customer>>, ListCell<ComboBoxOption<Customer>>>() {
            @Override
            public ListCell<ComboBoxOption<Customer>> call(ListView<ComboBoxOption<Customer>> param) {
                return new DefaultListCell<>();
            }
        });
        customerCombobox.getSelectionModel().selectFirst();
    }
    //endregion
    //region SaleBill Editing Panel
    @FXML
    private AnchorPane saleBillEditingPane;
    private void initializeSaleBillDisplayer(){
        saleBillEditingPane.setVisible(false);
    }
    private void displaySaleBill(SaleBill saleBill){
        if(saleBill == null) {
            saleBillEditingPane.setVisible(false);
            return;
        }
        saleBillEditingPane.setVisible(true);
    }
    //endregion
    //region SaleBill List
    @FXML
    private HBox saleBillToolbar;
    @FXML
    private ComboBox<ComboBoxOption<SaleBillListOrder>> orderCombobox;
    @FXML
    private ListView<SaleBill> saleBillListView;
    private SaleBillObservableList saleBillList;
    private SaleBillObservableList saleBillFullList;
    @FXML
    private Button deleteSaleBillBtn;
    @FXML
    private void deleteSaleBill(){
        var selectedItem = saleBillListView.getSelectionModel().getSelectedItem();
        DatabaseAdapter.getDbAdapter().deleteSaleBill(selectedItem);
        saleBillListView.getSelectionModel().clearSelection();
        deleteSaleBillBtn.setVisible(false);
    }
    private void adjustSaleBills(){
        DatabaseAdapter databaseAdapter = DatabaseAdapter.getDbAdapter();
        for (var x: databaseAdapter.getAllSaleBills()){
            x.setPrice(0);
        }
        for (var x: databaseAdapter.getAllProducts()){
            var salebill = x.getSaleBill();
            if(salebill != null){
                salebill.setPrice(salebill.getPrice() + x.getSaleValue());
            }
        }
    }
    private void initializeSaleBillList(){
        deleteSaleBillBtn.setVisible(false);
        //Initialize saleBill list order options
        orderCombobox.setItems(FXCollections.observableArrayList(
                new ComboBoxOption<>(SaleBillListOrder.TimeAscending, "Cũ nhất"),
                new ComboBoxOption<>(SaleBillListOrder.TimeDescending, "Mới nhất"),
                new ComboBoxOption<>(SaleBillListOrder.TitleAscending, "A->z"),
                new ComboBoxOption<>(SaleBillListOrder.TitleDescending, "z->A"),
                new ComboBoxOption<>(SaleBillListOrder.PriceAscending, "Giá trị tăng dần"),
                new ComboBoxOption<>(SaleBillListOrder.PriceDescending, "Giá trị giảm dần"),
                new ComboBoxOption<>(SaleBillListOrder.CustomerNameAscending, "Tên khách hàng A->z"),
                new ComboBoxOption<>(SaleBillListOrder.CustomerNameDescending, "Tên khách hàng z->A"),
                new ComboBoxOption<>(SaleBillListOrder.LocationAscending, "Địa chỉ A->z"),
                new ComboBoxOption<>(SaleBillListOrder.LocationDescending, "Địa chỉ z->A")
        ));
        orderCombobox.getSelectionModel().selectFirst();
        saleBillListView.setCellFactory(new Callback<ListView<SaleBill>, ListCell<SaleBill>>()
        {
            @Override
            public ListCell<SaleBill> call(ListView<SaleBill> listView)
            {
                return new SaleBillListCell();
            }
        });
        DatabaseAdapter databaseAdapter = DatabaseAdapter.getDbAdapter();
        var saleBills = databaseAdapter.getAllSaleBills();
        //adjustSaleBills();
        saleBillFullList = new SaleBillObservableList(saleBills);
        saleBillList = saleBillFullList;
        saleBillListView.setItems(saleBillList);
        saleBillListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deleteSaleBillBtn.setVisible(newValue != null);
        });
        orderCombobox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            saleBillList.setOrder(newValue.getValue());
        });
    }
    //endregion
    public PaymentWindowController() {

    }


    public void initialize()
    {
        initializeSaleBillFilterPanel();
        initializeSaleBillList();
        initializeSaleBillDisplayer();
    }
}
