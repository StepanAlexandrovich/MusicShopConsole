package org.example.services.implementations;

import org.example.model.Performer;
import org.example.repositories.PerformerRepository;
import org.example.repositories.implementations.PerformerRepositoryImpl;
import org.example.services.PerformerService;

import java.util.List;

public class PerformerServiceImpl implements PerformerService {
    private PerformerRepository performerRepository = new PerformerRepositoryImpl();
    @Override
    public List<Performer> getAll() {
        return performerRepository.findAll();
    }
    @Override
    public Performer getById(int id) {
        return performerRepository.findById(id);
    }
}
