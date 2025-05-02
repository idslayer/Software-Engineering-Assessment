package com.example.bemediasearch.service;


import com.example.bemediasearch.entity.User;
import com.example.bemediasearch.payload.response.ClientRegistrationResponse;
import com.example.bemediasearch.payload.response.TokenResponse;
import com.example.bemediasearch.payload.resquest.ClientRegistrationRequest;
import com.example.bemediasearch.payload.resquest.TokenRequest;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OpenverseAuthService {

    private static final String TOKEN_URL = "https://api.openverse.org/v1/auth_tokens/token/";

    public TokenResponse getToken(TokenRequest tokenRequest) {
        RestTemplate restTemplate = new RestTemplate();

        // Set form data
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();

        formData.add("grant_type", "client_credentials");
        formData.add("client_id", tokenRequest.getClientId());
        formData.add("client_secret", tokenRequest.getClientSecret());

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

        ResponseEntity<TokenResponse> response = restTemplate.exchange(
                TOKEN_URL,
                HttpMethod.POST,
                request,
                TokenResponse.class
        );

        return response.getBody();
    }

    public ClientRegistrationResponse registerClient(ClientRegistrationRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ClientRegistrationRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ClientRegistrationResponse> response = restTemplate.exchange(
                "https://api.openverse.org/v1/auth_tokens/register/",
                HttpMethod.POST,
                entity,
                ClientRegistrationResponse.class
        );

        return response.getBody();
    }

    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean register(String username, String fullName, String password) {
        if (users.containsKey(username)) return false;

        String passwordHash = passwordEncoder.encode(password);
        users.put(username, new User(username, fullName, passwordHash));
        return true;
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
            return user;
        }
        return null;
    }


}
