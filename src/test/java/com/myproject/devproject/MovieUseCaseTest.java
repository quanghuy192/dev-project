package com.myproject.devproject;

import com.myproject.devproject.models.Movie;
import com.myproject.devproject.repositories.MovieRepository;
import com.myproject.devproject.services.MovieService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class MovieUseCaseTest {

    @InjectMocks
    MovieService movieService;

    @Mock
    MovieRepository movieRepository;

    @Test
    public void whenSavedMovie_shouldReturnSavedMovie() {
        final Movie movie1 = new Movie();
        movie1.setSharedBy("John Doe");
        movie1.setContent("ABC123");
        movie1.setTitle("title1");
        movie1.setId(1L);

        when(movieRepository.save(any())).thenReturn(movie1);

        Movie savedMovie = movieService.resolveMovie(movie1);
        assertThat(savedMovie.getId()).isNotNull();
        verify(movieRepository).save(any());
    }

    @Test
    @SneakyThrows
    public void whenGetAllMovie_shouldReturnListMovie() {
        final Movie movie1 = new Movie();
        movie1.setSharedBy("John Doe");
        movie1.setContent("ABC123");
        movie1.setTitle("title1");
        movie1.setId(1L);

        final Movie movie2 = new Movie();
        movie1.setSharedBy("Doe Micheal");
        movie1.setContent("XYZ123");
        movie1.setTitle("title2");
        movie2.setId(2L);

        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));

        List<Movie> Movies = movieService.findAll();
        assertThat(Movies.size()).isEqualTo(2);
        verify(movieRepository).findAll();
    }

    @Test
    @SneakyThrows
    public void whenFindMovieByMoviename_shouldReturnMovie() {
        final Movie movie1 = new Movie();
        movie1.setSharedBy("John Doe");
        movie1.setContent("ABC123");
        movie1.setTitle("title1");
        movie1.setId(1L);

        when(movieRepository.findMovieByTitle(any())).thenReturn(movie1);

        Movie movieInDB = movieService.findBy(movie1.getTitle());
        assertThat(movieInDB.getContent()).isEqualTo(movie1.getContent());
        assertThat(movieInDB.getTitle()).isEqualTo(movie1.getTitle());
        assertThat(movieInDB.getSharedBy()).isEqualTo(movie1.getSharedBy());
        verify(movieRepository).findMovieByTitle(any());
    }

}
