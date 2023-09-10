package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionToDataBase {
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "1";
    private static final String URL = "jdbc:postgresql://localhost:5432/MusicShop1";

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

    //-----------------------------
    public static ResultSet getResultSet(String query) throws SQLException {
        return ConnectionToDataBase.createConnection().createStatement().executeQuery(query);
    }

    public static int getResultUpdate(String query) throws SQLException {
        return ConnectionToDataBase.createConnection().createStatement().executeUpdate(query);
    }
}
