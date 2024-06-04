package org.example.app;

import org.example.controllers.FacebookController;
import org.example.controllers.PostController;
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
        String productsPathVariable = User.productsPath;

        //////////////////////////////////////

        FacebookController facebookController = new FacebookController(user, password);
        ProductsManager productsManager = new ProductsManager(productsPathVariable);
        ImagesManager imagesManager = new ImagesManager(productsManager, 5);
        WindowsController windowsController = new WindowsController(productsPathVariable);
        PostController postController = new PostController(facebookController, imagesManager, windowsController);

        postController.postProduct();

    }
}
