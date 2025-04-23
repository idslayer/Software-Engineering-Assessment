package com.example.bemediasearch.payload.response;

import com.example.bemediasearch.dtos.AudioSet;
import com.example.bemediasearch.dtos.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioResult {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("indexed_on")
    private String indexedOn;

    @JsonProperty("foreign_landing_url")
    private String foreignLandingUrl;

    @JsonProperty("url")
    private String url;

    @JsonProperty("creator")
    private String creator;

    @JsonProperty("creator_url")
    private String creatorUrl;

    @JsonProperty("license")
    private String license;

    @JsonProperty("license_version")
    private String licenseVersion;

    @JsonProperty("license_url")
    private String licenseUrl;

    @JsonProperty("provider")
    private String provider;

    @JsonProperty("source")
    private String source;

    @JsonProperty("category")
    private String category;

    @JsonProperty("genres")
    private List<String> genres;

    @JsonProperty("filesize")
    private Integer filesize;

    @JsonProperty("filetype")
    private String filetype;

    @JsonProperty("tags")
    private List<Tag> tags;

    @JsonProperty("attribution")
    private String attribution;

    @JsonProperty("fields_matched")
    private List<String> fieldsMatched;

    @JsonProperty("mature")
    private boolean mature;

    @JsonProperty("audio_set")
    private AudioSet audioSet;

    @JsonProperty("duration")
    private Integer duration;

    @JsonProperty("bit_rate")
    private Integer bitRate;

    @JsonProperty("sample_rate")
    private Integer sampleRate;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("detail_url")
    private String detailUrl;

    @JsonProperty("related_url")
    private String relatedUrl;

    @JsonProperty("waveform")
    private String waveform;

    @JsonProperty("unstable__sensitivity")
    private List<String> unstableSensitivity;
}
