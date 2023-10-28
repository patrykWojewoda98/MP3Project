module ProjektMP3 {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    exports org.example.main;
    exports org.example.controls;
    opens org.example.controls to javafx.fxml;



}