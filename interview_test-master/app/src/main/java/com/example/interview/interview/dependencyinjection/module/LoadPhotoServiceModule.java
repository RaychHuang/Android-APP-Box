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
    OkHttpClient provideOkhttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        return client.build();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(NetworkConfig.BASE_ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    LoadPhotoService provideLoadPhotoService(Retrofit retrofit) {
        return retrofit.create(LoadPhotoService.class);
    }

}
