package org.example.controllers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FacebookController {

    private final String user;
    private final String password;

    private final WebDriver driver;
    private final Actions actions;


    public FacebookController(String user, String password) {

        ChromeOptions options = new ChromeOptions();
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
        Thread.sleep(5000);

        WebElement addPhotosButton = getAddPhotosButton();
        addPhotosButton.click();

    }

    private WebElement getAddPhotosButton() {
        actions.sendKeys("\t").perform();
        return driver.switchTo().activeElement();
    }

    public void setRequiredFieldsToPublish() throws InterruptedException {

        WebElement title = getTitleTextBox();
        title.sendKeys("Some title");

        By priceLocator = RelativeLocator.with(By.tagName("input")).below(title);
        WebElement priceTextBox = driver.findElement(priceLocator);
        priceTextBox.sendKeys("0");


        By categoryLocator = RelativeLocator.with(By.tagName("div")).below(priceTextBox);
        WebElement categoryComboBox = driver.findElement(categoryLocator);
        categoryComboBox.click();
        actions.sendKeys("\t\t\n").perform();

        By conditionLocator = RelativeLocator.with(By.tagName("div")).below(categoryComboBox);
        WebElement conditionComboBox = driver.findElement(conditionLocator);
        conditionComboBox.click();

        actions.sendKeys(Keys.ARROW_DOWN).sendKeys("\n").perform();


        By descriptionLocator = RelativeLocator.with(By.tagName("textarea")).below(conditionComboBox);
        WebElement descriptionTextArea = driver.findElement(descriptionLocator);
        descriptionTextArea.sendKeys("Some description");


    }

    private WebElement getTitleTextBox() throws InterruptedException {
        Thread.sleep(5000);
        actions.sendKeys("\t".repeat(10)).perform();
        return driver.switchTo().activeElement();
    }


}
