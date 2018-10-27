package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.MainActivityFragmentContract;
import com.example.interview.interview.MainActivityFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityFragmentPresenterModule {

    @Provides
    public MainActivityFragmentContract.Presenter providePresenter() {
        return new MainActivityFragmentPresenter();
    }
}
