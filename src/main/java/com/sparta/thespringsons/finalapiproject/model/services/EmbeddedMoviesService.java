package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.repositories.EmbeddedMoviesRepository;
import com.sparta.thespringsons.finalapiproject.model.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmbeddedMoviesService  {

    private EmbeddedMoviesRepository embeddedMoviesRepository;

    @Autowired
    public EmbeddedMoviesService(EmbeddedMoviesRepository embeddedMoviesRepository) {
        this.embeddedMoviesRepository = embeddedMoviesRepository;
    }

    public Optional <List<EmbeddedMovie>> getEmbeddedMovieByActor(String actor){
        List<EmbeddedMovie> EmbeddedMovies = embeddedMoviesRepository.findByCastContains(actor);
        return Optional.of(EmbeddedMovies);
    }

    public Optional<List<EmbeddedMovie>> findAllByTomatoesWithLowerRating(double rating) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if (embeddedMovie.tomato.getRating() < rating) {
                embeddedMovies.add(embeddedMovie);
            }
        }
        return Optional.of(embeddedMovies);
    }

    public Optional<List<EmbeddedMovie>> findAllByTomatoesWithHigherRating(double rating) {
        List<EmbeddedMovie> embeddedMovies = new ArrayList<>();
        for (EmbeddedMovie embeddedMovie : embeddedMoviesRepository.findAll()) {
            if (embeddedMovie.tomato.getRating() > rating) {
                embeddedMovies.add(embeddedMovie);
            }
        }
        return Optional.of(embeddedMovies);
    }



}