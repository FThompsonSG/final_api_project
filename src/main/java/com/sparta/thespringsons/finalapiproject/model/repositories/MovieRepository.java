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
    List<Movie> findAllByDirectors(String directors);

    List<Movie> findAllMoviesByCast(List<String> performers);

    List<Movie> findAllMoviesByGenre(String genre);

    List<Movie> findAllByImdbId(Integer id);
    List<Movie> findAllByImdbRating(Double rating);
    List<Movie> findAllByImdbVotes(Integer votes);


}
