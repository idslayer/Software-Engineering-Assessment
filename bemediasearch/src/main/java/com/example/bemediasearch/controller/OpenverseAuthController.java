package com.example.bemediasearch.controller;


import com.example.bemediasearch.payload.response.ClientRegistrationResponse;
import com.example.bemediasearch.payload.response.TokenResponse;
import com.example.bemediasearch.payload.resquest.ClientRegistrationRequest;
import com.example.bemediasearch.payload.resquest.TokenRequest;
import com.example.bemediasearch.service.OpenverseAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openverse")
public class OpenverseAuthController {
    @Autowired
    private  OpenverseAuthService openverseAuthService;

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
}
