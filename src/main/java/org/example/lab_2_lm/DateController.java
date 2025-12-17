package org.example.lab_2_lm;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateController {
    @FXML
    private Label dateLabel;
    @FXML
    private DatePicker myDatePicker;

    @FXML
    private ColorPicker myColorPicker;
    @FXML
    private Slider mySlider;

    @FXML
    private Label sliderLabel;
    private int score;

    @FXML
    private AnchorPane scenePane;
    @FXML
    void getDate(ActionEvent event) {

        LocalDate myDate = myDatePicker.getValue();
        System.out.println(myDate.toString());
        String dateFormatter = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        dateLabel.setText(dateFormatter);
    }

    @FXML
    void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue();
        scenePane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
    }
    @FXML
    private void openWin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("image.1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                score = (int) mySlider.getValue();
                sliderLabel.setText(score + " балів");
            }
        });

    }


}
