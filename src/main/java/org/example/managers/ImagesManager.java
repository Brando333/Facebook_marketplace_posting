package org.example.managers;

import java.io.File;

public class ImagesManager {

    private final int imagesSetQuantity;
    private final File[] images;
    private File[] imagesSet;

    private int index = 0;

    public ImagesManager(String productPath, int imagesSetQuantity) {
        images = new File(productPath).listFiles(File::isFile);
        this.imagesSetQuantity = imagesSetQuantity;
    }

    public File[] getNextImagesSet() {

        imagesSet = new File[imagesSetQuantity];
        for (int i = index; i < imagesSet.length; i++) {
            imagesSet[i] = images[i];
            index = i;
        }
        return imagesSet;
    }


}
