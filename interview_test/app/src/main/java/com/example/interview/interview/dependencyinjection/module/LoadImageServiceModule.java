package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.model.network.LoadImageService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Raych on Oct.31, 18.
 */

@Module
public class LoadImageServiceModule {

    @Provides
    LoadImageService provideLoadImageService(Retrofit retrofit) {
        return retrofit.create(LoadImageService.class);
    }
}
