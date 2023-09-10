package org.example.repositories.implementations.jdbc;

import org.example.Helper;
import org.example.model.Composition;
import org.example.model.Genre;
import org.example.repositories.CompositionRepository;
import org.example.repositories.implementations.jdbc.universal.PutInDeleteFromDataBase;
import org.example.repositories.implementations.jdbc.universal.TakeFromDataBase;
import org.example.repositories.implementations.jdbc.universal.UniversalRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CompositionRepositoryJdbcImpl extends UniversalRepositoryImpl<Composition> implements CompositionRepository{

    public CompositionRepositoryJdbcImpl() {
        tableName = "compositions";

        takeFromDataBase = new TakeFromDataBase<>(tableName) {
            @Override
            public Composition createObject(ResultSet resultSet) {
                try {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    LocalDate date = LocalDate.parse( resultSet.getString("date_release") );
                    Double duration = resultSet.getDouble("duration");
                    Double price = resultSet.getDouble("price");
                    int genreId = resultSet.getInt("genre_id");
                    int performerId = resultSet.getInt("performer_id");

                    return new Composition(id,name,date,duration,price,genreId,performerId);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        putInDeleteFromDataBase = new PutInDeleteFromDataBase<Composition>(tableName);
    }

    @Override
    public List<Composition> findAllByGenreId(int id) {
        return takeFromDataBase.list("genre_id",id);
    }
    @Override
    public List<Composition> findAllByPerformerId(int id) {
        return takeFromDataBase.list("performer_id",id);
    }

    @Override
    public Composition add(String name, LocalDate dateRelease, double duration, double price, int genreId, int performerId) {
        String condition = "name = "+ Helper.textToQuotes(name) + " and " + "performer_id = " + performerId;

        Composition composition = takeFromDataBase.findByCondition(condition);
        if(composition!=null){
            System.out.println("Композиция с таким названием и таким автором уже есть");
        }else{
            String descriptionValues = Helper.commas("name","date_release","duration","price","genre_id","performer_id");
            String stringValues =  Helper.commas(
                    Helper.textToQuotes(name),
                    Helper.textToQuotes(dateRelease.toString()),
                    Double.toString(duration),
                    Double.toString(price),
                    Integer.toString(genreId),
                    Integer.toString(performerId));
            putInDeleteFromDataBase.add(descriptionValues,stringValues);
            return takeFromDataBase.findByCondition(condition);
        }

        return null;
    }



//    @Override
//    public Composition delete(int id) {
//        String condition = "id = "+id;
//        Composition composition = takeFromDataBase.findByCondition(condition);
//        if(putInDeleteFromDataBase.delete(condition)){
//            return composition;
//        }
//        return null;
//    }

    //--------------------------
    @Override
    public List findByFewId(List fewId) {
        return null;
    }

}
