package edu.miracosta.cs112.finalproject.finalproject.controller;

import edu.miracosta.cs112.finalproject.finalproject.MainApp;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Common functionality for all screen controllers:
 *  - holds a reference to the primary Stage
 *  - provides switchTo(...) for scene changes
 */
public abstract class BaseController {
    private Stage stage;

    /**
     * Called by MainApp right after FXMLLoader.load(),
     * so each controller knows the primary Stage.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * For subclasses to grab the current Stage.
     */
    protected Stage getStage() {
        return stage;
    }

    /**
     * Swap to another FXML scene by name.
     * @param fxmlName the file under /fxml/, e.g. "Map.fxml"
     */
    protected void switchTo(String fxmlName) throws Exception {
        Scene scene = MainApp.loadScene(fxmlName);
        stage.setScene(scene);
    }
}