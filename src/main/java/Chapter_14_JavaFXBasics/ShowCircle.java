package Chapter_14_JavaFXBasics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// Class to demonstrate how to display a circle in the centre of a pane

public class ShowCircle extends Application {

    @Override
    public void start(Stage primaryStage){
        // Create a circle and se its properties
        Circle circle1 = new Circle();
        circle1.setCenterX(100);
        circle1.setCenterY(100);
        circle1.setRadius(50);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);

        // Create a pane to hold the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle1);    // add circle to the pane

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Show circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
