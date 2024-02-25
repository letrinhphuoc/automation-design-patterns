package com.automation.design.browser_factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DriverManagerFactory {

    private static final Function<WebDriver, DriverManager> CHROME = (d) -> new ChromeDriverManager();
    private static final Function<WebDriver, DriverManager> FIREFOX = (d) -> new FirefoxDriverManager();
    private static final Function<WebDriver, DriverManager> SAFARI = (d) -> new SafariDriverManager();

    private static final Map<DriverType, Function<WebDriver, DriverManager>> MAP = new HashMap<>();

    static {
        MAP.put(DriverType.CHROME, CHROME);
        MAP.put(DriverType.FIREFOX, FIREFOX);
        MAP.put(DriverType.SAFARI, SAFARI);
    }

    public static DriverManager getManager(DriverType driverType, WebDriver driver){
        return MAP.get(driverType).apply(driver);
    }
}
