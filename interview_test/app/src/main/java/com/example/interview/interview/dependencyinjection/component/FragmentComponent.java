package com.example.interview.interview.dependencyinjection.component;

import com.example.interview.interview.dependencyinjection.module.LoadImageServiceModule;
import com.example.interview.interview.dependencyinjection.module.MainPresenterModule;
import com.example.interview.interview.dependencyinjection.module.RetrofitModule;
import com.example.interview.interview.view.MainActivityFragment;

import dagger.Component;

/**
 * Created by Raych on Oct.31, 18.
 */

@Component(modules = {MainPresenterModule.class, RetrofitModule.class, LoadImageServiceModule.class})
public interface FragmentComponent {

    void inject(MainActivityFragment fragment);
}
