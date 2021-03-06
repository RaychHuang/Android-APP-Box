package com.example.jingzehuang.dagger2test.recursiveInject2;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import org.junit.Test;

public class TestRecursiveInject2 {

    @Test
    public void testProduct() {

        Destination c5Destination = new Destination();

        assertNull(c5Destination.product);

        c5Destination.init();

        assertNotNull(c5Destination.product);

        Product c5Product = c5Destination.product;

        System.out.println(c5Destination.product.getName());

        assertNotNull(c5Destination.product.tag);

//        c5Destination.init();
//
//        assertSame(c4Product, c5Destination.product);
//
//        System.out.println(c5Destination.product.getName());
    }

}
