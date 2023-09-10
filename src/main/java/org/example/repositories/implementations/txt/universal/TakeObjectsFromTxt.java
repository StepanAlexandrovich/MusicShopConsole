package org.example.repositories.implementations.txt.universal;

import org.example.application.ReadText;
import org.example.model.ObjectWithId;
import org.example.repositories.ManyToForeignKey;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindByFewId;
import org.example.repositories.functional.FindById;

import java.util.ArrayList;
import java.util.List;

public abstract class TakeObjectsFromTxt<T extends ObjectWithId> implements FindAll<T>, FindById<T>,FindByFewId<T>, ManyToForeignKey {
    private String path;
    private ReadText readText = new ReadText();
    public TakeObjectsFromTxt(String path){
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

    @Override
    public List list(int foreignKeyPosition,int foreignKeyId) {
        return findByFewId( getFewId(path,foreignKeyPosition,foreignKeyId) );
    }

    @Override
    public List list(String foreignKeyName, int foreignKeyNameId) {
        System.out.println("is empty");
        return null;
    }


    // inner -------------------------
    private List<Integer> getFewId(String path,int foreignKeyPosition,int foreignKeyId){
        List<Integer> fewId = new ArrayList<>();
        for(String line:readText.readLines(path)){
            String[] words = line.split(";");
            if(Integer.parseInt(words[foreignKeyPosition]) == foreignKeyId){
                fewId.add(Integer.parseInt(words[0]) - 1);
            }
        }

        return fewId;
    }
}
