package org.example.managers;

import java.io.File;
import java.util.Arrays;

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


        for (int i = 0; i < imagesSet.length; i++) {
            imagesSet[i] = images[i];
        }


        return imagesSet;
    }


}
