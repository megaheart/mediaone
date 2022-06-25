package com.shopkeeper.minh.windowfactories;

import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.models.StaffState;
import com.shopkeeper.linh.windowfactories.utilities.ComboBoxOption;
import com.shopkeeper.minh.functions.StaffManager;
import com.shopkeeper.minh.windowfactories.staff.StaffListCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class StaffWindowController {


    @FXML
    private ListView<Staff> staffListView;

    @FXML
    private VBox staffDisplayer;

    @FXML
    private Text staffHeaderDisplayer;

    @FXML
    private Text staffTargetDisplayer;

    @FXML
    private Text staffDescriptionDisplayer;

    @FXML
    private GridPane filterPanel;

    @FXML
    private Text result;

    @FXML
    private TextField filterTargetNameTxt;

    @FXML
    private TextField filterTargetIdTxt;

    @FXML
    private TextField filterTargetEmailTxt;

    @FXML
    private ComboBox<ComboBoxOption<StaffState>> filterTargetStateComboBox;

    @FXML
    private Button searchButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button insertButton;

    @FXML
    private Button punchInButton;

    @FXML
    private Button resetButton;

    @FXML
    private TextField filterPhoneTxt;

    @FXML
    private TextField filterDescriptTxt;

    @FXML
    private DatePicker filterDateOfBirth;

    @FXML
    private ComboBox<ComboBoxOption<Boolean>> filterSex;

    @FXML
    private void resetFilterPanel(){
        filterTargetStateComboBox.getSelectionModel().selectFirst();
        filterTargetIdTxt.setText("");
        filterTargetNameTxt.setText("");
        filterTargetEmailTxt.setText("");
        filterDateOfBirth.setValue(null);
        filterSex.getSelectionModel().selectFirst();
        filterPhoneTxt.setText("");
        filterDescriptTxt.setText("");
    }

    @FXML
    public void filterList() throws Exception {
        String staffName = filterTargetNameTxt.getText();
        String staffIdTxt = filterTargetIdTxt.getText();
        String staffEmail = filterTargetEmailTxt.getText();
        StaffState staffState = filterTargetStateComboBox.getValue().getValue();
        String phoneNumber = filterPhoneTxt.getText();
        String descript = filterDescriptTxt.getText();
        Boolean isMale = filterSex.getValue().getValue();
        LocalDate dateOfBirth = filterDateOfBirth.getValue();
        long staffId = 0;

        ArrayList<Staff> oldStaffList;
        ArrayList<Staff> newStaffList = new ArrayList<Staff>(StaffManager.getManager().getAll());



       if (staffIdTxt != null && !staffIdTxt.isEmpty()){
           try {
               staffId = Long.parseLong(staffIdTxt);
           }
           catch (Exception e){
               result.setText("Chỉ nhập số nguyên.");
               initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
               return;
           }

           Staff staff = StaffManager.getManager().findById(staffId);
           if (staff == null){
               result.setText("Không tìm thấy");
               initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
               return;
           }
           newStaffList = new ArrayList<>();
           newStaffList.add(staff);

       }

       // Name search

       if (staffName != null && !staffName.isEmpty()){
           oldStaffList = newStaffList;
           newStaffList = StaffManager.getManager().findByName(staffName, oldStaffList);
           if (newStaffList == null || newStaffList.isEmpty()){
               result.setText("Không tìm thấy");
               initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
               return;
           }
       }

       // Email search
       if (staffEmail != null && !staffEmail.isEmpty()) {
           oldStaffList = newStaffList;
           newStaffList = StaffManager.getManager().findByEmail(staffEmail, oldStaffList);
           if (newStaffList == null || newStaffList.isEmpty()){
               result.setText("Không tìm thấy");
               initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
               return;
           }
       }

       // State search
        if (!ComboBoxOption.isSelectAllOption(filterTargetStateComboBox.getValue())){
            oldStaffList = newStaffList;
            newStaffList = StaffManager.getManager().findByState(staffState, oldStaffList);
            if (newStaffList == null || newStaffList.isEmpty()){
                result.setText("Không tìm thấy");
                initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
                return;
            }
        }

        // Phone search
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            oldStaffList = newStaffList;
            newStaffList = StaffManager.getManager().findByPhoneNumber(phoneNumber, oldStaffList);
            if (newStaffList == null || newStaffList.isEmpty()){
                result.setText("Không tìm thấy");
                initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
                return;
            }
        }

        // Description search
        if (descript != null && !descript.isEmpty()) {
            oldStaffList = newStaffList;
            newStaffList = StaffManager.getManager().findByDescription(descript, oldStaffList);
            if (newStaffList == null || newStaffList.isEmpty()){
                result.setText("Không tìm thấy");
                initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
                return;
            }
        }

        // Sex search
        if (!ComboBoxOption.isSelectAllOption(filterSex.getValue())){
            oldStaffList = newStaffList;
            newStaffList = StaffManager.getManager().findBySex(isMale, oldStaffList);
            if (newStaffList == null || newStaffList.isEmpty()){
                result.setText("Không tìm thấy");
                initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
                return;
            }
        }

        // Birthday search
        if (dateOfBirth != null){
            oldStaffList = newStaffList;
            newStaffList = StaffManager.getManager().findByBirthday(dateOfBirth, oldStaffList);
            if (newStaffList == null || newStaffList.isEmpty()){
                result.setText("Không tìm thấy");
                initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
                return;
            }
        }


        // Display
        if (newStaffList != null && !newStaffList.isEmpty())
        {
            result.setText("Tìm thấy");
            ObservableList<Staff> staffObservableList = FXCollections.observableList(newStaffList);
            initializeStaffList(staffObservableList);
            return;
        }

    }

    private void initializeStaffDisplayer(){
        staffDisplayer.setVisible(false);
    }

    private void displayStaff(Staff staff){
        staffDisplayer.setVisible(true);
        staffHeaderDisplayer.setText(staff.getName());
        String staffIdTxt = String.format("ID: %d", staff.getStaffId());
        staffTargetDisplayer.setText(staffIdTxt);
        StringBuilder sb = new StringBuilder();
        if (staff.getIsMale()){
            sb.append("- Giới tính: "); sb.append("Nam");sb.append(",\n\n");
        }
        else {
            sb.append("- Giới tính: "); sb.append("Nữ");sb.append(",\n\n");
        }

        sb.append("- Ngày sinh: "); sb.append(staff.getDateOfBirth());sb.append(",\n\n");
        sb.append("- Email: \""); sb.append(staff.getEmail());sb.append("\",\n\n");
        sb.append("- Số điện thoại: \""); sb.append(staff.getPhoneNumber());sb.append("\",\n\n");
        sb.append("- Miêu tả: \""); sb.append(staff.getDescription());sb.append("\",\n\n");
        sb.append("- State: "); sb.append(staff.getState());sb.append("\n");
        staffDescriptionDisplayer.setText(sb.toString());
    }

    private void initializeStaffList(ObservableList<Staff> staffs){
        staffListView.setCellFactory(new Callback<ListView<Staff>, ListCell<Staff>>() {
            @Override
            public ListCell<Staff> call(ListView<Staff> staffListView) {
                return new StaffListCell();
            }
        });
        try{
            staffListView.setItems(staffs);
        } catch (Exception e){
            e.printStackTrace();
        }
        staffListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            displayStaff(newValue);
        });
    }

    public StaffWindowController(){
    }

    public void initializeStaffFilterPanel(){
        filterPanel.managedProperty().bind(filterPanel.visibleProperty());
        filterTargetStateComboBox.setItems(FXCollections.observableArrayList(
                ComboBoxOption.SelectAllOption("Chọn tất cả"),
                new ComboBoxOption<>(StaffState.Demited, "Demited"),
                new ComboBoxOption<>(StaffState.Working, "Working"),
                new ComboBoxOption<>(StaffState.Interviewing, "Interviewing"),
                new ComboBoxOption<>(StaffState.Unreliable, "Unreliable"),
                new ComboBoxOption<>(StaffState.NotEmployed, "Not employed")
        ));
        filterTargetStateComboBox.getSelectionModel().selectFirst();

        filterSex.setItems(FXCollections.observableArrayList(
                ComboBoxOption.SelectAllOption("Chọn tất cả"),
                new ComboBoxOption<>(true, "Nam"),
                new ComboBoxOption<>(false, "Nữ")
        ));
        filterSex.getSelectionModel().selectFirst();
    }


    public void initialize() throws Exception {
        initializeStaffFilterPanel();
        initializeStaffDisplayer();
        initializeStaffList(StaffManager.getManager().getAll());
    }

    @FXML
    public void update() throws Exception {
        String staffName = filterTargetNameTxt.getText();
        String staffIdTxt = filterTargetIdTxt.getText();
        String staffEmail = filterTargetEmailTxt.getText();
        StaffState staffState = filterTargetStateComboBox.getValue().getValue();
        String phoneNumber = filterPhoneTxt.getText();
        String descript = filterDescriptTxt.getText();
        Boolean isMale = filterSex.getValue().getValue();
        LocalDate dateOfBirth = filterDateOfBirth.getValue();
        long staffId = 0;

        if (staffIdTxt != null && !staffIdTxt.isEmpty()){
            try {
                staffId = Long.parseLong(staffIdTxt);
            }
            catch (Exception e){
                result.setText("Chỉ nhập số nguyên.");
                initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
                return;
            }
        }
        else {
            result.setText("Nhập ID của nhân viên trước khi update.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        Staff staff = StaffManager.getManager().findById(staffId);
        if (staff == null){
            result.setText("Không tìm thấy");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Name search

        if (staffName != null && !staffName.isEmpty()) staff.setName(staffName);

        // Email search
        if (staffEmail != null && !staffEmail.isEmpty()) staff.setEmail(staffEmail);

        // State search
        if (!ComboBoxOption.isSelectAllOption(filterTargetStateComboBox.getValue())) staff.setState(staffState);

        // Phone search
        if (phoneNumber != null && !phoneNumber.isEmpty()) staff.setPhoneNumber(phoneNumber);

        // Description search
        if (descript != null && !descript.isEmpty()) staff.setDescription(descript);

        // Sex search
        if (!ComboBoxOption.isSelectAllOption(filterSex.getValue()))staff.setIsMale(isMale);

        // Birthday search
        if (dateOfBirth != null)staff.setDateOfBirth(dateOfBirth);
        StaffManager.getManager().update(staff);

        Staff newStaff = StaffManager.getManager().findById(staffId);
        if (newStaff == null){
            result.setText("Error");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }
        else {
            // Display
            ArrayList<Staff> newStaffList = new ArrayList<>();
            newStaffList.add(newStaff);
            result.setText("Update thành công");
            ObservableList<Staff> staffObservableList = FXCollections.observableList(newStaffList);
            initializeStaffList(staffObservableList);
            return;
        }
    }

    @FXML
    public void insert() throws Exception {
        String staffName = filterTargetNameTxt.getText();
        String staffIdTxt = filterTargetIdTxt.getText();
        String staffEmail = filterTargetEmailTxt.getText();
        StaffState staffState = filterTargetStateComboBox.getValue().getValue();
        String phoneNumber = filterPhoneTxt.getText();
        String descript = filterDescriptTxt.getText();
        Boolean isMale = filterSex.getValue().getValue();
        LocalDate dateOfBirth = filterDateOfBirth.getValue();

        if (staffIdTxt != null && !staffIdTxt.isEmpty()){
            result.setText("Xóa ID của nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        Staff staff = new Staff();

        // Name search
        if (staffName != null && !staffName.isEmpty()) staff.setName(staffName);
        else {
            result.setText("Nhập tên của nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Email search
        if (staffEmail != null && !staffEmail.isEmpty()) staff.setEmail(staffEmail);
        else {
            result.setText("Nhập email của nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // State search
        if (!ComboBoxOption.isSelectAllOption(filterTargetStateComboBox.getValue())) staff.setState(staffState);
        else {
            result.setText("Chọn state của nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Phone search
        if (phoneNumber != null && !phoneNumber.isEmpty()) staff.setPhoneNumber(phoneNumber);
        else {
            result.setText("Nhập số điện thoại của nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Description search
        if (descript != null && !descript.isEmpty()) staff.setDescription(descript);
        else {
            result.setText("Nhập mô tả về nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Sex search
        if (!ComboBoxOption.isSelectAllOption(filterSex.getValue()))staff.setIsMale(isMale);
        else {
            result.setText("Chọn giới tính của nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Birthday search
        if (dateOfBirth != null)staff.setDateOfBirth(dateOfBirth);
        else {
            result.setText("Chọn sinh nhật của nhân viên trước khi thêm.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        StaffManager.getManager().add(staff);

        // Display

        Staff newStaff = StaffManager.getManager().findById(staff.getStaffId());
        if (newStaff == null){
            result.setText("Error");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }
        else {
            // Display
            ArrayList<Staff> newStaffList = new ArrayList<>();
            newStaffList.add(newStaff);
            result.setText(String.format("Thêm thành công, ID nhân viên mới là %d", staff.getStaffId()));
            ObservableList<Staff> staffObservableList = FXCollections.observableList(newStaffList);
            initializeStaffList(staffObservableList);
            return;
        }
    }

    @FXML
    public void delete() throws Exception {
        String staffName = filterTargetNameTxt.getText();
        String staffIdTxt = filterTargetIdTxt.getText();
        String staffEmail = filterTargetEmailTxt.getText();
        StaffState staffState = filterTargetStateComboBox.getValue().getValue();
        String phoneNumber = filterPhoneTxt.getText();
        String descript = filterDescriptTxt.getText();
        Boolean isMale = filterSex.getValue().getValue();
        LocalDate dateOfBirth = filterDateOfBirth.getValue();
        long staffId = 0;

        if (staffIdTxt != null && !staffIdTxt.isEmpty()){
            try {
                staffId = Long.parseLong(staffIdTxt);
            }
            catch (Exception e){
                result.setText("Chỉ nhập số nguyên.");
                initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
                return;
            }
        }
        else {
            result.setText("Nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        Staff staff = StaffManager.getManager().findById(staffId);

        // Name search
        if (staffName != null && !staffName.isEmpty())
        {
            result.setText("Chỉ nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Email search
        if (staffEmail != null && !staffEmail.isEmpty())
        {
            result.setText("Chỉ nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // State search
        if (!ComboBoxOption.isSelectAllOption(filterTargetStateComboBox.getValue()))
        {
            result.setText("Chỉ nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Phone search
        if (phoneNumber != null && !phoneNumber.isEmpty())
        {
            result.setText("Chỉ nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Description search
        if (descript != null && !descript.isEmpty())
        {
            result.setText("Chỉ nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Sex search
        if (!ComboBoxOption.isSelectAllOption(filterSex.getValue()))
        {
            result.setText("Chỉ nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        // Birthday search
        if (dateOfBirth != null)
        {
            result.setText("Chỉ nhập ID của nhân viên trước khi xóa.");
            initializeStaffList(FXCollections.observableArrayList(new ArrayList<Staff>()));
            return;
        }

        StaffManager.getManager().remove(staff);

        // Display
        result.setText("Xóa thành công");
        ObservableList<Staff> staffObservableList = FXCollections.observableList(StaffManager.getManager().getAll());
        initializeStaffList(staffObservableList);
        return;

    }

}
