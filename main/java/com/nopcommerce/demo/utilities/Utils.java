package com.nopcommerce.demo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver= driver;
    }

    public WebElement getElement(By locator){
        WebElement element = driver.findElement(locator);
        return element;
    }

    public boolean isElementDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }

    public void doSendKeys(By locator,String value){
        getElement(locator).sendKeys(value);
    }

    public void doClick(By locator){
        getElement(locator).click();
    }

    public String doGetText(By locator){
        return getElement(locator).getText();
    }

    public void isSelected(By locator) {
        getElement(locator).isSelected();
    }

    public String waitForTitlePresent(String titleValue, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.titleIs(titleValue));
        return driver.getTitle();
    }

    public WebElement waitForElementToBeVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
    }

}
