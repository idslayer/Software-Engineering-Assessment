package com.example.bemediasearch.controller;


import com.example.bemediasearch.entity.User;
import com.example.bemediasearch.payload.response.ClientRegistrationResponse;
import com.example.bemediasearch.payload.response.TokenResponse;
import com.example.bemediasearch.payload.resquest.ClientRegistrationRequest;
import com.example.bemediasearch.payload.resquest.LoginRequest;
import com.example.bemediasearch.payload.resquest.RegisterRequest;
import com.example.bemediasearch.payload.resquest.TokenRequest;
import com.example.bemediasearch.service.OpenverseAuthService;
import com.example.bemediasearch.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/openverse/v1/auth")
public class OpenverseAuthController {
    @Autowired
    private OpenverseAuthService openverseAuthService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/token")
    public ResponseEntity<TokenResponse> getToken(@Valid @RequestBody TokenRequest request) {
        TokenResponse token = openverseAuthService.getToken(request);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register-client")
    public ResponseEntity<ClientRegistrationResponse> registerClient(
           @Valid @RequestBody ClientRegistrationRequest request
    ) {
        ClientRegistrationResponse response = openverseAuthService.registerClient(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        boolean success = openverseAuthService.register(request.getUsername(), request.getFullName(), request.getPassword());
        if (!success) return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        return ResponseEntity.ok("Registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = openverseAuthService.authenticate(request.getUsername(), request.getPassword());
        if (user == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

        String token = jwtUtil.generateToken(user.getUsername(), user.getFullName());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
