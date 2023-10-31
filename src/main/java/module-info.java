module ProjektMP3 {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires jlayer;

    exports org.example.main;
    exports org.example.controls;
    opens org.example.controls to javafx.fxml;



}