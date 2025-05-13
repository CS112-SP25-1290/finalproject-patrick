package edu.miracosta.cs112.finalproject.finalproject.controller;

import edu.miracosta.cs112.finalproject.finalproject.Model.GameState;
import edu.miracosta.cs112.finalproject.finalproject.Model.LevelLockedException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;

public class MapController extends BaseController {

    @FXML private Button level1Btn;
    @FXML private Button level2Btn;
    @FXML private Button level3Btn;
    @FXML private Label  errorLabel;

    private final GameState gameState = GameState.getInstance();

    @FXML
    public void initialize() {
        updateButtonStates();
    }
    // Checks to see if previous level complete before unlocking
    @FXML
    private void onSelectLevel1() {
        try {
            selectLevel(1);
        } catch (LevelLockedException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void onSelectLevel2() {
        try {
            selectLevel(2);
        } catch (LevelLockedException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void onSelectLevel3() {
        try {
            selectLevel(3);
        } catch (LevelLockedException e) {
            showError(e.getMessage());
        }
    }

    private void selectLevel(int level) throws LevelLockedException {
        if (!gameState.isLevelUnlocked(level)) {
            throw new LevelLockedException("Complete Owens River first to unlock " +
                    getLocationName(level) + "!");
        }

        gameState.setCurrentLevel(level);
        errorLabel.setText("");

        try {
            switchTo("Cast.fxml");
        } catch (Exception e) {
            e.printStackTrace();
            showError("Error loading game screen");
        }
    }

    private String getLocationName(int level) {
        return switch (level) {
            case 1 -> "Owens River";
            case 2 -> "Silver Creek";
            case 3 -> "Hot Creek";
            default -> "Unknown Location";
        };
    }

    private void showError(String message) {
        errorLabel.setText(message);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Level Locked");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updateButtonStates() {
        // Visual feedback for locked levels
        level2Btn.setOpacity(gameState.isLevelUnlocked(2) ? 1.0 : 0.5);
        level3Btn.setOpacity(gameState.isLevelUnlocked(3) ? 1.0 : 0.5);
    }
}