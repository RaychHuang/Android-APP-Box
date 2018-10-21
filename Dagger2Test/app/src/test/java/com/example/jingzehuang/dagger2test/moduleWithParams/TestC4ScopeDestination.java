package com.example.jingzehuang.dagger2test.moduleWithParams;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

/**
 * Created by Raych on Oct.19, 18.
 */

public class TestC4ScopeDestination {

    @Test
    public void testProduct() {

        Destination c4Destination = new Destination();

        assertNull(c4Destination.product);

        c4Destination.init();

        assertNotNull(c4Destination.product);

        Product c4Product = c4Destination.product;


        System.out.println(c4Destination.product.getName());

//        c4Destination.init();
//
//        assertSame(c4Product, c4Destination.product);
//
//        System.out.println(c4Destination.product.getName());
    }

}
