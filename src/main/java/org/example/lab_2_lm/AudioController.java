package org.example.lab_2_lm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AudioController implements Initializable {

    @FXML
    private Slider volume;

    @FXML
    private ProgressBar audioProgress;

    @FXML
    private Label label_audio;

    private File[] files;
    private ArrayList<File> songs = new ArrayList<>();
    private Media media;
    private MediaPlayer mediaPlayer;
    private int songNumber = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // ---------- Завантаження музики з resources/music ----------
        URL musicFolderURL = getClass().getResource("music");
        if (musicFolderURL == null) {
            System.out.println("❌ Не знайдено папку music у resources!");
            return;
        }

        File folder = new File(musicFolderURL.getPath());
        files = folder.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.getName().endsWith(".mp3") || f.getName().endsWith(".wav")) {
                    songs.add(f);
                }
            }
        }

        if (songs.isEmpty()) {
            System.out.println("❌ У папці music немає аудіофайлів!");
            return;
        }

        // ---------- Створення Media і MediaPlayer ----------
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        label_audio.setText(songs.get(songNumber).getName());

        // ---------- Регулювання гучності ----------
        volume.valueProperty().addListener((obs, oldVal, newVal) ->
                mediaPlayer.setVolume(volume.getValue() * 0.01)
        );
    }

    // ---------- КНОПКИ ----------

    @FXML
    void play(ActionEvent event) {
        mediaPlayer.play();
        label_audio.setText(songs.get(songNumber).getName());
    }

    @FXML
    void pause(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    void next(ActionEvent event) {

        if (songNumber < songs.size() - 1)
            songNumber++;
        else
            songNumber = 0;

        mediaPlayer.stop();

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        label_audio.setText(songs.get(songNumber).getName());
    }

    @FXML
    void previous(ActionEvent event) {

        if (songNumber > 0)
            songNumber--;
        else
            songNumber = songs.size() - 1;

        mediaPlayer.stop();

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        label_audio.setText(songs.get(songNumber).getName());
    }
}
