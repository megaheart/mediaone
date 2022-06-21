package com.shopkeeper.vu.windowfactories;

import com.shopkeeper.vu.funtions.Accountant;
import com.shopkeeper.vu.funtions.StatisticGranularity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerWarehouseWindowFactory implements Initializable {
@FXML
    private ComboBox comboBox_pick;
    @FXML
    private LineChart lineChart;

    @FXML
    private ComboBox comboBox_stye;
    @FXML
    private Label lb_banhang;
    @FXML
    private Label lb_nhaphang;
    @FXML
    private Label lb_matbang;
    @FXML
    private Label lb_vanchuyen;
    @FXML
    private Label lb_loinhuan;
    @FXML
    private Label lb_nhanvien;
    @FXML
    private PieChart tk_all;
    @FXML
            private DatePicker date_day1;
    @FXML
    private DatePicker date_day2;



    XYChart.Series sr;
    @FXML
    PieChart pc;

    private  String[] pick = {"Ngày", "Tháng","Quý","Năm"};
    private  String[] stye ={"Bán ra","Nhập hàng","Lương nhân viên","Chi phí mặt bằng","Chi phí vận chuyển","Chi phí khác","Lợi nhuận"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox_stye.getItems().addAll(stye);

        comboBox_pick.getItems().addAll(pick);
        comboBox_stye.getSelectionModel().selectFirst();

        comboBox_pick.getSelectionModel().selectFirst();

    }
    public  void oa_phantich() throws Exception {

        LocalDate day1 = date_day1.getValue();
        LocalDate day2 = date_day2.getValue();
        String chon = String.valueOf(comboBox_pick.getValue()) ;
        String chonkieu = String.valueOf(comboBox_stye.getValue());
        Accountant a = new Accountant();
        //Tính theo ngày
        if(chon.equals("Ngày")&&chonkieu.equals("Bán ra")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listsaleday =FXCollections.observableArrayList();
            listsaleday=a.getSaleStatistics(day1,day2,StatisticGranularity.Day);
            double cost =0;
            for (XYChart.Data<String, Double> b: listsaleday) {
                cost =b.getYValue()+cost;
                sr.getData().add(b);
            }
            lb_banhang.setText("Tổng bán ra là : " + cost +"đồng");
            sr.setName("Bán ra");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Ngày")&&chonkieu.equals("Nhập hàng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listimportday =FXCollections.observableArrayList();
            listimportday=a.getImportStatistics(day1,day2,StatisticGranularity.Day);
            double cost =0;
            for (XYChart.Data<String, Double> b: listimportday) {
                cost =cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhaphang.setText("Tổng nhập hàng là :"+ cost +"đồng");
            sr.setName("Nhập hàng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Ngày")&&chonkieu.equals("Lương nhân viên")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> liststaffcost =FXCollections.observableArrayList();
            liststaffcost=a.getStaffCostsStatistics(day1,day2,StatisticGranularity.Day);
            double cost =0;
            for (XYChart.Data<String, Double> b: liststaffcost) {
                cost = cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhanvien.setText("Tổng lương nhân viên : "+ cost+ "đồng");
            sr.setName("Lương nhân viên");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Ngày")&&chonkieu.equals("Lợi nhuận")){
            //sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listprofit = FXCollections.observableArrayList();
            listprofit=a.getRevenueStatistics(day1,day2,StatisticGranularity.Day);
            double cost =0;
            for (XYChart.Data<String, Double> b: listprofit) {
                cost = cost +b.getYValue();
                //sr.getData().add(b);
            }
            lb_loinhuan.setText("Lợi nhận của cửa hàng: "+cost+"đồng");
            //sr.setName("Lợi nhuận");
            //lineChart.getData().add(sr);
        }
        if(chon.equals("Ngày")&&chonkieu.equals("Chi phí mặt bằng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listspace =FXCollections.observableArrayList();
            listspace=a.getSpaceCostsStatistics(day1,day2,StatisticGranularity.Day);
            double cost =0;
            for (XYChart.Data<String, Double> b: listspace) {
                sr.getData().add(b);
                cost = cost +b.getYValue();
            }
            lb_matbang.setText("Chi phí mặt bằng: "+cost+"đồng");
            sr.setName("Chi phí mặt bằng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Ngày")&&chonkieu.equals("Chi phí vận chuyển")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listtransport =FXCollections.observableArrayList();
            listtransport=a.getTranspotationCostsStatistics(day1,day2,StatisticGranularity.Day);
            double cost = 0;
            for (XYChart.Data<String, Double> b: listtransport) {
                sr.getData().add(b);
                cost =cost+b.getYValue();
            }
            lb_vanchuyen.setText("Chi phí vận chuyển: "+cost+"đồng");
            sr.setName("Chi phí vận chuyển");
            lineChart.getData().add(sr);
        }
        // Tính theo tháng
        if(chon.equals("Tháng")&&chonkieu.equals("Bán ra")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listsaleday =FXCollections.observableArrayList();
            listsaleday=a.getSaleStatistics(day1,day2,StatisticGranularity.Month);
            double cost =0;
            for (XYChart.Data<String, Double> b: listsaleday) {
                cost =b.getYValue()+cost;
                sr.getData().add(b);
            }
            lb_banhang.setText("Tổng bán ra là : " + cost +"đồng");
            sr.setName("Bán ra");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Tháng")&&chonkieu.equals("Nhập hàng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listimportday =FXCollections.observableArrayList();
            listimportday=a.getImportStatistics(day1,day2,StatisticGranularity.Month);
            double cost =0;
            for (XYChart.Data<String, Double> b: listimportday) {
                cost =cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhaphang.setText("Tổng nhập hàng là :"+ cost +"đồng");
            sr.setName("Nhập hàng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Tháng")&&chonkieu.equals("Lương nhân viên")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> liststaffcost =FXCollections.observableArrayList();
            liststaffcost=a.getStaffCostsStatistics(day1,day2,StatisticGranularity.Month);
            double cost =0;
            for (XYChart.Data<String, Double> b: liststaffcost) {
                cost = cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhanvien.setText("Tổng lương nhân viên : "+ cost+ "đồng");
            sr.setName("Lương nhân viên");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Tháng")&&chonkieu.equals("Lợi nhuận")){
            //sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listprofit = FXCollections.observableArrayList();
            listprofit=a.getRevenueStatistics(day1,day2,StatisticGranularity.Month);
            double cost =0;
            for (XYChart.Data<String, Double> b: listprofit) {
                cost = cost +b.getYValue();
                //sr.getData().add(b);
            }
            lb_loinhuan.setText("Lợi nhận của cửa hàng: "+cost+"đồng");
            //sr.setName("Lợi nhuận");
            //lineChart.getData().add(sr);
        }
        if(chon.equals("Tháng")&&chonkieu.equals("Chi phí mặt bằng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listspace =FXCollections.observableArrayList();
            listspace=a.getSpaceCostsStatistics(day1,day2,StatisticGranularity.Month);
            double cost =0;
            for (XYChart.Data<String, Double> b: listspace) {
                sr.getData().add(b);
                cost = cost +b.getYValue();
            }
            lb_matbang.setText("Chi phí mặt bằng: "+cost+"đồng");
            sr.setName("Chi phí mặt bằng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Tháng")&&chonkieu.equals("Chi phí vận chuyển")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listtransport =FXCollections.observableArrayList();
            listtransport=a.getTranspotationCostsStatistics(day1,day2,StatisticGranularity.Month);
            double cost = 0;
            for (XYChart.Data<String, Double> b: listtransport) {
                sr.getData().add(b);
                cost =cost+b.getYValue();
            }
            lb_vanchuyen.setText("Chi phí vận chuyển: "+cost+"đồng");
            sr.setName("Chi phí vận chuyển");
            lineChart.getData().add(sr);
        }
        //Tính theo quý
        if(chon.equals("Quý")&&chonkieu.equals("Bán ra")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listsaleday =FXCollections.observableArrayList();
            listsaleday=a.getSaleStatistics(day1,day2,StatisticGranularity.Quarter);
            double cost =0;
            for (XYChart.Data<String, Double> b: listsaleday) {
                cost =b.getYValue()+cost;
                sr.getData().add(b);
            }
            lb_banhang.setText("Tổng bán ra là : " + cost +"đồng");
            sr.setName("Bán ra");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Quý")&&chonkieu.equals("Nhập hàng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listimportday =FXCollections.observableArrayList();
            listimportday=a.getImportStatistics(day1,day2,StatisticGranularity.Quarter);
            double cost =0;
            for (XYChart.Data<String, Double> b: listimportday) {
                cost =cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhaphang.setText("Tổng nhập hàng là :"+ cost +"đồng");
            sr.setName("Nhập hàng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Quý")&&chonkieu.equals("Lương nhân viên")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> liststaffcost =FXCollections.observableArrayList();
            liststaffcost=a.getStaffCostsStatistics(day1,day2,StatisticGranularity.Quarter);
            double cost =0;
            for (XYChart.Data<String, Double> b: liststaffcost) {
                cost = cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhanvien.setText("Tổng lương nhân viên : "+ cost+ "đồng");
            sr.setName("Lương nhân viên");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Quý")&&chonkieu.equals("Lợi nhuận")){
            //sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listprofit = FXCollections.observableArrayList();
            listprofit=a.getRevenueStatistics(day1,day2,StatisticGranularity.Quarter);
            double cost =0;
            for (XYChart.Data<String, Double> b: listprofit) {
                cost = cost +b.getYValue();
                //sr.getData().add(b);
            }
            lb_loinhuan.setText("Lợi nhận của cửa hàng: "+cost+"đồng");
            //sr.setName("Lợi nhuận");
            //lineChart.getData().add(sr);
        }
        if(chon.equals("Quý")&&chonkieu.equals("Chi phí mặt bằng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listspace =FXCollections.observableArrayList();
            listspace=a.getSpaceCostsStatistics(day1,day2,StatisticGranularity.Quarter);
            double cost =0;
            for (XYChart.Data<String, Double> b: listspace) {
                sr.getData().add(b);
                cost = cost +b.getYValue();
            }
            lb_matbang.setText("Chi phí mặt bằng: "+cost+"đồng");
            sr.setName("Chi phí mặt bằng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Quý")&&chonkieu.equals("Chi phí vận chuyển")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listtransport =FXCollections.observableArrayList();
            listtransport=a.getTranspotationCostsStatistics(day1,day2,StatisticGranularity.Quarter);
            double cost = 0;
            for (XYChart.Data<String, Double> b: listtransport) {
                sr.getData().add(b);
                cost =cost+b.getYValue();
            }
            lb_vanchuyen.setText("Chi phí vận chuyển: "+cost+"đồng");
            sr.setName("Chi phí vận chuyển");
            lineChart.getData().add(sr);
        }
        //Tính theo năm
        if(chon.equals("Năm")&&chonkieu.equals("Bán ra")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listsaleday =FXCollections.observableArrayList();
            listsaleday=a.getSaleStatistics(day1,day2,StatisticGranularity.Year);
            double cost =0;
            for (XYChart.Data<String, Double> b: listsaleday) {
                cost =b.getYValue()+cost;
                sr.getData().add(b);
            }
            lb_banhang.setText("Tổng bán ra là : " + cost +"đồng");
            sr.setName("Bán ra");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Năm")&&chonkieu.equals("Nhập hàng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listimportday =FXCollections.observableArrayList();
            listimportday=a.getImportStatistics(day1,day2,StatisticGranularity.Year);
            double cost =0;
            for (XYChart.Data<String, Double> b: listimportday) {
                cost =cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhaphang.setText("Tổng nhập hàng là :"+ cost +"đồng");
            sr.setName("Nhập hàng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Năm")&&chonkieu.equals("Lương nhân viên")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> liststaffcost =FXCollections.observableArrayList();
            liststaffcost=a.getStaffCostsStatistics(day1,day2,StatisticGranularity.Year);
            double cost =0;
            for (XYChart.Data<String, Double> b: liststaffcost) {
                cost = cost+b.getYValue();
                sr.getData().add(b);
            }
            lb_nhanvien.setText("Tổng lương nhân viên : "+ cost+ "đồng");
            sr.setName("Lương nhân viên");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Năm")&&chonkieu.equals("Lợi nhuận")){
            //sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listprofit = FXCollections.observableArrayList();
            listprofit=a.getRevenueStatistics(day1,day2,StatisticGranularity.Year);
            double cost =0;
            for (XYChart.Data<String, Double> b: listprofit) {
                cost = cost +b.getYValue();
                //sr.getData().add(b);
            }
            lb_loinhuan.setText("Lợi nhận của cửa hàng: "+cost+"đồng");
            //sr.setName("Lợi nhuận");
            //lineChart.getData().add(sr);
        }
        if(chon.equals("Năm")&&chonkieu.equals("Chi phí mặt bằng")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listspace =FXCollections.observableArrayList();
            listspace=a.getSpaceCostsStatistics(day1,day2,StatisticGranularity.Year);
            double cost =0;
            for (XYChart.Data<String, Double> b: listspace) {
                sr.getData().add(b);
                cost = cost +b.getYValue();
            }
            lb_matbang.setText("Chi phí mặt bằng: "+cost+"đồng");
            sr.setName("Chi phí mặt bằng");
            lineChart.getData().add(sr);
        }
        if(chon.equals("Năm")&&chonkieu.equals("Chi phí vận chuyển")){
            sr= new XYChart.Series();
            ObservableList<XYChart.Data<String, Double>> listtransport =FXCollections.observableArrayList();
            listtransport=a.getTranspotationCostsStatistics(day1,day2,StatisticGranularity.Year);
            double cost = 0;
            for (XYChart.Data<String, Double> b: listtransport) {
                sr.getData().add(b);
                cost =cost+b.getYValue();
            }
            lb_vanchuyen.setText("Chi phí vận chuyển: "+cost+"đồng");
            sr.setName("Chi phí vận chuyển");
            lineChart.getData().add(sr);
        }
        lineChart.setAnimated(false);
    }
    public void oa_all() {
        LocalDate day1 = date_day1.getValue();
        LocalDate day2 = date_day2.getValue();
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        pc= new PieChart();
        Accountant a = new Accountant();
        ObservableList<PieChart.Data> list1;
        try {
            list1 = a.getAllTypesOfCostsStatistics(day1,day2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(list1);
        tk_all.setData(list1);
        tk_all.setTitle("cac");
    }
    public void oa_xoa(){
        comboBox_stye.getSelectionModel().selectFirst();
        comboBox_pick.getSelectionModel().selectFirst();

        lb_vanchuyen.setText(null);
        lb_nhanvien.setText(null);
        lb_matbang.setText(null);
        lb_banhang.setText(null);
        lb_nhaphang.setText(null);
        lb_loinhuan.setText(null);

        lineChart.getData().clear();
        tk_all.getData().clear();
        tk_all.setTitle(null);
    }
}
