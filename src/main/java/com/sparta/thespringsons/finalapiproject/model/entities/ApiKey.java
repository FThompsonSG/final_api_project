package com.sparta.thespringsons.finalapiproject.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name="API Key", description = "JSON schema of API key.")
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
