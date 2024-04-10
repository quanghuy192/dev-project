package com.myproject.devproject.services;

import com.myproject.devproject.models.Movie;
import com.myproject.devproject.models.User;
import com.myproject.devproject.repositories.MovieRepository;
import com.myproject.devproject.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie resolveUser(Movie movie) {
        return movieRepository.save(movie);
    }
}
