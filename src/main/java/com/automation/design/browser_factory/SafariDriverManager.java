package com.automation.design.browser_factory;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager{

    @Override
    protected void createdDriver() {
        driver = new SafariDriver();
    }
}
