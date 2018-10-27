package com.example.interview.interview.network;

import com.example.interview.interview.model.ImagePair;
import com.example.interview.interview.model.ResponseItem;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface LoadPhotoService {

//    @GET("photos/")
//    public Call<String> loadPhotos(@Query("client_id") String clientId);

    @GET("photos/")
    Observable<List<ResponseItem>> loadPhotos(@Query("client_id") String clientId);
}
