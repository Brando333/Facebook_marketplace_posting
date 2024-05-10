package org.example.controllers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

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
        selectHouseHoldCategory();


        goToConditionComboBox();
        WebElement conditionComboBox = driver.switchTo().activeElement();
        conditionComboBox.click();
        selectNewOptionInComboBox();


        WebElement colorTextField = driver.findElement(
                RelativeLocator.with(By.tagName("input")).below(conditionComboBox)
        );


        By descriptionLocator = RelativeLocator.with(By.tagName("textarea")).below(conditionComboBox);
        WebElement descriptionTextArea = driver.findElement(descriptionLocator);
        descriptionTextArea.sendKeys("Some description");


        WebElement availabilityComboBox = driver.findElement(
                RelativeLocator.with(By.tagName("div")).below(descriptionTextArea)
        );

        WebElement productTagsTextArea = driver.findElement(
                RelativeLocator.with(By.tagName("textarea")).below(availabilityComboBox)
        );

        WebElement SKUTextField = driver.findElement(
                RelativeLocator.with(By.tagName("input")).below(productTagsTextArea)
        );

        WebElement locationTextField = driver.findElement(
                RelativeLocator.with(By.tagName("input")).below(SKUTextField)
        );
        selectHuancayoCity(locationTextField);


        goToPublicMeetUpCheckBox();
        WebElement publicMeetupCheckBox = driver.switchTo().activeElement();
        publicMeetupCheckBox.click();


        goToButtonNext();
        WebElement buttonNext = driver.switchTo().activeElement();
        buttonNext.click();


    }

    private void selectNewOptionInComboBox() {
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys("\n").perform();
    }

    private void goToConditionComboBox() {
        actions.sendKeys("\t").perform();
    }

    private void selectHouseHoldCategory() {
        actions.sendKeys("\t\t\n").perform();
    }

    private void goToButtonNext() {
        actions.sendKeys("\t".repeat(8)).perform();
    }

    private void goToPublicMeetUpCheckBox() {
        actions.sendKeys("\t\t").perform();
    }

    private void selectHuancayoCity(WebElement locationTextField) throws InterruptedException {
        locationTextField.sendKeys(Keys.CONTROL, "A", Keys.DELETE);
        locationTextField.sendKeys("Huancayo, Peru");
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    private WebElement getTitleTextBox() throws InterruptedException {
        Thread.sleep(5000);
        actions.sendKeys("\t".repeat(10)).perform();
        return driver.switchTo().activeElement();
    }


}
