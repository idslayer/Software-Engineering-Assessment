package com.example.bemediasearch.payload.resquest;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageSearchRequest {
    private String q;
    private Integer page = 1;
    private Integer pageSize = 20;
    private String source;
    private String excludedSource;
    private String tags;
    private String title;

    public String getQ() {
        return q;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getSource() {
        return source;
    }

    public String getExcludedSource() {
        return excludedSource;
    }

    public String getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getUnstable__collection() {
        return unstable__collection;
    }

    public String getUnstable__tag() {
        return unstable__tag;
    }

    public String getLicense() {
        return license;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public Boolean getFilterDead() {
        return filterDead;
    }

    public String getExtension() {
        return extension;
    }

    public Boolean getMature() {
        return mature;
    }

    public String getUnstable__sort_by() {
        return unstable__sort_by;
    }

    public String getUnstable__sort_dir() {
        return unstable__sort_dir;
    }

    public Boolean getUnstable__authority() {
        return unstable__authority;
    }

    public Double getUnstable__authority_boost() {
        return unstable__authority_boost;
    }

    public Boolean getUnstable__include_sensitive_results() {
        return unstable__include_sensitive_results;
    }

    public String getCategory() {
        return category;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public String getSize() {
        return size;
    }

    private String creator;
    private String unstable__collection;
    private String unstable__tag;
    private String license;
    private String licenseType;
    private Boolean filterDead = true;
    private String extension;
    private Boolean mature = false;
    private String unstable__sort_by = "relevance";
    private String unstable__sort_dir = "desc";
    private Boolean unstable__authority = false;
    private Double unstable__authority_boost = 1.0;
    private Boolean unstable__include_sensitive_results = false;
    private String category;
    private String aspectRatio;
    private String size;
}
