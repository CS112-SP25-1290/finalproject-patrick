package edu.miracosta.cs112.finalproject.finalproject.controller;


import java.util.Random;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

/**
 * Handles Cast/Reel logic.
 */
public class CastController extends BaseController {
    @FXML private Button castBtn;
    @FXML private Button reelInBtn;

    private final Random rng = new Random();

    @FXML
    private void onCast() throws Exception {
        boolean hooked = rng.nextBoolean();
        if (hooked) {
            switchTo("Fight.fxml");
        } else {
            castBtn.setText("Missed! Cast Again");
        }
    }

    @FXML
    private void onReel() {
        castBtn.setText("Cast");
    }

    @FXML
    private void onBack() throws Exception {
        switchTo("Map.fxml");
    }
}