package com.example.bemediasearch.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioSet {
    private String title;

    @JsonProperty("foreign_landing_url")
    private String foreignLandingUrl;

    private String creator;

    @JsonProperty("creator_url")
    private String creatorUrl;

    private String url;
    private Integer filesize;
    private String filetype;
}