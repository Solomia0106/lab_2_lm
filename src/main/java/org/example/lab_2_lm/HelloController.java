package org.example.lab_2_lm;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnOther;

    @FXML
    void openNewWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lab_2_2_lm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 600, 200));
            stage.setTitle("Edit");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnAdd.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteRecord() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Видалення");
        alert.setHeaderText("Увага!");
        alert.setContentText("Видалення може призвести до зміни порядку осіб у Адресній книзі!");
        alert.showAndWait();
    }

    @FXML
    void search() {
        System.out.println("Пошук...");
    }

    @FXML
    public void initialize() {
        btnOther.setOnAction(event -> openOtherLabsWindow());
    }

    private void openOtherLabsWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OtherLabs.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 600, 400));
            stage.setTitle("OtherLabs");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnOther.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}