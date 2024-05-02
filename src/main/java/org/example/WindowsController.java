package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WindowsController {

    private final String absolutePathDirectoryImages;
    private GraphicsDevice gd;
    private final Robot robot;

    ProductsManager productsManager;


    public WindowsController(String path) throws AWTException {
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        robot = new Robot(gd);
        absolutePathDirectoryImages = path;
        productsManager = new ProductsManager(path);
    }

    public void pickImages() {
        writePathInWindowsManager();
        chooseProduct();
//        selectImages();
    }

    private void selectImages() {
        pressAndReleaseKey(KeyEvent.VK_DOWN);
        pressAndReleaseKey(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_SHIFT);
        repeatPressAndReleaseKey(KeyEvent.VK_LEFT, 4);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        pressAndReleaseKey(KeyEvent.VK_ENTER);

    }

    private void repeatPressAndReleaseKey(int keyCode, int repeatCount) {
        System.err.println("===============");
        for (int i = 0; i < repeatCount; i++) {
            pressAndReleaseKey(keyCode);
            System.out.println(KeyEvent.getKeyText(keyCode));
        }
    }

    private void pressAndReleaseKey(int keyCode) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    private void chooseProduct() {
        robot.delay(1000);
        putFocusOnFileBrowser();
        String product = productsManager.getNextProductName();
        sendKeys(product);
    }

    private void putFocusOnFileBrowser() {

        repeatPressAndReleaseKey(KeyEvent.VK_TAB, 6);

    }

    private void writePathInWindowsManager() {
        getFocusInWriter();
        clear();
        sendKeys(absolutePathDirectoryImages);
    }

    private void clear() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        pressAndReleaseKey(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);

    }

    private void getFocusInWriter() {
        pressAndReleaseKey(KeyEvent.VK_F4);
    }


    private void sendKeys(String text) {

        text = text.toUpperCase();


        for (char c : text.toCharArray()) {
            if (c == '\\') {
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_NUMPAD9);
                robot.keyPress(KeyEvent.VK_NUMPAD2);
                robot.keyRelease(KeyEvent.VK_ALT);
                robot.keyRelease(KeyEvent.VK_NUMPAD9);
                robot.keyRelease(KeyEvent.VK_NUMPAD2);
            }
            if (Character.isLetter(c)) {

                pressAndReleaseKey(c);
            }
            if (c == ':') { //for semicolon
                robot.keyPress(KeyEvent.VK_SHIFT);
                pressAndReleaseKey(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }

        }
        pressAndReleaseKey(KeyEvent.VK_ENTER);

    }

    public void getProducts() {

    }


}
