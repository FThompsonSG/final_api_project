package com.sparta.thespringsons.finalapiproject.repositories;

import com.sparta.thespringsons.finalapiproject.entities.EmbeddedMovies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmbeddedMoviesRepository extends MongoRepository<EmbeddedMovies, String> {


   List<EmbeddedMovies>  findByTitle(String title);

   List<EmbeddedMovies> findByAwardsNominations(Integer noms);
}
