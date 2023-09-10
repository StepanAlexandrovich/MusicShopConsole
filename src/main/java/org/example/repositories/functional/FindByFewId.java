package org.example.repositories.functional;

import org.example.model.ObjectWithId;

import java.util.List;
public interface FindByFewId<T extends ObjectWithId> {
    List findByFewId(List<Integer>fewId);
}
