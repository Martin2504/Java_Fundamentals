package Chapter_16_JavaFXUIControlsAndMultimedia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

// Class demonstrates the use of checkboxes to change text font

public class CheckBoxDemo extends ButtonDemo {
    @Override //Override the getPane() method in super class
    protected BorderPane getPane(){
        BorderPane pane = super.getPane();      // invoke super.getPane()

        // create fonts
        Font fontBoldItalic = Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman",
                FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times New Roman",
                FontWeight.NORMAL, FontPosture.REGULAR, 20);

        text.setFont(fontNormal);       // set starting font

        // create a pane for checkboxes
        VBox paneForCheckBoxes = new VBox(20);  // VBox (vertical box) lays out its children in a column
        paneForCheckBoxes.setPadding(new Insets(5,5,5,5));
        paneForCheckBoxes.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2, 2, 2, 2))));
        pane.setRight(paneForCheckBoxes);       // putting the VBox on the right of the pane

        // create check boxes
        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");
        paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);

        // create event handlers for the checkboxes
        EventHandler<ActionEvent> handler = e -> {
            if (chkBold.isSelected() && chkItalic.isSelected()) {
                text.setFont(fontBoldItalic);   // Both checkboxes checked
            }
            else if (chkBold.isSelected()) {
                text.setFont(fontBold);         // Bold checkbox is selected
            }
            else if (chkItalic.isSelected()) {
                text.setFont(fontItalic);       // Italic checkbox is selected
            }
            else {
                text.setFont(fontNormal);       // No checkboxes selected
            }
        };

        // set handlers for action (assign the event handler to the appropriate actions)
        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        return pane; // Return a new pane
    }
}
