module org.example.lab_2_lm {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab_2_lm to javafx.fxml;
    exports org.example.lab_2_lm;
}