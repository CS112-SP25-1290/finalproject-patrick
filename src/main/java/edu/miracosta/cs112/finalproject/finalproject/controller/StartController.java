package edu.miracosta.cs112.finalproject.finalproject.controller;

import javafx.fxml.FXML;

/**
 * Controller for the Start screen (New Game / Exit).
 */
public class StartController extends BaseController {

    @FXML
    private void onNew() throws Exception {
        switchTo("Map.fxml");
    }

    @FXML
    private void onExit() {
        System.exit(0);
    }
}