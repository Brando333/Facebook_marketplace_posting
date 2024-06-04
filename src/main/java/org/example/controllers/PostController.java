package org.example.controllers;

import org.example.managers.ImagesManager;
import org.example.utils.ImagesManagerUtils;

import java.io.File;

public class PostController {


    FacebookController facebookController;
    ImagesManager imagesManager;
    WindowsController windowsController;

    public PostController(FacebookController facebookController, ImagesManager imagesManager, WindowsController windowsController) {
        this.facebookController = facebookController;
        this.imagesManager = imagesManager;
        this.windowsController = windowsController;
    }

    public void postProduct() throws InterruptedException {

        facebookController.login();
        facebookController.clickMarketPlace();

        File[] files = imagesManager.getNextImagesSet();
        String imagesToBeSelected = ImagesManagerUtils.getImagesStringForSelecting(files);

        String product = imagesManager.getCurrentProduct();

        windowsController.pickImages(product, imagesToBeSelected);

        facebookController.setRequiredFieldsToPublish();
        facebookController.publishInGroups();

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
