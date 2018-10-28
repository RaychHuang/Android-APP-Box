package com.example.interview.interview.dependencyinjection.component;

import com.example.interview.interview.MainActivityFragment;
import com.example.interview.interview.dependencyinjection.module.LoadPhotoServiceModule;
import com.example.interview.interview.dependencyinjection.module.NetworkModule;

import dagger.Component;

@Component(modules = {LoadPhotoServiceModule.class, NetworkModule.class})
public interface MainActivityFragmentComponent {

    void inject(MainActivityFragment fragment);
}
