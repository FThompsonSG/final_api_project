package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.fields.Tomato;
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
        //maybe add all the fields?
        Movie testMovie = new Movie();
        testMovie.setId("HenriqueMartinsDaCunha");
        Awards testAwards = new Awards();
        testAwards.setWins(2);
        testAwards.setNominations(1);
        testAwards.setText("2 wins and 1 nomination.");
        testMovie.setAwards(testAwards);
        testMovie.setFullplot("This is the full plot.");
        testMovie.setYear("2002");
        List<String> directors = new ArrayList<>();
        directors.add("Luke Boorman");
        testMovie.setDirectors(directors);
        testMovie.setGenres(directors);
        Imdb testImdb = new Imdb();
        testImdb.setRating(7.3);
        testImdb.setVotes(373);
        testImdb.setId(3794);
        testMovie.setImdb(testImdb);
        testMovie.setCast(directors);
        testMovie.setTitle("The film");
        testMovie.setLanguages(directors);
        testMovie.setLastupdated("Updated now.");
        testMovie.setNum_mflix_comments(1);
        testMovie.setPlot("This ist he plot.");
        testMovie.setPoster("Poster");
        testMovie.setRated("PG");
        testMovie.setReleased("Now.");
        testMovie.setRuntime(37);
        testMovie.setType("Movie");
        testMovie.setWriters(directors);
        Tomato testTomato = new Tomato();
        testTomato.setFresh(1);
        testTomato.setRotten(0);
        testMovie.setTomatoes(testTomato);

        testMovie.setGenres(directors);
        testMovie.setLanguages(directors);

        Movie filmToCheck = moviesService.addMovie(testMovie);
        System.out.println(filmToCheck);

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
