package Chapter_16_JavaFXUIControlsAndMultimedia;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

// Class demonstrates the use of sliders to move text around
// Slider is similar to ScrollBar, but Slider has more properties and can appear in many forms

public class SliderDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX Programming");

        Slider slHorizontal = new Slider();     // Horizontal slider
        slHorizontal.setShowTickLabels(true);   // set slider properties
        slHorizontal.setShowTickMarks(true);

        Slider slVertical = new Slider();       // Vertical slider
        slVertical.setOrientation(Orientation.VERTICAL); // default = horizontal
        slVertical.setShowTickLabels(true);   // set slider properties
        slVertical.setShowTickMarks(true);
        slVertical.setValue(100);             // default = 0

        // Create a text in a pane
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);    // add text to pane

        // Create a border pane to hold the text and scroll bars
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(slHorizontal);
        pane.setRight(slVertical);

        // create handlers with listeners
        slHorizontal.valueProperty().addListener(ov ->
                text.setX(slHorizontal.getValue() * paneForText.getWidth() / slHorizontal.getMax()));       // set new X coordinate for text
        slVertical.valueProperty().addListener(ov ->
                text.setY(slVertical.getMax() - slVertical.getValue() * paneForText.getHeight() / slVertical.getMax()));          // set new Y coordinate for text

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("SliderDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
}
