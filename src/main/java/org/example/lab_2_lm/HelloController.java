package org.example.lab_2_lm;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Button btnSearch;
    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<Person> tableAddressBook;
    @FXML
    private TableColumn<Person, String> columnPIP;
    @FXML
    private TableColumn<Person, String> columnPhone;
    @FXML
    private Label labelCount;
    @FXML
    private Button btnText;

    private final CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    public void initialize() {
        columnPIP.setCellValueFactory(new PropertyValueFactory<>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());

        addressBookImpl.getPersonList().addListener((ListChangeListener<Person>) c -> updateCountLabel());
        updateCountLabel();

        btnOther.setOnAction(event -> openOtherLabsWindow());
    }

    private void updateCountLabel() {
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }

    @FXML
    void openWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lab_2_2_lm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.setTitle("Додати/Редагувати");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnAdd.getScene().getWindow());

            EditController editController = loader.getController();
            Person selectedPerson = tableAddressBook.getSelectionModel().getSelectedItem();

            if (btnEdit.isArmed() && selectedPerson != null) {
                editController.setPerson(selectedPerson);
            } else {
                Person newPerson = new Person("", "");
                editController.setPerson(newPerson);
                stage.showAndWait();
                if (newPerson.getPip() != null && !newPerson.getPip().isEmpty()) {
                    addressBookImpl.add(newPerson);
                }
                updateCountLabel();
                return;
            }

            stage.showAndWait();
            tableAddressBook.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteRecord() {
        Person selected = tableAddressBook.getSelectionModel().getSelectedItem();
        if (selected != null) {
            addressBookImpl.delete(selected);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Увага!");
            alert.setHeaderText(null);
            alert.setContentText("Виберіть запис для видалення!");
            alert.showAndWait();
        }
    }

    @FXML
    void search() {
        String searchText = txtSearch.getText().toLowerCase().trim();
        if (searchText.isEmpty()) {
            tableAddressBook.setItems(addressBookImpl.getPersonList());
        } else {
            var filteredList = addressBookImpl.getPersonList().filtered(
                    p -> p.getPip().toLowerCase().contains(searchText) ||
                            p.getPhone().toLowerCase().contains(searchText)
            );
            tableAddressBook.setItems(filteredList);
        }
    }

    private void openOtherLabsWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OtherLabs.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 600, 400));
            stage.setTitle("Інші лабораторні");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnOther.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void openTextWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lab_6.fxml")); // твій FXML
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 800, 600));
            stage.setTitle("Тест");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnText.getScene().getWindow()); // батьківське вікно
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
