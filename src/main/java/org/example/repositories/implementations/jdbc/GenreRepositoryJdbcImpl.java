package org.example.repositories.implementations.jdbc;

import org.example.Helper;
import org.example.model.Genre;
import org.example.repositories.GenreRepository;
import org.example.repositories.implementations.jdbc.universal.PutInDeleteFromDataBase;
import org.example.repositories.implementations.jdbc.universal.TakeFromDataBase;
import org.example.repositories.implementations.jdbc.universal.UniversalRepositoryImpl;

import java.sql.*;
import java.util.List;

public class GenreRepositoryJdbcImpl extends UniversalRepositoryImpl<Genre> implements GenreRepository {
    public GenreRepositoryJdbcImpl() {
        tableName = "genres";
        takeFromDataBase = new TakeFromDataBase<Genre>(tableName) {
            @Override
            public Genre createObject(ResultSet resultSet) {
                try {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");

                    return new Genre(id,name,description);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        putInDeleteFromDataBase = new PutInDeleteFromDataBase<>(tableName);
    }

    @Override
    public Genre findByName(String name) {
        return takeFromDataBase.findByCondition("name = " + Helper.textToQuotes(name));
    }

    @Override
    public Genre add(String genreName, String description) {
        String condition = "name = " + Helper.textToQuotes(genreName);
        Genre genre = takeFromDataBase.findByCondition(condition);

        if(genre == null){
            String descriptionValues = Helper.commas("name","description");
            String stringValues =  Helper.commas( Helper.textToQuotes(genreName), Helper.textToQuotes(description) );
            putInDeleteFromDataBase.add(descriptionValues,stringValues);
        }else{
            System.out.println("Такой жанр уже существует");
            return null;
        }

        return takeFromDataBase.findByCondition(condition);
    }


}
