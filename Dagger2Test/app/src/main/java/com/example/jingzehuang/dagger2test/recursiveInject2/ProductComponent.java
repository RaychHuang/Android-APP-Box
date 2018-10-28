package com.example.jingzehuang.dagger2test.recursiveInject2;

import dagger.Component;

@Component(modules = {NameModule.class, ProductTagModule.class})
public interface ProductComponent {

  Product provideProduct();
}
