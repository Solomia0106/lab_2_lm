package org.example.lab_2_lm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class OtherLabs {

    @FXML
    private ImageView imageView;

    @FXML
    private Button choose;


    @FXML
    private Label labelText;

    private final Image secondImage = new Image(Objects.requireNonNull(
            getClass().getResourceAsStream("/org/example/lab_2_lm/Image/winter.jpg")
    ));


    @FXML
    private void OpenSecondLabs(ActionEvent event) {
        imageView.setImage(secondImage);
        labelText.setText("Ви успішно змінили картинку!");
        choose.setDisable(true);
    }


}
