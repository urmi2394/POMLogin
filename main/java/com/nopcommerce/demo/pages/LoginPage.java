package com.nopcommerce.demo.pages;


import com.nopcommerce.demo.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    Utils utils;

    By emailId = By.id("Email");
    By password = By.id("Password");
    By loginButton = By.className("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        utils.waitForTitlePresent(title, 10);
        System.out.println("Login page title is:" + title);
        return title;
    }

    public HomePage doLogin(String username, String pwd){
        utils.waitForElementToBeVisible(emailId,10);
        utils.doSendKeys(emailId,username);
        utils.doSendKeys(password,pwd);
        utils.doClick(loginButton);

        return new HomePage(driver);
    }
}