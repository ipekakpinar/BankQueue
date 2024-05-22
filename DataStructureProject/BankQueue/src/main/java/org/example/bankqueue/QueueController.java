package org.example.bankqueue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QueueController {
    static Queue queue = new Queue();

    // Oluşturulan hazır Queue
    public static void createQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
    }

    // Yeni müşteri girişi için func.
    public static void newCustomer() {
        queue.enqueue(queue.size + 1);
        queue.size++;

        // Yeni müşteri ekleme butonuna tıklandığında yeni pencereyi aç
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("new-entry.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("New Customer Entry");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
