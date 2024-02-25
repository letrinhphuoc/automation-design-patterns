package com.automation.design.browser_factory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createdDriver();

    public void quitDriver(){
        if (null != driver){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if (null == driver){
            createdDriver();
        }
        return  driver;
    }

}
