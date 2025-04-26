package edu.miracosta.cs112.finalproject.finalproject.controller;

import javafx.fxml.FXML;

public class StartController extends BaseController {
    @FXML private void onNew() throws Exception  { switchTo("SaveSelect.fxml"); }
    @FXML private void onLoad() throws Exception { switchTo("SaveSelect.fxml"); }
}
