package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatersRepository extends MongoRepository<Theater, String> {


    Optional<Theater> getTheaterByTheaterId(int theater_id);


}