package org.example.repositories;

import org.example.model.User;

public interface UserRepository extends FindAll<User>,FindById<User>{}
