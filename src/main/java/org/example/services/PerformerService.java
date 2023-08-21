package org.example.services;

import org.example.model.Composition;
import org.example.model.Performer;

import java.util.List;

public interface PerformerService {
    List<Performer> getAll();
    Performer getById(int id);
}

