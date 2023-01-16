package Chapter_15_EventDrivenProgrammingAndAnimations;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

// Class demonstrates the use of path transitions to create animations

public class PathTransitionDemo extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        // Create a rectangle
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.ORANGE);

        // Create a circle
        Circle circle = new Circle(125, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Add circle and rectangle to the pane
        pane.getChildren().add(circle);
        pane.getChildren().add(rectangle);

        // Create a path transition
        PathTransition pt = new PathTransition();  // Create an instance of PathTransition  (there are many transitions)
        pt.setDuration(Duration.millis(10000));      // Set transition duration (speed at which the transition will execute)
        pt.setPath(circle);         // Set path in transition
        pt.setNode(rectangle);      // Set node in transition
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);      // Set cycle count indefinite
        pt.setAutoReverse(true);        // Set auto reverse true
        pt.play();      // Play animation

        circle.setOnMousePressed(e -> pt.pause());      // Pause animation
        circle.setOnMouseReleased(e -> pt.play());      // Resume animation

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("PathTransitionDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }
}