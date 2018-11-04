package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.presenter.MainPresenter;
import com.example.interview.interview.view.Contract;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Raych on Oct.31, 18.
 */

@Module
public abstract class MainPresenterModule {

    @Binds
    abstract Contract.Presenter provideMainPresenter(MainPresenter presenter);
}
