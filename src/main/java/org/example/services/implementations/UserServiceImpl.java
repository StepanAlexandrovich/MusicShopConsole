package org.example.services.implementations;

import org.example.model.User;
import org.example.repositories.UserRepository;
import org.example.repositories.implementations.UserRepositoryImpl;
import org.example.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User getById(int id) {
        return userRepository.findById(id);
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
