package com.example.interview.interview.dependencyinjection.component;

import com.example.interview.interview.MainActivity;
import com.example.interview.interview.MainActivityFragment;
import com.example.interview.interview.dependencyinjection.module.MainActivityFragmentPresenterModule;
import com.example.interview.interview.dependencyinjection.module.NetworkModule;
import com.example.interview.interview.dependencyinjection.module.PhotoServiceModule;

import dagger.Component;

@Component(modules = {NetworkModule.class, PhotoServiceModule.class,
        MainActivityFragmentPresenterModule.class})
public interface MainActivityFragmentComponent {

    void inject(MainActivityFragment fragment);
}
