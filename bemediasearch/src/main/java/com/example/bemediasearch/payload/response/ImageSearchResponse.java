package com.example.bemediasearch.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ImageSearchResponse {
    @JsonProperty("result_count")
    private Integer resultCount;

    @JsonProperty("page_count")
    private Integer pageCount;

    @JsonProperty("page_size")
    private Integer pageSize;

    private Integer page;

    private List<ImageResult> results;

    private List<Object> warnings; // optional

    public Integer getResultCount() {
        return resultCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public List<ImageResult> getResults() {
        return results;
    }

    public List<Object> getWarnings() {
        return warnings;
    }
}
