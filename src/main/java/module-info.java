module edu.miracosta.cs112.finalproject.finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    // so the JavaFX launcher can reflectively instantiate MainApp:
    opens edu.miracosta.cs112.finalproject.finalproject to javafx.graphics;

    // so FXMLLoader can inject into your controllers and @FXML models:
    opens edu.miracosta.cs112.finalproject.finalproject.controller to javafx.fxml;
    opens edu.miracosta.cs112.finalproject.finalproject.Model      to javafx.fxml;

    // export exactly those packages that actually contain your .class files:
    exports edu.miracosta.cs112.finalproject.finalproject;
    exports edu.miracosta.cs112.finalproject.finalproject.controller;
    exports edu.miracosta.cs112.finalproject.finalproject.Model;
}