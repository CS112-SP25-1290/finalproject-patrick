package edu.miracosta.cs112.finalproject.finalproject.controller;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

/**
 * Controller for the Start screen (New Game / Exit).
 */
public class StartController extends BaseController {

    private MediaPlayer mediaPlayer;
    // I 100% used AI for help to get the sound working just a heads up
    @FXML
    private void initialize() {
        // 1. The file must be on the **runtime** classpath, so the path starts with “/”
        String path = "/audio/PATRON & NICO BARAN speedy 70.mp3";
        Media media = new Media(Objects.requireNonNull(
                getClass().getResource(path)).toExternalForm());

        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // loop forever
        mediaPlayer.play();
    }

    @FXML
    private void onNew() throws Exception {
        mediaPlayer.stop();           // stop music before loading the map
        switchTo("Map.fxml");
    }

    @FXML
    private void onExit() {
        mediaPlayer.stop();
        System.exit(0);
    }
}