package org.example.services.implementations;

import org.example.model.Composition;
import org.example.repositories.implementations.CompositionRepositoryImpl;
import org.example.services.CompositionService;
import org.example.repositories.*;
import org.example.repositories.implementations.OneToManyImpl;

import java.util.List;

public class CompositionServiceImpl implements CompositionService {
    private CompositionRepository compositionRepository = new CompositionRepositoryImpl();
    private OneToManyImpl<CompositionRepository> oneToMany= new OneToManyImpl<>(compositionRepository,"src/main/resources/compositions.txt");

    @Override
    public Composition getById(int id) {
        return compositionRepository.findById(id);
    }
    @Override
    public List<Composition> getAllByGenreId(int id) {
        return oneToMany.setFirstLast(0,5).list(id);
    }
    @Override
    public List<Composition> getAllByPerformerId(int id) {
        return oneToMany.setFirstLast(0,6).list(id);
    }
    @Override
    public List<Composition> getAll() {
        return compositionRepository.findAll();
    }
}
