package com.automation.design.test.decorator;

import com.automation.design.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {
    private static void shouldDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //Ingredients:
    private static final Consumer<DashboardPage> adminComponentPresence = dashboardPage -> shouldDisplay(dashboardPage.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresence = dashboardPage -> shouldNotDisplay(dashboardPage.getAdminComponents());
    private static final Consumer<DashboardPage> suComponentPresence = dashboardPage -> shouldDisplay(dashboardPage.getSuperUserComponents());
    private static final Consumer<DashboardPage> suComponentNotPresence = dashboardPage -> shouldNotDisplay(dashboardPage.getSuperUserComponents());
    private static final Consumer<DashboardPage> guestComponentPresence = dashboardPage -> shouldDisplay(dashboardPage.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresence = dashboardPage -> shouldNotDisplay(dashboardPage.getGuestComponents());

    //Role selection
    public static final Consumer<DashboardPage> adminSelection = dashboardPage -> dashboardPage.selectRole("admin");
    public static final Consumer<DashboardPage> suSelection = dashboardPage -> dashboardPage.selectRole("superuser");
    public static final Consumer<DashboardPage> guestSelection = dashboardPage -> dashboardPage.selectRole("guest");

    // user role pages
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresence).andThen(suComponentNotPresence).andThen(adminComponentNotPresence);
    public static final Consumer<DashboardPage> suPage = suSelection.andThen(guestComponentPresence).andThen(suComponentPresence).andThen(adminComponentNotPresence);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentPresence).andThen(suComponentPresence).andThen(adminComponentPresence);




}
