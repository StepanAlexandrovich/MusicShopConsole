package org.example.repositories;

import org.example.model.Performer;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindById;

public interface PerformerRepository extends UniversalRepository<Performer>{
    Performer add(String firstName, String middleName, String lastName, String description, String country);
    Performer findByName(String name);
}
