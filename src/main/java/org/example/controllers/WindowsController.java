package org.example.controllers;

import org.example.managers.ImagesManager;
import org.example.managers.ProductsManager;
import org.example.utils.RobotUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WindowsController {

    private final String absolutePathDirectoryImages;
    private GraphicsDevice gd;
    private final Robot robot;
    private RobotUtils robotUtils;


    public WindowsController(String path) throws AWTException {
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        robot = new Robot(gd);
        absolutePathDirectoryImages = path;
        robotUtils = new RobotUtils(robot);
    }

    public void pickImages(String product, String imagesToBeSelected) {
        writePathInWindowsManager();
        chooseProduct(product);
        selectImages(product, imagesToBeSelected);

    }

    private void selectImages(String imagesPath, String imagesToBeSelected) {
        robot.delay(500);
        robotUtils.sendKeys(imagesToBeSelected);
        robotUtils.pressAndReleaseKey(KeyEvent.VK_ENTER);
        robot.delay(500);
    }


    private void chooseProduct(String product) {
        putFocusOnFileBrowser();
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
