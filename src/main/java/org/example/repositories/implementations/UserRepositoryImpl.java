package org.example.repositories.implementations;

import org.example.model.User;
import org.example.repositories.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private String path = "src/main/resources/users.txt";
    private CreateObjectFromString<User> createObjectFromString = new CreateObjectFromString<User>(path) {
        @Override
        public User createObject(String line) {
            String[] words = line.split(";");
            return new User(Integer.parseInt(words[0]),words[1],words[2]);
        }
    };
    @Override
    public List<User> findAll() {
        return createObjectFromString.findAll();
    }
    @Override
    public User findById(int id) {
        return createObjectFromString.findById(id);
    }
}
