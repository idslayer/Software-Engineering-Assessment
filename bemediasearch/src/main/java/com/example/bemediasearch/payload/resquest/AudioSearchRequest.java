package com.example.bemediasearch.payload.resquest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AudioSearchRequest {
    private String query;
    private Integer page;
    private Integer pageSize;
    private String source;
    private String license;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public AudioSearchRequest(String query, Integer page, Integer pageSize) {
        this.query = query;
        this.page = page;
        this.pageSize = pageSize;

    }
}
