package org.example.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPaneController {

    @FXML
    ControlsPaneController controlsPaneController;

    @FXML
    private ImageView mainImagineView;

    @FXML
    private MenuBar mainMenuBar;

    @FXML
    private ListView playListListView;

    @FXML
    private MenuItem AddMiusicMenuItem;
    @FXML
    private MenuItem RefreshListButton;

    @FXML
    private AddMiusicPaneController addMiusicPaneController;
    ObservableList<Miusic> items;



    public void initialize(){
        AddMiusicMenuItem.setOnAction(actionEvent -> {
            // Tworzymy nowe okno/widok dodawania muzyki
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addMiusicPane.fxml"));
            Parent root;
            try {
                root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Dodawanie Muzyki");
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        RefreshListButton.setOnAction(actionEvent -> {
            // Odświeżanie listy
            items = playListListView.getItems();
            items.clear();
            playListListView.getItems().addAll(addMiusicPaneController.getMyPlayList().getPlayList());
            System.out.println(addMiusicPaneController.getMyPlayList().getPlayList());

        });


    }
}
