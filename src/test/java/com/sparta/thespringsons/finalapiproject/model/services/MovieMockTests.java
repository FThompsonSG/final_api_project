package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        when(movieRepositoryMock.save(any(Movie.class)))
                .thenReturn(mockMovie);

        Movie result = moviesServiceMock.addMovie(mockMovie);

        verify(movieRepositoryMock, times(1)).save(Mockito.eq(mockMovie));

        Assertions.assertEquals(mockMovie, result);
    }

    @Test
    @DisplayName("Testing delete document from mock repository")
    public void testingDeleteFromMockRepository() {
        Movie mockMovie = new Movie();
        mockMovie.setId("HenriqueMartinsDaCunha");

        when(movieRepositoryMock.findById(any())).thenReturn(Optional.of(mockMovie));

        moviesServiceMock.deleteMovieById(mockMovie.getId());
        //mockMovie.getId()

        verify(movieRepositoryMock, never()).findById(mockMovie.getId());
        verify(movieRepositoryMock, never()).delete(mockMovie);

    }

    @Test
    @DisplayName("Testing Add Movie on Real Database")
    public void testingAddMovieOnRealDatabase(){
        Movie testMovie = new Movie();
        testMovie.setYear("2002");
        List<String> directors = new ArrayList<>();
        directors.add("Luke Boorman");
        testMovie.setDirectors(directors);
        testMovie.setCast(directors);
        testMovie.setTitle("The film");
        testMovie.setGenres(directors);
        testMovie.setLanguages(directors);

        Movie filmToCheck = moviesService.addMovie(testMovie);

        Optional<Movie> tester = movieRepositoryMock.findById(filmToCheck.getId());

        if(tester.isPresent()) {
            Assertions.assertEquals(filmToCheck, tester.get());
        }
    }
    @Test
    @DisplayName("Testing Delete Method")
    public void testingDeleteMethod(){
        List<Movie> result = moviesService.findAllMoviesByDirector("Luke Boorman");
        for(Movie movie: result) {
            moviesService.deleteMovieById(movie.getId());
        }
        List<Movie> testResult = moviesService.findAllMoviesByDirector("Luke Boorman");

        Assertions.assertTrue(testResult.isEmpty());
    }
    @Test
    @DisplayName("Testing Update Methods")
    public void testingUpdateMethods(){
        Movie testMovie = new Movie();
        testMovie.setYear("2002");
        String[] directors = {"Luke Boorman"};
        testMovie.setDirectors(List.of(directors));
        testMovie.setCast(List.of(directors));
        testMovie.setTitle("The film");
        testMovie.setGenres(List.of(directors));
        testMovie.setLanguages(List.of(directors));

        Movie filmToCheck = moviesService.addMovie(testMovie);


        moviesService.updateMovieCast(filmToCheck.getId(), "Ryan MCc");
        moviesService.updateMovieGenres(filmToCheck.getId(), "Action");
        moviesService.updateMovieTitle(filmToCheck.getId(), "The film 2 electric boogaloo");
        moviesService.updateYear(filmToCheck.getId(), "2003");

        Optional<Movie> result = movieRepositoryMock.findById(filmToCheck.getId());

        if(result.isPresent()) {
            String[] cast = {"Luke Boorman", "Ryan MCc"};
            String[] genres = {"Luke Boorman", "Action"};
            Movie filmToTest = result.get();
            Assertions.assertEquals("The film 2 electric boogaloo", filmToTest.getTitle());
            Assertions.assertEquals(cast, filmToTest.getCast());
            Assertions.assertEquals(genres, filmToTest.getGenres());
            Assertions.assertEquals("2003", filmToTest.getYear());
        }

        //-------------------------------------

        moviesService.deleteMovieById(filmToCheck.getId());
    }
}
