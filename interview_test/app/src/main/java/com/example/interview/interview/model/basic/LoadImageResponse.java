package com.example.interview.interview.model.basic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Raych on Oct.31, 18.
 */

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
}
