package org.example.bankqueue;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewEntryController {
    @FXML
    private TextField adtext;

    @FXML
    private TextField soyadtext;

    @FXML
    private ChoiceBox<String> gelisSebebi;

    @FXML
    private Button OKbutton;

    @FXML
    private Label WarningLabel;

    private DatabaseConnection databaseConnection;


    @FXML
    private void initialize() {

        databaseConnection = new DatabaseConnection();
        // ChoiceBox'a seçenekler ekleme
        gelisSebebi.getItems().addAll("Kredi Başvurusu", "Hesap Açma", "Fatura Ödeme", "Diğer");
    }

    @FXML
    private void handleSaveButton() {
        // Kullanıcı girdilerini al
        String ad = adtext.getText();
        String soyad = soyadtext.getText();
        String sebep = gelisSebebi.getValue();

        // Kullanıcı girdilerinin boş olup olmadığını kontrol et
        if (ad.isEmpty() || soyad.isEmpty() || sebep == null) {
            // Eğer bir veya daha fazla alan boşsa uyarı mesajını göster ve kaydetmeyi durdur
            WarningLabel.setText("Lütfen Bilgileri Eksiksiz Giriniz!");
            return;
        }

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (user_no, user_name, user_surname, reason) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, QueueController.queue.size);
            preparedStatement.setString(2, ad);
            preparedStatement.setString(3, soyad);
            preparedStatement.setString(4, sebep);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        WarningLabel.setText("");

        System.out.println("Kullanıcı bilgileri kaydedildi: Adı: " + ad + ", Soyadı: " + soyad + ", Geliş Sebebi: " + sebep);

        Stage stage = (Stage) OKbutton.getScene().getWindow();
        stage.close();
    }
}
