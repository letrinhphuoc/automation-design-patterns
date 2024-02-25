package com.automation.design.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleFrench extends GoogleEnglish{

    @FindBy(linkText = "Français")
    private WebElement language;
    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.fr");
        this.language.click();

    }
}
