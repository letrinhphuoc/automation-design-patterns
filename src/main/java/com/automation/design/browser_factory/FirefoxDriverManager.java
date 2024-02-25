package com.automation.design.browser_factory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
    @Override
    protected void createdDriver() {
        driver = new FirefoxDriver();
    }
}
