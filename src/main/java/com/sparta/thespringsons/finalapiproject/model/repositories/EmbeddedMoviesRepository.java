package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.EmbeddedMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmbeddedMoviesRepository extends MongoRepository<EmbeddedMovie, String> {


   List<EmbeddedMovie>  findByTitle(String title);

   List<EmbeddedMovie> findByAwardsNominations(Integer noms);
}
