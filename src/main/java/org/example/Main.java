package org.example;

import java.sql.*;

public class Main {

    static String url = "jdbc:mariadb://127.0.0.1:3306/digitalehausverwaltung";
    static String user = "root"; // Ersetzen Sie durch Ihren Benutzernamen
    static String password = ""; // Ersetzen Sie durch Ihr Passwort


    public static void main(String[] args) {


        try {


            // Erstelle eine Verbindung
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