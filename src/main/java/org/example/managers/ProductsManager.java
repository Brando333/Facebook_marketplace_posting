package org.example.managers;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;


/**
 * Manages the quantity of products and retrieve their names
 */
public class ProductsManager {
    private int productsQuantity;
    private File[] products;
    private int nextProduct = 0;

    public ProductsManager(String path) {
        products = new File(path).listFiles(File::isDirectory);
        int productsQuantity = Objects.requireNonNull(products).length;
    }

    public String[] getProductsNames() {
        return Arrays.stream(products).map(File::getName).toArray(String[]::new);
    }

    public void nextProductName() {
        nextProduct++;
    }

    public String getCurrentProductName() {
        return products[nextProduct].getName();
    }

}
