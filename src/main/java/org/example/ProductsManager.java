package org.example;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;

public class ProductsManager {
    private int productsQuantity;
    private File[] products;


    public int nextProduct = 0;


    public ProductsManager(String path) {
        products = new File(path).listFiles(File::isDirectory);
        int productsQuantity = products.length;
    }

    public String getNextProductName() {
        return products[nextProduct++].getName();
    }

    public String getCurrentProductImage() {
        return products[nextProduct].getName();
    }


//    public File[] getSetImagesOfCurrentProduct() {
//
//    }
}
