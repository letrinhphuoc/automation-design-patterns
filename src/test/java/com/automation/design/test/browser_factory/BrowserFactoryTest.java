package com.automation.design.test.browser_factory;

import com.automation.design.browser_factory.DriverManager;
import com.automation.design.browser_factory.DriverManagerFactory;
import com.automation.design.browser_factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserFactoryTest {
    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME, driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driverManager.quitDriver();
    }

    @Test
    public void launchGoogleTest(){
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }
}
