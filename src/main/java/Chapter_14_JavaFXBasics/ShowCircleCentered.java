package Chapter_14_JavaFXBasics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// Class demonstrates the use of Property Binding to fix the circle to centre of pane no matter whether the window is resized.

public class ShowCircleCentered extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the circle
        Pane pane = new Pane();

        // Create a circle and set its properties
        Circle circle1 = new Circle();
        circle1.centerXProperty().bind(pane.widthProperty().divide(2));      // bind properties
        circle1.centerYProperty().bind(pane.heightProperty().divide(2));     // bind properties
        circle1.setRadius(50);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);
        pane.getChildren().add(circle1);    // Add the circle to the pane

        // Create a scene and place it in the scene
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Show Circle Centered");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
