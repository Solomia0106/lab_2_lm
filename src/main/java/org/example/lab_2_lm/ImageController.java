package org.example.lab_2_lm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class ImageController {
    @FXML
    private Button btnOpen;
    @FXML
    private ImageView imgView;
    @FXML
    private AnchorPane scenePane;

    @FXML
    void filechooser(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Get image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("image", "*.png"));
        Stage stage = (Stage) scenePane.getScene().getWindow();

        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            URI uri = file.toURI();
            Image image = new Image(uri.toString());
            imgView.setImage(image);
        }


    }

    @FXML
    private void openWin1(ActionEvent event) throws IOException {
        URL fxmlUrl = getClass().getResource("/org/example/lab_2_lm/media.fxml");
        if (fxmlUrl == null) {
            System.out.println("media.fxml не знайдено!");
            return;
        }
        Parent root = FXMLLoader.load(fxmlUrl);
        Stage stage = new Stage();
        stage.setTitle("Media Player");
        stage.setScene(new Scene(root));
        stage.show();
    }

}