package com.example.bemediasearch.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {
    private String name;
    private Double accuracy;

    @JsonProperty("unstable__provider")
    private String unstableProvider;
}
