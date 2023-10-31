package org.example.controls;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.TreeSet;

public class ControlsPaneController extends AddMiusicPaneController {

    @FXML
    private Button nextButton;

    @FXML
    private Button playButton;

    @FXML
    private Button previusButton;

    @FXML
    private Button stopButton;


    private TreeSet<Miusic> myMiusic;
    private Miusic currentMiusic;
    private Thread playerThread;

    public void initialize() {
        nextButton.setOnAction(actionEvent -> {
            System.err.println("kliknięto!");
        });

        playButton.setOnAction(actionEvent -> {
            myMiusic = myPlayList.getPlayList();
            currentMiusic = myMiusic.first();
            File myMiusicFile = new File(currentMiusic.getLocalization());

            playerThread = new Thread(() -> {
                Player player = null;
                try {
                    player = new Player(new FileInputStream(myMiusicFile));
                    player.play();
                } catch (JavaLayerException | FileNotFoundException e) {
                    System.err.println("Wystąpił błąd podczas odtwarzania pliku mp3.");
                    e.printStackTrace();
                } finally {
                    if (player != null) {
                        player.close();
                    }
                }
            });
            playerThread.start();
        });

        stopButton.setOnAction(actionEvent -> {
            //trzeba wymyślić jak zatrzymać odtwarzanie muzyki
        });
    }
}
