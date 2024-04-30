package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FacebookController {

    private ChromeOptions options;
    private WebDriver driver;
    Actions actions;

    public FacebookController() throws InterruptedException {
        init();
        login();
        publish();
    }

    private void init() {
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        actions = new Actions(driver);
    }

    private void login() {
        driver.findElement(By.id("email")).sendKeys(User.email);
        driver.findElement(By.id("pass")).sendKeys(User.password);
        driver.findElement(By.tagName("button")).click();
    }

    private void publish() throws InterruptedException {
        driver.findElement(By.linkText("Marketplace")).click();
        driver.findElement(By.partialLinkText("Create new listing")).click();
        driver.findElement(By.partialLinkText("Item for sale")).click();

        Thread.sleep(3000);
        WebElement addPhotosButton = getAddPhotosButton();
        addPhotosButton.click();

    }

    private WebElement getAddPhotosButton() {
        actions.sendKeys("\t").perform();
        return driver.switchTo().activeElement();
    }


}
