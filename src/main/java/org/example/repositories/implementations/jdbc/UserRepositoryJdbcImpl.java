package org.example.repositories.implementations.jdbc;

import org.example.model.User;
import org.example.repositories.UserRepository;
import org.example.repositories.implementations.jdbc.universal.TakeFromDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryJdbcImpl implements UserRepository {
    private final String tableName = "users";
    private TakeFromDataBase<User> takeObjectsFromDataBase = new TakeFromDataBase<>(tableName) {
        @Override
        public User createObject(ResultSet resultSet) {
            try {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String type = resultSet.getString("type");

                return new User(id,name,password,type);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };
    @Override
    public List<User> findAll() {
        return takeObjectsFromDataBase.findAll();
    }
    @Override
    public User findById(int id) {
        return takeObjectsFromDataBase.findById(id);
    }
}
