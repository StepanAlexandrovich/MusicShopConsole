package org.example.services;

import org.example.model.Composition;
import org.example.model.Performer;

import java.util.List;

public interface PerformerService {
    List<Performer> getAll();
    Performer getById(int id);
    Performer getByName(String name);

    Performer add(String firstName, String middleName, String lastName,String description,String country);
    Performer deleteById(int id);
}

