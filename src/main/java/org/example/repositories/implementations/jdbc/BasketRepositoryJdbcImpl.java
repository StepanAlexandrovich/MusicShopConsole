package org.example.repositories.implementations.jdbc;

import org.example.model.Basket;
import org.example.repositories.BasketRepository;
import org.example.repositories.implementations.jdbc.universal.TakeFromDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BasketRepositoryJdbcImpl implements BasketRepository {
    private final String tableName = "baskets";
    private TakeFromDataBase<Basket> takeFromDataBase = new TakeFromDataBase<>(tableName) {
        @Override
        public Basket createObject(ResultSet resultSet) {
            try {
                int id = resultSet.getInt("id");
                Boolean status = resultSet.getBoolean("status");
                int userId = resultSet.getInt("user_id");

                return new Basket(id,status,userId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Override
    public List<Basket> findAll() {
        return takeFromDataBase.findAll();
    }
    @Override
    public Basket findById(int id) {
        return takeFromDataBase.findById(id);
    }
    @Override
    public List<Basket> findAllByUserId(int id) {
        return takeFromDataBase.list("user_id",id);
    }
    @Override
    public List findByFewId(List<Integer> fewId) {
        return takeFromDataBase.findByFewId(fewId);
    }

}
