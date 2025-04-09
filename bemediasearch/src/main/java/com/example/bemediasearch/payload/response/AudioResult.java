package com.example.bemediasearch.payload.response;

import com.example.bemediasearch.dtos.AudioSet;
import com.example.bemediasearch.dtos.AudioTag;
import com.example.bemediasearch.dtos.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioResult {
    private String id;
    private String title;

    @JsonProperty("indexed_on")
    private String indexedOn;

    @JsonProperty("foreign_landing_url")
    private String foreignLandingUrl;

    private String url;
    private String creator;

    @JsonProperty("creator_url")
    private String creatorUrl;

    private String license;

    @JsonProperty("license_version")
    private String licenseVersion;

    @JsonProperty("license_url")
    private String licenseUrl;

    private String provider;
    private String source;
    private String category;
    private List<String> genres;
    private Integer filesize;
    private String filetype;
    private List<Tag> tags;
    private String attribution;

    @JsonProperty("fields_matched")
    private List<String> fieldsMatched;

    private boolean mature;

    @JsonProperty("audio_set")
    private AudioSet audioSet;

    private Integer duration;

    @JsonProperty("bit_rate")
    private Integer bitRate;

    @JsonProperty("sample_rate")
    private Integer sampleRate;

    private String thumbnail;

    @JsonProperty("detail_url")
    private String detailUrl;

    @JsonProperty("related_url")
    private String relatedUrl;

    private String waveform;

    @JsonProperty("unstable__sensitivity")
    private List<String> unstableSensitivity;
}