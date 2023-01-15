package Chapter_14_JavaFXBasics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

// Class to demonstrate the use of pane's in a scene.

/* ADD THIS TO THE VM OPTIONS:
--module-path "C:\Users\44793\javafx-sdk-19\lib" --add-modules=javafx.controls
 */

public class ButtonInPane extends Application{

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage){
        // Create a scene and place the button in the scene.
        StackPane pane = new StackPane();       // create pane
        pane.getChildren().add(new Button("Button1"));      // add a button as a child of the pane
        Scene scene = new Scene(pane, 200, 50);     // add pane to scene
        primaryStage.setTitle("Button in a pane");      // Set the stage title
        primaryStage.setScene(scene);       // Place the scene in the stage
        primaryStage.show();        // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
