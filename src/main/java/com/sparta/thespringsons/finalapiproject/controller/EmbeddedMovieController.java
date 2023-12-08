package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.exceptions.InvalidDocumentException;
import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
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
    @Operation(summary = "Updates embedded movie text")
    @PatchMapping ("/embeddedMovie/UpdateReleaseDate")
    private void updateText(@RequestBody EmbeddedMovie movieToUpdate) {
        embeddedMoviesService.updateText(movieToUpdate);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie release date")
    @PatchMapping ("/embeddedMovie/UpdateReleaseDate")
    public void updateReleaseDate(@RequestParam String Id, @RequestParam String date) {
        embeddedMoviesService.updateReleaseDate(Id, date);
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Updates embedded movie Runtime")
    @PatchMapping ("/embeddedMovie/UpdateYear")
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


}
