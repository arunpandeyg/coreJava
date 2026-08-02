package com.arun.movies.services;

import com.arun.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List findAllMovies() {
        return repository.findAll();
    }
    public Optional findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}
