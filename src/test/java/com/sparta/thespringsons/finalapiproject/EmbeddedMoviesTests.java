package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.services.EmbeddedMoviesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EmbeddedMoviesTests {

    @Autowired
    private EmbeddedMoviesService embeddedMoviesService;

    @Test
    @DisplayName("Testing get by Rotten Reviews")
    public void testingGetByTomatoRottenReviews() {
        List<EmbeddedMovie> result = embeddedMoviesService.findAllByTomatoesRottenReviews(3, 5);
        Assertions.assertNotNull(result);
        if(!result.isEmpty()) {
            for (EmbeddedMovie embeddedMovie : result) {
                Assertions.assertEquals(4, embeddedMovie.getTomato().getRotten());
            }
        }
    }

    @Test
    @DisplayName("Testing get by Fresh Reviews")
    public void testingGetByTomatoFreshReviews() {
        List<EmbeddedMovie> result = embeddedMoviesService.findAllByTomatoesFreshReviews(3, 5);
        Assertions.assertNotNull(result);
        if(!result.isEmpty()) {
            for (EmbeddedMovie embeddedMovie : result) {
                Assertions.assertEquals(4, embeddedMovie.getTomato().getFresh());
            }
        }
    }

    @Test
    @DisplayName("Testing get by Tomato Production")
    public void testingGetByTomatoProduction() {
        List<EmbeddedMovie> result = embeddedMoviesService.findAllByTomatoesProduction("Paramount Pictures");
        Assertions.assertNotNull(result);
        if(!result.isEmpty()) {
            for (EmbeddedMovie embeddedMovie : result) {
                Assertions.assertEquals("Paramount Pictures", embeddedMovie.getTomato().getProduction());
            }
        }
    }

    @Test
    @DisplayName("Testing get by year exact with 1994")
    public void testingGetByYearExactWith1994() {
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByYearExact("1994");
        Assertions.assertNotNull(result);
        if(!result.isEmpty()) {
            for (EmbeddedMovie embeddedMovie : result) {
                Assertions.assertEquals(1994, Integer.parseInt(embeddedMovie.getYear()));
            }
        }
    }

    @Test
    @DisplayName("Testing get by year after with 1994")
    public void testingGetByYearAfterWith1994(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByYearAfter("1994");
        Assertions.assertNotNull(result);
        if(!result.isEmpty()) {
            for (EmbeddedMovie embeddedMovie : result) {
                Assertions.assertTrue(Integer.parseInt(embeddedMovie.getYear()) >= 1994);
            }
        }
    }

    @Test
    @DisplayName("Testing get by year exact with 1994e1998")
    public void testingGetByYearExactWith1994E1998(){
        Assertions.assertNull(embeddedMoviesService.getEmbeddedMoviesByYearExact("1994e1998"));
    }
    
    @Test
    @DisplayName("Testing get movies by writer with Niven Busch")
    public void testingGetMoviesByWriterWithNivenBusch(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByWriter("Niven Busch");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                List<String> writers = Arrays.asList(embeddedMovie.getWriters());
                Assertions.assertTrue(writers.stream().anyMatch(s -> s.toLowerCase().contains("niven busch")));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by max runtime with 120mins")
    public void testingGetMoviesByMaxRuntimeWith120Mins(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByMaxRuntime(120);
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getRuntime() <= 120);
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by plot with rejected by his")
    public void testingGetMoviesByPlotWithCar(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByPlot("rejected by his");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getPlot().contains("rejected by his"));
            }
        }
    }

    @Test
    @DisplayName("Testing get number of comments with 8")
    public void testingGetNumberOfCommentsWith8(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByNumberOfCommentsLowerBound(8);
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getNum_mflix_comments() > 8);
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by language with French")
    public void testingGetMoviesByLanguageWithFrench(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByLanguage("French");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                List<String> languages = Arrays.asList(embeddedMovie.getLanguages());
                Assertions.assertTrue(languages.stream().anyMatch(s -> s.toLowerCase().contains("french")));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by genre")
    public void testingGetMoviesByGenre(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByGenre("Action");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                List<String> genres = Arrays.asList(embeddedMovie.getGenres());
                Assertions.assertTrue(genres.stream().anyMatch(s -> s.toLowerCase().contains("action")));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by director")
    public void testingGetMoviesByDirector(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByDirector("Howard Hawks");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                List<String> directors = Arrays.asList(embeddedMovie.getDirectors());
                Assertions.assertTrue(directors.stream().anyMatch(s -> s.toLowerCase().contains("howard hawks")));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by cast member")
    public void testingGetMoviesByCastMember(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByCastMember("Katherine");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                List<String> castMembers = Arrays.asList(embeddedMovie.getCast());
                Assertions.assertTrue(castMembers.stream().anyMatch(s -> s.toLowerCase().contains("katherine")));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by title containing with harry potter")
    public void testingGetMoviesByTitleContainingWithHarryPotter(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByTitleContaining("Harry Potter");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getTitle().contains("Harry Potter"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movie by award name with Oscar")
    public void testingGetMovieByAwardNameWithOscar(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByAwardName("Oscar");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getAwards().getText().contains("Oscar"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by number of nominations with 8")
    public void testingGetMoviesByNumberOfNominationsWith8(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByNumberOfNominations(8);
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getAwards().getNominations() >= 8);
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by country with France")
    public void testingGetMoviesByCountryWithFrance(){
        List<EmbeddedMovie> result = embeddedMoviesService.getEmbeddedMoviesByCountry("France");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                List<String> countries = Arrays.asList(embeddedMovie.getCountries());
                Assertions.assertTrue(countries.stream().anyMatch(s -> s.toLowerCase().contains("france")));
            }
        }
    }
}