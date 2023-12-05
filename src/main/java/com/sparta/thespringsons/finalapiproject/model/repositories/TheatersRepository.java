package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.TheaterDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatersRepository extends MongoRepository<TheaterDTO, String> {



}