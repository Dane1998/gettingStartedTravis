package dto;

import entities.Movie;
import java.util.ArrayList;
import java.util.List;

public class MoviesDTO {

    private List<MovieDTO> all = new ArrayList();

    public MoviesDTO(List<Movie> movieList) {
        for (Movie movie : movieList) {
            all.add(new MovieDTO(movie));
        }
    }

    public List<MovieDTO> getAll() {
        return all;
    }

}
