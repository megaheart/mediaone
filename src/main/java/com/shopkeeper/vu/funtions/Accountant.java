package com.shopkeeper.vu.funtions;

import com.shopkeeper.lam.models.Product;
import com.shopkeeper.lam.models.ProductInfo;
import com.shopkeeper.linh.models.SaleBill;
import com.shopkeeper.mediaone.database.DatabaseAdapter;
import com.shopkeeper.mediaone.models.Bill;
import com.shopkeeper.minh.functions.BillManager;
import com.shopkeeper.minh.models.ImportBill;
import com.shopkeeper.minh.models.OtherBill;
import com.shopkeeper.minh.models.StaffBill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;

public class Accountant {
    private int countMonth;
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

    ObservableList<XYChart.Data<String, Double>> test;

    private int endMonth;
    private int startMonth;
    private int startYear;
    private int endYear;


    public ObservableList<XYChart.Data<String, Double>> getImportStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<ImportBill> list = adapter.getAllImportBills();
        listImportBillDay = FXCollections.observableArrayList();
        listImportBillMonth = FXCollections.observableArrayList();
        if (granularity.equals(StatisticGranularity.Day)) {
            for (ImportBill a : list) {
                int b = a.getTime().compareTo(fromDate);
                int c = toDate.compareTo(a.getTime());
                if (b >= 0 && c >= 0) {
                    listImportBillDay.add(new XYChart.Data<>(a.getTime() + "", a.getPrice()));
                }
            }
            return listImportBillDay;
        } else if (granularity.equals(StatisticGranularity.Month)) {
            listImportBillMonth = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            endMonth = toDate.getMonthValue();
            while (countMonth > 0) {
                double profitMonth = 0;
                for (ImportBill a : list) {
                    if (a.getTime().getMonthValue() == (startMonth % 12) && a.getTime().getYear() == (startYear + countMonth / 12)) {
                        profitMonth = profitMonth + a.getPrice();
                    }
                }
                int newYear = (startYear + startMonth / 12);
                int newMonth = ((startMonth - 1) % 12 + 1);
                listImportBillMonth.add(new XYChart.Data<>(newMonth + "/" + newYear, profitMonth));
                countMonth--;
                startMonth++;
            }
            return listImportBillMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listImportBillQuarter = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            while (countMonth > 0) {
                double profitQuarter = 0;
                for (ImportBill a : list) {
                    if ((startMonth % 12) <= a.getTime().getMonthValue() && a.getTime().getMonthValue() <= (startMonth + 2) % 12) {
                        profitQuarter = profitQuarter + a.getPrice();
                    }
                }
                int newYear = startYear + startMonth / 12;
                int newQuarter = ((startMonth + 2) / 3 - 1) % 4 + 1;
                listImportBillQuarter.add(new XYChart.Data<>("Quarter " + newQuarter + "/" + newYear, profitQuarter));
                startMonth = startMonth + 3;
                countMonth = countMonth - 3;
            }
            return listImportBillQuarter;
        } else if (granularity.equals(StatisticGranularity.Year)) {
            listImportBillYear = FXCollections.observableArrayList();
            startYear = fromDate.getYear();
            endYear = toDate.getYear();
            while (endYear >= startYear) {
                double profitYear = 0;
                for (ImportBill a : list) {
                    if (a.getTime().getYear() == startYear) {
                        profitYear = profitYear + a.getPrice();
                    }
                }
                listImportBillYear.add(new XYChart.Data<>(startYear + "", profitYear));
                startYear++;
            }
            return listImportBillYear;
        } else {
            return null;
        }
    }

    public ObservableList<XYChart.Data<String, Double>> getImportStatistics(ProductInfo productInfo, LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        listImportProductInfoDay = FXCollections.observableArrayList();
        ObservableList<Product> list = adapter.getAllProducts();
        if (granularity.equals(StatisticGranularity.Day)) {
            for (Product a : list) {
                int b = a.getImportBill().getTime().compareTo(fromDate);
                int c = toDate.compareTo(a.getImportBill().getTime());
                if (productInfo.equals(a.getProductInfo()) && b >= 0 && c >= 0) {
                    listImportProductInfoDay.add(new XYChart.Data<>(a.getImportBill().getTime() + "", a.getImportCost()));
                }
                return listImportProductInfoDay;
            }
        } else if (granularity.equals(StatisticGranularity.Month)) {
            listImportProductInfoMonth = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            endMonth = toDate.getMonthValue();
            while (countMonth > 0) {
                double profitMonth = 0;
                for (Product a : list) {
                    if (productInfo.equals(a.getProductInfo()) && a.getImportBill().getTime().getMonthValue() == (startMonth % 12) && a.getImportBill().getTime().getYear() == (startYear + countMonth / 12)) {
                        profitMonth = profitMonth + a.getImportCost();
                    }
                }
                int newYear = (startYear + startMonth / 12);
                int newMonth = ((startMonth - 1) % 12 + 1);
                listImportProductInfoMonth.add(new XYChart.Data<>(newMonth + "/" + newYear, profitMonth));
                countMonth--;
                startMonth++;
            }
            return listImportProductInfoMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listImportProductInfoQuarter = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            while (countMonth > 0) {
                double profitQuarter = 0;
                for (Product a : list) {
                    if (productInfo.equals(a.getProductInfo()) && (startMonth % 12) <= a.getImportBill().getTime().getMonthValue() && a.getImportBill().getTime().getMonthValue() <= (startMonth + 2) % 12) {
                        profitQuarter = profitQuarter + a.getImportCost();
                    }
                }
                int newYear = startYear + startMonth / 12;
                int newQuarter = ((startMonth + 2) / 3 - 1) % 4 + 1;
                listImportProductInfoQuarter.add(new XYChart.Data<>("Quarter " + newQuarter + "/" + newYear, profitQuarter));
                startMonth = startMonth + 3;
                countMonth = countMonth - 3;
            }
            return listImportProductInfoQuarter;
        } else if (granularity.equals(StatisticGranularity.Year)) {
            listImportProductInfoYear = FXCollections.observableArrayList();
            startYear = fromDate.getYear();
            endYear = toDate.getYear();
            while (endYear >= startYear) {
                double profitYear = 0;
                for (Product a : list) {
                    if (productInfo.equals(a.getProductInfo()) && a.getImportBill().getTime().getYear() == startYear) {
                        profitYear = profitYear + a.getImportCost();
                    }
                }
                listImportProductInfoYear.add(new XYChart.Data<>(startYear + "", profitYear));
                startYear++;
            }
            return listImportProductInfoYear;
        }
        return null;
    }

    public ObservableList<XYChart.Data<String, Double>> getSaleStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<SaleBill> list = adapter.getAllSaleBills();
        listSaleBillDay = FXCollections.observableArrayList();
        if (granularity.equals(StatisticGranularity.Day)) {
            for (SaleBill a : list) {
                int b = a.getTime().compareTo(fromDate);
                int c = toDate.compareTo(a.getTime());
                if (b >= 0 && c >= 0) {
                    listSaleBillDay.add(new XYChart.Data<>(a.getTime() + "", a.getPrice()));
                }
            }
            return listSaleBillDay;
        } else if (granularity.equals(StatisticGranularity.Month)) {
            listSaleBillMonth = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            endMonth = toDate.getMonthValue();
            while (countMonth > 0) {
                double profitMonth = 0;
                for (SaleBill a : list) {
                    if (a.getTime().getMonthValue() == (startMonth % 12) && a.getTime().getYear() == (startYear + countMonth / 12)) {
                        profitMonth = profitMonth + a.getPrice();
                    }
                }
                int newYear = (startYear + startMonth / 12);
                int newMonth = ((startMonth - 1) % 12 + 1);
                listSaleBillMonth.add(new XYChart.Data<>(newMonth + "/" + newYear, profitMonth));
                countMonth--;
                startMonth++;
            }
            return listSaleBillMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listSaleBillQuarter = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            while (countMonth > 0) {
                double profitQuarter = 0;
                for (SaleBill a : list) {
                    if ((startMonth % 12) <= a.getTime().getMonthValue() && a.getTime().getMonthValue() <= (startMonth + 2) % 12) {
                        profitQuarter = profitQuarter + a.getPrice();
                    }
                }
                int newYear = startYear + startMonth / 12;
                int newQuarter = ((startMonth + 2) / 3 - 1) % 4 + 1;
                listSaleBillQuarter.add(new XYChart.Data<>("Quarter " + newQuarter + "/" + newYear, profitQuarter));
                startMonth = startMonth + 3;
                countMonth = countMonth - 3;
            }
            return listSaleBillQuarter;
        } else if (granularity.equals(StatisticGranularity.Year)) {
            listSaleBillYear = FXCollections.observableArrayList();
            startYear = fromDate.getYear();
            endYear = toDate.getYear();
            while (endYear >= startYear) {
                double profitYear = 0;
                for (SaleBill a : list) {
                    if (a.getTime().getYear() == startYear) {
                        profitYear = profitYear + a.getPrice();
                    }
                }
                listSaleBillYear.add(new XYChart.Data<>(startYear + "", profitYear));
                startYear++;
            }
            return listSaleBillYear;
        } else {
            return null;
        }
    }

    public ObservableList<XYChart.Data<String, Double>> getSaleStatistics(ProductInfo productInfo, LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        listSaleProductInfoDay = FXCollections.observableArrayList();
        ObservableList<Product> list = adapter.getAllProducts();
        if (granularity.equals(StatisticGranularity.Day)) {
            for (Product a : list) {
                int b = a.getSaleBill().getTime().compareTo(fromDate);
                int c = toDate.compareTo(a.getSaleBill().getTime());
                if (productInfo.equals(a.getProductInfo()) && b >= 0 && c >= 0) {
                    listSaleProductInfoDay.add(new XYChart.Data<>(a.getSaleBill().getTime() + "", a.getSaleValue()));
                }
                return listSaleProductInfoDay;
            }
        } else if (granularity.equals(StatisticGranularity.Month)) {
            listSaleProductInfoMonth = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            endMonth = toDate.getMonthValue();
            while (countMonth > 0) {
                double profitMonth = 0;
                for (Product a : list) {
                    if (productInfo.equals(a.getProductInfo()) && a.getSaleBill().getTime().getMonthValue() == (startMonth % 12) && a.getSaleBill().getTime().getYear() == (startYear + countMonth / 12)) {
                        profitMonth = profitMonth + a.getSaleValue();
                    }
                }
                int newYear = (startYear + startMonth / 12);
                int newMonth = ((startMonth - 1) % 12 + 1);
                listSaleProductInfoMonth.add(new XYChart.Data<>(newMonth + "/" + newYear, profitMonth));
                countMonth--;
                startMonth++;
            }
            return listSaleProductInfoMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listSaleProductInfoQuarter = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            while (countMonth > 0) {
                double profitQuarter = 0;
                for (Product a : list) {
                    if (productInfo.equals(a.getProductInfo()) && (startMonth % 12) <= a.getSaleBill().getTime().getMonthValue() && a.getSaleBill().getTime().getMonthValue() <= (startMonth + 2) % 12) {
                        profitQuarter = profitQuarter + a.getSaleValue();
                    }
                }
                int newYear = startYear + startMonth / 12;
                int newQuarter = ((startMonth + 2) / 3 - 1) % 4 + 1;
                listSaleProductInfoQuarter.add(new XYChart.Data<>("Quarter " + newQuarter + "/" + newYear, profitQuarter));
                startMonth = startMonth + 3;
                countMonth = countMonth - 3;
            }
            return listSaleProductInfoQuarter;
        } else if (granularity.equals(StatisticGranularity.Year)) {
            listSaleProductInfoYear = FXCollections.observableArrayList();
            startYear = fromDate.getYear();
            endYear = toDate.getYear();
            while (endYear >= startYear) {
                double profitYear = 0;
                for (Product a : list) {
                    if (productInfo.equals(a.getProductInfo()) && a.getSaleBill().getTime().getYear() == startYear) {
                        profitYear = profitYear + a.getSaleValue();
                    }
                }
                listSaleProductInfoYear.add(new XYChart.Data<>(startYear + "", profitYear));
                startYear++;
            }
            return listSaleProductInfoYear;
        }
        return null;
    }

    public ObservableList<XYChart.Data<String, Double>> getStaffCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        var adapter = DatabaseAdapter.getDbAdapter();
        ObservableList<StaffBill> list = adapter.getAllStaffBills();
        listStaffCostsStatisticsDay = FXCollections.observableArrayList();
        if (granularity.equals(StatisticGranularity.Day)) {
            for (StaffBill a : list) {
                int b = a.getTime().compareTo(fromDate);
                int c = toDate.compareTo(a.getTime());
                if (b >= 0 && c >= 0) {
                    listStaffCostsStatisticsDay.add(new XYChart.Data<>(a.getTime() + "", a.getPrice()));
                }
            }
            return listStaffCostsStatisticsDay;
        } else if (granularity.equals(StatisticGranularity.Month)) {
            listStaffCostsStatisticsMonth = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            endMonth = toDate.getMonthValue();
            while (countMonth > 0) {
                double profitMonth = 0;
                for (StaffBill a : list) {
                    if (a.getTime().getMonthValue() == (startMonth % 12) && a.getTime().getYear() == (startYear + countMonth / 12)) {
                        profitMonth = profitMonth + a.getPrice();
                    }
                }
                int newYear = (startYear + startMonth / 12);
                int newMonth = ((startMonth - 1) % 12 + 1);
                listStaffCostsStatisticsMonth.add(new XYChart.Data<>(newMonth + "/" + newYear, profitMonth));
                countMonth--;
                startMonth++;
            }
            return listStaffCostsStatisticsMonth;
        } else if (granularity.equals(StatisticGranularity.Quarter)) {
            listStaffCostsStatisticsQuarter = FXCollections.observableArrayList();
            countMonth = (toDate.getYear() - fromDate.getYear() - 1) * 12 + 13 + toDate.getMonthValue() - fromDate.getMonthValue();
            startYear = fromDate.getYear();
            startMonth = fromDate.getMonthValue();
            while (countMonth > 0) {
                double profitQuarter = 0;
                for (StaffBill a : list) {
                    if ((startMonth % 12) <= a.getTime().getMonthValue() && a.getTime().getMonthValue() <= (startMonth + 2) % 12) {
                        profitQuarter = profitQuarter + a.getPrice();
                    }
                }
                int newYear = startYear + startMonth / 12;
                int newQuarter = ((startMonth + 2) / 3 - 1) % 4 + 1;
                listStaffCostsStatisticsQuarter.add(new XYChart.Data<>("Quarter " + newQuarter + "/" + newYear, profitQuarter));
                startMonth = startMonth + 3;
                countMonth = countMonth - 3;
            }
            return listStaffCostsStatisticsQuarter;
        } else if (granularity.equals(StatisticGranularity.Year)) {
            listStaffCostsStatisticsYear = FXCollections.observableArrayList();
            startYear = fromDate.getYear();
            endYear = toDate.getYear();
            while (endYear >= startYear) {
                double profitYear = 0;
                for (StaffBill a : list) {
                    if (a.getTime().getYear() == startYear) {
                        profitYear = profitYear + a.getPrice();
                    }
                }
                listStaffCostsStatisticsYear.add(new XYChart.Data<>(startYear + "", profitYear));
                startYear++;
            }
            return listStaffCostsStatisticsYear;
        } else {
            return null;
        }
    }
    public ObservableList<XYChart.Data<String, Double>> getSpaceCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity){
        //chi phi mat ban
        return null;
    }
    public ObservableList<XYChart.Data<String, Double>> getTranspotationCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity){
        //chi phi van chuyen
        return null;
    }
    public ObservableList<XYChart.Data<String, Double>> getCostsStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity) throws Exception {
        //chi phi bo ra
        BillManager m =new BillManager();
        test = FXCollections.observableArrayList();
        ObservableList<ImportBill> a = m.getImportBills(fromDate,toDate);
        ObservableList<StaffBill> b = m.getStaffBills(fromDate,toDate);
        ObservableList<OtherBill> d = m.getOtherBills(fromDate,toDate);

        return null;
    }
    public ObservableList<XYChart.Data<String, Double>> getRevenueStatistics(LocalDate fromDate, LocalDate toDate, StatisticGranularity granularity){
        //doanh thu
        return null;
    }
}