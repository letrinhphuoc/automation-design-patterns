package com.automation.design.emirates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class EmiratesPage {
    private final WebDriver driver;
    private FlightSearch flightSearch;
    private final By sessionExpired = By.className("ts-session-expire--link");
    private final By acceptBtn = By.id("onetrust-accept-btn-handler");
    public EmiratesPage(final WebDriver driver){
        this.driver = driver;
    }

    public void goTo(){
        this.driver.get("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");

        this.driver.findElements(acceptBtn)
                .stream()
                .findFirst()
                .ifPresent(WebElement::click);

        this.driver.findElements(sessionExpired)
                .stream()
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void setFlightSearch(FlightSearch flightSearch){
        this.flightSearch = flightSearch;
        PageFactory.initElements(driver, this.flightSearch);
        this.flightSearch.setDatePicker(PageFactory.initElements(driver,DatePicker.class));
    }
    public void searchForFlights(Map<String, String> searchDetails){
        this.flightSearch.search(searchDetails);
    }
}
