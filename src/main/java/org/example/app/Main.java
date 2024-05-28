package org.example.app;

import org.example.controllers.FacebookController;
import org.example.controllers.WindowsController;
import org.example.managers.ImagesManager;
import org.example.managers.ProductsManager;
import org.example.utils.ImagesManagerUtils;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {

         String user = User.user;
        String password = User.pass;
        String imagesPath = User.productsPath;

        //////////////////////////////////////

        FacebookController facebookController = new FacebookController(user, password);
        facebookController.login();
        facebookController.clickMarketPlace();

        ProductsManager productsManager = new ProductsManager(imagesPath);

        String product = productsManager.getCurrentProductName();
        String productPath = imagesPath + "\\" + product;

        ImagesManager imagesManager = new ImagesManager(productPath, 5);
        File[] images = imagesManager.getNextImagesSet();

        WindowsController windowsController = new WindowsController(imagesPath);
        String imagesToBeSelected = ImagesManagerUtils.getImagesStringForSelecting(images);

        windowsController.pickImages(productPath, imagesToBeSelected);

        facebookController.setRequiredFieldsToPublish();
        facebookController.publishInGroups();

    }
}
