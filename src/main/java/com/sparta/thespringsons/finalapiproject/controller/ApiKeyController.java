package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.ApiKey;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.security.ApiKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiKeyController {

    private ApiKeyService apiKeyService;
    private ApiKeyGenerator apiKeyGenerator;
    @Autowired
    public ApiKeyController(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;

    }

    @GetMapping("/generate")
    public ApiKey generateApiKey() {
        // Generate and return a new API key
        String apiKey = ApiKeyGenerator.generateApiKey();
        // You may want to associate the generated key with a user and store it in a database.
        return apiKeyService.createApiKey(apiKey);
    }
}
