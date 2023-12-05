package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.services.EmbeddedMoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmbeddedMovieController {

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all the embedded movies from MongoDB")
    @GetMapping("/embeddedMovies")
    public void getAllEmbeddedMovies() {
        // Gets all embedded movie
    }

    @Tag(name = "")
    @Operation(summary = "Gets all embedded movies with a specified actor in the cast")
    @GetMapping("/embeddedMovies/actor")
    public void getEmbeddedMovieByActor(String actor) {

    }
}
