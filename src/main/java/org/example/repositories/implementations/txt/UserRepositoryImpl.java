package org.example.repositories.implementations.txt;

import org.example.model.User;
import org.example.repositories.UserRepository;
import org.example.repositories.implementations.txt.universal.TakeObjectsFromTxt;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private String path = "src/main/resources/users.txt";
    private TakeObjectsFromTxt<User> takeObjectsFromTxt = new TakeObjectsFromTxt<User>(path) {
        @Override
        public User createObject(String line) {
            String[] words = line.split(";");
            return new User(Integer.parseInt(words[0]),words[1],words[2],words[3]);
        }
    };
    @Override
    public List<User> findAll() {
        return takeObjectsFromTxt.findAll();
    }
    @Override
    public User findById(int id) {
        return takeObjectsFromTxt.findById(id);
    }

}
