package Chapter_15_EventDrivenProgrammingAndAnimations;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// Class demonstrates how to enlarge/shrink a circle using event handling.
// Also demonstrates the use of inner classes and anonymous inner classes.

public class ControlCircle extends Application{
    private CirclePane circlePane = new CirclePane();       // creating a new instance of CirclePane

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage){
        // Hold 2 buttons in a HBox
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().addAll(btEnlarge, btShrink);

        // Create and register the handlers
        btEnlarge.setOnAction(new EnlargeHandler());
//        btShrink.setOnAction(new ShrinkHandler());
        btShrink.setOnAction(new EventHandler<ActionEvent>() {   // Anonymous Inner class, meaning we can comment line 58 onwards.
            @Override
            public void handle(ActionEvent e){
                circlePane.shrink();
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }


    class EnlargeHandler implements EventHandler<ActionEvent> {     // Handler class (NESTED/INNER CLASS)
        @Override
        public void handle(ActionEvent e){
            circlePane.enlarge();
        }
    }

//    class ShrinkHandler implements EventHandler<ActionEvent> {      // Handler class
//        @Override
//        public void handle(ActionEvent e){
//            circlePane.shrink();
//        }
//    }
}

class CirclePane extends StackPane {
    private Circle circle = new Circle(50);     // Creating an instance of Circle

    public CirclePane(){
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink() {
        circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
    }
}

