package Chapter_14_JavaFXBasics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Class demonstrates the use of the image and showimage classes to represent a graphical image

public class ShowImage extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage){
        // Create pane to hold the image views
        Pane pane = new HBox(10);       // Create HBox
        pane.setPadding(new Insets(5,5,5,5));
        Image image = new Image("images/UsFlag.png");    // Create an image
        pane.getChildren().add(new ImageView(image));   // add an image view to pane

        ImageView imageView2 = new ImageView(image);    // Create an image view
        imageView2.setFitHeight(100);                   // Set image view properties
        imageView2.setFitWidth(100);
        pane.getChildren().add(imageView2);             // Add an image to pane

        ImageView imageView3 = new ImageView(image);    // Create an image view
        imageView3.setRotate(90);                       // Rotate an image view
        pane.getChildren().add(imageView3);             // Add an image to pane

        // Create a scene and place it in the page
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

