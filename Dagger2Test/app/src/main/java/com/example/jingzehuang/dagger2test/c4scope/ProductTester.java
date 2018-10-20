package com.example.jingzehuang.dagger2test.c4scope;

/**
 * Created by Raych on Oct.19, 18.
 */

public class ProductTester {

    private static int NUM = 0;
    private final String name;

    public ProductTester() {
        this.name = "Tester[" + NUM++ + "]";
    }

    public String testProduct(Product product) {
        return "Product:[" + product.getName() + "] is tested by Tester:[" + this.name + "].";
    }

    public String getName() {
        return name;
    }
}
