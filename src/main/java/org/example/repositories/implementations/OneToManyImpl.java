package org.example.repositories.implementations;

import org.example.application.ReadText;
import org.example.repositories.FindByFewId;
import org.example.repositories.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class OneToManyImpl<T extends FindByFewId> implements OneToMany {
    private T repository;
    private String path;
    private ReadText readText = new ReadText();
    private int first,last;

    public OneToManyImpl(T repository, String path) {
        this.repository = repository;
        this.path = path;
    }

    public OneToManyImpl setFirstLast(int first, int last){
        this.first = first;
        this.last = last;
        return this;
    }

    private List<Integer> getFewId(String path,int id){
        List<Integer> fewId = new ArrayList<>();
        for(String line:readText.readLines(path)){
            String[] words = line.split(";");
            if(Integer.parseInt(words[last]) == id){
                fewId.add(Integer.parseInt(words[first]) - 1);
            }
        }

        return fewId;
    }

    @Override
    public List list(int id){
        List<Integer> values = getFewId(path,id);
        return repository.findByFewId(values);
    }

}
