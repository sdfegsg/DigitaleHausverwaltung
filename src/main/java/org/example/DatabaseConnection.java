package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection implements IDatabaseConnection{

    Connection connection = null;




    @Override
    public IDatabaseConnection openConnection(Properties props) throws SQLException {


            // Get connection details from properties file
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database.");

        return this;
    }






    @Override
    public void createAllTable() {
        String createCustomersTable = "CREATE TABLE IF NOT EXISTS customers (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "first_name VARCHAR(50), " +
                "last_name VARCHAR(50), " +
                "birth_date DATE, " +
                "gender CHAR(1)" +
                ");";

        try (Statement stmt = connection.createStatement()){
            stmt.execute(createCustomersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void truncateAllTables() {

    }

    @Override
    public void removeAllTables() {

    }

    @Override
    public void closeConnection() {

    }
}
