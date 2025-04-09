package com.example.bemediasearch.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioSearchResponse {

    @JsonProperty("result_count")
    int resultCount;

    @JsonProperty("page_count")
    int pageCount;

    @JsonProperty("page_size")
    int pageSize;

    int page;
    List<AudioResult> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<AudioResult> getResults() {
        return results;
    }

    public void setResults(List<AudioResult> results) {
        this.results = results;
    }




    public AudioSearchResponse(int resultCount, int pageCount, int pageSize, int page, List<AudioResult> results, List<Objects> warnings) {
        this.resultCount = resultCount;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.page = page;
        this.results = results;
    }

    public AudioSearchResponse() {

    }
}