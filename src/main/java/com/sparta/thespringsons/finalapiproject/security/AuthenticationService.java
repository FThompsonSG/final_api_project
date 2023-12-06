package com.sparta.thespringsons.finalapiproject.security;

import com.sparta.thespringsons.finalapiproject.model.repositories.ApiKeyRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
>>>>>>> ae17f5c0ee9383c4937d9494582c68af9a50ac9b

public class AuthenticationService {

    private final ApiKeyRepository apiKeyRepository;

    @Autowired
    public AuthenticationService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

<<<<<<< HEAD
    public boolean checkUserAccess(HttpServletRequest request) throws Exception {
        // Allow requests without an API key for HTTP GET methods
=======
    public static ApiKeyAuthentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

>>>>>>> ae17f5c0ee9383c4937d9494582c68af9a50ac9b
        if (HttpMethod.GET.matches(request.getMethod())) {
            return false;
            // Maybe we want to throw status code or exception here instead
        }
<<<<<<< HEAD
        // For all other methods (POST, PUT, DELETE, etc.), require a valid API key
        String apiKey = request.getHeader("Key");
=======

>>>>>>> ae17f5c0ee9383c4937d9494582c68af9a50ac9b
        if (apiKey == null || !isValidApiKey(apiKey)) {
            throw new Exception("Invalid API Key");
        }

        return true;
    }

<<<<<<< HEAD
    private boolean isValidApiKey(String apiKey) {
=======
    private static boolean isValidApiKey(String apiKey) {
        if (apiKeyRepository == null) {
            throw new IllegalStateException("apiKeyRepository is not initialized");
        }
        // Check if the API key is present in the database
>>>>>>> ae17f5c0ee9383c4937d9494582c68af9a50ac9b
        return apiKeyRepository.findByApiKey(apiKey).isPresent();
    }
}