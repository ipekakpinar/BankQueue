module org.example.bankqueue {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires java.sql;


    opens org.example.bankqueue to javafx.fxml;
    exports org.example.bankqueue;
}