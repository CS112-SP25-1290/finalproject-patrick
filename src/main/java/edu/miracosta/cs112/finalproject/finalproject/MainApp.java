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

        // DEBUG: verify the Logo is on the classpath
        URL logoUrl = getClass().getResource("/images/logo.png");
        System.out.println("DEBUG: logo.png URL → " + logoUrl);

        // DEBUG: verify the FXML is on the classpath
        URL fxmlUrl = getClass().getResource("/fxml/Start.fxml");
        System.out.println("DEBUG: Start.fxml URL → " + fxmlUrl);
        if (fxmlUrl == null) {
            throw new RuntimeException("Cannot find /fxml/Start.fxml on the classpath");
        }

        // Load the FXML
        Parent root = FXMLLoader.load(fxmlUrl);

        //Build a scene and show it
        Scene scene = new Scene(root);
        stage.setTitle("Sierra Trout Quest");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Helper to load any other screen by FXML name (e.g. "Map.fxml", "Fight.fxml", etc.)
     * Had a lot of issues here and used AI for help
     */
    public static Scene loadScene(String fxmlName) throws Exception {
        URL url = MainApp.class.getResource("/fxml/" + fxmlName);
        if (url == null) {
            throw new RuntimeException("FXML not found on classpath: /fxml/" + fxmlName);
        }
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Object ctrl = loader.getController();
        if (ctrl instanceof BaseController bc) {
            bc.setStage(primaryStage);
        }

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}