package dto;

import entities.Movie;
import java.util.StringJoiner;

public class MovieDTO {

    private long id;
    private int year;
    private String title;
    private String actors;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.year = movie.getYear();
        this.title = movie.getTitle();
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < movie.getActors().length; i++) {
            joiner.add(movie.getActors()[i]);
        }
    }

    public MovieDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

}
