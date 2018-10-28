package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.network.LoadPhotoService;
import com.example.interview.interview.network.NetworkConfig;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module
public class LoadPhotoServiceModule {

    @Provides
    LoadPhotoService provideLoadPhotoService(Retrofit retrofit) {
        return retrofit.create(LoadPhotoService.class);
    }

//    @Provides
//    public LoadPhotoService provideLoadPhotoService() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(new OkHttpClient.Builder().build())
//                .baseUrl(NetworkConfig.BASE_ENDPOINT)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        return retrofit.create(LoadPhotoService.class);
//    }
}
