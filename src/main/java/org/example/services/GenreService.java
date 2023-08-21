package org.example.services;

import org.example.model.Genre;

import java.util.List;

public interface GenreService {
    Genre getById(int id);
    List<Genre> getAll();
}
