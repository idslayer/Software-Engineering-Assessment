package com.example.bemediasearch.payload.resquest;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ImageSearchRequest {
    private String q;
    private Integer page = 1;
    private Integer pageSize = 20;
    private String source;
    private String excludedSource;
    private String tags;
    private String title;
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

    public void setQ(String q) {
        this.q = q;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setExcludedSource(String excludedSource) {
        this.excludedSource = excludedSource;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setUnstable__collection(String unstable__collection) {
        this.unstable__collection = unstable__collection;
    }

    public void setUnstable__tag(String unstable__tag) {
        this.unstable__tag = unstable__tag;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public void setFilterDead(Boolean filterDead) {
        this.filterDead = filterDead;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setMature(Boolean mature) {
        this.mature = mature;
    }

    public void setUnstable__sort_by(String unstable__sort_by) {
        this.unstable__sort_by = unstable__sort_by;
    }

    public void setUnstable__sort_dir(String unstable__sort_dir) {
        this.unstable__sort_dir = unstable__sort_dir;
    }

    public void setUnstable__authority(Boolean unstable__authority) {
        this.unstable__authority = unstable__authority;
    }

    public void setUnstable__authority_boost(Double unstable__authority_boost) {
        this.unstable__authority_boost = unstable__authority_boost;
    }

    public void setUnstable__include_sensitive_results(Boolean unstable__include_sensitive_results) {
        this.unstable__include_sensitive_results = unstable__include_sensitive_results;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
