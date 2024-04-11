package com.myproject.devproject;

import com.github.javafaker.Faker;
import com.myproject.devproject.models.Movie;
import com.myproject.devproject.models.User;
import com.myproject.devproject.repositories.MovieRepository;
import com.myproject.devproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class Migrations implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    private final Faker usFaker = new Faker(new Locale("en-US"));

    @Override
    public void run(String... args) throws Exception {
        // create users data
        loadUserData();
        // create movies data
        loadMoviesData();
    }

    private void loadUserData() {
        userRepository.deleteAll();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername(usFaker.internet().emailAddress());
            user.setPassword(usFaker.internet().password());
            users.add(user);
        }

        // master user
        final User user1 = new User();
        user1.setUsername("name1");
        user1.setPassword("pass123@1");

        final User user2 = new User();
        user2.setUsername("name2");
        user2.setPassword("pass123@2");

        users.add(user1);
        users.add(user2);
        userRepository.saveAll(users);
    }

    private void loadMoviesData() {
        movieRepository.deleteAll();

        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Movie movie = new Movie();
            movie.setContent(usFaker.book().author());
            movie.setTitle(usFaker.book().title());
            movie.setSharedBy(usFaker.name().fullName());
            movies.add(movie);
        }
        movieRepository.saveAll(movies);
    }
}