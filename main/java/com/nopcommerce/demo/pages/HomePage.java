package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    Utils utils;

    By logOut =By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By myAccount = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");

    public  HomePage(WebDriver driver){
        this.driver=driver;
        utils = new Utils(driver);
    }

    public boolean isLogOutPresent(){
        return utils.isElementDisplayed(logOut);
    }

    public String getLogOutText(){
        return utils.doGetText(logOut);
    }

    public boolean isMyAccountPresent(){
        return utils.isElementDisplayed(myAccount);
    }
}