package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.model.network.NetworkConfig;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raych on Oct.31, 18.
 */

@Module
public class RetrofitModule {

    @Provides
    OkHttpClient provideClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(NetworkConfig.API_ADDRESS)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
