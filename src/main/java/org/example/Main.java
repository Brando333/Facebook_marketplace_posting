package org.example;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Scanner sc = new Scanner(System.in);

        System.out.println("User");
        String user = User.user;
        System.out.println("password");
        String password = User.pass;
        System.out.println("imagesPath");
        String imagesPath = User.images;

        FacebookController facebookController = new FacebookController(user, password);
        facebookController.login();
        facebookController.clickMarketPlace();

        WindowsController windowsController = new WindowsController(imagesPath);
        windowsController.pickImages();


    }
}
