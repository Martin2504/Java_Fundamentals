package Chapter_16_JavaFXUIControlsAndMultimedia;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

// Class demonstrates the use of Media to play/pause a video and change the volume

public class MediaDemo extends Application {
    private static final String MEDIA_URL = "media/sample.mp4";      // import the media

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Media media = new Media(MEDIA_URL);                 // Create a media
        MediaPlayer mediaPlayer = new MediaPlayer(media);   // Create a media player
        MediaView mediaView = new MediaView(mediaPlayer);   // Create a media view

        Button playButton = new Button(">");            // Create a play/pause button
        // add handler for button action
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();         // play media
                playButton.setText("||");
            } else {
                mediaPlayer.pause();        // pause media
                playButton.setText(">");
            }
        });

        Button rewindButton = new Button("<<");     // Create a rewind button
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));     // Create a handler for rewinding

        // Create a slider for volume
        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);      // set current volume
        mediaPlayer.volumeProperty().bind(slVolume.valueProperty().divide(100));    // bind volume with slider

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton, new Label("Volume"), slVolume);     // add buttons and slider to HBox

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("MediaDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }


}
