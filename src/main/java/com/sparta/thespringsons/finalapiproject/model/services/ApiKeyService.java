package com.sparta.thespringsons.finalapiproject.model.services;

import com.sparta.thespringsons.finalapiproject.model.entities.ApiKey;
import com.sparta.thespringsons.finalapiproject.model.repositories.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {
    private ApiKeyRepository apiKeyRepository;
    @Autowired
    public ApiKeyService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public ApiKey createApiKey(String apiKey){
        ApiKey newkey = new ApiKey();
        newkey.setApiKey(apiKey);
        apiKeyRepository.save(newkey);
        return newkey;
    }

    public boolean checkIfApiKeyExists(String apiKey){
        boolean keyExists = false;
        if(apiKeyRepository.findByApiKey(apiKey).isPresent()){
            keyExists = true;
        }
        return keyExists;
    }
}
