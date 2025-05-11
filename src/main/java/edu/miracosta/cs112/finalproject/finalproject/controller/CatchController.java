package edu.miracosta.cs112.finalproject.finalproject.controller;

import edu.miracosta.cs112.finalproject.finalproject.Model.Fish;
import edu.miracosta.cs112.finalproject.finalproject.Model.GameState;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controller for the post-catch screen.
 */
public class CatchController extends BaseController {

    @FXML private ImageView fishImage;
    @FXML private Label speciesLabel;
    @FXML private Label weightLabel;
    @FXML private Label descLabel;

    private Fish caughtFish;
    private final GameState gameState = GameState.getInstance();

    @FXML
    public void initialize() {
        // initialization done in initData()
    }

    /**
     * Inject the fish instance and populate the UI.
     */
    public void initData(Fish fish) {
        this.caughtFish = fish;

        // Mark current level as complete when fish is caught
        gameState.completeLevel(gameState.getCurrentLevel());

        // Build resource name
        String key = fish.getSpecies().split(" ")[0].toLowerCase();
        String imgPath = "/images/" + key + "_Caught.png";

        try {
            fishImage.setImage(new Image(
                    getClass().getResourceAsStream(imgPath)
            ));
        } catch (Exception e) {
            System.err.println("Could not load fish image: " + imgPath);
        }

        speciesLabel.setText(fish.getSpecies());

        // Show weight with size category
        double weight = fish.getWeight();
        String sizeCategory = getSizeCategory(weight);
        weightLabel.setText(String.format("Weight: %.1f lbs - %s", weight, sizeCategory));

        // Add catch location to description
        String location = gameState.getLocation();
        descLabel.setText(fish.getDescription() + "\n\nCaught at: " + location);
    }

    private String getSizeCategory(double weight) {
        if (weight < 1.5) return "Small";
        else if (weight < 3.0) return "Average";
        else if (weight < 5.0) return "Large";
        else return "Trophy Size!";
    }

    @FXML
    private void onRestart() {
        try {
            switchTo("Map.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onExit() {
        System.exit(0);
    }
}