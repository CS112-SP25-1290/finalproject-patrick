
package edu.miracosta.cs112.finalproject.finalproject.controller;

import edu.miracosta.cs112.finalproject.finalproject.MainApp;
import edu.miracosta.cs112.finalproject.finalproject.Model.Fish;
import edu.miracosta.cs112.finalproject.finalproject.Model.RainbowTrout;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Controller for fighting screen with dynamic instructions.
 */
public class FightController extends BaseController {

    @FXML private ProgressBar fightBar;
    @FXML private Button slackBtn;
    @FXML private Button tensionBtn;
    @FXML private Label instructionLabel;
    @FXML private Label feedbackLabel;
    @FXML private ImageView streamView;

    private Fish currentFish;
    private int correctActions = 0;
    private int wrongActions = 0;

    @FXML
    public void initialize() {
        // Create a fish with random weight (base weight 2.5 lbs)
        currentFish = new RainbowTrout(2.5, true);

        // Load the stream background image
        try {
            streamView.setImage(new Image(getClass().getResourceAsStream("/images/stream.png")));
        } catch (Exception e) {
            System.err.println("Could not load stream image: " + e.getMessage());
        }

        // Initialize the UI
        fightBar.setProgress(0);
        slackBtn.setDisable(false);
        tensionBtn.setDisable(false);

        // Show initial fight behavior
        updateFishBehavior();

        // Listen for "full" -> transition to Catch screen
        fightBar.progressProperty().addListener(
                (ObservableValue<? extends Number> obs, Number oldV, Number newV) -> {
                    if (newV.doubleValue() >= 1.0) {
                        showCatchScreen();
                    }
                }
        );
    }

    @FXML
    private void onSlack() {
        handlePlayerAction("Slack");
    }

    @FXML
    private void onTension() {
        handlePlayerAction("Tension");
    }

    private void handlePlayerAction(String action) {
        boolean correct = currentFish.isCorrectAction(action);

        if (correct) {
            correctActions++;
            feedbackLabel.setText("Good move! Keep it up!");
            feedbackLabel.setTextFill(Color.GREEN);

            // Progress based on fish weight, heavier fish are harder
            double progressIncrease = 0.2 - (currentFish.getWeight() / 50.0);
            progressIncrease = Math.max(0.1, progressIncrease); // Minimum progress

            fightBar.setProgress(Math.min(1.0, fightBar.getProgress() + progressIncrease));
        } else {
            wrongActions++;
            feedbackLabel.setText("Wrong choice! The fish is getting away!");
            feedbackLabel.setTextFill(Color.RED);

            // Lose some progress for wrong moves
            fightBar.setProgress(Math.max(0, fightBar.getProgress() - 0.1));

            // Too many wrong moves = fish escapes
            if (wrongActions > 5) {
                showFishEscaped();
                return;
            }
        }

        // Show next behavior
        slackBtn.setDisable(true);
        tensionBtn.setDisable(true);

        // Use Timeline for delay
        javafx.animation.Timeline timeline = new javafx.animation.Timeline(
                new javafx.animation.KeyFrame(
                        javafx.util.Duration.seconds(1.5),
                        e -> {
                            updateFishBehavior();
                            slackBtn.setDisable(false);
                            tensionBtn.setDisable(false);
                        }
                )
        );
        timeline.play();
    }

    private void updateFishBehavior() {
        String behavior = currentFish.fightBehavior();
        instructionLabel.setText(behavior);
        feedbackLabel.setText(""); // Clear previous feedback
    }

    private void showFishEscaped() {
        instructionLabel.setText("The fish escaped! Better luck next time.");
        feedbackLabel.setText("");
        slackBtn.setDisable(true);
        tensionBtn.setDisable(true);

        // Return to cast screen after delay
        javafx.animation.Timeline timeline = new javafx.animation.Timeline(
                new javafx.animation.KeyFrame(
                        javafx.util.Duration.seconds(2),
                        e -> {
                            try {
                                switchTo("Cast.fxml");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                )
        );
        timeline.play();
    }

    /**
     * Load Catch.fxml and pass the caught fish data.
     */
    private void showCatchScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    MainApp.class.getResource("/fxml/Catch.fxml")
            );
            Parent root = loader.load();

            // Pass the caught fish with its random weight
            CatchController ctrl = loader.getController();
            ctrl.setStage(getStage());
            ctrl.initData(currentFish);

            Scene scene = new Scene(root);
            getStage().setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}