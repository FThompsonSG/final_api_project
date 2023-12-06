package com.sparta.thespringsons.finalapiproject.security;

import com.sparta.thespringsons.finalapiproject.model.repositories.ApiKeyRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";

    private static ApiKeyRepository apiKeyRepository;

    @Autowired
    public AuthenticationService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public static ApiKeyAuthentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

        if (HttpMethod.GET.matches(request.getMethod())) {
            return null; // Return null to indicate no authentication is required for GET requests
        }

        if (apiKey == null || !isValidApiKey(apiKey)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }

    private static boolean isValidApiKey(String apiKey) {
        if (apiKeyRepository == null) {
            throw new IllegalStateException("apiKeyRepository is not initialized");
        }
        // Check if the API key is present in the database
        return apiKeyRepository.findByApiKey(apiKey).isPresent();
    }
}