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
    
}
