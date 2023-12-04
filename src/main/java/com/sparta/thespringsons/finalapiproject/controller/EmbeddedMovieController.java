package com.sparta.thespringsons.finalapiproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmbeddedMovieController {

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets all the embedded movies from MongoDB")
    @GetMapping("/embeddedMovies")
    public void getAllEmbeddedMovies() {
        // Gets all embedded movie
        // Should return list.
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets an embedded movie by its ID.")
    @GetMapping("/embeddedMovie/{movie_id}")
    public void getEmbeddedMovieById(@PathVariable String movie_id) {
        // Gets embedded movie by id
        // Should return Optional.
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets an embedded movie by date range")
    @GetMapping("/embeddedMovie/")
    public void getEmbeddedMovieByDateRange
            (@RequestParam Integer lowerYear, @RequestParam Integer upperYear) {
        // Gets an embedded movie by date range
        // If either are empty or null, it assumes to search everything before or after
        // Should return a list.
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Creates a new EmbeddedMovie record into the database.")
    @PostMapping("/embeddedMovie")
    public void createEmbeddedMovie() { // We need a body in here somewhere
        // Gets all embedded movie
        // Maybe returns the JSON body of created object?
    }

    @Tag(name = "Embedded Movie API")
    @Operation(summary = "Gets alL embedded movie by runtime range")
    @GetMapping("/embeddedMovies")
    public void getEmbeddedMovieByRuntimeRange
            (@RequestParam Integer lowerRuntime, @RequestParam Integer upperRuntime){
        // Gets all embedded movies within the specified runtime range
        // If either are empty or null, it assumes to search everything before or after
        // Returns a list
    }
}
