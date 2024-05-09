package org.example.managers;

import java.io.File;

public class ProductsManager {
    private int productsQuantity;
    private File[] products;


    private int nextProduct = 0;


    public ProductsManager(String path) {
        products = new File(path).listFiles(File::isDirectory);
        int productsQuantity = products.length;
    }

    public void nextProductName() {
        nextProduct++;
    }

    public String getCurrentProductName() {
        return products[nextProduct].getName();
    }


//    public File[] getSetImagesOfCurrentProduct() {
//
//    }
}
