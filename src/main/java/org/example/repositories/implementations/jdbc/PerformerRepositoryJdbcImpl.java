package org.example.repositories.implementations.jdbc;

import org.example.Helper;
import org.example.model.Genre;
import org.example.model.Performer;
import org.example.repositories.PerformerRepository;
import org.example.repositories.implementations.jdbc.universal.PutInDeleteFromDataBase;
import org.example.repositories.implementations.jdbc.universal.TakeFromDataBase;
import org.example.repositories.implementations.jdbc.universal.UniversalRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PerformerRepositoryJdbcImpl extends UniversalRepositoryImpl<Performer> implements PerformerRepository {
    public PerformerRepositoryJdbcImpl() {
        tableName = "performers";
        takeFromDataBase = new TakeFromDataBase<>(tableName) {
            @Override
            public Performer createObject(ResultSet resultSet) {
                try {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String middleName = resultSet.getString("middle_name");
                    String lastName = resultSet.getString("last_name");
                    String description = resultSet.getString("description");
                    String country = resultSet.getString("country");

                    return new Performer(id,firstName,middleName,lastName,description,country);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        putInDeleteFromDataBase = new PutInDeleteFromDataBase<>(tableName);
    }

    @Override
    public List<Performer> findAll() {
        return takeFromDataBase.findAll();
    }

    @Override
    public Performer findById(int id) {
        return takeFromDataBase.findById(id);
    }

    @Override
    public Performer add(String firstName, String middleName, String lastName,String description, String country) {
        String condition = "first_name = " + Helper.textToQuotes(firstName) + " and " + "middle_name = " + Helper.textToQuotes(middleName) + " and " + "last_name = " + Helper.textToQuotes(lastName) ;
        Performer performer = takeFromDataBase.findByCondition(condition);

        if(performer == null){
            String descriptionValues = Helper.commas("first_name","middle_name","last_name","description","country");
            String stringValues =  Helper.commas(
                    Helper.textToQuotes(firstName),
                    Helper.textToQuotes(middleName),
                    Helper.textToQuotes(lastName),
                    Helper.textToQuotes(description),
                    Helper.textToQuotes(country) );
            putInDeleteFromDataBase.add(descriptionValues,stringValues);

        }else{
            System.out.println("Исполнитель с таким first_name middle_name и last_name уже существует");
            return null;
        }

        return takeFromDataBase.findByCondition(condition);
    }
    @Override
    public Performer findByName(String name) {
        return takeFromDataBase.findByCondition("first_name = " + Helper.textToQuotes(name));
    }
}
