package org.example.repositories.implementations.jdbc.universal;

import org.example.ConnectionToDataBase;
import org.example.model.ObjectWithId;
import org.example.repositories.*;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindByFewId;
import org.example.repositories.functional.FindById;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class TakeFromDataBase<T extends ObjectWithId> implements FindAll<T>, FindById<T>, FindByFewId<T>, ManyToForeignKey {
    private String table;
    public TakeFromDataBase(String table) {
        this.table = table;
    }

    @Override
    public List<T> findAll() {
        List<T> objects = new ArrayList<>();

        try {
            ResultSet resultSet = getResultSet("select * from public." + table);
            while (resultSet.next()){
                objects.add(createObject(resultSet));
            }
            return objects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T findByCondition(String condition){
        try {
            ResultSet resultSet = getResultSet("select * from public." + table + " where " + condition+";");
            while (resultSet.next()){
                return createObject(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public T findById(int id) {
        return findByCondition("id = " + id);
    }
    @Override
    public List findByFewId(List<Integer> fewId) {
        System.out.println("empty");
        return null;
    }
    @Override
    public List list(int foreignKeyPosition, int foreignKeyId) {
        System.out.println("empty");
        return null;
    }
    @Override
    public List list(String foreignKeyName, int foreignKeyNameId) {
        List<T> objects = new ArrayList<>();

        try {
            ResultSet resultSet = getResultSet("select * from public." + table + " where " + foreignKeyName + " = " + foreignKeyNameId);

            while (resultSet.next()){
                objects.add(createObject(resultSet));
            }
            return objects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract T createObject(ResultSet resultSet);
    //--------------------------
    private ResultSet getResultSet(String query) throws SQLException {
        return ConnectionToDataBase.createConnection().createStatement().executeQuery(query);
    }

}
