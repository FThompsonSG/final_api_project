package com.sparta.thespringsons.finalapiproject.controller;

import com.sparta.thespringsons.finalapiproject.model.entities.ApiKey;
import com.sparta.thespringsons.finalapiproject.model.services.ApiKeyService;
import com.sparta.thespringsons.finalapiproject.security.ApiKeyGenerator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiKeyController {

    private final ApiKeyService apiKeyService;
    private final HttpServletRequest request;

    private ApiKeyGenerator apiKeyGenerator;
    @Autowired
    public ApiKeyController(ApiKeyService apiKeyService, HttpServletRequest request) {
        this.apiKeyService = apiKeyService;
        this.request = request;
    }

    @Tag(name = "Key API")
    @Operation(summary = "Generate an API key")
    @GetMapping("/generate")
    public ApiKey generateApiKey() {
        // Generate and return a new API key
        String apiKey = ApiKeyGenerator.generateApiKey();
        // You may want to associate the generated key with a user and store it in a database.
        return apiKeyService.createApiKey(apiKey);
    }

    @Tag(name = "Key API")
    @Operation(summary = "Test if an API key is valid")
    @PostMapping("/test")
    public boolean randomCheck() {
        String apikey = request.getHeader("Key");
        return apiKeyService.checkIfApiKeyExists(apikey);
    }
}
