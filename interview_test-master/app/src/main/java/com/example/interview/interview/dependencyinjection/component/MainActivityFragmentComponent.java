package com.example.interview.interview.dependencyinjection.component;

import com.example.interview.interview.MainActivityFragment;
import com.example.interview.interview.dependencyinjection.module.LoadPhotoServiceModule;
import com.example.interview.interview.dependencyinjection.module.NetworkModule;
import com.example.interview.interview.dependencyinjection.module.PresenterModule;

import dagger.Component;

@Component(modules = {PresenterModule.class, LoadPhotoServiceModule.class})
public interface MainActivityFragmentComponent {

    void inject(MainActivityFragment fragment);
}
