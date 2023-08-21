package org.example.repositories.implementations;

import org.example.application.ReadText;
import org.example.model.ObjectWithId;
import org.example.repositories.FindAll;
import org.example.repositories.FindByFewId;
import org.example.repositories.FindById;

import java.util.ArrayList;
import java.util.List;

public abstract class CreateObjectFromString<T extends ObjectWithId> implements FindAll<T>, FindById<T>,FindByFewId<T> {
    private String path;
    private ReadText readText = new ReadText();
    public CreateObjectFromString(String path){
        this.path = path;
    }

    @Override
    public List<T> findAll() {
        List<T> objects = new ArrayList<>();
        for(String line:readText.readLines(path)){
            objects.add( (T)createObject(line));
        }
        return objects;
    }

    @Override
    public T findById(int id) {
        for(String line:readText.readLines(path)){
            T o = createObject(line);
            if(o.getId() == id){
                return o;
            }
        }
        return null;
    }
    @Override
    public List findByFewId(List<Integer> fewId) {
        List<T> newList = new ArrayList<>();
        fewId = fewId;
        for (Integer index : fewId) {
            newList.add(findAll().get(index));
        }
        return newList;
    }

    public abstract T createObject(String line);

}
