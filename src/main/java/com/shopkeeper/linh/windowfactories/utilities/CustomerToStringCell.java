package com.shopkeeper.linh.windowfactories.utilities;

import com.shopkeeper.linh.models.Customer;
import com.shopkeeper.linh.models.SaleBill;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;

public class CustomerToStringCell extends ListCell<Customer> {
    @Override
    public void updateItem(Customer data, boolean empty)
    {
        if (empty || data == null) {
            setText(null);
            setGraphic(null);
            return;
        }
        super.updateItem(data, empty);
        setText(data.getName());

    }
}
