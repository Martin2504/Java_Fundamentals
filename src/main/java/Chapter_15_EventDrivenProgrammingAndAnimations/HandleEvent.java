package Chapter_15_EventDrivenProgrammingAndAnimations;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Class demonstrates simple event handling

public class HandleEvent extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage){
        // Create a pane and set its properties
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button btOK = new Button("OK");                          // Create source object
        Button btCancel = new Button("Cancel");                  // Create source object

        OKHandlerClass handler1 = new OKHandlerClass();             // Create Handler object
        btOK.setOnAction(handler1);                                 // Register Handler object
        CancelHandlerClass handler2 = new CancelHandlerClass();     // Create Handler object
        btCancel.setOnAction(handler2);                             // Register Handler object
        pane.getChildren().addAll(btOK, btCancel);                  // Add buttons to the pane

        // Create a new scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    class OKHandlerClass implements EventHandler<ActionEvent>{      // Handler class for OK button (NESTED/INNER CLASS)
        @Override
        public void handle(ActionEvent e){                  // Handle event
            System.out.println("OK button Clicked");
        }
    }

    class CancelHandlerClass implements EventHandler<ActionEvent>{  // Handler class for Cancel button
        @Override
        public void handle(ActionEvent e){                  // Handle event
            System.out.println("Cancel button clicked");
        }
    }
}
