package com.example.jingzehuang.dagger2test.c4;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;

/**
 * Created by Raych on Oct.19, 18.
 */

public class TestC4Destination {

    @Test
    public void testProduct() {

        com.example.jingzehuang.dagger2test.c4.Destination c4Destination = new Destination();

        assertNull(c4Destination.product);
        assertNull(c4Destination.tester);

        c4Destination.init();

        assertNotNull(c4Destination.product);
        assertNotNull(c4Destination.tester);

        Product c4Product = c4Destination.product;
        ProductTester c4Tester = c4Destination.tester;

        System.out.println(c4Destination.product.getName());
        System.out.println(c4Destination.tester.getName());

        c4Destination.init();

        assertNotSame(c4Product, c4Destination.product);
        assertSame(c4Tester, c4Destination.tester);

        System.out.println(c4Destination.product.getName());
        System.out.println(c4Destination.tester.getName());
    }

}
