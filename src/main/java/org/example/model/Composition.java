package org.example.model;

import org.example.Top;

import java.time.LocalDate;

public class Composition implements ObjectWithId{
    private int id;
    private String name;
    private LocalDate dateRelease;
    private double duration;
    private double price;
    private int genreId;
    private int performerId;


    private String genreName = "";
    private String performerName = "";

    public Composition(
            int id,
            String name,
            LocalDate dateRelease,
            double duration,
            double price,
            int genreId,
            int performerId
    ) {
        this.id = id;
        this.name = name;
        this.dateRelease = dateRelease;
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
    public LocalDate getDateRelease() {
        return dateRelease;
    }
    public double getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return Top.genreService.getById(genreId);
    }
    public Performer getPerformer() { return Top.performerService.getById(performerId); }

    public int getGenreId() { return genreId; }

    public int getPerformerId() { return performerId; }

    public void setGenreName(String genreName) { this.genreName = genreName; }
    public void setPerformerName(String performerName) { this.performerName = performerName; }

    @Override
    public String toString() {
        return "Composition{" +
                " name='" + name + '\'' +
                ", dataRelease=" + dateRelease +
                ", duration=" + duration +
                ", genre = " + genreName +
                ", performer = " + performerName +
                '}';
    }

}
