package org.example.utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotUtils {
    private Robot robot;

    public RobotUtils(Robot robot) {
        this.robot = robot;
    }

    /**
     * returns true if is found a printable character
     * that can be typed with no needing of key modifier as 'SHIFT' or 'ALT GR' keys
     */
    public static boolean isEspecialChar(char ch) {
        return String.valueOf(ch).matches("[ª\"·$%&/()=?¿^*¨;:_@|#~€¬\\\\]");
    }

    public void pressAndReleaseSpecialChar(char ch) {

        switch (ch) {
            case '\\' -> {
                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_NUMPAD9);
                robot.keyPress(KeyEvent.VK_NUMPAD2);
                robot.keyRelease(KeyEvent.VK_ALT);

                robot.keyRelease(KeyEvent.VK_NUMPAD9);
                robot.keyRelease(KeyEvent.VK_NUMPAD2);
            }
            case ':' -> {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            case '(' -> {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_8);
                robot.keyRelease(KeyEvent.VK_8);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            case ')' -> {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_9);
                robot.keyRelease(KeyEvent.VK_9);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            case '"' -> {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_2);
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }

        }
    }

    public void pressAndReleaseKey(int keyCode) {

        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    public void sendKeys(String text) {

        text = text.toUpperCase();
        for (char c : text.toCharArray()) {
            if (RobotUtils.isEspecialChar(c)) {
                pressAndReleaseSpecialChar(c);
            } else {
                pressAndReleaseKey(c);
            }
        }
        pressAndReleaseKey(KeyEvent.VK_ENTER);
        robot.delay(500);
    }

    public void repeatPressAndReleaseKey(int keyCode, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            pressAndReleaseKey(keyCode);
            robot.delay(300);
        }
    }
}
