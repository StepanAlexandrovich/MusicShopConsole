package org.example.validation;

import org.example.ConnectionToDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Validator {
    private String tableName = "";
    private String condition;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public void setCondition(String condition) { this.condition = condition; }
    public boolean process(){
        try {
            ResultSet resultSet = ConnectionToDataBase.getResultSet(
                    "select * from public." + tableName + " where " + condition
            );

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
