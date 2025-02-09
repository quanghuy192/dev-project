package usecases.movie;

import entities.Movie;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IMovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GetMovieUseCase {
    @Autowired
    IMovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.getAll();
    }

    @SneakyThrows
    public Optional<Movie> findBy(String title){
        return movieRepository.findByTitle(title);
    }
}
