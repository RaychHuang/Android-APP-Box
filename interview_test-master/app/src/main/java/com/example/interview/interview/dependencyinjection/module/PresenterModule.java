package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.MainActivityFragmentContract;
import com.example.interview.interview.MainActivityFragmentPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PresenterModule {

    @Binds
    abstract MainActivityFragmentContract.Presenter providePresenter(MainActivityFragmentPresenter presenter);
}
