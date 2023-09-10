package org.example.repositories.implementations.jdbc.universal;

import org.example.model.Composition;
import org.example.model.ObjectWithId;
import org.example.repositories.UniversalRepository;


import java.util.List;

public abstract class UniversalRepositoryImpl<T extends ObjectWithId> implements UniversalRepository<T> {
    public String tableName;
    public TakeFromDataBase<T> takeFromDataBase;
    public PutInDeleteFromDataBase<T> putInDeleteFromDataBase;

    @Override
    public List<T> findAll() { return takeFromDataBase.findAll(); }

    @Override
    public T findById(int id) {
        return takeFromDataBase.findById(id);
    }

    @Override
    public T deleteById(int id) {
        String condition = "id = "+id;
        T object = takeFromDataBase.findByCondition(condition);
        if(putInDeleteFromDataBase.delete(condition)){
            return object;
        }
        return null;
    }
}
