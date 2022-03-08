package com.nopcommerce.tests;

import com.nopcommerce.demo.base.BasePage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.utilities.Constant;
import com.sun.org.apache.bcel.internal.Const;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {
    BasePage basePage;
    Properties prop;
    LoginPage loginPage;
    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void openBrowser(){
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String browser = prop.getProperty("browser");
        driver = basePage.initialiseDriver(browser);
        driver.get(prop.getProperty("url"));

        loginPage = new LoginPage(driver);
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void verifyLogOutLink(){
        Assert.assertTrue(homePage.isLogOutPresent(),"Log out link is not Present");
        String logOutLink = homePage.getLogOutText();
        System.out.println("Log Out Link is:" +logOutLink);
        Assert.assertEquals(logOutLink, Constant.HOME_PAGE_LOGOUT);
    }

    @Test
    public void verifyMyAccountLink(){
        Assert.assertTrue(homePage.isMyAccountPresent(),"My Account link is not present");
    }

}
