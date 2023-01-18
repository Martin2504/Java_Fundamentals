package Chapter_16_JavaFXUIControlsAndMultimedia;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

// Class demonstrates the use of a ComboBox (choice list) to let the user choose a country

public class ComboBoxDemo extends Application {
    // Declare an array of Strings for flag titles
    private String[] flagTitles = {"USA", "China", "Denmark"};

    // Declare an ImageView array for the national flags of the 3 countries
    private ImageView[] flagImage = {
            new ImageView("images/UsFlag.png"),
            new ImageView("images/ChinaFlag.png"),
            new ImageView("images/DenmarkFlag.png"),
    };

    // Declare an array of string for flag descriptions
    private String[] flagDescription = new String[9];

    // Declare and create a description pane
    private DescriptionPane descriptionPane = new DescriptionPane();       // description

    // Create a combo box for selecting countries
    private ComboBox<String> cbo = new ComboBox<>(); // flagTitles

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Set text description
        flagDescription[0] = "The US national flag ... ";
        flagDescription[1] = "Description for China ... ";
        flagDescription[2] = "Description for Denmark ... ";

        // Set the first country (US) for display
        setDisplay(0);

        // Add combo box and description pane to the border pane
        BorderPane pane = new BorderPane();

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("US");     // set combo box value

        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);   // observable list
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        // Display the selected country
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ComboBoxDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Set display information on the description pane
     */
    public void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }
}