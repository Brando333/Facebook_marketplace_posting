package org.example.controllers;

import org.example.managers.ImagesManager;
import org.example.managers.ProductsManager;

import java.io.File;

public class PostController {


    ProductsManager productsManager;
    ImagesManager imagesManager;

    public PostController(ProductsManager productsManager, ImagesManager imagesManager) {
        this.productsManager = productsManager;
        this.imagesManager = imagesManager;
    }

    public void postProduct() {


    }

//
//    private int getNextGroupIndexToPublishSince() {
//
//
//    }

    private File[] getNextImages() {
        return imagesManager.getNextImagesSet();
    }

}
