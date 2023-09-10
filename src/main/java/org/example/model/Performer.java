package org.example.model;

import org.example.Top;

import java.util.ArrayList;
import java.util.List;

public class Performer implements ObjectWithId{
    private int id;

    private String firstName;
    private String middleName;
    private String lastName;

    private String description;
    private String country;

    private List<Composition> compositions = new ArrayList();
    @Override
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCountry() {
        return country;
    }
    public List<Composition> getCompositions() {
        return Top.compositionService.getAllByPerformerId(id);
    }

    public Performer(int id, String firstName, String middleName, String lastName,String description, String country) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.description = description;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Performer{" +
                " firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", compositions=" + compositions +
                '}';
    }
}
