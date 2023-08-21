package org.example.model;

import java.time.LocalDate;

public class Composition implements ObjectWithId{
    private int id;
    private String name;
    private LocalDate dataRelease;
    private double duration;
    private double price;
    private int genreId;
    private int performerId;
    // TODO: 10.08.2023 добавить цену
    public Composition(){};
    public Composition(
            int id,
            String name,
            LocalDate dataRelease,
            double duration,
            double price,
            int genreId,
            int performerId
    ) {
        this.id = id;
        this.name = name;
        this.dataRelease = dataRelease;
        this.duration = duration;
        this.price = price;
        this.genreId = genreId;
        this.performerId = performerId;
    }
    @Override
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getDataRelease() {
        return dataRelease;
    }
    public double getDuration() {
        return duration;
    }
    public int getGenreId() {
        return genreId;
    }
    public int getPerformerId() {
        return performerId;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataRelease=" + dataRelease +
                ", duration=" + duration +
                ", genreId=" + genreId +
                ", performerId=" + performerId +
                '}';
    }

}
