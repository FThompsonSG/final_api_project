package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MovieMockTests {

    @Autowired
    private MoviesService moviesService;

    @Mock
    private MovieRepository movieRepositoryMock;

    @InjectMocks
    private MoviesService moviesServiceMock;
    @Test
    @DisplayName("Testing add document to mock repository")
    public void testingAddDocumentToMockRepository(){
        Movie mockMovie = new Movie();
        mockMovie.setYear("2002");
        String[] directors = {"Luke Boorman"};
        mockMovie.setDirectors(List.of(directors));
        mockMovie.setCast(List.of(directors));
        mockMovie.setTitle("The film");
        mockMovie.setGenres(List.of(directors));
        mockMovie.setLanguages(List.of(directors));

        // Mock the repository behavior
        Mockito.when(movieRepositoryMock.save(Mockito.any(Movie.class)))
                .thenReturn(mockMovie);

        Movie result = moviesServiceMock.addMovie(mockMovie);

        Mockito.verify(movieRepositoryMock, Mockito.times(1)).save(Mockito.eq(mockMovie));

        Assertions.assertEquals(mockMovie, result);
    }

    @Test
    @DisplayName("Testing delete document from mock repository")
    public void testingDeleteFromMockRepository() {
        Movie mockMovie = new Movie();
        mockMovie.setId("HenriqueMartinsDaCunha");




        Mockito.when(movieRepositoryMock.save(Mockito.any(Movie.class)))
                .thenReturn(mockMovie);

        moviesServiceMock.deleteMovieById(mockMovie.getId());
        //mockMovie.getId()
        
        Mockito.verify(movieRepositoryMock, Mockito.times(1)).deleteById(mockMovie.getId());

    }
}
