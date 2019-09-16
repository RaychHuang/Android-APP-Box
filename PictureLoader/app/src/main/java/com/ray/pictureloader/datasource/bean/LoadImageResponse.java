package com.ray.pictureloader.datasource.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoadImageResponse {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("urls")
    @Expose
    public Urls urls;

    public static class Urls {

        @SerializedName("raw")
        @Expose
        public String raw;
        @SerializedName("full")
        @Expose
        public String full;
        @SerializedName("regular")
        @Expose
        public String regular;
        @SerializedName("small")
        @Expose
        public String small;
        @SerializedName("thumb")
        @Expose
        public String thumb;
    }
}
