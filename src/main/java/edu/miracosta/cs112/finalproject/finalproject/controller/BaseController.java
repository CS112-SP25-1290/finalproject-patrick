package edu.miracosta.cs112.finalproject.finalproject.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.miracosta.cs112.finalproject.finalproject.MainApp;

public abstract class BaseController {
    protected Stage stage;
    public void setStage(Stage stage) { this.stage = stage; }
    protected void switchTo(String fxml) throws Exception {
        stage.setScene(MainApp.loadScene(fxml));
    }
}
