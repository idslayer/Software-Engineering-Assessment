package com.example.bemediasearch.service;


import com.example.bemediasearch.payload.response.ImageSearchResponse;
import com.example.bemediasearch.payload.resquest.ImageSearchRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class OpenverseService {

    private final String BASE_URL = "https://api.openverse.org/v1/images";

//    public OpenverseSearchResponse searchImages(OpenverseSearchRequest request) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = UriComponentsBuilder
//                .fromUriString(BASE_URL)
//                .queryParam("q", request.getQuery())
//                .queryParam("page", request.getPage() != null ? request.getPage() : 1)
//                .queryParam("page_size", request.getPageSize() != null ? request.getPageSize() : 10)
//                .build()
//                .toUriString();
//
//        Map<String, Object> apiResponse = restTemplate.getForObject(url, Map.class);
//
//        Integer resultCount = (Integer) apiResponse.getOrDefault("result_count", 0);
//        List<Map<String, Object>> results = (List<Map<String, Object>>) apiResponse.getOrDefault("results", List.of());
//
//        return new OpenverseSearchResponse(resultCount, results);
//    }

    public ImageSearchResponse searchImages(ImageSearchRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.openverse.org/v1/images")
                .queryParam("q", request.getQ())
                .queryParam("page", request.getPage())
                .queryParam("page_size", request.getPageSize())
                .queryParam("source", request.getSource())
                .queryParam("excluded_source", request.getExcludedSource())
                .queryParam("tags", request.getTags())
                .queryParam("title", request.getTitle())
                .queryParam("creator", request.getCreator())
                .queryParam("collection", request.getUnstable__collection())
                .queryParam("tag", request.getUnstable__tag())
                .queryParam("license", request.getLicense())
                .queryParam("license_type", request.getLicenseType())
                .queryParam("filter_dead", request.getFilterDead())
                .queryParam("extension", request.getExtension())
                .queryParam("mature", request.getMature())
                .queryParam("sort_by", request.getUnstable__sort_by())
                .queryParam("sort_dir", request.getUnstable__sort_dir())
                .queryParam("authority", request.getUnstable__authority())
                .queryParam("authority_boost", request.getUnstable__authority_boost())
                .queryParam("include_sensitive_results", request.getUnstable__include_sensitive_results())
                .queryParam("category", request.getCategory())
                .queryParam("aspect_ratio", request.getAspectRatio())
                .queryParam("size", request.getSize())
                .build(true)
                .toUri();

        ResponseEntity<ImageSearchResponse> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                ImageSearchResponse.class
        );

        return response.getBody();
    }

}

