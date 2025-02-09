package usecases.movie;

import dto.MovieDTO;
import entities.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import repositories.IMovieRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MovieUseCaseTest {
    @Mock
    private IMovieRepository movieRepository;

    @InjectMocks
    private CreateMovieUseCase createMovieUseCase;

    @Before
    public void setup() {
    }

    @Test
    public void testCreateMovieSuccess() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setContent("content");
        movieDTO.setSharedBy("by");
        movieDTO.setTitle("title");

        Optional<Movie> movieSaved = createMovieUseCase.create(movieDTO);

        assertNotNull(movieSaved);
        assertTrue(movieSaved.isPresent());
        assertNotNull(movieSaved.get().getId());
        assertNotNull(movieSaved.get().getCreatedAt());
        assertEquals(movieSaved.get().getContent(), movieDTO.getContent());
        assertEquals(movieSaved.get().getSharedBy(), movieDTO.getSharedBy());
        assertEquals(movieSaved.get().getTitle(), movieDTO.getTitle());

        verify(movieRepository, times(1)).save(Mockito.any());
    }
}
