package org.example.services.implementations;

import org.example.model.User;
import org.example.repositories.UserRepository;
import org.example.repositories.implementations.jdbc.UserRepositoryJdbcImpl;
//import org.example.repositories.implementations.txt.UserRepositoryImpl;
import org.example.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    //private UserRepository userRepository= new UserRepositoryImpl();
    private UserRepository userRepository= new UserRepositoryJdbcImpl();

    @Override
    public User getById(int id) {
        return userRepository.findById(id);
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
