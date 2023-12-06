package com.sparta.thespringsons.finalapiproject.security;

import com.sparta.thespringsons.finalapiproject.model.repositories.ApiKeyRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    private final ApiKeyRepository apiKeyRepository;

    @Autowired
    public AuthenticationService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public boolean checkUserAccess(HttpServletRequest request) throws Exception {
        // Allow requests without an API key for HTTP GET methods
        if (HttpMethod.GET.matches(request.getMethod())) {
            return false;
            // Maybe we want to throw status code or exception here instead
        }

        // For all other methods (POST, PUT, DELETE, etc.), require a valid API key
        String apiKey = request.getHeader("Key");

        if (apiKey == null || !isValidApiKey(apiKey)) {
            throw new Exception("Invalid API Key");
        }

        return true;
    }


    private boolean isValidApiKey(String apiKey) {
        return apiKeyRepository.findByApiKey(apiKey).isPresent();
    }
}