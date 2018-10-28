package com.example.jingzehuang.dagger2test.recursiveInject;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductTagModule {

  @Provides
  public ProductTag provideProductTag() {
    return new ProductTag();
  }
}
