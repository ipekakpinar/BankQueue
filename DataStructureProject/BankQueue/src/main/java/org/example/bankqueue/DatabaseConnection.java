package org.example.bankqueue;
import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConnection {
    private static final String DATABASE_NAME = "bank_app";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost/" + DATABASE_NAME;

    private Connection databaseLink;


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}