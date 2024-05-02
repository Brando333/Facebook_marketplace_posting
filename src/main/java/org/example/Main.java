package org.example;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Scanner sc = new Scanner(System.in);

        System.out.println("User");
        String user = sc.nextLine();
        System.out.println("password");
        String password = sc.nextLine();
        System.out.println("imagesPath");
        String imagesPath = sc.nextLine();

        FacebookController facebookController = new FacebookController(user, password);
        WindowsController windowsController = new WindowsController(imagesPath);

        facebookController.login();
        facebookController.clickMarketPlace();
        windowsController.pickImages();



    }
}
