package org.example.repositories;

import org.example.model.Composition;

import java.util.List;

public interface CompositionRepository extends FindAll<Composition>,FindById<Composition>,FindByFewId{}
