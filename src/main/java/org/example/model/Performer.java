package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Performer implements ObjectWithId{
    private int id;

    private String name;
    private String lastName;

    private String country;

    private List<Composition> compositions = new ArrayList();
    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public List<Composition> getCompositions() {
        return compositions;
    }
    public void setCompositions(List<Composition> compositions) {
        this.compositions = compositions;
    }

    public Performer(int id, String name, String lastName, String country) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Performer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", compositions=" + compositions +
                '}';
    }
}
