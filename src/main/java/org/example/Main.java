package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Main {



    public static void main(String[] args) throws SQLException {


        Properties props = new Properties();

        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            // Load properties file
            props.load(input);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.openConnection(props);

    }

    public void testSQL() {
        try {

            String url = "jdbc:mariadb://127.0.0.1:3306/digitalehausverwaltung";
            String user = "root";
            String password = "";

            // Erstelle eine Verbindung-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            Connection conn = DriverManager.getConnection(url, user, password);

            // Erstelle ein Statement
            Statement stmt = conn.createStatement();

            // Führe eine SQL-Anweisung aus
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

            // Gehe die Ergebnisse durch
            while (rs.next()) {
                // int id = rs.getInt("id");
                String name = rs.getString("last_name");
                System.out.println("ID: " + ", Name: " + name);
            }

            // Schließe ResultSet, Statement und Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Catch");
        }
    }

}