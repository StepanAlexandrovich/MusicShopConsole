package org.example.services.implementations;

import org.example.model.Genre;
import org.example.repositories.GenreRepository;
import org.example.repositories.implementations.jdbc.GenreRepositoryJdbcImpl;
import org.example.services.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository = new GenreRepositoryJdbcImpl();
    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
    @Override
    public Genre getById(int id) {
        return genreRepository.findById(id);
    }
    @Override
    public Genre getByName(String name) { return genreRepository.findByName(name); }
    @Override
    public Genre add(String name,String description) { return genreRepository.add(name,description); }

    @Override
    public Genre deleteById(int id) { return genreRepository.deleteById(id); }
}
