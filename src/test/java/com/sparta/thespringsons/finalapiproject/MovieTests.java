package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import com.sparta.thespringsons.finalapiproject.model.services.MoviesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MovieTests {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MoviesService moviesService;
    @Test
    @DisplayName("FindMovieByRating")
    public void testingGetMoviesByRating(){

        List<Movie> movies = moviesService.findAllRatedMoviesByRating("PASSED");
        //System.out.println(movies);

    }

    @Test
    @DisplayName("FindAllUnratedMovies")
    public void findAllUnratedMovies(){

        List<Movie> movies = moviesService.findAllUnratedMovies();
        System.out.println(movies);

    }

}

