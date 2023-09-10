package org.example.services;

import org.example.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();
    Genre getById(int id);
    Genre getByName(String name);
    Genre add(String name,String description);

    Genre deleteById(int id);

}
