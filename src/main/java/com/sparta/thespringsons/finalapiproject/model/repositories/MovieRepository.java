package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import com.sparta.thespringsons.finalapiproject.model.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

//    List<Movie> findAllMovies();
    List<Movie> findByTitle(String title);
    ArrayList<Movie> findAllByDirectors(String directors);


    ArrayList<Movie> findAllByWriters(String writer);

    List<Movie> findAllByGenres(String genreName);

    List<Movie> findAllByLanguages(String language);

    List<Movie> findAllByCountries(String country);

    @Query("{'year' : { $eq : ?0 } }")
    List<Movie> findByYearExact(Integer year);

    @Query("{'year' : { $lte : ?0 } }")
    List<Movie> findByYearBefore(Integer year);

    @Query("{'year' : { $gte : ?0 } }")
    List<Movie> findByYearAfter(Integer year);

}
