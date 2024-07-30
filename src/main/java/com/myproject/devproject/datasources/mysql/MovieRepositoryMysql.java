package com.myproject.devproject.datasources.mysql;

import com.myproject.devproject.application.entities.Movie;
import com.myproject.devproject.application.repositories.IMovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Repository
public interface MovieRepositoryMysql extends IMovieRepository, JpaRepository<Movie, Long> {

    // JPA method
    Movie findMovieByTitle(String title);

    // Override from Repository
    @Override
    default Movie findOne(Long id) {
        return findById(id)
                .orElseThrow(() -> new AssertionError(String.format("Movie with id %d not found", id)));
    }

    @Override
    default List<Movie> getALl() {
        return findAll();
    }

    // Override from MovieRepository
    @Override
    default Movie findByTitle(String title){
        final Movie movie = StringUtils.hasLength(title) ? findMovieByTitle(title) : null;
        if(Objects.nonNull(movie)){
            return movie;
        } else {
            throw new AssertionError(String.format("Movie with title %s not found", title));
        }
    }
}
