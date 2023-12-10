package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;

import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.model.services.EmbeddedMoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmbeddedMovieController {

    EmbeddedMoviesService embeddedMoviesService;
    private final HttpServletRequest request;
    private final ApiKeyService apiKeyService;

    public EmbeddedMovieController(EmbeddedMoviesService embeddedMoviesService, HttpServletRequest request, ApiKeyService apiKeyService) {
        this.embeddedMoviesService = embeddedMoviesService;
        this.request = request;
        this.apiKeyService = apiKeyService;
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Title")
    @PatchMapping ("/embeddedMovie/update/title")
    public void updateEmbeddedMovieTitle(@RequestParam String Id, @RequestParam String newTitle,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateEmbeddedMovieTitle(Id, newTitle);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Writers")
    @PatchMapping ("/embeddedMovie/update/writers")
    public void updateEmbeddedMovieWriters(@RequestParam String Id, @RequestParam String newWriter,@RequestHeader(name = "Key") String apiKey) {

        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateEmbeddedMovieWriters(Id, newWriter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Cast")
    @PatchMapping ("/embeddedMovie/update/cast")
    public void updateEmbeddedMovieCast(@RequestParam String Id, @RequestParam String newMember,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateEmbeddedMovieCast(Id, newMember);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Genre")
    @PatchMapping ("/embeddedMovie/update/genre")
    public void updateEmbeddedMovieGenres(@RequestParam String Id, @RequestParam String newGenre,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateEmbeddedMovieGenres(Id,newGenre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Language")
    @PatchMapping ("/embeddedMovie/update/language")
    public void updateEmbeddedMovieLanguages(@RequestParam String Id, @RequestParam String newLanguage,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateEmbeddedMovieLanguages(Id, newLanguage);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Country")
    @PatchMapping ("/embeddedMovie/update/country")
    public void updateEmbeddedMovieCountries(@RequestParam String Id, @RequestParam String newCountry,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateEmbeddedMovieCountries(Id, newCountry);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates CommentCount")
    @PatchMapping ("/embeddedMovie/update/commentCount")
    public void incrementCommentCount(@RequestParam String Id,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.incrementCommentCount(Id);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic meter")
    @PatchMapping ("/embeddedMovie/update/tomatoesCriticMeter")
    public void updateTomatoesCriticMeter(@RequestParam String id, @RequestParam Integer meter,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesCriticMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer meter")
    @PatchMapping ("/embeddedMovie/update/tomatoesViewerMeter")
    public void updateTomatoesViewerMeter(@RequestParam String id, @RequestParam Integer meter,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesViewerMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer NumReviews")
    @PatchMapping ("/embeddedMovie/update/tomatoesViewerNumReviews")
    public void updateTomatoesViewerNumReviews(@RequestParam String id, @RequestParam Integer numReviews,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesViewerNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic NumReviews")
    @PatchMapping ("/embeddedMovie/update/tomatoesCriticNumReviews")
    public void updateTomatoesCriticNumReviews(@RequestParam String id, @RequestParam Integer numReviews,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesCriticNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic Rating")
    @PatchMapping ("/embeddedMovie/update/tomatoesCriticRating")
    public void updateTomatoesCriticRating(@RequestParam String id, @RequestParam Double rating,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesCriticRating(id, rating);
    }


    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer Rating")
    @PatchMapping ("/embeddedMovie/update/tomatoesViewerRating")
    public void updateTomatoesViewerRating(@RequestParam String id, @RequestParam Double rating,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesViewerRating(id, rating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Rotten")
    @PatchMapping ("/embeddedMovie/update/tomatoesRotten")
    public void updateTomatoesRotten(@RequestParam String id, @RequestParam Integer rotten,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesRotten(id, rotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Fresh")
    @PatchMapping ("/embeddedMovie/update/tomatoesFresh")
    public void updateTomatoesFresh(@RequestParam String id, @RequestParam Integer fresh,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateTomatoesFresh(id, fresh);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Award Wins")
    @PatchMapping ("/embeddedMovie/update/awardsWins")
    public void updateAwardsWins(@RequestParam String code, @RequestParam Integer wins,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateAwardsWins(code, wins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates awards nominations")
    @PatchMapping ("/embeddedMovie/update/awardsNominations")
    public void updateAwardsNominations(@RequestParam String code, @RequestParam Integer nominations,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateAwardsNominations(code,nominations);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie release date")
    @PatchMapping ("/embeddedMovie/update/releaseDate")
    public void updateReleaseDate(@RequestParam String Id, @RequestParam String date,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateReleaseDate(Id, date);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Runtime")
    @PatchMapping ("/embeddedMovie/update/runtime")
    public void updateRuntime(@RequestParam String Id, @RequestParam Integer runtime,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateRuntime(Id, runtime);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Year")
    @PatchMapping ("/embeddedMovie/update/year")
    public void updateYear(@RequestParam String Id, @RequestParam String year,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.updateYear(Id, year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Deletes embedded movie by Id")
    @DeleteMapping ("/embeddedMovie/delete/byId")
    public void deleteMovieById(@RequestParam String Id,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        embeddedMoviesService.deleteMovieById(Id);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets embedded movie from Embedding")
    @GetMapping("/embeddedMovie/get/byEmbedding")
    public List<EmbeddedMovie> findEmbeddedMovieFromEmbedding(@RequestBody EmbeddedMovie originalMovie, @RequestParam double wantedDistance) {
        return embeddedMoviesService.findEmbeddedMovieFromEmbedding(originalMovie, wantedDistance);
    }

    @Operation(summary = "Gets all embedded movies by tomato rating")
    @GetMapping("/embeddedMovie/get/byTomatoesCriticRating")
    public List<EmbeddedMovie> findAllByTomatoesCriticRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesCriticRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato viewer rating")
    @GetMapping("/embeddedMovie/get/byTomatoesViewerRating")
    public List<EmbeddedMovie> findAllByTomatoesViewerRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesViewerRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato meter rating")
    @GetMapping("/embeddedMovie/get/byTomatoesCriticMeter")
    public List<EmbeddedMovie> findAllByTomatoesCriticMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesCriticMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by viewer meter rating")
    @GetMapping("/embeddedMovie/get/byTomatoesViewerMeter")
    public List<EmbeddedMovie> findAllByTomatoesViewerMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return embeddedMoviesService.findAllByTomatoesViewerMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Rotten Reviews")
    @GetMapping("/embeddedMovie/get/byTomatoesRottenReviews")
    public List<EmbeddedMovie> findAllByTomatoesRottenReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return embeddedMoviesService.findAllByTomatoesRottenReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Fresh Reviews")
    @GetMapping("/embeddedMovie/get/byTomatoesFreshReviews")
    public List<EmbeddedMovie> findAllByTomatoesFreshReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return embeddedMoviesService.findAllByTomatoesFreshReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Production")
    @GetMapping("/embeddedMovie/get/byTomatoesProduction")
    public List<EmbeddedMovie> findAllByTomatoesProduction(@RequestParam String production) {
        return embeddedMoviesService.findAllByTomatoesProduction(production);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Imdb Rating")
    @GetMapping("/embeddedMovie/get/byImdbRating")
    public List<EmbeddedMovie> getAllMoviesByImdbRating(@RequestParam double lowerRating, @RequestParam double upperRating) {
        return embeddedMoviesService.findAllMoviesByImdbRating(lowerRating, upperRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies, by Movie Imdb Votes")
    @GetMapping("/embeddedMovie/get/byMovieImdbVotes")
    public List<String> getNumberOfMovieImdbVotes(@RequestParam String movieName) {
        return embeddedMoviesService.findAllNumberOfMovieImdbVotes(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Rating By Name")
    @GetMapping("/embeddedMovie/get/imdbRating/byName")
    public List<String> getMovieImdbRatingByName(@RequestParam String movieName) {
        return embeddedMoviesService.findAllMovieImdbRatingByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/embeddedMovie/get/imdbId/byName")
    public List<String> getMovieImdbIdByName(@RequestParam String movieName) {
        return embeddedMoviesService.findAllMovieImdbIdByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/embeddedMovie/get/byCountry")
    public  List<EmbeddedMovie> getEmbeddedMoviesByCountry(@RequestParam String movieName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByCountry(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Nominations")
    @GetMapping("/embeddedMovie/get/byNumberOfNominations")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfNominations(@RequestParam Integer noms) {
        return embeddedMoviesService.findAllEmbeddedMoviesByNumberOfNominations(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Wins")
    @GetMapping("/embeddedMovie/get/byNumberOfWins")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfWins(@RequestParam Integer noms) {
        return embeddedMoviesService.findAllEmbeddedMoviesByNumberOfWins(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Award Name")
    @GetMapping("/embeddedMovie/get/byAwardName")
    public  List<EmbeddedMovie> getEmbeddedMoviesByAwardName(@RequestParam String awardName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByAwardName(awardName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Title Containing")
    @GetMapping("/embeddedMovie/get/byTitleContaining")
    public  List<EmbeddedMovie> getEmbeddedMoviesByTitleContaining(@RequestParam String filmTitle) {
        return embeddedMoviesService.findAllEmbeddedMoviesByTitleContaining(filmTitle);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Cast Member")
    @GetMapping("/embeddedMovie/get/byCastMember")
    public  List<EmbeddedMovie> getEmbeddedMoviesByCastMember(@RequestParam String castMemberName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByCastMember(castMemberName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Director")
    @GetMapping("/embeddedMovie/get/byDirector")
    public  List<EmbeddedMovie> getEmbeddedMoviesByDirector(@RequestParam String directorName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByDirector(directorName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/embeddedMovie/get/byFullPlot")
    public  List<EmbeddedMovie> getEmbeddedMoviesByFullPlot(@RequestParam String fullPlot) {
        return embeddedMoviesService.findAllEmbeddedMoviesByFullPlot(fullPlot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/embeddedMovie/get/byGenre")
    public  List<EmbeddedMovie> getEmbeddedMoviesByGenre(@RequestParam String genre) {
        return embeddedMoviesService.findAllEmbeddedMoviesByGenre(genre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Language")
    @GetMapping("/embeddedMovie/get/byLanguage")
    public  List<EmbeddedMovie> getEmbeddedMoviesByLanguage(@RequestParam String language) {
        return embeddedMoviesService.findAllEmbeddedMoviesByLanguage(language);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Comments Lower Bound")
    @GetMapping("/embeddedMovie/get/byNumberOfCommentsLowerBound")
    public  List<EmbeddedMovie> getEmbeddedMoviesByNumberOfCommentsLowerBound(@RequestParam Integer numberOfComments) {
        return embeddedMoviesService.findAllEmbeddedMoviesByNumberOfCommentsLowerBound(numberOfComments);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Plot")
    @GetMapping("/embeddedMovie/get/byPlot")
    public  List<EmbeddedMovie> getEmbeddedMoviesByPlot(@RequestParam String plot) {
        return embeddedMoviesService.findAllEmbeddedMoviesByPlot(plot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Max Runtime")
    @GetMapping("/embeddedMovie/get/byMaxRuntime")
    public  List<EmbeddedMovie> getEmbeddedMoviesByMaxRuntime(@RequestParam Integer mins) {
        return embeddedMoviesService.findAllEmbeddedMoviesByMaxRuntime(mins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Writer")
    @GetMapping("/embeddedMovie/get/byWriter")
    public  List<EmbeddedMovie> getEmbeddedMoviesByWriter(@RequestParam String writerName) {
        return embeddedMoviesService.findAllEmbeddedMoviesByWriter(writerName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Exact")
    @GetMapping("/embeddedMovie/get/byYearExact")
    public  List<EmbeddedMovie> getEmbeddedMoviesByYearExact(@RequestParam String year) {
        return embeddedMoviesService.findAllEmbeddedMoviesByYearExact(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Poster Link By Title")
    @GetMapping("/embeddedMovie/get/posterLink/byTitle")
    public List<String> getPosterLinkByTitle(@RequestParam String name) {
        return embeddedMoviesService.findAllPosterLinkByTitle(name);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Before")
    @GetMapping("/embeddedMovie/get/byYearBefore")
    public  List<EmbeddedMovie> getEmbeddedMoviesByYearBefore(@RequestParam String year) {
        return embeddedMoviesService.findAllEmbeddedMoviesByYearBefore(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year After")
    @GetMapping("/embeddedMovie/get/byYearAfter")
    public  List<EmbeddedMovie> findAllEmbeddedMoviesByYearAfter(@RequestParam String year) {
        return embeddedMoviesService.findAllEmbeddedMoviesByYearAfter(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get All Movies By ReleaseRange")
    @GetMapping("/embeddedMovie/get/byReleaseRange")
    public List<EmbeddedMovie> findAllByReleaseRange(@RequestParam String lowerDate, @RequestParam String upperDate) {
        return embeddedMoviesService.findAllMoviesByReleaseRange(lowerDate,upperDate);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "creates an embedded movie")
    @PutMapping("/embeddedMovie/add")
    public void addEmbeddedMovie(@RequestBody EmbeddedMovie movie) {
        embeddedMoviesService.addEmbeddedMovie(movie);
    }
}
