package org.example;

import java.io.File;

public class ImagesManager {

    private final int imagesSetQuantity;
    private final File[] images;
    private File[] imagesSet;



    public ImagesManager(String productPath, int imagesSetQuantity) {
        images = new File(productPath).listFiles(File::isFile);
        this.imagesSetQuantity = imagesSetQuantity;
    }

    public File[] getImagesSet() {
        imagesSet = new File[imagesSetQuantity];
        System.arraycopy(images, 0, imagesSet, 0, imagesSetQuantity);
        return imagesSet;
    }


}
