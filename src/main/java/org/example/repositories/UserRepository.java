package org.example.repositories;

import org.example.model.User;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindById;

public interface UserRepository extends FindAll<User>, FindById<User> {}
