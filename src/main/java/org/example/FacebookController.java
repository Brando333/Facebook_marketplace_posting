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

    private String user;
    private String password;

    private ChromeOptions options;
    private WebDriver driver;
    private Actions actions;

    public FacebookController(String user, String password) {

        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        actions = new Actions(driver);

        this.user = user;
        this.password = password;


    }


    public void login() {
        driver.findElement(By.id("email")).sendKeys(user);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
    }

    public void clickMarketPlace() throws InterruptedException {
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
