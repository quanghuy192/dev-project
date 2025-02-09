package usecases.movie;

import dto.MovieDTO;
import entities.Movie;
import lombok.val;
import mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IMovieRepository;

import java.util.Optional;

@Service
public class CreateMovieUseCase {
    @Autowired
    IMovieRepository movieRepository;

    public Optional<Movie> create(MovieDTO movieDto) {
        val movie = MovieMapper.INSTANCE.fromDTO(movieDto);
        return movieRepository.save(movie);
    }
}
