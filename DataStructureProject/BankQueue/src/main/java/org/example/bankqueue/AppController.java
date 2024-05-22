package org.example.bankqueue;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML private Label seqA;
    @FXML private Label seqB;
    @FXML private Label seqC;
    @FXML private Label seqD;

    @FXML private Label infoText;

    // Sırada bekleyen kişi sayısı
    int num_of_waiting;

    /***
     * Next button'lar için func. tanımlandı.
     * buttonlardan uygun olana tıklanınca bir sonraki
     * müşteri çağırılır.
     */

    public void onCLick_btn1() {
        if (num_of_waiting == 0)
            infoText.setText("Sırada bekleyen müşteri yok");
        else {
            String str = QueueController.queue.peek().toString();
            seqA.setText(str);

            infoText.setText("Bekleyen müşteri sayısı : " + (--num_of_waiting));

            QueueController.queue.dequeue();
        }
    }

    public void onCLick_btn2() {
        if (num_of_waiting == 0)
            infoText.setText("Sırada bekleyen müşteri yok");
        else {
            String str = QueueController.queue.peek().toString();
            seqB.setText(str);

            infoText.setText("Bekleyen müşteri sayısı : " + (--num_of_waiting));

            QueueController.queue.dequeue();
        }
    }

    public void onCLick_btn3() {
        if (num_of_waiting == 0)
            infoText.setText("Sırada bekleyen müşteri yok");
        else {
            String str = QueueController.queue.peek().toString();
            seqC.setText(str);

            infoText.setText("Bekleyen müşteri sayısı : " + (--num_of_waiting));

            QueueController.queue.dequeue();
        }
    }

    public void onCLick_btn4() {
        if (num_of_waiting == 0)
            infoText.setText("Sırada bekleyen müşteri yok");
        else {
            String str = QueueController.queue.peek().toString();
            seqD.setText(str);

            infoText.setText("Bekleyen müşteri sayısı : " + (--num_of_waiting));

            QueueController.queue.dequeue();
        }
    }

    // Yeni giriş yapan müşteriler için button
    public void newCustomer_btn() {
        QueueController.newCustomer();
        infoText.setText("Bekleyen müşteri sayısı : " + (++num_of_waiting));
    }

    /***
     * Program başlarken hazır bir Queue ile başlar.
     * Bu Queue size'ı size() ile hesaplanır.
     * Çıkan ve giren müşterilere göre yeniden hesaplamalar
     * yapılır.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QueueController.createQueue();

        QueueController.queue.size();
        num_of_waiting = QueueController.queue.size;

        infoText.setText("Bekleyen müşteri sayısı : " + num_of_waiting);
    }
}