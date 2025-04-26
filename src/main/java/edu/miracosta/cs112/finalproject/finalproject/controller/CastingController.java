package edu.miracosta.cs112.finalproject.finalproject.controller;

import javafx.fxml.FXML;
public class CastingController extends BaseController {
    @FXML private void onCast() throws Exception  { switchTo("Fight.fxml"); }
    @FXML private void onBack() throws Exception  { switchTo("WorldMap.fxml"); }
}
