package com.shopkeeper.linh.windowfactories;

import com.shopkeeper.lam.models.FilmInfo;
import com.shopkeeper.lam.models.MusicInfo;
import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.linh.models.Feedback;
import com.shopkeeper.linh.models.FeedbackAbout;
import com.shopkeeper.linh.models.FeedbackType;
import com.shopkeeper.linh.windowfactories.feedback.FeedbackListCell;
import com.shopkeeper.linh.windowfactories.feedback.FeedbackListOrder;
import com.shopkeeper.linh.windowfactories.utilities.ComboBoxOption;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class FeedbackWindowController {
    //region Feedback Filter Panel
    @FXML
    private TextField filterSubnameTxtBox;
    @FXML
    private TextField filterTargetNameTxt;
    @FXML
    private GridPane filterPanel;
    @FXML
    private ComboBox<ComboBoxOption<FeedbackAbout>> feedbackAboutCombobox;
    @FXML
    private ComboBox<ComboBoxOption<FeedbackType>> feedbackTypeCombobox;
    @FXML
    private ComboBox<ComboBoxOption<Boolean>> beUsefulCombobox;
    @FXML
    private DatePicker filterFromDateBox;
    @FXML
    private DatePicker filterToDateBox;
    @FXML
    private Button closeFilterPanelBtn;
    @FXML
    private void resetFilterPanel(){
        filterSubnameTxtBox.setText("");
        feedbackAboutCombobox.getSelectionModel().selectFirst();
        feedbackTypeCombobox.getSelectionModel().selectFirst();
        filterTargetNameTxt.setText("");
        beUsefulCombobox.getSelectionModel().selectFirst();
        filterFromDateBox.setValue(null);
        filterToDateBox.setValue(null);
    }
    @FXML
    private void filterList(){
//        FeedbackAbout feedbackAbout = feedbackAboutCombobox.getValue().getValue();
//        FeedbackType feedbackType = feedbackTypeCombobox.getValue().getValue();
//        boolean isUseful = beUsefulCombobox.getValue().getValue();
//        String subName = filterSubnameTxtBox.getText();
//        String targetName = filterTargetNameTxt.getText();
//        LocalDate fromDate = filterFromDateBox.getValue();
//        LocalDate toDate = filterToDateBox.getValue();
        if(ComboBoxOption.isSelectAllOption(feedbackAboutCombobox.getValue())){
            System.out.println("chon tat ca");
        }
        else{
            System.out.println("chon 1 thang duy nhat");
        }

    }
    @FXML
    private void closeFilterPanel(){
        filterPanel.setVisible(false);
    }
    @FXML
    private void openFilterPanel(){
        filterPanel.setVisible(true);
    }

    private void initializeFeedbackFilterPanel(){
        filterPanel.managedProperty().bind(filterPanel.visibleProperty());
        //Initialize feedback about options
        feedbackAboutCombobox.setItems(FXCollections.observableArrayList(
                ComboBoxOption.SelectAllOption("Chọn tất cả"),
                new ComboBoxOption<>(FeedbackAbout.Service, "Dịch vụ cửa hàng"),
                new ComboBoxOption<>(FeedbackAbout.Staff, "Nhân viên phục vụ"),
                new ComboBoxOption<>(FeedbackAbout.ProductInfo, "Bài hát/Bộ phim/Bộ sách"),
                new ComboBoxOption<>(FeedbackAbout.Product, "Sản phẩm")
        ));
        feedbackAboutCombobox.getSelectionModel().selectFirst();
        //Initialize feedback type options
        feedbackTypeCombobox.setItems(FXCollections.observableArrayList(
                ComboBoxOption.SelectAllOption("Chọn tất cả"),
                new ComboBoxOption<>(FeedbackType.Suggestions, "Gợi ý/Đề xuất"),
                new ComboBoxOption<>(FeedbackType.Unsatisfied, "Không hài lòng"),
                new ComboBoxOption<>(FeedbackType.Satisfied, "Hài lòng")
        ));
        feedbackTypeCombobox.getSelectionModel().selectFirst();
        //Initialize usefulness options
        beUsefulCombobox.setItems(FXCollections.observableArrayList(
                ComboBoxOption.SelectAllOption("Chọn tất cả"),
                new ComboBoxOption<>(true, "Hữu ích"),
                new ComboBoxOption<>(false, "Không hữu ích")
        ));
        beUsefulCombobox.getSelectionModel().selectFirst();
    }
    //endregion
    //region Feedback Display
    @FXML
    private VBox feedbackDisplayer;
    @FXML
    private Text feedbackHeaderDisplayer;
    @FXML
    private Text feedbackTargetDisplayer;
    @FXML
    private Text feedbackDescriptionDisplayer;
    private void initializeFeedbackDisplayer(){
        feedbackDisplayer.setVisible(false);
    }
    private void displayFeedback(Feedback feedback){
        feedbackDisplayer.setVisible(true);
        feedbackHeaderDisplayer.setText(feedback.getTitle());
        String s;
        switch (feedback.getFeedbackAbout()) {
            case Staff:
                try {
                    s = String.format("Về: Nhân viên %s (Mã nhân viên: %d)",
                            feedback.getStaffTarget().getName(),
                            feedback.getStaffTarget().getStaffId()
                            );
                }catch (Exception e){
                    e.printStackTrace();
                    s = "";
                }
                feedbackTargetDisplayer.setText(s);
                feedbackDescriptionDisplayer.setText(feedback.getDescription());
                break;
            case ProductInfo:
                try {
                    String type = "Sách";
                    ProductInfo pi = feedback.getProductInfoTarget();
                    if(pi instanceof MusicInfo) type = "Bản nhạc";
                    else if(pi instanceof FilmInfo) type = "Bộ phim";
                    s = String.format("Về: %s %s (%d)",
                            type,
                            pi.getTitle(),
                            pi.getProductInfoId()
                    );
                    feedbackDescriptionDisplayer.setText(
                            "Đánh giá: " + feedback.getProductInfoRating() + " sao.\n\n"
                            + feedback.getDescription());
                }catch (Exception e){
                    e.printStackTrace();
                    s = "";
                    feedbackDescriptionDisplayer.setText(feedback.getDescription());
                }
                feedbackTargetDisplayer.setText(s);
                break;
            case  Product:
                try {
                    String type = "Sách";
                    ProductInfo pi = feedback.getProductTarget().getProductInfo();
                    if(pi instanceof MusicInfo) type = "Bản nhạc";
                    else if(pi instanceof FilmInfo) type = "Bộ phim";
                    s = String.format("Về: Sản phẩm mã %d (Loại: %s %s (%d))",
                            feedback.getProductTarget().getProductId(),
                            type,
                            pi.getTitle(),
                            pi.getProductInfoId()
                    );
                }catch (Exception e){
                    e.printStackTrace();
                    s = "";
                }
                feedbackTargetDisplayer.setText(s);
                feedbackDescriptionDisplayer.setText(feedback.getDescription());
                break;
            case Service:
                feedbackTargetDisplayer.setText("Về: Dịch vụ");
                break;
        }
    }
    //endregion
    //region Feedback List
    @FXML
    private ComboBox<ComboBoxOption<FeedbackListOrder>> orderCombobox;
    @FXML
    private ListView<Feedback> feedbackListView;
    private void initializeFeedbackList(){
        //Initialize feedback list order options
        orderCombobox.setItems(FXCollections.observableArrayList(
                new ComboBoxOption<>(FeedbackListOrder.NameAscending, "Cũ nhất"),
                new ComboBoxOption<>(FeedbackListOrder.TimeDescending, "Mới nhất"),
                new ComboBoxOption<>(FeedbackListOrder.NameAscending, "A->z"),
                new ComboBoxOption<>(FeedbackListOrder.NameDescending, "z->A")
        ));
        orderCombobox.getSelectionModel().selectFirst();
        feedbackListView.setCellFactory(new Callback<ListView<Feedback>, ListCell<Feedback>>()
        {
            @Override
            public ListCell<Feedback> call(ListView<Feedback> listView)
            {
                return new FeedbackListCell();
            }
        });
        try{
            DatabaseAdapter databaseAdapter = DatabaseAdapter.getDbAdapter();
            feedbackListView.setItems(databaseAdapter.getAllFeedbacks());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        feedbackListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            displayFeedback(newValue);
        });
    }
    //endregion
    public FeedbackWindowController() {

    }


    public void initialize()
    {
        initializeFeedbackFilterPanel();
        initializeFeedbackList();
        initializeFeedbackDisplayer();
    }
}
