package org.example.controllers;

import org.example.managers.ImagesManager;
import org.example.utils.ImagesManagerUtils;
import org.example.managers.ProductsManager;
import org.example.utils.RobotUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class WindowsController {

    private final String absolutePathDirectoryImages;
    private GraphicsDevice gd;
    private final Robot robot;
    private RobotUtils robotUtils;

    ProductsManager productsManager;


    public WindowsController(String path) throws AWTException {
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        robot = new Robot(gd);
        absolutePathDirectoryImages = path;
        productsManager = new ProductsManager(path);
        robotUtils = new RobotUtils(robot);
    }

    public void pickImages() {
        writePathInWindowsManager();
        chooseProduct();
        selectImages();
        productsManager.nextProductName();
    }

    private void selectImages() {
        String imagesPath = absolutePathDirectoryImages + "\\" + productsManager.getCurrentProductName();
        ImagesManager imagesManager = new ImagesManager(imagesPath, 5);
        File[] images = imagesManager.getImagesSet();
        String imagesToBeSelected = ImagesManagerUtils.getImagesStringForSelecting(images);
        robot.delay(500);
        robotUtils.sendKeys(imagesToBeSelected);
        robotUtils.pressAndReleaseKey(KeyEvent.VK_ENTER);
        robot.delay(500);
    }


    private void chooseProduct() {
        putFocusOnFileBrowser();
        String product = productsManager.getCurrentProductName();
        robot.keyPress(KeyEvent.VK_ENTER);
        robotUtils.sendKeys(product);
    }

    private void putFocusOnFileBrowser() {

        robot.delay(500);
        robotUtils.repeatPressAndReleaseKey(KeyEvent.VK_TAB, 6);

    }

    private void writePathInWindowsManager() {
        getFocusInWriter();
        clear();
        robotUtils.sendKeys(absolutePathDirectoryImages);

    }

    private void clear() {
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robotUtils.pressAndReleaseKey(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);


    }

    private void getFocusInWriter() {
        robot.delay(1000);
        robotUtils.pressAndReleaseKey(KeyEvent.VK_F4);
    }

}
