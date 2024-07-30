package com.myproject.devproject.application.repositories;

import com.myproject.devproject.application.core.IRepository;
import com.myproject.devproject.application.entities.Movie;

public interface IMovieRepository extends IRepository {
    Movie findByTitle(String title);
}
