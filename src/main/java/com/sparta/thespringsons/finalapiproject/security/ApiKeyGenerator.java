package com.sparta.thespringsons.finalapiproject.security;

import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;


@Component
public class ApiKeyGenerator {

    private static ApiKeyService apiKeyService = null;

    @Autowired
    public ApiKeyGenerator(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    public static String generateApiKey() {
        String apiKey;
        do {
            int randomNumber = new Random().nextInt(90000000) + 10000000;
            apiKey = String.valueOf(randomNumber);
        } while (apiKeyService.checkIfApiKeyExists(apiKey));
        return apiKey;
    }
}
