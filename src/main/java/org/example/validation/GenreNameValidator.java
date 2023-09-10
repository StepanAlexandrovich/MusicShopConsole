package org.example.validation;

import org.example.ConnectionToDataBase;

import java.sql.*;

public class GenreNameValidator {
    public boolean validation(String genreName){
        try {
            Connection connection = ConnectionToDataBase.createConnection();

            String query = "select id from public.genres where name = '" + genreName + "'";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            if (resultSet.next()) {
                System.out.println("validationFalse");
                return false;
            } else {
                System.out.println("validationTrue");
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
