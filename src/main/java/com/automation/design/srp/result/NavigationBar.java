package com.automation.design.srp.result;

import com.automation.design.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Videos")
    private WebElement videos;

    @FindBy(linkText = "News")
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToVideos(){
        this.videos.click();
    }

    public void goToNews(){
        this.news.click();
    }


    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> this.bar.isDisplayed());
    }
}
