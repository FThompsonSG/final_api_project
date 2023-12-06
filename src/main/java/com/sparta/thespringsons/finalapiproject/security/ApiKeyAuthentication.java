package com.sparta.thespringsons.finalapiproject.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class ApiKeyAuthentication extends AbstractAuthenticationToken {
    private final String apiKey;

    public ApiKeyAuthentication(String apiKey, List<GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apiKey;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return apiKey;
    }
}
