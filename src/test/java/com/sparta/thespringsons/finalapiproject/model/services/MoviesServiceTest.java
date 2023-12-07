package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
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
        List<Movie> movie = MoviesService.getAllMoviesByReleaseRange("1900", "1915");
        Assertions.assertNotEquals(0, movie.size());

        for (Movie movie1 : movie){
            System.out.println(movie1.getTitle());
        }
    }

    @Test
    @DisplayName("Testing get by year exact with 1994")
    public void testingGetByYearExactWith1994() {
        List<Movie> result = moviesService.getMoviesByYearExact("1994");
        Assertions.assertNotNull(result);
        if(!result.isEmpty()) {
            for (Movie movie : result) {
                Assertions.assertEquals(1994, Integer.parseInt(movie.getYear()));
            }
        }
    }
    @Test
    @DisplayName("Testing get by year after with 1994")
    public void testingGetByYearAfterWith1994(){
        List<Movie> result = moviesService.getMoviesByYearAfter("1994");
        Assertions.assertNotNull(result);
        if(!result.isEmpty()) {
            for (Movie movie : result) {
                Assertions.assertTrue(Integer.parseInt(movie.getYear()) >= 1994);
            }
        }
    }

    @Test
    @DisplayName("Testing get by year exact with 1994e1998")
    public void testingGetByYearExactWith1994E1998(){
        Assertions.assertNull(moviesService.getMoviesByYearExact("1994e1998"));
    }

    @Test
    @DisplayName("Testing get movies by max runtime with 120mins")
    public void testingGetMoviesByMaxRuntimeWith120Mins(){
        List<Movie> result = moviesService.getMoviesByMaxRuntime(120);
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getRuntime() <= 120);
            }
        }
    }
    @Test
    @DisplayName("Testing get movies by plot with violin")
    public void testingGetMoviesByFullPlotWithCar(){
        List<Movie> result = moviesService.getAllByFullPlot("violin");
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getFullplot().contains("violin"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by plot with violin")
    public void testingGetMoviesByPlotWithCar(){
        List<Movie> result = moviesService.getAllByPlot("violin");
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getPlot().contains("violin"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Title returns The Great Train Robbery")
    public void testingGetMovieByTitleReturnsTheGreatTrainRobbery(){
        List<Movie> result = moviesService.getMovieByTitle("The Great Train Robbery");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getTitle().contains("The Great Train Robbery"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Director returns Hal Roach")
    public void testingGetMovieByDirectorReturnsHalRoach(){
        List<Movie> result = moviesService.getAllMoviesByDirector("Hal Roach");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getDirectors().contains("Hal Roach"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Genre returns Comedy")
    public void testingGetMovieByGenreReturnsComedy(){
        List<Movie> result = moviesService.getMoviesByGenre("Comedy");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getGenres().contains("Comedy"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Language returns English")
    public void testingGetMovieByLanguageReturnsEnglish(){
        List<Movie> result = moviesService.getMoviesByLanguages("English");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getLanguages().contains("English"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Country returns France")
    public void testingGetMovieByCountryReturnsFrance(){
        List<Movie> result = moviesService.getMoviesByCountries("France");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getCountries().contains("France"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Imdb Rating returns movies with 3 for rating")
    public void testingGetMovieByImdbRatingReturnsMoviesWith3Rating(){
        List<Movie> result = moviesService.getAllMoviesByImdbRating(3d,3.0d);
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getImdb().getRating().equals(3d));
            }
        }
    }

    @Test
    @DisplayName("Testing get Number Of Movie Imdb Votes returns 1375")
    public void testingGetNumberOfMovieImdbVotesReturns1375(){
        List<String> result = moviesService.getNumberOfMovieImdbVotes("A Corner in Wheat");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.equals("A Corner in Wheat IMDB Votes: 1375"));
            }
        }
    }

    @Test
    @DisplayName("Testing get Movie Imdb Rating by Title returns 6")
    public void testingGetMovieImdbRatingByTitleReturns6(){
        List<String> result = moviesService.getMovieImdbRatingByName("Traffic in Souls");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.contains("6"));
            }
        }
    }

    @Test
    @DisplayName("Testing get Movie Imdb Id by Title returns 3471")
    public void testingGetMovieImdbIdByTitleReturns3471(){
        List<String> result = moviesService.getMovieImdbIdByName("Traffic in Souls");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.contains(" IMDB ID : "));
            }
        }
    }







}