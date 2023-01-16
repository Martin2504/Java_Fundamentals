package Chapter_15_EventDrivenProgrammingAndAnimations;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Class demonstrates the use of lambda expressions to simplify event handling

public class LambdaHandlerDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Text text = new Text(40, 40, "Programming is fun");
        Pane pane = new Pane(text);

        // Hold four buttons in an HBox
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        HBox hBox = new HBox(btUp, btDown, btLeft, btRight);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(hBox);

        // Create and register the handlers
        btUp.setOnAction((ActionEvent e) -> {                       // Lambda handler
            text.setY(text.getY() > 10 ? text.getY() - 5 : 10);     // Would have previously been an inner class
        });
        btDown.setOnAction((e) -> {                                 // Lambda handler
            text.setY(text.getY() < pane.getHeight() ?
                    text.getY() + 5 : pane.getHeight());
        });
        btLeft.setOnAction(e -> {                                   // Lambda handler
            text.setX(text.getX() > 0 ? text.getX() - 5 : 0);
        });
        btRight.setOnAction(e ->                                    // Lambda handler
                text.setX(text.getX() < pane.getWidth() - 100 ?
                        text.getX() + 5 : pane.getWidth() - 100)
        );

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle("AnonymousHandlerDemo"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}