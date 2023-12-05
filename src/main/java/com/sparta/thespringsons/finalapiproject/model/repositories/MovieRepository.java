package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import com.sparta.thespringsons.finalapiproject.model.fields.Awards;
import com.sparta.thespringsons.finalapiproject.model.fields.Imdb;
import com.sparta.thespringsons.finalapiproject.model.fields.Tomato;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findAllMovies();
    Movie findByTitle(String title);
    List<Movie> findAllByDirectors(List<String> directors);

    List<Movie> findAllMoviesByActors(String performer);

    List<Movie> findAllMoviesByGenre(String genre);
}
