package com.sparta.thespringsons.finalapiproject.security;

import com.sparta.thespringsons.finalapiproject.model.entities.ApiKey;
import com.sparta.thespringsons.finalapiproject.model.repositories.ApiKeyRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";

    private static ApiKeyRepository apiKeyRepository;

    @Autowired
    public AuthenticationService(ApiKeyRepository apiKeyRepository) {
        AuthenticationService.apiKeyRepository = apiKeyRepository;
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        // Allow requests without an API key for HTTP GET methods
        if (HttpMethod.GET.matches(request.getMethod())) {
            return null; // Return null to indicate no authentication is required for GET requests
        }

        // For all other methods (POST, PUT, DELETE, etc.), require a valid API key
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !isValidApiKey(apiKey)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }

    private static boolean isValidApiKey(String apiKey) {
        // Check if the API key is present in the database
        return apiKeyRepository.findByApiKey(apiKey).isPresent();
    }

    // Method to create a new key for a user and store it in the database
    public String createAndStoreApiKey(String userId) {
        // Generate a new API key (you can use your logic here)
        String newApiKey = ApiKeyGenerator.generateApiKey();

        // Save the new key in the database
        ApiKey apiKey = new ApiKey();
        apiKey.setApiKey(newApiKey);
        apiKeyRepository.save(apiKey);
        return newApiKey;
    }
}