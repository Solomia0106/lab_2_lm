package org.example.lab_2_lm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaController implements Initializable {

    @FXML
    private Button pauseButton;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("src/main/resources/org/example/lab_2_lm/video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaView.setMediaPlayer(mediaPlayer);
    }

    @FXML
    void playButton_method(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    void pauseButton_method(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    void resetButton_method(ActionEvent event) { // реалізація кнопки Reset
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();
        }


    }
    @FXML
    private void openWin1(ActionEvent event) throws IOException {
        URL fxmlUrl = getClass().getResource("/org/example/lab_2_lm/AudioPlayer.fxml");
        if (fxmlUrl == null) {
            System.out.println("AudioPlayer.fxml не знайдено!");
            return;
        }
        Parent root = FXMLLoader.load(fxmlUrl);
        Stage stage = new Stage();
        stage.setTitle("audio Player");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
