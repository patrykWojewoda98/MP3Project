package org.example.controls;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddMiusicPaneController {

    @FXML
    private Button addSongButton;

    @FXML
    private VBox addSongPaneVBox;

    @FXML
    private TextField localizacionTextField;

    @FXML
    private TextField titleTextField;

    private PlayList playList;


    public static PlayList myPlayList = new PlayList();

    public PlayList getMyPlayList() {
        return myPlayList;
    }



    public void initialize() {
    addSongButton.setOnAction(actionEvent -> {


        myPlayList.addMiusicToPlayList(titleTextField.getText(),localizacionTextField.getText());
        titleTextField.setText("");
        localizacionTextField.setText("");

    });
    }

}
