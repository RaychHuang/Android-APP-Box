package com.example.jingzehuang.dagger2test.multibinding;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MultibindingsTest {

  @Test
  public void testMultibindings() {
    ParentComponent parentComponent = DaggerParentComponent.create();
    assertThat(parentComponent.strings().size(), is(2));
    assertThat(parentComponent.stringMap().size(), is(2));

    ChildComponent childComponent = parentComponent.provideChildComponentBuilder().build();
//    assertThat(childComponent.strings().size(), is(4));
//    assertThat(childComponent.stringMap().size(), is(4));
  }
}
