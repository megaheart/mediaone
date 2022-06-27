package com.shopkeeper.linh.windowfactories.utilities;

import com.shopkeeper.linh.models.Feedback;
import com.shopkeeper.linh.models.Staff;
import com.shopkeeper.linh.windowfactories.feedback.FeedbackListViewItemController;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;

public class StaffToStringCell extends ListCell<Staff> {
    @Override
    public void updateItem(Staff data, boolean empty)
    {
        if (empty || data == null) {
            setText(null);
            setGraphic(null);
            return;
        }
        super.updateItem(data, empty);

        if(data != null)
        {
            setText(String.format("%s [%d]",
                    data.getName(),
                    data.getStaffId()
            ));
        }
    }
}
