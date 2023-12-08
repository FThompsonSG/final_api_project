package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoviesServiceTest {

    @Autowired
    private MoviesService moviesService;

    @Test
    @DisplayName("testMovieIsWithinRange")
    public void testMovieIsWithinRange() throws Exception {
        List<Movie> movie = moviesService.findAllMoviesByReleaseRange("1900", "1915");
        Assertions.assertNotEquals(0, movie.size());

        for (Movie movie1 : movie){
            System.out.println(movie1.getTitle());
        }
    }

    @Test
    @DisplayName("Testing get by year exact with 1994")
    public void testingGetByYearExactWith1994() {
        List<Movie> result = moviesService.findAllMoviesByYearExact("1994");
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
        List<Movie> result = moviesService.findAllMoviesByYearAfter("1994");
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
        Assertions.assertNull(moviesService.findAllMoviesByYearExact("1994e1998"));
    }

    @Test
    @DisplayName("Testing get movies by max runtime with 120mins")
    public void testingGetMoviesByMaxRuntimeWith120Mins(){
        List<Movie> result = moviesService.findAllMoviesByMaxRuntime(120);
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getRuntime() <= 120);
            }
        }
    }
    @Test
    @DisplayName("Testing get movies by plot with violin")
    public void testingGetMoviesByFullPlotWithCar(){
        List<Movie> result = moviesService.findAllByFullPlot("violin");
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getFullplot().contains("violin"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by plot with violin")
    public void testingGetMoviesByPlotWithCar(){
        List<Movie> result = moviesService.findAllByPlot("violin");
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getPlot().contains("violin"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Title returns The Great Train Robbery")
    public void testingGetMovieByTitleReturnsTheGreatTrainRobbery(){
        List<Movie> result = moviesService.findAllMovieByTitle("The Great Train Robbery");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getTitle().contains("The Great Train Robbery"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Director returns Hal Roach")
    public void testingGetMovieByDirectorReturnsHalRoach(){
        List<Movie> result = moviesService.findAllMoviesByDirector("Hal Roach");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getDirectors().contains("Hal Roach"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Genre returns Comedy")
    public void testingGetMovieByGenreReturnsComedy(){
        List<Movie> result = moviesService.findAllMoviesByGenre("Comedy");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getGenres().contains("Comedy"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Language returns English")
    public void testingGetMovieByLanguageReturnsEnglish(){
        List<Movie> result = moviesService.findAllMoviesByLanguages("English");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getLanguages().contains("English"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Country returns France")
    public void testingGetMovieByCountryReturnsFrance(){
        List<Movie> result = moviesService.findAllMoviesByCountries("France");
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getCountries().contains("France"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by Imdb Rating returns movies with 3 for rating")
    public void testingGetMovieByImdbRatingReturnsMoviesWith3Rating(){
        List<Movie> result = moviesService.findAllMoviesByImdbRating(3d,3.0d);
        if(!result.isEmpty()) {
            for(Movie movie : result) {
                Assertions.assertTrue(movie.getImdb().getRating().equals(3d));
            }
        }
    }

    @Test
    @DisplayName("Testing get Number Of Movie Imdb Votes returns 1375")
    public void testingGetNumberOfMovieImdbVotesReturns1375(){
        List<String> result = moviesService.findAllNumberOfMovieImdbVotes("A Corner in Wheat");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.equals("A Corner in Wheat IMDB Votes: 1375"));
            }
        }
    }

    @Test
    @DisplayName("Testing get Movie Imdb Rating by Title returns 6")
    public void testingGetMovieImdbRatingByTitleReturns6(){
        List<String> result = moviesService.findAllMovieImdbRatingByName("Traffic in Souls");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.contains("6"));
            }
        }
    }

    @Test
    @DisplayName("Testing get Movie Imdb Id by Title returns 3471")
    public void testingGetMovieImdbIdByTitleReturns3471(){
        List<String> result = moviesService.findAllMovieImdbIdByName("Traffic in Souls");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.contains(" IMDB ID : "));
            }
        }
    }

    @Test
    @DisplayName("Testing get Year of Release returns 1914")
    public void testingGetYearOfReleaseReturns1914(){
        List<String> result = moviesService.findAllYearOfRelease("Gertie the Dinosaur");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.contains("1914"));
            }
        }
    }

    @Test
    @DisplayName("Testing get Poster returns Link")
    public void testingGetPosterLinkReturnsLink(){
        List<String> result = moviesService.findAllPosterLinkByTitle("Gertie the Dinosaur");
        if(!result.isEmpty()) {
            for(String movie : result) {
                Assertions.assertTrue(movie.contains("https://m.media-amazon.com/images/M/MV5BMTQxNzI4ODQ3NF5BMl5BanBnXkFtZTgwNzY5NzMwMjE@._V1_SY1000_SX677_AL_.jpg"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by cast member")
    public void testingGetMoviesByCastMember(){
        List<Movie> result = moviesService.findAllMoviesByCastMember("Katherine");
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                List<String> castMembers = movie.getCast();
                Assertions.assertTrue(castMembers.stream().anyMatch(s -> s.toLowerCase().contains("katherine")));
            }
        }
    }

    @Test
    @DisplayName("Testing get movie by award name with Oscar")
    public void testingGetMovieByAwardNameWithOscar(){
        List<Movie> result = moviesService.findAllMoviesByAwardName("Oscar");
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getAwards().getText().contains("Oscar"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by number of nominations with 8")
    public void testingGetMoviesByNumberOfNominationsWith8(){
        List<Movie> result = moviesService.findAllMoviesByNumberOfNominations(8);
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getAwards().getNominations() >= 8);
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by number of wins with 1")
    public void testingGetMoviesByNumberOfWinsWith1(){
        List<Movie> result = moviesService.findAllMoviesByNumberOfWins(1);
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getAwards().getWins() >= 1);
            }
        }
    }

    @Test
    @DisplayName("Testing get last updated for movie Gertie the Dinosaur")
    public void testingGetLastUpdatedByMovieTitle(){
        List<String> result = moviesService.findAllLastUpdatedByMovieTitle("Gertie the Dinosaur");
        if(!result.isEmpty()) {
            for(String movie: result) {
                Assertions.assertTrue(movie.contains("2015-08-18 01:03:15.313000000"));
            }
        }
    }
    @Test
    @DisplayName("Testing get Number of Comments for movie Gertie the Dinosaur")
    public void testingGetNumberOfCommentsByMovieTitle(){
        List<String> result = moviesService.findAllNumberOfCommentsByTitle("Gertie the Dinosaur");
        if(!result.isEmpty()) {
            for(String movie: result) {
                Assertions.assertTrue(movie.contains("0"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by range of runtime")
    public void testingGetMoviesByRangeOfRuntime(){
        List<Movie> result = moviesService.findAllMoviesByRangeOfRuntime(100,100);
        if(!result.isEmpty()) {
            for(Movie movie: result) {
                Assertions.assertTrue(movie.getRuntime().equals(100));
            }
        }
    }

    @Test
    @DisplayName("Testing get type for movie Gertie the Dinosaur")
    public void testingGetTypeByMovieTitle(){
        List<String> result = moviesService.findAllTypeByTitle("Gertie the Dinosaur");
        if(!result.isEmpty()) {
            for(String movie: result) {
                Assertions.assertTrue(movie.contains("movie"));
            }
        }
    }

    @Test
    @DisplayName("Testing get all movies by writer Winsor MCcay")
    public void getAllMoviesByWriter(){

        List<Movie> movies = moviesService.findAllMoviesByWriter("Winsor mccay");
        System.out.println(movies);
        if(!movies.isEmpty()) {
            for (Movie movie : movies) {
                List<String> writers = movie.getWriters();
                Assertions.assertTrue(writers.stream().anyMatch(x -> x.toLowerCase().contains("winsor mccay")));

            }
        }else{
            Assertions.assertEquals(0, movies.size());
        }
    }

    @Test
    @DisplayName("Testing get all movies with train in title")
    public void getAllMoviesByTitle(){

        List<Movie> movies = moviesService.findAllMovieByTitle("train");
        System.out.println(movies);
        if(!movies.isEmpty()) {
            for (Movie movie : movies) {
                String movieTitle = movie.getTitle();
                Assertions.assertTrue(movieTitle.toLowerCase().contains("train"));

            }
        }else{
            Assertions.assertEquals(0, movies.size());
        }
    }
}