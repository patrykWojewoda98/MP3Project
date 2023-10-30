package org.example.controls;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControlsPaneController {

    @FXML
    private Button nextButton;

    @FXML
    private Button playStopButton;

    @FXML
    private Button previusButton;
    @FXML
    AddMiusicPaneController addMiusicPaneController;

   public void initialize(){
       nextButton.setOnAction(actionEvent -> {
           System.err.println("kliknięto!");
       });


   }

}
