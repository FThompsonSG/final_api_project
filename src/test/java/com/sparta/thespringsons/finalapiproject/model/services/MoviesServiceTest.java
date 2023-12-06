package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoviesServiceTest {

    @Autowired
    private MoviesService moviesService;

    @Test
    @DisplayName("testMovieIsWithinRange")
    public void testMovieIsWithinRange() throws Exception {
        List<Movie> movie = moviesService.getAllMoviesByReleaseRange("1900", "1915");
        Assertions.assertNotEquals(0, movie.size());
    }

}