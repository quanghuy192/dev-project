package repositories;

import core.IRepository;
import entities.Movie;

public interface IMovieRepository extends IRepository {
    Movie findByTitle(String title);
}
