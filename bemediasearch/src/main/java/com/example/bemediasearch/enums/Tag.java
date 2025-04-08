package com.example.bemediasearch.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private String name;
    private Double accuracy;
    private String unstable_provider;

    public String getName() {
        return name;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public String getUnstable_provider() {
        return unstable_provider;
    }
}
