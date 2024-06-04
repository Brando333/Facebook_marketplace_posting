package org.example.managers;

import org.example.app.User;

import java.io.File;

public class ImagesManager {

    private final int imagesSetQuantity;
    private final File[] images;
    private File[] imagesSet;
    private int index = 0;
    private ProductsManager productsManager;


    public ImagesManager(ProductsManager productsManager, int imagesSetQuantity) {
        String product = productsManager.getCurrentProductName();
        String imagesPath = User.productsPath + "\\" + product;
        images = new File(imagesPath).listFiles(File::isFile);
        this.imagesSetQuantity = imagesSetQuantity;
        this.productsManager = productsManager;
    }

    public File[] getNextImagesSet() {

        imagesSet = new File[imagesSetQuantity];
        for (int i = index; i < imagesSet.length; i++) {
            imagesSet[i] = images[i];
            index = i;
        }
        return imagesSet;
    }


    public String getCurrentProduct() {
        return productsManager.getCurrentProductName();
    }

}
