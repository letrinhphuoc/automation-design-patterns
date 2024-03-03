package com.automation.design.decorator;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(id = "role")
    private WebElement role;

    @FindBy(css ="div.guest")
    private List<WebElement> guestComponents;

    @FindBy(css ="div.superuser")
    private List<WebElement> superUserComponents;

    @FindBy(css ="div.admin")
    private List<WebElement> adminComponents;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectRole(String role){
        Select select = new Select(this.role);
        select.selectByValue(role);
//        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    /*
    We are just finding all elements and we are returning the elements
     */
    public List<WebElement> getAdminComponents() {
        return adminComponents;
    }

    public List<WebElement> getGuestComponents() {
        return guestComponents;
    }

    public List<WebElement> getSuperUserComponents() {
        return superUserComponents;
    }
}
