package com.example.interview.interview.model.network;

import com.example.interview.interview.model.basic.LoadImageResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Raych on Oct.31, 18.
 */

public interface LoadImageService {

    @GET("photos/")
    Observable<List<LoadImageResponse>> loadImage(@Query("client_id") String client_id);
}
