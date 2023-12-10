package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.model.services.MoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MoviesService movieService;
    private final ApiKeyService apiKeyService;

    @Autowired
    public MovieController(MoviesService movieService, ApiKeyService apiKeyService) {
        this.movieService = movieService;
        this.apiKeyService = apiKeyService;
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Title")
    @PatchMapping("/movie/update/title")
    public void updateMovieTitle(@RequestParam String Id, @RequestParam String newTitle,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateMovieTitle(Id, newTitle);
    }


    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Writers")
    @PatchMapping ("/movie/update/writers")
    public void updateMovieWriters(@RequestParam String Id, @RequestParam String newWriter,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateMovieWriters(Id, newWriter);
    }

    //Partial search for movie title
//    @Tag(name = "Movie Controller API")
//    @Operation(summary = "")
//    @GetMapping("/movies/title")
//    public void getFilmByTitle(@RequestParam(name = "title", required = true) String title) {
//        //return lists instead of optional
//        Optional<MovieDTO> movie = movieRepository.findByTitle(title);

//
//

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Cast")
    @PatchMapping ("/movie/update/cast")
    public void updateMovieCast(@RequestParam String Id, @RequestParam String newMember,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateMovieCast(Id, newMember);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Genre")
    @PatchMapping ("/movie/update/genre")
    public void updateMovieGenres(@RequestParam String Id, @RequestParam String newGenre,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateMovieGenres(Id,newGenre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Language")
    @PatchMapping ("/movie/update/language")
    public void updateMovieLanguages(@RequestParam String Id, @RequestParam String newLanguage,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateMovieLanguages(Id, newLanguage);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Country")
    @PatchMapping ("/movie/update/country")
    public void updateMovieCountries(@RequestParam String Id, @RequestParam String newCountry,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateMovieCountries(Id, newCountry);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates CommentCount")
    @PatchMapping ("/movie/update/commentCount")
    public void incrementCommentCount(@RequestParam String Id,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.incrementCommentCount(Id);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic meter")
    @PatchMapping ("/movie/update/tomatoesCriticMeter")
    public void updateTomatoesCriticMeter(@RequestParam String id, @RequestParam Integer meter,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesCriticMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer meter")
    @PatchMapping ("/movie/update/tomatoesViewerMeter")
    public void updateTomatoesViewerMeter(@RequestParam String id, @RequestParam Integer meter,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesViewerMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer NumReviews")
    @PatchMapping ("/movie/update/tomatoesViewerNumReviews")
    public void updateTomatoesViewerNumReviews(@RequestParam String id, @RequestParam Integer numReviews,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesViewerNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic NumReviews")
    @PatchMapping ("/movie/update/tomatoesCriticNumReviews")
    public void updateTomatoesCriticNumReviews(@RequestParam String id, @RequestParam Integer numReviews,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesCriticNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic Rating")
    @PatchMapping ("/movie/update/tomatoesCriticRating")
    public void updateTomatoesCriticRating(@RequestParam String id, @RequestParam Double rating,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesCriticRating(id, rating);
    }


    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer Rating")
    @PatchMapping ("/movie/update/tomatoesViewerRating")
    public void updateTomatoesViewerRating(@RequestParam String id, @RequestParam Double rating,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesViewerRating(id, rating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Rotten")
    @PatchMapping ("/movie/update/tomatoesRotten")
    public void updateTomatoesRotten(@RequestParam String id, @RequestParam Integer rotten,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesRotten(id, rotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Fresh")
    @PatchMapping ("/movie/update/tomatoesFresh")
    public void updateTomatoesFresh(@RequestParam String id, @RequestParam Integer fresh,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateTomatoesFresh(id, fresh);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Award Wins")
    @PatchMapping ("/movie/update/awardsWins")
    public void updateAwardsWins(@RequestParam String code, @RequestParam Integer wins,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateAwardsWins(code, wins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates awards nominations")
    @PatchMapping ("/movie/update/awardsNominations")
    public void updateAwardsNominations(@RequestParam String code, @RequestParam Integer nominations,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateAwardsNominations(code,nominations);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie release date")
    @PatchMapping ("/movie/update/releaseDate")
    public void updateReleaseDate(@RequestParam String Id, @RequestParam String date,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateReleaseDate(Id, date);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Runtime")

    @PatchMapping ("/movie/update/runtime")
    public void updateRuntime(@RequestParam String Id, @RequestParam Integer runtime,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateRuntime(Id, runtime);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Year")
    @PatchMapping ("/movie/update/year")
    public void updateYear(@RequestParam String Id, @RequestParam String year,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.updateYear(Id, year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Deletes embedded movie by Id")
    @DeleteMapping("/movie/delete/byId")
    public void deleteMovieById(@RequestParam String Id,@RequestHeader(name = "Key") String apiKey) {
        if(!apiKeyService.checkIfApiKeyExists(apiKey)){
            return;
        }
        movieService.deleteMovieById(Id);
    }

    @Operation(summary = "Gets all embedded movies by tomato rating")
    @GetMapping("/movie/get/byTomatoesCriticRating")
    public List<Movie> findAllByTomatoesCriticRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesCriticRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato viewer rating")
    @GetMapping("/movie/get/byTomatoesViewerRating")
    public List<Movie> findAllByTomatoesViewerRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesViewerRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato meter rating")
    @GetMapping("/movie/get/byTomatoesCriticMeter")
    public List<Movie> findAllByTomatoesCriticMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesCriticMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by viewer meter rating")
    @GetMapping("/movie/get/byTomatoesViewerMeter")
    public List<Movie> findAllByTomatoesViewerMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesViewerMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Rotten Reviews")
    @GetMapping("/movie/get/byTomatoesRottenReviews")
    public List<Movie> findAllByTomatoesRottenReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return movieService.findAllByTomatoesRottenReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Fresh Reviews")
    @GetMapping("/movie/get/byTomatoesFreshReviews")
    public List<Movie> findAllByTomatoesFreshReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return movieService.findAllByTomatoesFreshReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Production")
    @GetMapping("/movie/get/byTomatoesProduction")
    public List<Movie> findAllByTomatoesProduction(@RequestParam String production) {
        return movieService.findAllByTomatoesProduction(production);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Imdb Rating")
    @GetMapping("/movie/get/byImdbRating")
    public List<Movie> getAllMoviesByImdbRating(@RequestParam double lowerRating, @RequestParam double upperRating) {
        return movieService.findAllMoviesByImdbRating(lowerRating, upperRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies, by Movie Imdb Votes")
    @GetMapping("/movie/get/byMovieImdbVotes")
    public List<String> getNumberOfMovieImdbVotes(@RequestParam String movieName) {
        return movieService.findAllNumberOfMovieImdbVotes(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Rating By Name")
    @GetMapping("/movie/get/imdbRating/byName")
    public List<String> getMovieImdbRatingByName(@RequestParam String movieName) {
        return movieService.findAllMovieImdbRatingByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/movie/get/imdbId/byName")
    public List<String> getMovieImdbIdByName(@RequestParam String movieName) {
        return movieService.findAllMovieImdbIdByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/movie/get/byCountry")
    public  List<Movie> getMoviesByCountry(@RequestParam String movieName) {
        return movieService.findAllMoviesByLanguages(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Nominations")
    @GetMapping("/movie/get/byNumberOfNominations")
    public  List<Movie> getMoviesByNumberOfNominations(@RequestParam Integer noms) {
        return movieService.findAllMoviesByNumberOfNominations(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Wins")
    @GetMapping("/movie/get/byNumberOfWins")
    public  List<Movie> getMoviesByNumberOfWins(@RequestParam Integer noms) {
        return movieService.findAllMoviesByNumberOfWins(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Award Name")
    @GetMapping("/movie/get/byAwardName")
    public  List<Movie> getMoviesByAwardName(@RequestParam String awardName) {
        return movieService.findAllMoviesByAwardName(awardName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Title Containing")
    @GetMapping("/movie/get/byTitleContaining")
    public  List<Movie> getMoviesByTitleContaining(@RequestParam String filmTitle) {
        return movieService.findAllMovieByTitle(filmTitle);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Cast Member")
    @GetMapping("/movie/get/byCastMember")
    public  List<Movie> getMoviesByCastMember(@RequestParam String castMemberName) {
        return movieService.findAllMoviesByCastMember(castMemberName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Director")
    @GetMapping("/movie/get/byDirector")
    public  List<Movie> getMoviesByDirector(@RequestParam String directorName) {
        return movieService.findAllMoviesByDirector(directorName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/movie/get/byFullPlot")
    public  List<Movie> getMoviesByFullPlot(@RequestParam String fullPlot) {
        return movieService.findAllByFullPlot(fullPlot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/movie/get/byGenre")
    public  List<Movie> getMoviesByGenre(@RequestParam String genre) {
        return movieService.findAllMoviesByGenre(genre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Language")
    @GetMapping("/movie/get/byLanguage")
    public  List<Movie> getMoviesByLanguage(@RequestParam String language) {
        return movieService.findAllMoviesByLanguages(language);
    }

    //we have no comments upper and lower bounds, we only have exact comments.
    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Comments")
    @GetMapping("/movie/get/byNumberOfComments")
    public  List<Movie> getMoviesByNumberOfComments(@RequestParam Integer numberOfComments) {
        return movieService.findAllMoviesByNumberOfComments(numberOfComments);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Plot")
    @GetMapping("/movie/get/byPlot")
    public  List<Movie> getMoviesByPlot(@RequestParam String plot) {
        return movieService.findAllByPlot(plot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Max Runtime")
    @GetMapping("/movie/get/byMaxRuntime")
    public  List<Movie> getMoviesByMaxRuntime(@RequestParam Integer mins) {
        return movieService.findAllMoviesByMaxRuntime(mins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Writer")
    @GetMapping("/movie/get/byWriter")
    public List<Movie> getMoviesByWriter(@RequestParam String writerName) {
        return movieService.findAllMoviesByWriter(writerName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Exact")
    @GetMapping("/movie/get/byYearExact")
    public  List<Movie> getMoviesByYearExact(@RequestParam String year) {
        return movieService.findAllMoviesByYearExact(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Poster Link By Title")
    @GetMapping("/movie/get/posterLink/byTitle")
    public List<String> getPosterLinkByTitle(@RequestParam String name) {
        return movieService.findAllPosterLinkByTitle(name);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Before")
    @GetMapping("/movie/get/byYearBefore")
    public  List<Movie> getMoviesByYearBefore(@RequestParam String year) {
        return movieService.findAllMoviesByYearBefore(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year After")
    @GetMapping("/movie/get/byYearAfter")
    public  List<Movie> getMoviesByYearAfter(@RequestParam String year) {
        return movieService.findAllMoviesByYearAfter(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get All Movies By ReleaseRange")
    @GetMapping("/movie/get/byReleaseRange")
    public List<Movie> getAllMoviesByReleaseRange(@RequestParam String lowerDate, @RequestParam String upperDate) {
        return movieService.findAllMoviesByReleaseRange(lowerDate,upperDate);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "creates an embedded movie")
    @PutMapping("/movie/add")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }
}
