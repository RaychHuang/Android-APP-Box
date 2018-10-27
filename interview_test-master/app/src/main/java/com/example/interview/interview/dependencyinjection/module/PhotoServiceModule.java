package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.network.LoadPhotoService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class PhotoServiceModule {

    @Provides
    public LoadPhotoService provideLoadPhotoService(Retrofit retrofit) {
        return retrofit.create(LoadPhotoService.class);
    }
}
