package com.example.eventApplication.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtResponse {
    private String token;
    private String type = "Bearer";

    public JwtResponse(@JsonProperty("accessToken") String accessToken){
        this.token = accessToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String type) {
        this.type = type;
    }
}
