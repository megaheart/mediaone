package com.shopkeeper.mediaone.models;

import java.time.LocalDate;

public interface IBill {
    // ----------- << method.annotations@AAAAAAGAg9lfTVJENPE= >>
    // ----------- >>
    String getName();
    // ----------- << method.annotations@AAAAAAGAg9qx7VJQ6yQ= >>
    // ----------- >>
    BillType getBillType();
    // ----------- << method.annotations@AAAAAAGAg952L2BvAnk= >>
    // ----------- >>
    double getPrice();
    // ----------- << method.annotations@AAAAAAGAg9+ThmB+lZ8= >>
    // ----------- >>
    int getBillId();
    // ----------- << method.annotations@AAAAAAGAg+CozmCbsL0= >>
    // ----------- >>
    LocalDate getTime();
    // ----------- << method.annotations@AAAAAAGAg+KKLWC4GcM= >>
    // ----------- >>
    boolean getIsEffected();
    // ----------- << method.annotations@AAAAAAGAg+QiVmDYWF4= >>
    // ----------- >>
    String getNote();
// ----------- << interface.extras@AAAAAAGAgzbV/FBSND4= >>
// ----------- >>
}