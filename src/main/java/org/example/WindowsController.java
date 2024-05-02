package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class WindowsController {

    private GraphicsDevice gd;
    private final File imagesDirectory;
    private final Robot robot;
    private final File[] subDirectories;

    public WindowsController(String path) throws AWTException {
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        imagesDirectory = new File(path);
        robot = new Robot(gd);
        subDirectories = imagesDirectory.listFiles(File::isDirectory);
    }

    public void pickImages() {
        writePathInWindowsManager();
        chooseProduct();
        selectImages();
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
        for (int i = 0; i < repeatCount; i++) {
            pressAndReleaseKey(keyCode);
            System.err.println(KeyEvent.getKeyText(keyCode) + "is presseingf");
        }
    }

    private void pressAndReleaseKey(int keyCode) {

        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    private void chooseProduct() {
        System.out.println("choose product");
        repeatPressAndReleaseKey(KeyEvent.VK_TAB, 4);
        pressAndReleaseKey(KeyEvent.VK_ENTER);
    }

    private void writePathInWindowsManager() {
        System.out.println("writePathInWindowsManager");
        getFocusInWriter();
        clear();
        sendKeys(imagesDirectory.getAbsolutePath());
    }

    private void clear() {
        System.out.println("clear");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        pressAndReleaseKey(KeyEvent.VK_LEFT);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        pressAndReleaseKey(KeyEvent.VK_LEFT);

        pressAndReleaseKey(KeyEvent.VK_DELETE);

    }

    private void getFocusInWriter() {
        System.err.println("getFocusInWriter");
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
