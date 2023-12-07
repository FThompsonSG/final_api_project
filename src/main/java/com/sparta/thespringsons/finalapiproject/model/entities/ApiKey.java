package com.sparta.thespringsons.finalapiproject.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Keys")
public class ApiKey {
    @Id
    private String id;
    private String apiKey;

    public String getId() {
        return id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
