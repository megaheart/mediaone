package com.shopkeeper.vu.funtions;

import com.shopkeeper.lam.models.Product;
import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.mediaone.models.Bill;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;
import com.shopkeeper.minh.models.StaffBill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;

public class Accountant {
    ObservableList<XYChart.Data<String, Double>> listImportBillDay;
    ObservableList<XYChart.Data<String, Double>> listImportBillMonth;
    ObservableList<XYChart.Data<String, Double>> listImportBillQuarter;
    ObservableList<XYChart.Data<String, Double>> listImportBillYear;
    ObservableList<XYChart.Data<String, Double>> listImportProductInfoDay;
    ObservableList<XYChart.Data<String, Double>> listImportProductInfoMonth;
    ObservableList<XYChart.Data<String, Double>> listImportProductInfoQuarter;
    ObservableList<XYChart.Data<String, Double>> listImportProductInfoYear;
    ObservableList<XYChart.Data<String, Double>> listSaleBillDay;
    ObservableList<XYChart.Data<String, Double>> listSaleBillMonth;
    ObservableList<XYChart.Data<String, Double>> listSaleBillQuarter;
    ObservableList<XYChart.Data<String, Double>> listSaleBillYear;
    ObservableList<XYChart.Data<String, Double>> listSaleProductInfoDay;
    ObservableList<XYChart.Data<String, Double>> listSaleProductInfoMonth;
    ObservableList<XYChart.Data<String, Double>> listSaleProductInfoQuarter;
    ObservableList<XYChart.Data<String, Double>> listSaleProductInfoYear;
    ObservableList<XYChart.Data<String, Double>> listStaffCostsStatisticsDay;
    ObservableList<XYChart.Data<String, Double>> listStaffCostsStatisticsMonth;
    ObservableList<XYChart.Data<String, Double>> listStaffCostsStatisticsQuarter;
    ObservableList<XYChart.Data<String, Double>> listStaffCostsStatisticsYear;
    ObservableList<XYChart.Data<String, Double>> listSpaceCostsStatisticsDay;
    ObservableList<XYChart.Data<String, Double>> listSpaceCostsStatisticsMonth;
    ObservableList<XYChart.Data<String, Double>> listSpaceCostsStatisticsQuarter;
    ObservableList<XYChart.Data<String, Double>> listSpaceCostsStatisticsYear;
    ObservableList<XYChart.Data<String, Double>> listTranspotationCostsStatisticsDay;
    ObservableList<XYChart.Data<String, Double>> listTranspotationCostsStatisticsMonth;
    ObservableList<XYChart.Data<String, Double>> listTranspotationCostsStatisticsQuarter;
    ObservableList<XYChart.Data<String, Double>> listTranspotationCostsStatisticsYear;
    ObservableList<XYChart.Data<String, Double>> listBillFromDateToDateDay;
    ObservableList<XYChart.Data<String, Double>> listBillFromDateToDateMonth;
    ObservableList<XYChart.Data<String, Double>> listBillFromDateToDateYear;
    ObservableList<XYChart.Data<String, Double>> listBillFromDateToDateQuarter;
    ObservableList<XYChart.Data<String, Double>> listBillProfitFromDateToDateDay;
    ObservableList<XYChart.Data<String, Double>> listBillProfitFromDateToDateMonth;
    ObservableList<XYChart.Data<String, Double>> listBillProfitFromDateToDateQuarter;
    ObservableList<XYChart.Data<String, Double>> listBillProfitFromDateToDateYear;
    ObservableList<PieChart.Data> listBill;
    ObservableList<Bill> listBillFromDateToDate;
    ObservableList<Bill> listBillCostFromDateToDate;
    ObservableList<Bill> listBillProfitFromDateToDate;


    public ObservableList<XYChart.Data<String, Double>> getImportStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<ImportBill> list = adapter.getAllImportBills();
        listImportBillDay = FXCollections.observableArrayList();
        if(granularity.equals(StatisticGranularity.Day)){
            listImportBillDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (ImportBill bill: list) {
                    if(d.compareTo(bill.getTime())==0){
                        cost =cost + bill.getPrice();
                    }
                }
                listImportBillDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listImportBillDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listImportBillMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonthValue()!=toDate.getMonthValue();d=d.plusMonths(1)){
                double cost =0;
                for (ImportBill bill: list) {
                    if(d.getMonth()==bill.getTime().getMonth()&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listImportBillMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listImportBillMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listImportBillQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (ImportBill bill: list) {
                    if(d.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(d.getMonthValue()+2)&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listImportBillQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listImportBillQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listImportBillYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (ImportBill bill: list) {
                    if(bill.getTime().getYear()==d.getYear()){
                        cost=cost+bill.getPrice();
                    }
                }
                listImportBillYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listImportBillYear;
        }
        return null;
    }

    public ObservableList<XYChart.Data<String, Double>> getImportStatistics(ProductInfo productInfo, LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Product> list = adapter.getAllProducts();
        listImportProductInfoDay = FXCollections.observableArrayList();
        if(granularity.equals(StatisticGranularity.Day)){
            listImportProductInfoDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (Product a: list) {
                    if(a.getImportBill().getTime().equals(d)&&a.getProductInfo().equals(productInfo)){
                        cost =cost+a.getImportCost();
                    }
                }
                listImportProductInfoDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listImportProductInfoDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listImportProductInfoMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonthValue()!=toDate.getMonthValue();d=d.plusMonths(1)){
                double cost =0;
                for (Product a: list) {
                    if(a.getImportBill().getTime().getYear()==d.getYear()&&a.getImportBill().getTime().getMonthValue()==d.getMonthValue()&&a.getProductInfo().equals(productInfo)){
                        cost =cost+ a.getImportCost();
                    }
                }
                listImportProductInfoMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listImportProductInfoMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listImportProductInfoQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (Product a: list) {
                    if(a.getImportBill().getTime().getMonthValue()>=d.getMonthValue()&&a.getImportBill().getTime().getMonthValue()<=(d.getMonthValue()+2)&&a.getImportBill().getTime().getYear()==d.getYear()&&a.getProductInfo().equals(productInfo)){
                        cost =cost+ a.getImportCost();
                    }
                }
                listImportProductInfoQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listImportProductInfoQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listImportProductInfoYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (Product a: list) {
                    if(a.getImportBill().getTime().getYear()==d.getYear()&&a.getProductInfo().equals(productInfo)){
                        cost=cost+a.getImportCost();
                    }
                }
                listImportProductInfoYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listImportProductInfoYear;
        }
        return null;
    }

    public ObservableList<XYChart.Data<String, Double>> getSaleStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<SaleBill> list = adapter.getAllSaleBills();
        listSaleBillDay = FXCollections.observableArrayList();
        if(granularity.equals(StatisticGranularity.Day)){
            listSaleBillDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (SaleBill bill: list) {
                    if(d.compareTo(bill.getTime())==0){
                        cost =cost + bill.getPrice();
                    }
                }
                listSaleBillDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listSaleBillDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listSaleBillMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonthValue()!=toDate.getMonthValue();d=d.plusMonths(1)){
                double cost =0;
                for (SaleBill bill: list) {
                    if(d.getMonth()==bill.getTime().getMonth()&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listSaleBillMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listSaleBillMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listSaleBillQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (SaleBill bill: list) {
                    if(d.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(d.getMonthValue()+2)&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listSaleBillQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listSaleBillQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listSaleBillYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (SaleBill bill: list) {
                    if(bill.getTime().getYear()==d.getYear()){
                        cost=cost+bill.getPrice();
                    }
                }
                listSaleBillYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listSaleBillYear;
        }
        return null;
    }

    public ObservableList<XYChart.Data<String, Double>> getSaleStatistics(ProductInfo productInfo, LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<Product> list = adapter.getAllProducts();
        listImportProductInfoDay = FXCollections.observableArrayList();
        if(granularity.equals(StatisticGranularity.Day)){
            listImportProductInfoDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (Product a: list) {
                    if(a.getSaleBill().getTime().equals(d)&&a.getProductInfo().equals(productInfo)){
                        cost =cost+a.getSaleValue();
                    }
                }
                listImportProductInfoDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listImportProductInfoDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listImportProductInfoMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonthValue()!=toDate.getMonthValue();d=d.plusMonths(1)){
                double cost =0;
                for (Product a: list) {
                    if(a.getSaleBill().getTime().getYear()==d.getYear()&&a.getSaleBill().getTime().getMonthValue()==d.getMonthValue()&&a.getProductInfo().equals(productInfo)){
                        cost =cost+ a.getSaleValue();
                    }
                }
                listImportProductInfoMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listImportProductInfoMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listImportProductInfoQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (Product a: list) {
                    if(a.getSaleBill().getTime().getMonthValue()>=d.getMonthValue()&&a.getSaleBill().getTime().getMonthValue()<=(d.getMonthValue()+2)&&a.getSaleBill().getTime().getYear()==d.getYear()&&a.getProductInfo().equals(productInfo)){
                        cost =cost+ a.getSaleValue();
                    }
                }
                listImportProductInfoQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listImportProductInfoQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listImportProductInfoYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (Product a: list) {
                    if(a.getSaleBill().getTime().getYear()==d.getYear()&&a.getProductInfo().equals(productInfo)){
                        cost=cost+a.getSaleValue();
                    }
                }
                listImportProductInfoYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listImportProductInfoYear;
        }
        return null;
    }

    public ObservableList<XYChart.Data<String, Double>> getStaffCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        //chi phi nhan vien
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<StaffBill> list = adapter.getAllStaffBills();
        listStaffCostsStatisticsDay = FXCollections.observableArrayList();
        if(granularity.equals(StatisticGranularity.Day)){
            listStaffCostsStatisticsDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (StaffBill bill: list) {
                    if(d.compareTo(bill.getTime())==0){
                        cost =cost + bill.getPrice();
                    }
                }
                listStaffCostsStatisticsDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listStaffCostsStatisticsDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listStaffCostsStatisticsMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonthValue()!=toDate.getMonthValue();d=d.plusMonths(1)){
                double cost =0;
                for (Bill bill: list) {
                    if(d.getMonth()==bill.getTime().getMonth()&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listStaffCostsStatisticsMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listStaffCostsStatisticsMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listStaffCostsStatisticsQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (Bill bill: list) {
                    if(d.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(d.getMonthValue()+2)&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listStaffCostsStatisticsQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listStaffCostsStatisticsQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listStaffCostsStatisticsYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (Bill bill: list) {
                    if(bill.getTime().getYear()==d.getYear()){
                        cost=cost+bill.getPrice();
                    }
                }
                listStaffCostsStatisticsYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listStaffCostsStatisticsYear;
        }
        return null;
    }
    public ObservableList<XYChart.Data<String, Double>> getSpaceCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        //chi phi mat bang
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<OtherBill> list = adapter.getAllOtherBills();
        listSpaceCostsStatisticsDay = FXCollections.observableArrayList();
        if(granularity.equals(StatisticGranularity.Day)){
            listSpaceCostsStatisticsDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (OtherBill bill: list) {
                    if(bill.getName().equals("Mặt bằng")&&d.compareTo(bill.getTime())==0){
                        cost =cost + bill.getPrice();
                    }
                }
                listSpaceCostsStatisticsDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listSpaceCostsStatisticsDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listSpaceCostsStatisticsMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonthValue()!=toDate.getMonthValue();d=d.plusMonths(1)){
                double cost =0;
                for (Bill bill: list) {
                    if(bill.getName().equals("Mặt bằng")&&d.getMonth()==bill.getTime().getMonth()&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listSpaceCostsStatisticsMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listSpaceCostsStatisticsMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listSpaceCostsStatisticsQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (Bill bill: list) {
                    if(bill.getName().equals("Mặt bằng")&&d.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(d.getMonthValue()+2)&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listSpaceCostsStatisticsQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listSpaceCostsStatisticsQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listSpaceCostsStatisticsYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (Bill bill: list) {
                    if(bill.getName().equals("Mặt bằng")&&bill.getTime().getYear()==d.getYear()){
                        cost=cost+bill.getPrice();
                    }
                }
                listSpaceCostsStatisticsYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listSpaceCostsStatisticsYear;
        }
        return null;
    }
    public ObservableList<XYChart.Data<String, Double>> getTranspotationCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        //chi phi van chuyen
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<OtherBill> list = adapter.getAllOtherBills();
        listTranspotationCostsStatisticsDay = FXCollections.observableArrayList();
        if(granularity.equals(StatisticGranularity.Day)){
            listTranspotationCostsStatisticsDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (OtherBill bill: list) {
                    if(bill.getName().equals("Vận chuyển")&&d.compareTo(bill.getTime())==0){
                        cost =cost + bill.getPrice();
                    }
                }
                listTranspotationCostsStatisticsDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listTranspotationCostsStatisticsDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listTranspotationCostsStatisticsMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonth()!=toDate.getMonth();d=d.plusMonths(1)){
                double cost =0;
                for (Bill bill: list) {
                    if(bill.getName().equals("Vận chuyển")&&d.getMonth()==bill.getTime().getMonth()&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listTranspotationCostsStatisticsMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listTranspotationCostsStatisticsMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listTranspotationCostsStatisticsQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (Bill bill: list) {
                    if(bill.getName().equals("Vận chuyển")&&d.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(d.getMonthValue()+2)&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listTranspotationCostsStatisticsQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listTranspotationCostsStatisticsQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listTranspotationCostsStatisticsYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (Bill bill: list) {
                    if(bill.getName().equals("Vận chuyển")&&bill.getTime().getYear()==d.getYear()){
                        cost=cost+bill.getPrice();
                    }
                }
                listTranspotationCostsStatisticsYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listTranspotationCostsStatisticsYear;
        }
        return null;
    }
    public ObservableList<XYChart.Data<String, Double>> getCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        //chi phi bo ra
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<OtherBill> a = adapter.getAllOtherBills();
        ObservableList<ImportBill> b= adapter.getAllImportBills();
        ObservableList<StaffBill> c = adapter.getAllStaffBills();
        listBillFromDateToDate =FXCollections.observableArrayList();
        listBillFromDateToDate.addAll(a);
        listBillFromDateToDate.addAll(b);
        listBillFromDateToDate.addAll(c);
        if(granularity.equals(StatisticGranularity.Day)){
            listBillFromDateToDateDay =FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.compareTo(toDate.plusDays(1))!=0;d=d.plusDays(1)){
                double cost =0;
                for (Bill bill: listBillFromDateToDate) {
                    if(d.compareTo(bill.getTime())==0){
                        cost =cost + bill.getPrice();
                    }
                }
                listBillFromDateToDateDay.add(new XYChart.Data<>(d+"",cost));
            }
            return listBillFromDateToDateDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listBillFromDateToDateMonth =FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= toDate.getYear()||d.getMonth()!=toDate.getMonth();d=d.plusMonths(1)){
                double cost =0;
                for (Bill bill: listBillFromDateToDate) {
                    if(d.getMonth()==bill.getTime().getMonth()&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listBillFromDateToDateMonth.add(new XYChart.Data<>(d.getMonthValue()+"/"+d.getYear()+"",cost));
            }
            return listBillFromDateToDateMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listBillFromDateToDateQuarter=FXCollections.observableArrayList();
            for (LocalDate d =fromDate;d.getYear()!= (toDate.getYear())||d.getMonthValue()!=(toDate.getMonthValue()+3);d=d.plusMonths(3)){
                double cost =0;
                for (Bill bill: listBillFromDateToDate) {
                    if(d.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(d.getMonthValue()+2)&&d.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                listBillFromDateToDateQuarter.add(new XYChart.Data<>("Quarter "+(d.getMonthValue()/3+1)+"/"+d.getYear(),cost));
            }
            return listBillFromDateToDateQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listBillFromDateToDateYear=FXCollections.observableArrayList();
            for(LocalDate d=fromDate;d.getYear()!=(toDate.getYear()+1);d=d.plusYears(1)){
                double cost =0;
                for (Bill bill: listBillFromDateToDate) {
                    if(bill.getTime().getYear()==d.getYear()){
                        cost=cost+bill.getPrice();
                    }
                }
                listBillFromDateToDateYear.add(new XYChart.Data<>(d.getYear()+"",cost));
            }
            return listBillFromDateToDateYear;
        }
        return null;
    }
    public ObservableList<XYChart.Data<String, Double>> getRevenueStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        //doanh thu
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<OtherBill> a = adapter.getAllOtherBills();
        ObservableList<ImportBill> b= adapter.getAllImportBills();
        ObservableList<StaffBill> c = adapter.getAllStaffBills();
        ObservableList<SaleBill> d = adapter.getAllSaleBills();
        listBillCostFromDateToDate =FXCollections.observableArrayList();
        listBillProfitFromDateToDate=FXCollections.observableArrayList();
        listBillCostFromDateToDate.addAll(a);
        listBillCostFromDateToDate.addAll(b);
        listBillCostFromDateToDate.addAll(c);
        listBillProfitFromDateToDate.addAll(d);
        if(granularity.equals(StatisticGranularity.Day)){
            listBillProfitFromDateToDateDay =FXCollections.observableArrayList();
            for(LocalDate ld=fromDate;ld.compareTo(toDate)!=0;ld=ld.plusDays(1)){
                double cost =0;
                double profit=0;
                for (Bill bill: listBillCostFromDateToDate) {
                    if(ld.compareTo(bill.getTime())==0){
                        cost =cost + bill.getPrice();
                    }
                }
                for(Bill bill: listBillProfitFromDateToDate){
                    if(ld.compareTo(bill.getTime())==0){
                        profit=profit+ bill.getPrice();
                    }
                }
                System.out.println(profit-cost);
                listBillProfitFromDateToDateDay.add(new XYChart.Data<>(d+"",profit-cost));
            }
            return listBillProfitFromDateToDateDay;
        }else if(granularity.equals(StatisticGranularity.Month)){
            listBillProfitFromDateToDateMonth =FXCollections.observableArrayList();
            for (LocalDate ld =fromDate;ld.getYear()!= toDate.getYear()||ld.getMonthValue()!=(toDate.getMonthValue()+1);ld=ld.plusMonths(1)){
                double cost =0;
                double profit=0;
                for (Bill bill: listBillCostFromDateToDate) {
                    if(ld.getMonth()==bill.getTime().getMonth()&&ld.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                for (Bill bill: listBillProfitFromDateToDate) {
                    if(ld.getMonth()==bill.getTime().getMonth()&&ld.getYear()==bill.getTime().getYear()){
                        profit =profit+ bill.getPrice();
                    }
                }
                listBillProfitFromDateToDateMonth.add(new XYChart.Data<>(ld.getMonthValue()+"/"+ld.getYear(),profit-cost));
            }
            return listBillProfitFromDateToDateMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listBillProfitFromDateToDateQuarter=FXCollections.observableArrayList();
            for (LocalDate ld =fromDate;ld.getYear()!= toDate.getYear()||ld.getMonthValue()!=(toDate.getMonthValue()+3);ld=ld.plusMonths(3)){
                double cost =0;
                double profit=0;
                for (Bill bill: listBillCostFromDateToDate) {
                    if(ld.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(ld.getMonthValue()+2)&&ld.getYear()==bill.getTime().getYear()){
                        cost =cost+ bill.getPrice();
                    }
                }
                for (Bill bill: listBillProfitFromDateToDate) {
                    if(ld.getMonthValue()<=bill.getTime().getMonthValue()&&bill.getTime().getMonthValue()<=(ld.getMonthValue()+2)&&ld.getYear()==bill.getTime().getYear()){
                        profit =profit+ bill.getPrice();
                    }
                }
                listBillProfitFromDateToDateQuarter.add(new XYChart.Data<>((ld.getMonthValue()/3+1)+"/"+ld.getYear(),profit-cost));
            }
            return listBillProfitFromDateToDateQuarter;
        }else if(granularity.equals(StatisticGranularity.Year)){
            listBillProfitFromDateToDateYear=FXCollections.observableArrayList();
            for(LocalDate ld=fromDate;ld.getYear()!=(toDate.getYear()+1);ld=ld.plusYears(1)){
                double cost =0;
                double profit=0;
                for (Bill bill: listBillCostFromDateToDate) {
                    if(bill.getTime().getYear()==ld.getYear()){
                        cost=cost+bill.getPrice();
                    }
                }
                for (Bill bill: listBillProfitFromDateToDate) {
                    if(bill.getTime().getYear()==ld.getYear()){
                        profit=profit+bill.getPrice();
                    }
                }
                listBillProfitFromDateToDateYear.add(new XYChart.Data<>(ld.getYear()+"",profit-cost));
            }
            return listBillProfitFromDateToDateYear;

        }
        return null;
    }
    public ObservableList<PieChart.Data> getAllTypesOfCostsStatistics(LocalDate fromDate, LocalDate toDate) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        listBill=FXCollections.observableArrayList();
        ObservableList<OtherBill> a = adapter.getAllOtherBills();
        ObservableList<ImportBill> b= adapter.getAllImportBills();
        ObservableList<StaffBill> c = adapter.getAllStaffBills();
        ObservableList<SaleBill> d = adapter.getAllSaleBills();
        double costSale =0;
        double costSpace =0;
        double costStaff =0;
        double costTranSport =0;
        double costImport =0;
        for(LocalDate ld=fromDate;ld.compareTo(toDate)!=0;ld=ld.plusDays(1) ){
            //Vận chuyển

            for (OtherBill ob:a) {
                if(ob.getName().equals("Vận chuyển")&&ob.getTime().compareTo(ld)==0){
                    costTranSport = costTranSport+ob.getPrice();
                }
            }

            //Mặt bằng

            for (OtherBill ob:a) {
                if(ob.getName().equals("Mặt bằng")&&ob.getTime().compareTo(ld)==0){
                    costSpace = costSpace+ob.getPrice();
                }
            }

            //Chi phí nhân viên

            for (StaffBill sb:c) {
                if(sb.getTime().compareTo(ld)==0){
                    costStaff = costStaff+sb.getPrice();
                }
            }
            //Chi phí nhập hàng

            for (ImportBill ib:b) {
                if(ib.getTime().compareTo(ld)==0){
                    costImport = costImport+ib.getPrice();
                }
            }

            //Số lượng hàng bán được
            for (SaleBill sbl:d) {
                if(sbl.getTime().compareTo(ld)==0){
                    costSale = costSale+sbl.getPrice();
                }
            }

        }
        listBill.add(new PieChart.Data("Mặt bằng",costSpace));
        listBill.add(new PieChart.Data("nhân viên",costStaff));
        listBill.add(new PieChart.Data("nhập hàng",costImport));
        listBill.add(new PieChart.Data("Vận chuyển",costTranSport));
        listBill.add(new PieChart.Data("bán được",costSale));
        return listBill;
    }
}