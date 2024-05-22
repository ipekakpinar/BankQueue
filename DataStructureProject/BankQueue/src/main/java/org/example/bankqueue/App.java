package org.example.bankqueue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage primaryStage; // Stage referansı

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage; // primaryStage'e atama yapıyoruz
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Bank Queue!");
        stage.setScene(scene);
        stage.show();
    }

    // Diğer sınıfların bu referansa erişmesini sağlayacak bir metot
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
