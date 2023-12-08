package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.mongodb.lang.NonNullApi;
import com.sparta.thespringsons.finalapiproject.model.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


    Optional<User> findByName(String name);

    Optional<User> findById(String id);


}