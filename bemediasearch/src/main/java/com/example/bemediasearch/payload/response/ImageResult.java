package com.example.bemediasearch.payload.response;

import com.example.bemediasearch.enums.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResult {

    private String id;
    private String title;
    private ZonedDateTime indexed_on;
    private String foreign_landing_url;
    private String url;
    private String creator;
    private String creator_url;
    private String license;
    private String license_version;
    private String license_url;
    private String provider;
    private String source;
    private String category;
    private Long filesize;
    private String filetype;
    private List<Tag> tags;
    private String attribution;
    private List<String> fields_matched;
    private boolean mature;
    private int height;
    private int width;
    private String thumbnail;
    private String detail_url;
    private String related_url;
    private List<String> unstable__sensitivity;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getIndexed_on() {
        return indexed_on;
    }

    public String getForeign_landing_url() {
        return foreign_landing_url;
    }

    public String getUrl() {
        return url;
    }

    public String getCreator() {
        return creator;
    }

    public String getCreator_url() {
        return creator_url;
    }

    public String getLicense() {
        return license;
    }

    public String getLicense_version() {
        return license_version;
    }

    public String getLicense_url() {
        return license_url;
    }

    public String getProvider() {
        return provider;
    }

    public String getSource() {
        return source;
    }

    public String getCategory() {
        return category;
    }

    public Long getFilesize() {
        return filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getAttribution() {
        return attribution;
    }

    public List<String> getFields_matched() {
        return fields_matched;
    }

    public boolean isMature() {
        return mature;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDetail_url() {
        return detail_url;
    }

    public String getRelated_url() {
        return related_url;
    }

    public List<String> getUnstable__sensitivity() {
        return unstable__sensitivity;
    }
}
