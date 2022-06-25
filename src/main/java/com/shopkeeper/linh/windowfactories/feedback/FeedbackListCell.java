package com.shopkeeper.linh.windowfactories.feedback;

import com.shopkeeper.linh.models.Feedback;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

public class FeedbackListCell extends ListCell<Feedback> {
    @Override
    public void updateItem(Feedback data, boolean empty)
    {
        if (empty || data == null) {
            setText(null);
            setGraphic(null);
            return;
        }
        super.updateItem(data, empty);

        if(data != null)
        {
            BorderPane container = FeedbackListViewItemController.getBorderPane(data);
            setGraphic(container);
        }
    }
}
