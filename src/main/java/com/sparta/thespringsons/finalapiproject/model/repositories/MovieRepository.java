package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

//    List<Movie> findAllMovies();
    Movie findByTitle(String title);
    ArrayList<Movie> findAllByDirectors(String directors);

//    List<Movie> findAllMoviesByCast(List<String> performers);
//
////    List<Movie> findAllMoviesByGenres(String genre);
//
//    List<Movie> findAllByImdbId(Integer id);
//    ArrayList<Movie> findAllByImdbRating(Double lowerRating, Double upperRating);
//    List<Movie> findAllByImdbVotes(Integer votes);
//        Double findImdbRating(Movie movie);

}
