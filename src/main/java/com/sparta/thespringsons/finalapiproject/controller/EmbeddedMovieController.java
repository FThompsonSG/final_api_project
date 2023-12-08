package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.InvalidDocumentException;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;

import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;

import com.sparta.thespringsons.finalapiproject.model.services.EmbeddedMoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class EmbeddedMovieController {

    private final EmbeddedMoviesService embeddedMoviesService;

    @Autowired
    public EmbeddedMovieController(EmbeddedMoviesService embeddedMoviesService) {
        this.embeddedMoviesService = embeddedMoviesService;
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Title")
    @PatchMapping ("/embeddedMovie/UpdateTitle")
    public void updateEmbeddedMovieTitle(@RequestParam String Id, @RequestParam String newTitle) {
        embeddedMoviesService.updateEmbeddedMovieTitle(Id, newTitle);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Writers")
    @PatchMapping ("/embeddedMovie/UpdateWriters")
    public void updateEmbeddedMovieWriters(@RequestParam String Id, @RequestParam String newWriter) {
        embeddedMoviesService.updateEmbeddedMovieWriters(Id, newWriter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Cast")
    @PatchMapping ("/embeddedMovie/UpdateCast")
    public void updateEmbeddedMovieCast(@RequestParam String Id, @RequestParam String newMember) {
        embeddedMoviesService.updateEmbeddedMovieCast(Id, newMember);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Genre")
    @PatchMapping ("/embeddedMovie/UpdateGenre")
    public void updateEmbeddedMovieGenres(@RequestParam String Id, @RequestParam String newGenre) {
        embeddedMoviesService.updateEmbeddedMovieGenres(Id,newGenre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Language")
    @PatchMapping ("/embeddedMovie/UpdateLanguage")
    public void updateEmbeddedMovieLanguages(@RequestParam String Id, @RequestParam String newLanguage) {
        embeddedMoviesService.updateEmbeddedMovieLanguages(Id, newLanguage);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Country")
    @PatchMapping ("/embeddedMovie/UpdateCountry")
    public void updateEmbeddedMovieCountries(@RequestParam String Id, @RequestParam String newCountry) {
        embeddedMoviesService.updateEmbeddedMovieCountries(Id, newCountry);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates CommentCount")
    @PatchMapping ("/embeddedMovie/UpdateCommentCount")
    public void incrementCommentCount(@RequestParam String Id) {
        embeddedMoviesService.incrementCommentCount(Id);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic meter")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesCriticMeter")
    public void updateTomatoesCriticMeter(@RequestParam String id, @RequestParam Integer meter ) {
        embeddedMoviesService.updateTomatoesCriticMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer meter")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesViewerMeter")
    public void updateTomatoesViewerMeter(@RequestParam String id, @RequestParam Integer meter ) {
        embeddedMoviesService.updateTomatoesViewerMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer NumReviews")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesViewerNumReviews")
    public void updateTomatoesViewerNumReviews(@RequestParam String id, @RequestParam Integer numReviews) {
        embeddedMoviesService.updateTomatoesViewerNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic NumReviews")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesCriticNumReviews")
    public void updateTomatoesCriticNumReviews(@RequestParam String id, @RequestParam Integer numReviews) {
        embeddedMoviesService.updateTomatoesCriticNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic Rating")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesCriticRating")
    public void updateTomatoesCriticRating(@RequestParam String id, @RequestParam Double rating) {
        embeddedMoviesService.updateTomatoesCriticRating(id, rating);
    }


    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer Rating")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesViewerRating")
    public void updateTomatoesViewerRating(@RequestParam String id, @RequestParam Double rating) {
        embeddedMoviesService.updateTomatoesViewerRating(id, rating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Rotten")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesRotten")
    public void updateTomatoesRotten(@RequestParam String id, @RequestParam Integer rotten) {
        embeddedMoviesService.updateTomatoesRotten(id, rotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Fresh")
    @PatchMapping ("/embeddedMovie/UpdateTomatoesFresh")
    public void updateTomatoesFresh(@RequestParam String id, @RequestParam Integer fresh) {
        embeddedMoviesService.updateTomatoesFresh(id, fresh);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Award Wins")
    @PatchMapping ("/embeddedMovie/UpdateAwardsWins")
    public void updateAwardsWins(@RequestParam String code, @RequestParam Integer wins) {
        embeddedMoviesService.updateAwardsWins(code, wins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates awards nominations")
    @PatchMapping ("/embeddedMovie/UpdateAwardsNominations")
    public void updateAwardsNominations(@RequestParam String code, @RequestParam Integer nominations) {
        embeddedMoviesService.updateAwardsNominations(code,nominations);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie release date")
    @PatchMapping ("/embeddedMovie/UpdateReleaseDate")
    public void updateReleaseDate(@RequestParam String Id, @RequestParam String date) {
        embeddedMoviesService.updateReleaseDate(Id, date);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Runtime")
    @PatchMapping ("/embeddedMovie/UpdateRuntime")
    public void updateRuntime(@RequestParam String Id, @RequestParam Integer runtime) {
        embeddedMoviesService.updateRuntime(Id, runtime);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Year")
    @PatchMapping ("/embeddedMovie/UpdateYear")
    public void updateYear(@RequestParam String Id, @RequestParam String year) {
        embeddedMoviesService.updateYear(Id, year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Deletes embedded movie by Id")
    @DeleteMapping ("/embeddedMovie/DeleteById")
    public void deleteMovieById(@RequestParam String Id) {
        embeddedMoviesService.deleteMovieById(Id);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets embedded movie from Embedding")
    @GetMapping("/embeddedMovie/ByEmbedding")
    public List<EmbeddedMovie> findEmbeddedMovieFromEmbedding(@RequestBody EmbeddedMovie originalMovie, @RequestParam double wantedDistance) {
        return embeddedMoviesService.findEmbeddedMovieFromEmbedding(originalMovie, wantedDistance);
    }

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
        return embeddedMoviesService.findAllMoviesByImdbRating(lowerRating, upperRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies, by Movie Imdb Votes")
    @GetMapping("/embeddedMovie/ByMovieImdbVotes")
    public List<String> getNumberOfMovieImdbVotes(@RequestParam String movieName) {
        return embeddedMoviesService.findAllNumberOfMovieImdbVotes(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Rating By Name")
    @GetMapping("/embeddedMovie/getMovieImdbRatingByName")
    public List<String> getMovieImdbRatingByName(@RequestParam String movieName) {
        return embeddedMoviesService.findAllMovieImdbRatingByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/embeddedMovie/getMovieImdbIdByName")
    public List<String> getMovieImdbIdByName(@RequestParam String movieName) {
        return embeddedMoviesService.findAllMovieImdbIdByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByCountry")
    public  List<EmbeddedMovie> getEmbeddedMoviesByCountry(@RequestParam String movieName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByCountry(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Nominations")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByNumberOfNominations")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfNominations(@RequestParam Integer noms) {
        return embeddedMoviesService.findAllEmbeddedMoviesByNumberOfNominations(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Wins")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByNumberOfWins")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfWins(@RequestParam Integer noms) {
        return embeddedMoviesService.findAllEmbeddedMoviesByNumberOfWins(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Award Name")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByAwardName")
    public  List<EmbeddedMovie> getEmbeddedMoviesByAwardName(@RequestParam String awardName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByAwardName(awardName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Title Containing")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByTitleContaining")
    public  List<EmbeddedMovie> getEmbeddedMoviesByTitleContaining(@RequestParam String filmTitle) {
        return embeddedMoviesService.findAllEmbeddedMoviesByTitleContaining(filmTitle);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Cast Member")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByCastMember")
    public  List<EmbeddedMovie> getEmbeddedMoviesByCastMember(@RequestParam String castMemberName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByCastMember(castMemberName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Director")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByDirector")
    public  List<EmbeddedMovie> getEmbeddedMoviesByDirector(@RequestParam String directorName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByDirector(directorName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByFullPlot")
    public  List<EmbeddedMovie> getEmbeddedMoviesByFullPlot(@RequestParam String fullPlot) {
        return embeddedMoviesService.findAllEmbeddedMoviesByFullPlot(fullPlot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByGenre")
    public  List<EmbeddedMovie> getEmbeddedMoviesByGenre(@RequestParam String genre) {
        return embeddedMoviesService.findAllEmbeddedMoviesByGenre(genre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Language")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByLanguage")
    public  List<EmbeddedMovie> getEmbeddedMoviesByLanguage(@RequestParam String language) {
        return embeddedMoviesService.findAllEmbeddedMoviesByLanguage(language);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Comments Lower Bound")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByNumberOfCommentsLowerBound")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfCommentsLowerBound(@RequestParam Integer numberOfComments) {
        return embeddedMoviesService.findAllEmbeddedMoviesByNumberOfCommentsLowerBound(numberOfComments);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Plot")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByPlot")
    public  List<EmbeddedMovie> getEmbeddedMoviesByPlot(@RequestParam String plot) {
        return embeddedMoviesService.findAllEmbeddedMoviesByPlot(plot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Max Runtime")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByMaxRuntime")
    public  List<EmbeddedMovie> getEmbeddedMoviesByMaxRuntime(@RequestParam Integer mins) {
        return embeddedMoviesService.findAllEmbeddedMoviesByMaxRuntime(mins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Writer")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByWriter")
    public  List<EmbeddedMovie> getEmbeddedMoviesByWriter(@RequestParam String writerName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByWriter(writerName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Exact")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByYearExact")
    public  List<EmbeddedMovie> getEmbeddedMoviesByYearExact(@RequestParam String year) {
        return embeddedMoviesService.findAllEmbeddedMoviesByYearExact(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Poster Link By Title")
    @GetMapping("/embeddedMovie/getPosterLinkByTitle")
    public List<String> getPosterLinkByTitle(@RequestParam String name) {
        return embeddedMoviesService.findAllPosterLinkByTitle(name);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Before")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByYearBefore")
    public  List<EmbeddedMovie> getEmbeddedMoviesByYearBefore(@RequestParam String year) {
        return embeddedMoviesService.findAllEmbeddedMoviesByYearBefore(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year After")
    @GetMapping("/embeddedMovie/getEmbeddedMoviesByYearAfter")
    public  List<EmbeddedMovie> findAllEmbeddedMoviesByYearAfter(@RequestParam String year) {
        return embeddedMoviesService.findAllEmbeddedMoviesByYearAfter(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get All Movies By ReleaseRange")
    @GetMapping("/embeddedMovie/getAllMoviesByReleaseRange")
    public List<EmbeddedMovie> findAllByReleaseRange(@RequestParam String lowerDate, @RequestParam String upperDate) {
        return embeddedMoviesService.findAllMoviesByReleaseRange(lowerDate,upperDate);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "creates an embedded movie")
    @PutMapping("/embeddedMovie/addEmbeddedMovie")
    public void addEmbeddedMovie(@RequestBody EmbeddedMovie movie) {
        embeddedMoviesService.addEmbeddedMovie(movie);
    }
}
