package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmbeddedMoviesRepository extends MongoRepository<EmbeddedMovie, String> {

   @Query("{ 'countries' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByCountries(String countryName);

   @Query("{'awards.nominations' : { $gte : ?0 } }")
   List<EmbeddedMovie> findEmbeddedMoviesByAwards_Nominations(Integer numberOfNomintations);

   @Query("{ 'awards.wins' : { $gte : ?0 } }")
   List<EmbeddedMovie> findEmbeddedMoviesByAwards_Wins(Integer numberOfWins);

   @Query("{ 'awards.text' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByFieldNameContaining(String substringToSearch);

   @Query("{ 'title' : {$regex:  ?0, $options:  'i' } }")
   List<EmbeddedMovie> findByTitleContaining(String subStringToSearch);

   @Query("{ 'cast' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByCastMember(String subStringToSearch);

   @Query("{ 'directors' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByDirector(String subStringToSearch);

   @Query("{ 'fullplot' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByFullPlot(String subStringToSearch);

   @Query("{ 'genres' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByGenre(String subStringToSearch);

   @Query("{ 'languages' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByLanguage(String subStringToSearch);

   @Query("{'num_mflix_comments' : { $gte : ?0 } }")
   List<EmbeddedMovie> findByNumberOfComments(Integer numberOfComments);

   @Query("{ 'plot' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByPlot(String subStringToSearch);

   @Query("{'runtime' : { $lte : ?0 } }")
   List<EmbeddedMovie> findByMaxRuntime(Integer mins);

   @Query("{ 'writers' : { $regex: ?0, $options: 'i' } }")
   List<EmbeddedMovie> findByWriter(String subStringToSearch);

   @Query("{'year' : { $eq : ?0 } }")
   List<EmbeddedMovie> findByYearExact(Integer year);

   @Query("{'year' : { $lte : ?0 } }")
   List<EmbeddedMovie> findByYearBefore(Integer year);

   @Query("{'year' : { $gte : ?0 } }")
   List<EmbeddedMovie> findByYearAfter(Integer year);

   List<EmbeddedMovie> findByTitle(String title);


}
