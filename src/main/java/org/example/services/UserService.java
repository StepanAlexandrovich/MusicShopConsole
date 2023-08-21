package org.example.services;

import org.example.model.User;

import java.util.List;

public interface UserService{
    User getById(int id);
    List<User> getAll();
}
