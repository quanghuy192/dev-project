package usecases;

import entities.Movie;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IMovieRepository;

import java.util.List;

@Service
public class MovieUseCase {

    @Autowired
    IMovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.getAll();
    }

    public Movie storeMovie(Movie movie) {
        return movieRepository.store(movie);
    }

    @SneakyThrows
    public Movie findBy(String title){
        return movieRepository.findByTitle(title);
    }
}
