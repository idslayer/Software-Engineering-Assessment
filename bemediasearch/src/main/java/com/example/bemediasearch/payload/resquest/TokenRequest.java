package com.example.bemediasearch.payload.resquest;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public class TokenRequest {
    private String clientId;
    private String clientSecret;
    private String grant_type;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getGrant_type() {
        return grant_type;
    }
}
