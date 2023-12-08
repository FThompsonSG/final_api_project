package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.InvalidDocumentException;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.services.EmbeddedMoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class EmbeddedMovieController {

    EmbeddedMoviesService embeddedMoviesService;

    public EmbeddedMovieController(EmbeddedMoviesService embeddedMoviesService) {
        this.embeddedMoviesService = embeddedMoviesService;
    }
//
//    @Tag(name = "Embedded Movie API")
//    @Operation(summary = "Gets all the embedded movies from MongoDB")
//    @GetMapping("/embeddedMovie")
//    public void getAllEmbeddedMovies() {
//        // Gets all embedded movie
//        // Should return list.
//    }
//
//    @Tag(name = "Embedded Movie API")
//    @Operation(summary = "Gets an embedded movie by its ID.")
//    @GetMapping("/embeddedMovie/byId/{movie_id}")
//    public void getEmbeddedMovieById(@PathVariable String movie_id) {
//        // Gets embedded movie by id
//        // Should return Optional.
//    }
//
//    @Tag(name = "Embedded Movie API")
//    @Operation(summary = "Gets an embedded movie by date range")
//    @GetMapping("/embeddedMovie/byDateRange")
//    public void getEmbeddedMovieByDateRange
//            (@RequestParam Integer lowerYear, @RequestParam Integer upperYear) {
//        // Gets an embedded movie by date range
//        // If either are empty or null, it assumes to search everything before or after
//        // Should return a list.
//    }
//
//    @Tag(name = "Embedded Movie API")
//    @Operation(summary = "Creates a new EmbeddedMovie record into the database.")
//    @PostMapping("/embeddedMovie/add")
//    public void createEmbeddedMovie() { // We need a body in here somewhere
//        // Gets all embedded movie
//        // Maybe returns the JSON body of created object?
//    }
//
//    @Tag(name = "Embedded Movie API")
//    @Operation(summary = "Gets alL embedded movie by runtime range")
//    @GetMapping("/embeddedMovie/byRuntime")
//    public void getEmbeddedMovieByRuntimeRange
//            (@RequestParam Integer lowerRuntime, @RequestParam Integer upperRuntime) {
//        // Gets all embedded movies within the specified runtime range
//        // If either are empty or null, it assumes to search everything before or after
//        // Returns a list
//    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato rating")
    @GetMapping("/embeddedMovie/ByTomatoesCriticRating")
    public List<EmbeddedMovie> findAllByTomatoesCriticRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesCriticRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato viewer rating")
    @GetMapping("/embeddedMovie/ByTomatoesViewerRating")
    public List<EmbeddedMovie> findAllByTomatoesViewerRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesViewerRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato meter rating")
    @GetMapping("/embeddedMovie/ByTomatoesCriticMeter")
    public List<EmbeddedMovie> findAllByTomatoesCriticMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesCriticMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by viewer meter rating")
    @GetMapping("/embeddedMovie/ByTomatoesViewerMeter")
    public List<EmbeddedMovie> findAllByTomatoesViewerMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesViewerMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Rotten Reviews")
    @GetMapping("/embeddedMovie/ByTomatoesRottenReviews")
    public List<EmbeddedMovie> findAllByTomatoesRottenReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return embeddedMoviesService.findAllByTomatoesRottenReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Fresh Reviews")
    @GetMapping("/embeddedMovie/ByTomatoesFreshReviews")
    public List<EmbeddedMovie> findAllByTomatoesFreshReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return embeddedMoviesService.findAllByTomatoesFreshReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Production")
    @GetMapping("/embeddedMovie/ByTomatoesProduction")
    public List<EmbeddedMovie> findAllByTomatoesProduction(@RequestParam String production) {
        return embeddedMoviesService.findAllByTomatoesProduction(production);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Imdb Rating")
    @GetMapping("/embeddedMovie/ByImdbRating")
    public List<EmbeddedMovie> getAllMoviesByImdbRating(@RequestParam double lowerRating, @RequestParam double upperRating) {
        return embeddedMoviesService.getAllMoviesByImdbRating(lowerRating, upperRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies, by Movie Imdb Votes")
    @GetMapping("/embeddedMovie/ByMovieImdbVotes")
    public List<String> getNumberOfMovieImdbVotes(@RequestParam String movieName) {
        return embeddedMoviesService.getNumberOfMovieImdbVotes(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Rating By Name")
    @GetMapping("/embeddedMovie/getMovieImdbRatingByName")
    public List<String> getMovieImdbRatingByName(@RequestParam String movieName) {
        return embeddedMoviesService.getMovieImdbRatingByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/embeddedMovie/getMovieImdbIdByName")
    public List<String> getMovieImdbIdByName(@RequestParam String movieName) {
        return embeddedMoviesService.getMovieImdbIdByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByCountry")
    public  List<EmbeddedMovie> getEmbeddedMoviesByCountry(@RequestParam String movieName) {
        return embeddedMoviesService.getEmbeddedMoviesByCountry(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Nominations")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByNumberOfNominations")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfNominations(@RequestParam Integer noms) {
        return embeddedMoviesService.getEmbeddedMoviesByNumberOfNominations(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Wins")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByNumberOfWins")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfWins(@RequestParam Integer noms) {
        return embeddedMoviesService.getEmbeddedMoviesByNumberOfWins(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Award Name")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByAwardName")
    public  List<EmbeddedMovie> getEmbeddedMoviesByAwardName(@RequestParam String awardName) {
        return embeddedMoviesService.getEmbeddedMoviesByAwardName(awardName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Title Containing")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByTitleContaining")
    public  List<EmbeddedMovie> getEmbeddedMoviesByTitleContaining(@RequestParam String filmTitle) {
        return embeddedMoviesService.getEmbeddedMoviesByTitleContaining(filmTitle);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Cast Member")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByCastMember")
    public  List<EmbeddedMovie> getEmbeddedMoviesByCastMember(@RequestParam String castMemberName) {
        return embeddedMoviesService.getEmbeddedMoviesByCastMember(castMemberName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Director")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByDirector")
    public  List<EmbeddedMovie> getEmbeddedMoviesByDirector(@RequestParam String directorName) {
        return embeddedMoviesService.getEmbeddedMoviesByDirector(directorName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByDirector")
    public  List<EmbeddedMovie> getEmbeddedMoviesByFullPlot(@RequestParam String fullPlot) {
        return embeddedMoviesService.getEmbeddedMoviesByFullPlot(fullPlot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByDirector")
    public  List<EmbeddedMovie> getEmbeddedMoviesByGenre(@RequestParam String genre) {
        return embeddedMoviesService.getEmbeddedMoviesByGenre(genre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Language")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByLanguage")
    public  List<EmbeddedMovie> getEmbeddedMoviesByLanguage(@RequestParam String language) {
        return embeddedMoviesService.getEmbeddedMoviesByLanguage(language);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Comments Lower Bound")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByNumberOfCommentsLowerBound")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfCommentsLowerBound(@RequestParam Integer numberOfComments) {
        return embeddedMoviesService.getEmbeddedMoviesByNumberOfCommentsLowerBound(numberOfComments);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Plot")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByPlot")
    public  List<EmbeddedMovie> getEmbeddedMoviesByPlot(@RequestParam String plot) {
        return embeddedMoviesService.getEmbeddedMoviesByPlot(plot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Max Runtime")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByMaxRuntime")
    public  List<EmbeddedMovie> getEmbeddedMoviesByMaxRuntime(@RequestParam Integer mins) {
        return embeddedMoviesService.getEmbeddedMoviesByMaxRuntime(mins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Writer")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByWriter")
    public  List<EmbeddedMovie> getEmbeddedMoviesByWriter(@RequestParam String writerName) {
        return embeddedMoviesService.getEmbeddedMoviesByWriter(writerName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Exact")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByYearExact")
    public  List<EmbeddedMovie> getEmbeddedMoviesByYearExact(@RequestParam String year) {
        return embeddedMoviesService.getEmbeddedMoviesByYearExact(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Poster Link By Title")
    @GetMapping("/embeddedMovie/getPosterLinkByTitle")
    public List<String> getPosterLinkByTitle(@RequestParam String name) {
        return embeddedMoviesService.getPosterLinkByTitle(name);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Before")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByYearBefore")
    public  List<EmbeddedMovie> getEmbeddedMoviesByYearBefore(@RequestParam String year) {
        return embeddedMoviesService.getEmbeddedMoviesByYearBefore(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year After")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByYearAfter")
    public  List<EmbeddedMovie> getEmbeddedMoviesByYearAfter(@RequestParam String year) {
        return embeddedMoviesService.getEmbeddedMoviesByYearAfter(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get All Movies By ReleaseRange")
    @GetMapping("/embeddedMovie/getAllMoviesByReleaseRange")
    public List<EmbeddedMovie> getAllMoviesByReleaseRange(@RequestParam String lowerDate, @RequestParam String upperDate) {
        return embeddedMoviesService.getAllMoviesByReleaseRange(lowerDate,upperDate);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "creates an embedded movie")
    @PutMapping("/embeddedMovie/addEmbeddedMovie")
    public void addEmbeddedMovie(@RequestBody EmbeddedMovie movie) {
        embeddedMoviesService.addEmbeddedMovie(movie);
    }
}
