package org.example;

import java.sql.SQLException;
import java.util.Properties;

public interface IDatabaseConnection {

    IDatabaseConnection openConnection(Properties properties) throws SQLException;

    void createAllTable();

    void truncateAllTables();

    void removeAllTables();

    void closeConnection();

}
