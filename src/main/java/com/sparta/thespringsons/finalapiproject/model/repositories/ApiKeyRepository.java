package com.sparta.thespringsons.finalapiproject.model.repositories;

import com.sparta.thespringsons.finalapiproject.model.entities.ApiKey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiKeyRepository extends MongoRepository<ApiKey,String> {
    Optional<ApiKey> findByApiKey(String apiKey);
}
