package usecases;

import com.myproject.devproject.application.entities.Movie;
import com.myproject.devproject.datasources.mysql.MovieRepositoryMysql;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieUseCase {

    @Autowired
    MovieRepositoryMysql movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie resolveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @SneakyThrows
    public Movie findBy(String title){
        return movieRepository.findMovieByTitle(title);
    }
}
