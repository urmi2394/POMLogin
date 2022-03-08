package com.nopcommerce.tests;

import com.nopcommerce.demo.base.BasePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.utilities.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPageTest {
    BasePage basePage;
    Properties prop;
    LoginPage loginPage;
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
    }
    @Test(priority = 1)
    public void verifyLoginPageTitleTest(){
        Assert.assertEquals(loginPage.getPageTitle(), Constant.LOGIN_PAGE_TITLE ,
                "Login page title is not correct");

    }

    @Test(priority = 2)
    public void loginTest(){
        loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
