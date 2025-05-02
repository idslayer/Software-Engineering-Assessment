package com.example.bemediasearch.controller;


import com.example.bemediasearch.dtos.UserPrincipal;
import com.example.bemediasearch.payload.response.AudioSearchResponse;
import com.example.bemediasearch.payload.response.ImageSearchResponse;
import com.example.bemediasearch.payload.resquest.AudioSearchRequest;
import com.example.bemediasearch.payload.resquest.ImageSearchRequest;
import com.example.bemediasearch.security.CurrentUser;
import com.example.bemediasearch.service.OpenverseService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/openverse/v1")
@Tag(name = "OpenverseController", description = "Openverse Controller")
public class OpenverseController {

    @Autowired
    private OpenverseService openverseService;

    @GetMapping("/images")
    public ResponseEntity<ImageSearchResponse> imageSearch(@ParameterObject ImageSearchRequest request) {
        ImageSearchResponse response = openverseService.searchImages(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/audios")
    public ResponseEntity<AudioSearchResponse> audioSearch(@Parameter String q, @Parameter Integer page, @Parameter Integer pageSize) {
        AudioSearchRequest request = new AudioSearchRequest(q, page, pageSize);
        AudioSearchResponse response = openverseService.searchAudio(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(currentUser);
    }
}