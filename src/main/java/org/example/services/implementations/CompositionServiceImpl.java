package org.example.services.implementations;

import org.example.model.Composition;
import org.example.repositories.implementations.jdbc.CompositionRepositoryJdbcImpl;
//import org.example.repositories.implementations.txt.CompositionRepositoryImpl;
import org.example.services.CompositionService;
import org.example.repositories.*;

import java.time.LocalDate;
import java.util.List;

public class CompositionServiceImpl implements CompositionService {
    private CompositionRepository compositionRepository = new CompositionRepositoryJdbcImpl();

    //private CompositionRepository compositionRepository = new CompositionRepositoryImpl();

    @Override
    public List<Composition> getAll() {
        return compositionRepository.findAll();
    }
    @Override
    public Composition getById(int id) {
        return compositionRepository.findById(id);
    }
    @Override
    public List<Composition> getAllByGenreId(int id) {
        return compositionRepository.findAllByGenreId(id);
    }
    @Override
    public List<Composition> getAllByPerformerId(int id) {
        return compositionRepository.findAllByPerformerId(id);
    }

    @Override
    public Composition add(String name, LocalDate dateRelease, double duration, double price, int genreId, int performerId) {
        return compositionRepository.add(name,dateRelease,duration,price,genreId,performerId);
    }

    @Override
    public Composition deleteById(int id) {
        return compositionRepository.deleteById(id);
    }

}
