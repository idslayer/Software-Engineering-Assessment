package com.example.bemediasearch.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AudioTag {
    private String name;
    private String unstable__provider;
    private Double accuracy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnstable__provider() {
        return unstable__provider;
    }

    public void setUnstable__provider(String unstable__provider) {
        this.unstable__provider = unstable__provider;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }
}