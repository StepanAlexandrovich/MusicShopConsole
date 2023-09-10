package org.example.repositories.implementations.jdbc.universal;

import org.example.ConnectionToDataBase;
import org.example.model.ObjectWithId;
import org.example.repositories.functional.AddByValues;
import org.example.repositories.functional.DeleteByCondition;

import java.sql.SQLException;

public class PutInDeleteFromDataBase<T extends ObjectWithId> implements AddByValues, DeleteByCondition {
    private String tableName;
    private TakeFromDataBase<T> tTakeFromDataBase;

    public PutInDeleteFromDataBase(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public boolean add(String descriptionValues,String stringValues) {
        int resultUpdate = 0;
        try {
            resultUpdate = ConnectionToDataBase.getResultUpdate("insert into public." + tableName + "(" + descriptionValues + ")" + "values(" + stringValues + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return intToBoolean(resultUpdate);
    }
    @Override
    public boolean delete(String condition) {
        int resultUpdate = 0;
        try {
            resultUpdate = ConnectionToDataBase.getResultUpdate("delete from public." + tableName + " where " + condition + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return intToBoolean(resultUpdate);
    }

    private boolean intToBoolean(int i){
        if(i == 1){ return true; }
        return false;
    }

}
