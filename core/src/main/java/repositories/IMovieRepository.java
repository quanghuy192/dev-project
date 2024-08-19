package repositories;

import core.IRepository;
import entities.Movie;

import java.util.List;

public interface IMovieRepository extends IRepository {
    Movie findByTitle(String title);
    Movie store(Movie movie);
    boolean storeAll(List<Movie> movies);
    boolean deleteAll();
}
