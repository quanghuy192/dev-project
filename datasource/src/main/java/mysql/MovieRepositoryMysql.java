package mysql;

import entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import repositories.IMovieRepository;

import java.util.List;

@Repository
public interface MovieRepositoryMysql extends IMovieRepository, JpaRepository<Long, Movie> {

    Movie findMovieByTitle(String title);

    List<Movie> findMoviesByShareBy(String shareBy);
}
