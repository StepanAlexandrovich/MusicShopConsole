package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Genre implements ObjectWithId{
    private int id;

    private String name;

    private String description;

    private List<Composition> compositions = new ArrayList();

    public Genre(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /////////////////////////////
    public List<Composition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", compositions=" + compositions +
                '}';
    }

}
