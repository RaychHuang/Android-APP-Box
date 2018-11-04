package com.example.interview.interview.model.basic;

/**
 * Created by Raych on Oct.31, 18.
 */
public class ImageInfo {

    private String id;
    private Integer width;
    private Integer height;
    private String url;

    public ImageInfo(String id, Integer width, Integer height, String url) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.url = url;
    }

    public ImageInfo(LoadImageResponse response) {
        this.id = response.id;
        this.width = response.width;
        this.height = response.height;
        this.url = response.urls.regular;
    }

    public String getId() {
        return id;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public int getTargetHeight(int targetWidth) {
        return (this.height * targetWidth) / this.width;
    }
}
