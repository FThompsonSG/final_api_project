package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmbeddedMoviesRepository extends MongoRepository<EmbeddedMovie, String> {

   List<EmbeddedMovie> findByCountries(String countryName);

   List<EmbeddedMovie> findByCastContains(String actor);

   @Query("{'awards.nominations' : { $gte : ?0 } }")
   List<EmbeddedMovie> findEmbeddedMoviesByAwards_Nominations(Integer numberOfNomintations);

   @Query("{ 'awards.wins' : { $gte : ?0 } }")
   List<EmbeddedMovie> findEmbeddedMoviesByAwards_Wins(Integer numberOfWins);

   @Query("{ 'awards.text' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByFieldNameContaining(String substringToSearch);

}
