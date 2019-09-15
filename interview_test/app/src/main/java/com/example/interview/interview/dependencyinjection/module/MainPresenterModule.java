package com.example.interview.interview.dependencyinjection.module;

import com.example.interview.interview.model.network.LoadImageService;
import com.example.interview.interview.view.MainPresenter;
import com.example.interview.interview.view.Contract;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Raych on Oct.31, 18.
 */

@Module
public abstract class MainPresenterModule {

    @Binds
    abstract Contract.Presenter providePresenter(MainPresenter presenter);

    @Provides
    static MainPresenter provideMainPresenter(LoadImageService service) {
        return new MainPresenter(service);
    }
}
