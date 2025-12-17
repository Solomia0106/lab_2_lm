module org.example.lab_2_lm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example.lab_2_lm to javafx.fxml;
    exports org.example.lab_2_lm;
}