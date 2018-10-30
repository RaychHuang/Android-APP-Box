package com.example.interview.interview.model;

public class ImagePair {

    private String id;
    private String url;
    private int width;
    private int height;

    public ImagePair(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public ImagePair(String id, String url, int w, int h) {
        this.id = id;
        this.url = url;
        this.width = w;
        this.height = h;
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public int getTargetHeight(int targetWidth) {
        return (this.height * targetWidth) / this.width;
    }
}
