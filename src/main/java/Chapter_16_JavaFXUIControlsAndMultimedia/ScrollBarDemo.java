package Chapter_16_JavaFXUIControlsAndMultimedia;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

// Class demonstrates the use of a scroll bar
// ScrollBar is a control that enables the user to select from a range of values.

public class ScrollBarDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX Programming");

        ScrollBar sbHorizontal = new ScrollBar();       // Horizontal ScrollBar
        ScrollBar sbVertical = new ScrollBar();         // Vertical ScrollBar
        sbVertical.setOrientation(Orientation.VERTICAL);

        // Create a text in a pane
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);        // add text to pane

        // Create a border pane to hold text and scroll bars
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setRight(sbVertical);
        pane.setBottom(sbHorizontal);

        // Create a listener for horizontal scroll bar value change
        sbHorizontal.valueProperty().addListener(ov -> text.setX(sbHorizontal.getValue()
                * paneForText.getWidth() / sbHorizontal.getMax()));     // set new location for text

        // Create a listener for vertical scroll bar value change
        sbVertical.valueProperty().addListener(ov -> text.setY(sbVertical.getValue()
                * paneForText.getHeight() / sbVertical.getMax()));      // set new location for text

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ScrollBarDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

