package Chapter_16_JavaFXUIControlsAndMultimedia;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

// Class demonstrates the use of buttons to control the movement of a text

public class ButtonDemo extends Application {
    protected Text text = new Text(50,50,"JavaFX Programming");

    protected BorderPane getPane() {
        HBox paneForButtons = new HBox(50); // HBox (horizontal box) lays out its children in a row
        Button btLeft = new Button("Left", new ImageView("images/LeftButton.png"));         // create button
        Button btRight = new Button("Right", new ImageView("images/RightButton.png"));
        paneForButtons.getChildren().addAll(btLeft, btRight);   // add buttons to HBox pane
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setBorder(new Border(new BorderStroke(Color.GREEN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2, 2, 2, 2))));

        BorderPane pane = new BorderPane();         // create a border pane
        pane.setBottom(paneForButtons);             // add buttons in HBox to the bottom

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));   // add action handlers
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
