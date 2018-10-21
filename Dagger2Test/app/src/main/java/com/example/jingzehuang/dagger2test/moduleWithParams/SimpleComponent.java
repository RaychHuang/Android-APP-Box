package com.example.jingzehuang.dagger2test.moduleWithParams;

import dagger.Component;

@Component(modules = {SimpleModule.class, NameModule.class})
public interface SimpleComponent {

    void inject(Destination destination);
}