package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.services.MoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    MoviesService movieService;

    public MovieController(MoviesService movieService) {
        this.movieService = movieService;
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Title")
    @PatchMapping("/Movie/UpdateTitle")
    public void updateMovieTitle(@RequestParam String Id, @RequestParam String newTitle) {
        movieService.updateMovieTitle(Id, newTitle);
    }


    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Writers")
    @PatchMapping ("/Movie/UpdateWriters")
    public void updateMovieWriters(@RequestParam String Id, @RequestParam String newWriter) {
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
    @PatchMapping ("/Movie/UpdateCast")
    public void updateMovieCast(@RequestParam String Id, @RequestParam String newMember) {
        movieService.updateMovieCast(Id, newMember);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Genre")
    @PatchMapping ("/Movie/UpdateGenre")
    public void updateMovieGenres(@RequestParam String Id, @RequestParam String newGenre) {
        movieService.updateMovieGenres(Id,newGenre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Language")
    @PatchMapping ("/Movie/UpdateLanguage")
    public void updateMovieLanguages(@RequestParam String Id, @RequestParam String newLanguage) {
        movieService.updateMovieLanguages(Id, newLanguage);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Country")
    @PatchMapping ("/Movie/UpdateCountry")
    public void updateMovieCountries(@RequestParam String Id, @RequestParam String newCountry) {
        movieService.updateMovieCountries(Id, newCountry);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates CommentCount")
    @PatchMapping ("/Movie/UpdateCommentCount")
    public void incrementCommentCount(@RequestParam String Id) {
        movieService.incrementCommentCount(Id);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic meter")
    @PatchMapping ("/Movie/UpdateTomatoesCriticMeter")
    public void updateTomatoesCriticMeter(@RequestParam String id, @RequestParam Integer meter ) {
        movieService.updateTomatoesCriticMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer meter")
    @PatchMapping ("/Movie/UpdateTomatoesViewerMeter")
    public void updateTomatoesViewerMeter(@RequestParam String id, @RequestParam Integer meter ) {
        movieService.updateTomatoesViewerMeter(id, meter);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer NumReviews")
    @PatchMapping ("/Movie/UpdateTomatoesViewerNumReviews")
    public void updateTomatoesViewerNumReviews(@RequestParam String id, @RequestParam Integer numReviews) {
        movieService.updateTomatoesViewerNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic NumReviews")
    @PatchMapping ("/Movie/UpdateTomatoesCriticNumReviews")
    public void updateTomatoesCriticNumReviews(@RequestParam String id, @RequestParam Integer numReviews) {
        movieService.updateTomatoesCriticNumReviews(id, numReviews);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Critic Rating")
    @PatchMapping ("/Movie/UpdateTomatoesCriticRating")
    public void updateTomatoesCriticRating(@RequestParam String id, @RequestParam Double rating) {
        movieService.updateTomatoesCriticRating(id, rating);
    }


    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Viewer Rating")
    @PatchMapping ("/Movie/UpdateTomatoesViewerRating")
    public void updateTomatoesViewerRating(@RequestParam String id, @RequestParam Double rating) {
        movieService.updateTomatoesViewerRating(id, rating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Rotten")
    @PatchMapping ("/Movie/UpdateTomatoesRotten")
    public void updateTomatoesRotten(@RequestParam String id, @RequestParam Integer rotten) {
        movieService.updateTomatoesRotten(id, rotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Tomatoes Fresh")
    @PatchMapping ("/Movie/UpdateTomatoesFresh")
    public void updateTomatoesFresh(@RequestParam String id, @RequestParam Integer fresh) {
        movieService.updateTomatoesFresh(id, fresh);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates Award Wins")
    @PatchMapping ("/Movie/UpdateAwardsWins")
    public void updateAwardsWins(@RequestParam String code, @RequestParam Integer wins) {
        movieService.updateAwardsWins(code, wins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates awards nominations")
    @PatchMapping ("/Movie/UpdateAwardsNominations")
    public void updateAwardsNominations(@RequestParam String code, @RequestParam Integer nominations) {
        movieService.updateAwardsNominations(code,nominations);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie release date")
    @PatchMapping ("/Movie/UpdateReleaseDate")
    public void updateReleaseDate(@RequestParam String Id, @RequestParam String date) {
        movieService.updateReleaseDate(Id, date);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Runtime")
    @PatchMapping ("/Movie/UpdateRuntime")
    public void updateRuntime(@RequestParam String Id, @RequestParam Integer runtime) {
        movieService.updateRuntime(Id, runtime);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Year")
    @PatchMapping ("/Movie/UpdateYear")
    public void updateYear(@RequestParam String Id, @RequestParam String year) {
        movieService.updateYear(Id, year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Deletes embedded movie by Id")
    @DeleteMapping("/Movie/DeleteById")
    public void deleteMovieById(@RequestParam String Id) {
        movieService.deleteMovieById(Id);
    }

    @Operation(summary = "Gets all embedded movies by tomato rating")
    @GetMapping("/Movie/ByTomatoesCriticRating")
    public List<Movie> findAllByTomatoesCriticRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesCriticRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato viewer rating")
    @GetMapping("/Movie/ByTomatoesViewerRating")
    public List<Movie> findAllByTomatoesViewerRating(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesViewerRating(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by tomato meter rating")
    @GetMapping("/Movie/ByTomatoesCriticMeter")
    public List<Movie> findAllByTomatoesCriticMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesCriticMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies by viewer meter rating")
    @GetMapping("/Movie/ByTomatoesViewerMeter")
    public List<Movie> findAllByTomatoesViewerMeter(@RequestParam double minRating, @RequestParam double maxRating) {
        return movieService.findAllByTomatoesViewerMeter(minRating, maxRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Rotten Reviews")
    @GetMapping("/Movie/ByTomatoesRottenReviews")
    public List<Movie> findAllByTomatoesRottenReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return movieService.findAllByTomatoesRottenReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Fresh Reviews")
    @GetMapping("/Movie/ByTomatoesFreshReviews")
    public List<Movie> findAllByTomatoesFreshReviews(@RequestParam int minRotten, @RequestParam int maxRotten) {
        return movieService.findAllByTomatoesFreshReviews(minRotten, maxRotten);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Tomatoes Production")
    @GetMapping("/Movie/ByTomatoesProduction")
    public List<Movie> findAllByTomatoesProduction(@RequestParam String production) {
        return movieService.findAllByTomatoesProduction(production);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies By Imdb Rating")
    @GetMapping("/Movie/ByImdbRating")
    public List<Movie> getAllMoviesByImdbRating(@RequestParam double lowerRating, @RequestParam double upperRating) {
        return movieService.findAllMoviesByImdbRating(lowerRating, upperRating);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded movies, by Movie Imdb Votes")
    @GetMapping("/Movie/ByMovieImdbVotes")
    public List<String> getNumberOfMovieImdbVotes(@RequestParam String movieName) {
        return movieService.findAllNumberOfMovieImdbVotes(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Rating By Name")
    @GetMapping("/Movie/getMovieImdbRatingByName")
    public List<String> getMovieImdbRatingByName(@RequestParam String movieName) {
        return movieService.findAllMovieImdbRatingByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/Movie/getMovieImdbIdByName")
    public List<String> getMovieImdbIdByName(@RequestParam String movieName) {
        return movieService.findAllMovieImdbIdByName(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Movie Imdb Id By Name")
    @GetMapping("/Movie/getMoviesByCountry")
    public  List<Movie> getMoviesByCountry(@RequestParam String movieName) {
        return movieService.findAllMoviesByLanguages(movieName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Nominations")
    @GetMapping("/Movie/getMoviesByNumberOfNominations")
    public  List<Movie> getMoviesByNumberOfNominations(@RequestParam Integer noms) {
        return movieService.findAllMoviesByNumberOfNominations(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Wins")
    @GetMapping("/Movie/getMoviesByNumberOfWins")
    public  List<Movie> getMoviesByNumberOfWins(@RequestParam Integer noms) {
        return movieService.findAllMoviesByNumberOfWins(noms);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Award Name")
    @GetMapping("/Movie/getMoviesByAwardName")
    public  List<Movie> getMoviesByAwardName(@RequestParam String awardName) {
        return movieService.findAllMoviesByAwardName(awardName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Title Containing")
    @GetMapping("/Movie/getMoviesByTitleContaining")
    public  List<Movie> getMoviesByTitleContaining(@RequestParam String filmTitle) {
        return movieService.findAllMovieByTitle(filmTitle);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Cast Member")
    @GetMapping("/Movie/getMoviesByCastMember")
    public  List<Movie> getMoviesByCastMember(@RequestParam String castMemberName) {
        return movieService.findAllMoviesByCastMember(castMemberName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Director")
    @GetMapping("/Movie/getMoviesByDirector")
    public  List<Movie> getMoviesByDirector(@RequestParam String directorName) {
        return movieService.findAllMoviesByDirector(directorName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/Movie/getMoviesByFullPlot")
    public  List<Movie> getMoviesByFullPlot(@RequestParam String fullPlot) {
        return movieService.findAllByFullPlot(fullPlot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Full Plot")
    @GetMapping("/Movie/getMoviesByGenre")
    public  List<Movie> getMoviesByGenre(@RequestParam String genre) {
        return movieService.findAllMoviesByGenre(genre);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Language")
    @GetMapping("/Movie/getMoviesByLanguage")
    public  List<Movie> getMoviesByLanguage(@RequestParam String language) {
        return movieService.findAllMoviesByLanguages(language);
    }

    //we have no comments upper and lower bounds, we only have exact comments.
    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Number Of Comments")
    @GetMapping("/Movie/getMoviesByNumberOfComments")
    public  List<Movie> getMoviesByNumberOfComments(@RequestParam Integer numberOfComments) {
        return movieService.findAllMoviesByNumberOfComments(numberOfComments);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Plot")
    @GetMapping("/Movie/getMoviesByPlot")
    public  List<Movie> getMoviesByPlot(@RequestParam String plot) {
        return movieService.findAllByPlot(plot);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Max Runtime")
    @GetMapping("/Movie/getMoviesByMaxRuntime")
    public  List<Movie> getMoviesByMaxRuntime(@RequestParam Integer mins) {
        return movieService.findAllMoviesByMaxRuntime(mins);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Writer")
    @GetMapping("/Movie/getMoviesByWriter")
    public List<Movie> getMoviesByWriter(@RequestParam String writerName) {
        return movieService.findAllMoviesByWriter(writerName);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Exact")
    @GetMapping("/Movie/getMoviesByYearExact")
    public  List<Movie> getMoviesByYearExact(@RequestParam String year) {
        return movieService.findAllMoviesByYearExact(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Poster Link By Title")
    @GetMapping("/Movie/getPosterLinkByTitle")
    public List<String> getPosterLinkByTitle(@RequestParam String name) {
        return movieService.findAllPosterLinkByTitle(name);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year Before")
    @GetMapping("/Movie/getMoviesByYearBefore")
    public  List<Movie> getMoviesByYearBefore(@RequestParam String year) {
        return movieService.findAllMoviesByYearBefore(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get Embedded Movies By Year After")
    @GetMapping("/Movie/getMoviesByYearAfter")
    public  List<Movie> getMoviesByYearAfter(@RequestParam String year) {
        return movieService.findAllMoviesByYearAfter(year);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all embedded Movies, get All Movies By ReleaseRange")
    @GetMapping("/Movie/getAllMoviesByReleaseRange")
    public List<Movie> getAllMoviesByReleaseRange(@RequestParam String lowerDate, @RequestParam String upperDate) {
        return movieService.findAllMoviesByReleaseRange(lowerDate,upperDate);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "creates an embedded movie")
    @PutMapping("/Movie/addMovie")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }
}
