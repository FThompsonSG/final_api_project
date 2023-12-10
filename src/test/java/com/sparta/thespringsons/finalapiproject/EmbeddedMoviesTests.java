package com.sparta.thespringsons.finalapiproject;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.services.EmbeddedMoviesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EmbeddedMoviesTests {

    @Autowired
    private EmbeddedMoviesService embeddedMoviesService;

    @Mock
    private EmbeddedMoviesRepository embeddedMoviesRepository;

    @InjectMocks
    private EmbeddedMoviesService embeddedMoviesServiceMock;

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
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByYearExact("1994");
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
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByYearAfter("1994");
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
        Assertions.assertNull(embeddedMoviesService.findAllEmbeddedMoviesByYearExact("1994e1998"));
    }
    
    @Test
    @DisplayName("Testing get movies by writer with Niven Busch")
    public void testingGetMoviesByWriterWithNivenBusch(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByWriter("Niven Busch");
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
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByMaxRuntime(120);
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getRuntime() <= 120);
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by plot with rejected by his")
    public void testingGetMoviesByPlotWithCar(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByPlot("rejected by his");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getPlot().contains("rejected by his"));
            }
        }
    }

    @Test
    @DisplayName("Testing get number of comments with 8")
    public void testingGetNumberOfCommentsWith8(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByNumberOfCommentsLowerBound(8);
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getNum_mflix_comments() > 8);
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by language with French")
    public void testingGetMoviesByLanguageWithFrench(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByLanguage("French");
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
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByGenre("Action");
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
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByDirector("Howard Hawks");
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
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByCastMember("Katherine");
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
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByTitleContaining("Harry Potter");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getTitle().contains("Harry Potter"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movie by award name with Oscar")
    public void testingGetMovieByAwardNameWithOscar(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByAwardName("Oscar");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getAwards().getText().contains("Oscar"));
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by number of nominations with 8")
    public void testingGetMoviesByNumberOfNominationsWith8(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByNumberOfNominations(8);
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                Assertions.assertTrue(embeddedMovie.getAwards().getNominations() >= 8);
            }
        }
    }

    @Test
    @DisplayName("Testing get movies by country with France")
    public void testingGetMoviesByCountryWithFrance(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByCountry("France");
        if(!result.isEmpty()) {
            for(EmbeddedMovie embeddedMovie: result) {
                List<String> countries = Arrays.asList(embeddedMovie.getCountries());
                Assertions.assertTrue(countries.stream().anyMatch(s -> s.toLowerCase().contains("france")));
            }
        }
    }

    //-------->07/12/2023<--------------
    @Test
    @DisplayName("Testing add document to mock repository")
    public void testingAddDocumentToMockRepository(){
        EmbeddedMovie mockMovie = new EmbeddedMovie();
        mockMovie.setYear("2002");
        String[] directors = {"Luke Boorman"};
        mockMovie.setDirectors(directors);
        mockMovie.setCast(directors);
        mockMovie.setTitle("The film");
        mockMovie.setGenres(directors);
        mockMovie.setLanguages(directors);

        // Mock the repository behavior
        Mockito.when(embeddedMoviesRepository.save(Mockito.any(EmbeddedMovie.class)))
                .thenReturn(mockMovie);

        EmbeddedMovie result = embeddedMoviesServiceMock.addEmbeddedMovie(mockMovie);

        Mockito.verify(embeddedMoviesRepository, Mockito.times(1)).save(Mockito.eq(mockMovie));

        Assertions.assertEquals(mockMovie, result);
    }

    @Test
    @DisplayName("Testing Add Embedded Movie on Real Database")
    public void testingAddEmbeddedMovieOnRealDatabase(){
        EmbeddedMovie testMovie = new EmbeddedMovie();
        testMovie.setYear("2002");
        String[] directors = {"Luke Boorman"};
        testMovie.setDirectors(directors);
        testMovie.setCast(directors);
        testMovie.setTitle("The film");
        testMovie.setGenres(directors);
        testMovie.setLanguages(directors);

        EmbeddedMovie filmToCheck = embeddedMoviesService.addEmbeddedMovie(testMovie);

        Optional<EmbeddedMovie> tester = embeddedMoviesRepository.findById(filmToCheck.getId());
        
        if(tester.isPresent()) {
            Assertions.assertEquals(filmToCheck, tester.get());
        }
    }
    
    @Test
    @DisplayName("Testing Delete Method")
    public void testingDeleteMethod(){
        List<EmbeddedMovie> result = embeddedMoviesService.findAllEmbeddedMoviesByDirector("Luke Boorman");
        for(EmbeddedMovie movie: result) {
            embeddedMoviesService.deleteMovieById(movie.getId());
        }
        List<EmbeddedMovie> testResult = embeddedMoviesService.findAllEmbeddedMoviesByDirector("Luke Boorman");

        Assertions.assertTrue(testResult.isEmpty());
    }

    @Test
    @DisplayName("Testing Some Update Methods")
    public void testingSomeUpdateMethods(){
        EmbeddedMovie testMovie = new EmbeddedMovie();
        testMovie.setYear("2002");
        String[] directors = {"Luke Boorman"};
        testMovie.setDirectors(directors);
        testMovie.setCast(directors);
        testMovie.setTitle("The film");
        testMovie.setGenres(directors);
        testMovie.setLanguages(directors);

        EmbeddedMovie filmToCheck = embeddedMoviesService.addEmbeddedMovie(testMovie);

        //----------->Updates here<------------

        embeddedMoviesService.updateEmbeddedMovieCast(filmToCheck.getId(), "Ryan MCc");
        embeddedMoviesService.updateEmbeddedMovieGenres(filmToCheck.getId(), "Action");
        embeddedMoviesService.updateEmbeddedMovieTitle(filmToCheck.getId(), "The film 2 electric boogaloo");
        embeddedMoviesService.updateYear(filmToCheck.getId(), "2003");

        Optional<EmbeddedMovie> result = embeddedMoviesRepository.findById(filmToCheck.getId());

        if(result.isPresent()) {
            String[] cast = {"Luke Boorman", "Ryan MCc"};
            String[] genres = {"Luke Boorman", "Action"};
            EmbeddedMovie filmToTest = result.get();
            Assertions.assertEquals("The film 2 electric boogaloo", filmToTest.getTitle());
            Assertions.assertEquals(cast, filmToTest.getCast());
            Assertions.assertEquals(genres, filmToTest.getGenres());
            Assertions.assertEquals("2003", filmToTest.getYear());
        }

        //-------------------------------------

        embeddedMoviesService.deleteMovieById(filmToCheck.getId());
    }


}

