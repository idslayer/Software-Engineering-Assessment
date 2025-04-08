package com.example.bemediasearch.payload.resquest;

public class OpenverseSearchRequest {
    private String query;
    private Integer page;
    private Integer pageSize;

    // Constructors
    public OpenverseSearchRequest() {}

    public OpenverseSearchRequest(String query, Integer page, Integer pageSize) {
        this.query = query;
        this.page = page;
        this.pageSize = pageSize;
    }

    // Getters & Setters
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
}
