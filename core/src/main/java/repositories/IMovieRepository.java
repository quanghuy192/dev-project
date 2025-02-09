package repositories;

import core.IRepository;
import entities.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository extends IRepository<Movie> {
    Optional<Movie> findByTitle(String title);
    Optional<Movie> save(Movie movie);
    void saveAll(List<Movie> movies);
    void deleteAll();
}
