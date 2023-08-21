package org.example.services;

import org.example.model.Composition;

import java.util.List;

public interface CompositionService {
    List<Composition> getAll();
    Composition getById(int id);
    List<Composition> getAllByPerformerId(int id);
    List<Composition> getAllByGenreId(int id);

}
