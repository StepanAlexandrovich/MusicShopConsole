package org.example.services.implementations;

import org.example.model.Performer;
import org.example.repositories.PerformerRepository;
import org.example.repositories.implementations.jdbc.PerformerRepositoryJdbcImpl;
import org.example.services.PerformerService;

import java.util.List;

public class PerformerServiceImpl implements PerformerService {
    //private PerformerRepository performerRepository = new PerformerRepositoryImpl();
    private PerformerRepository performerRepository = new PerformerRepositoryJdbcImpl();
    @Override
    public List<Performer> getAll() {
        return performerRepository.findAll();
    }
    @Override
    public Performer getById(int id) {
        return performerRepository.findById(id);
    }

    @Override
    public Performer getByName(String name) { return performerRepository.findByName(name); }

    @Override
    public Performer add(String firstName, String middleName, String lastName,String description, String country) {
        return performerRepository.add(firstName,middleName,lastName,description,country);
    }

    @Override
    public Performer deleteById(int id) { return performerRepository.deleteById(id); }


}
