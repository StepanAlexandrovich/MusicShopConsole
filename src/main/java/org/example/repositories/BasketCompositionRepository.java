package org.example.repositories;

import org.example.model.BasketComposition;

import java.util.List;

public interface BasketCompositionRepository extends FindAll<BasketComposition>,FindById<BasketComposition>,FindByFewId<BasketComposition>{}
