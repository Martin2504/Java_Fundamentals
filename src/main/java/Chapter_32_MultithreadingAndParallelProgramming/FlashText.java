package Chapter_32_MultithreadingAndParallelProgramming;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Demonstrates the use of threads to display flashing text on a label

/* You can use a thread to control an animation and run the code in JavaFX GUI thread
using the Platform.runLater method.  */

/* ADD THIS TO THE VM OPTIONS:
--module-path "C:\Users\44793\javafx-sdk-19\lib" --add-modules=javafx.controls
 */

public class FlashText extends Application {
    private String text = "";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage){
        StackPane pane = new StackPane();
        Label lblText = new Label("Programming is fun!");           // create a label
        pane.getChildren().add(lblText);                               // label in a pane

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (lblText.getText().trim().length() == 0)
                            text = "Welcome";                           //  sets a text in the label if the label is blank
                        else
                            text = "";                                  // sets its text blank if the label has a text

                        Platform.runLater(new Runnable() {              // Run from JavaFX GUI
                            @Override
                            public void run() {
                                lblText.setText(text);                  // update GUI
                            }
                        });
                        Thread.sleep(200);
                    }
                } catch (InterruptedException ex) {}
            }
        }).start();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("FlashText"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
