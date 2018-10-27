package com.example.interview.interview.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface LoadPhotoService {

    @GET("photos/")
    public Call<String> loadPhotos(@Query("client_id") String clientId);
}
