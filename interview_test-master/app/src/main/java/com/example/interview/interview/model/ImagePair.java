package com.example.interview.interview.model;

/**
 * Created by Raych on Oct.26, 18.
 */

public class ImagePair {

    String id;

    String url;

    public ImagePair(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }
}
