package org.example.lab_2_lm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TestController {

    // ===== CheckBox =====
    @FXML private CheckBox ch4;
    @FXML private CheckBox ch7;
    @FXML private CheckBox ch10;
    @FXML private CheckBox ch24;
    @FXML private Label lblCheckBoxResult;

    // ===== ChoiceBox =====
    @FXML private ChoiceBox<String> choiceDiv;
    @FXML private Label lblChoiceResult;

    // ===== ComboBox =====
    @FXML private ComboBox<String> comboRoot;
    @FXML private Label lblComboResult;

    // ===== RadioButton =====
    @FXML private RadioButton rb45;
    @FXML private RadioButton rb90;
    @FXML private RadioButton rb120;
    @FXML private RadioButton rb60;
    private ToggleGroup radioGroup;
    @FXML private Label lblRadioResult;

    // ===== Total =====
    @FXML private Label lblTotal;

    @FXML
    public void initialize() {
        // ChoiceBox без значення за замовчуванням
        choiceDiv.getItems().addAll("Правильно", "Неправильно");

        // ComboBox без значення за замовчуванням
        comboRoot.getItems().addAll("8", "9", "10");

        // RadioButton ToggleGroup
        radioGroup = new ToggleGroup();
        rb45.setToggleGroup(radioGroup);
        rb90.setToggleGroup(radioGroup);
        rb120.setToggleGroup(radioGroup);
    }


    @FXML
    void checkAnswer(ActionEvent event) {
        String result;
        if (ch4.isSelected() && ch10.isSelected() && ch24.isSelected() && !ch7.isSelected()) {
            result = "Відповідь правильна!";
        } else {
            result = "Відповідь неправильна!";
        }
        lblCheckBoxResult.setText(result);
    }

    @FXML
    void checkChoiceAnswer(ActionEvent event) {
        String selected = choiceDiv.getValue();
        if (selected == null) {
            lblChoiceResult.setText("Ви не обрали відповідь!");
            return;
        }
        if ("Правильно".equals(selected)) {
            lblChoiceResult.setText("Відповідь правильна!");
        } else {
            lblChoiceResult.setText("Відповідь неправильна!");
        }
    }

    @FXML
    void checkComboAnswer(ActionEvent event) {
        String selected = comboRoot.getValue();
        if (selected == null) {
            lblComboResult.setText("Ви не обрали відповідь!");
            return;
        }
        if ("9".equals(selected)) {
            lblComboResult.setText("Відповідь правильна!");
        } else {
            lblComboResult.setText("Відповідь неправильна!");
        }
    }

    @FXML
    void checkRadioAnswer(ActionEvent event) {
        RadioButton selected = (RadioButton) radioGroup.getSelectedToggle();
        if (selected != null && selected.equals(rb90)) {
            lblRadioResult.setText("Відповідь правильна!");
        } else {
            lblRadioResult.setText("Відповідь неправильна!");
        }
    }


    @FXML
    void showTotal(ActionEvent event) {
        int score = 0;
        if (ch4.isSelected() && ch10.isSelected() && ch24.isSelected() && !ch7.isSelected()) score++;
        if ("Правильно".equals(choiceDiv.getValue())) score++;
        if ("9".equals(comboRoot.getValue())) score++;
        if (rb90.isSelected()) score++;

        lblTotal.setText("Ваш загальний бал: " + score + " / 4");
    }
}
