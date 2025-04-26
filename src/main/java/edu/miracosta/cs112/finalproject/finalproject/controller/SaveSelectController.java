package edu.miracosta.cs112.finalproject.finalproject.controller;

import javafx.fxml.FXML;
public class SaveSelectController extends BaseController {
    @FXML private void onSlot1() throws Exception { switchTo("WorldMap.fxml"); }
    @FXML private void onBack()  throws Exception { switchTo("Start.fxml"); }
}