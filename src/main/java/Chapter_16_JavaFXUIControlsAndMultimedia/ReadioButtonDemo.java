package Chapter_16_JavaFXUIControlsAndMultimedia;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

// Class demonstrates the use of radio buttons to change color of text
// Radio buttons enable you to choose a single item from a group of choices.

public class ReadioButtonDemo extends CheckBoxDemo {
    @Override // Override the getPane() method in super class
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5,5,5,5));
        paneForRadioButtons.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2, 2, 2, 2))));
        pane.setLeft(paneForRadioButtons); // putting the VBox on the left of the pane

        // create radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);

        // create an instance of ToggleGroup to group radio buttons (only one can be toggled at a time)
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);

        // create the event handlers for radio buttons
        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });
        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });
        rbBlue.setOnAction(e -> {
            if (rbBlue.isSelected()) {
                text.setFill(Color.BLUE);
            }
        });

        return pane;
    }
}
