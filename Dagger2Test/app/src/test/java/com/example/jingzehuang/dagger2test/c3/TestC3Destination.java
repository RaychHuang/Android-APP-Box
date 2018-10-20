package com.example.jingzehuang.dagger2test.c3;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;

/**
 * Created by Raych on Oct.19, 18.
 */

public class TestC3Destination {

    @Test
    public void testProduct() {

        com.example.jingzehuang.dagger2test.c3.Destination c3Destination = new Destination();

        assertNull(c3Destination.product);
        assertNull(c3Destination.tester);

        c3Destination.init();

        assertNotNull(c3Destination.product);
        assertNotNull(c3Destination.tester);

        Product c3Product = c3Destination.product;
        ProductTester c3Testor = c3Destination.tester;

        System.out.println(c3Destination.product.getName());
        System.out.println(c3Destination.tester.getName());

        c3Destination.init();

        assertNotSame(c3Product, c3Destination.product);
        assertNotSame(c3Testor, c3Destination.tester);

        System.out.println(c3Destination.product.getName());
        System.out.println(c3Destination.tester.getName());
    }

}
