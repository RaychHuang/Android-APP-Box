package com.example.jingzehuang.dagger2test.subcomponent;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

@Module(subcomponents = SubSimpleModule.SubSimpleComponent.class)
public class SubSimpleModule {

  @Provides
  public Product provideProduct() {
    return new Product();
  }

  @Subcomponent(modules = SubSimpleModule.class)
  public interface SubSimpleComponent {

    @Subcomponent.Builder
    interface Builder {
      com.example.jingzehuang.dagger2test.subcomponent.SubSimpleComponent build();
    }
  }
}
