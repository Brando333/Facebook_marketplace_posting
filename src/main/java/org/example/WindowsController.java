package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class WindowsController {

    GraphicsDevice gd;
    File imagesDirectory;
    Robot robot;

    public WindowsController() throws AWTException {
        gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        imagesDirectory = new File("C:\\images");
        robot = new Robot(gd);

        writePathInWindowsManager(KeyEvent.VK_F4);
        init();
    }

    private void writePathInWindowsManager(int vkF4) {
        getFocusInWriter(vkF4);
        clear();
        sendKeys(imagesDirectory.getAbsolutePath());

    }

    private void clear() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_LEFT);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_LEFT);

        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);

    }

    private void getFocusInWriter(int vkF4) {
        robot.keyPress(vkF4);
        robot.keyRelease(vkF4);
    }

    public void init() {
        File[] subDirectories = imagesDirectory.listFiles(File::isDirectory);

    }

    private void sendKeys(String text) {

        text = text.toUpperCase();


        for (char c : text.toCharArray()) {
            System.out.println("c = " + c);
            if (c == '\\') {
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_NUMPAD9);
                robot.keyPress(KeyEvent.VK_NUMPAD2);
                robot.keyRelease(KeyEvent.VK_ALT);
                robot.keyRelease(KeyEvent.VK_NUMPAD9);
                robot.keyRelease(KeyEvent.VK_NUMPAD2);
            }
            if (Character.isLetter(c)) {
                robot.keyPress(c);
                robot.keyRelease(c);
            }
            if (c == ':') { //for semicolon
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }

        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void getProducts() {

    }


}
