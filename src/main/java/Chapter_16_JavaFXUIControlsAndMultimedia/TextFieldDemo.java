package Chapter_16_JavaFXUIControlsAndMultimedia;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

// Class demonstrates the use of TextFields to type desired text to screen

public class TextFieldDemo extends ReadioButtonDemo {
    @Override // Override the getPane() method in super class
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();          // invoke super.getPane()

        BorderPane paneForTextField = new BorderPane(); // create a pane for the text field and label
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2, 2, 2, 2))));
        paneForTextField.setLeft(new Label("Enter a new message : "));
        pane.setTop(paneForTextField);      // putting the border pane on the top of the pane

        // create the text field
        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);     // add text field to the pane

        // handle the text field action
        tf.setOnAction(e -> text.setText(tf.getText()));

        return pane;
    }
}
