package org.example.services.implementations;

import org.example.model.Genre;
import org.example.repositories.GenreRepository;
import org.example.repositories.implementations.GenreRepositoryImpl;
import org.example.services.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository = new GenreRepositoryImpl();
    @Override
    public Genre getById(int id) {
        return genreRepository.findById(id);
    }
    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
