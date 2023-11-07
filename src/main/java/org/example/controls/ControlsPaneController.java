package org.example.controls;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class ControlsPaneController extends AddMiusicPaneController {

    @FXML
    private Button nextButton;

    @FXML
    private Button playButton;

    @FXML
    private Button jumpToBeginingOfPlayList;

    @FXML
    private Button stopButton;


    private Miusic currentMiusic;
    private Thread playerThread;
    private Player player = null;
    Iterator<Miusic> miusicIterator;


    public void initialize() {

        nextButton.setOnAction(actionEvent -> {
            if (miusicIterator==null){
                miusicIterator = myPlayList.getMiusicIterator();
            }
            if(miusicIterator.hasNext()) {
                currentMiusic = miusicIterator.next();
                System.out.println(currentMiusic);
            }else {
                System.out.println("Nie ma już następnego elemętu");
            }
        });

        jumpToBeginingOfPlayList.setOnAction(actionEvent -> {
            miusicIterator=myPlayList.getMiusicIterator();
            System.out.println("Przeskoczono do początu playlisty");

        });



        playButton.setOnAction(actionEvent -> {

            playerThread = new Thread(() -> {
                try {
                    File myMiusicFile = new File(currentMiusic.getLocalization());
                    player = new Player(new FileInputStream(myMiusicFile));
                    player.play();
                } catch (JavaLayerException | FileNotFoundException e) {
                    System.err.println("Wystąpił błąd podczas odtwarzania pliku mp3.");
                    e.printStackTrace();
                }catch (NullPointerException e){
                    System.err.println("Nie wybrałeś żadnego utworu z listy.");
                    System.err.println("Najpierw dodaj utwór do listy a następnie kliknij przycisk Next");
                }
                finally {
                    if (player != null) {
                        player.close();
                    }
                }
            });
            playerThread.start();
        });

        stopButton.setOnAction(actionEvent -> {
            player.close();
        });
    }
}
