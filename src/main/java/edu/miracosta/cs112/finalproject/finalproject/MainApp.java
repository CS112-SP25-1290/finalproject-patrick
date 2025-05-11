package edu.miracosta.cs112.finalproject.finalproject;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.miracosta.cs112.finalproject.finalproject.controller.BaseController;

public class MainApp extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        stage.setTitle("Sierra Trout Quest");

        stage.setScene(loadScene("Start.fxml"));
        stage.show();
    }

    /** Utility that every controller can use to jump screens */
    public static Scene loadScene(String fxmlName) throws Exception {
        URL url = MainApp.class.getResource("/fxml/" + fxmlName);
        if (url == null) throw new RuntimeException("Missing FXML " + fxmlName);

        FXMLLoader fx = new FXMLLoader(url);
        Parent root    = fx.load();
        Scene  scene   = new Scene(root);

        Object c = fx.getController();
        if (c instanceof BaseController bc) bc.setStage(primaryStage);
        return scene;
    }

    public static void main(String[] args) { launch(args); }
}