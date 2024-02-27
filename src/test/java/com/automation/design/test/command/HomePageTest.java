package com.automation.design.test.command;

import com.automation.design.command.ElementValidator;
import com.automation.design.command.HomePage;
import com.automation.design.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.homePage = new HomePage(driver);
    }

//    @Test
//    public void homePageTest(){
//        this.homePage.goTo();
//        this.homePage.getElementValidators()
//                .stream()
//                .parallel()
//                .map(ev -> ev.validate())
//                .forEach(b -> Assert.assertTrue(b));
//    }
    @Test
    public void goTo(){
        this.homePage.goTo();
    }

    @Test(dataProvider = "getData", dependsOnMethods = "goTo")
    public void homePageTest_01(ElementValidator elementValidator){
        Assert.assertTrue(elementValidator.validate());
    }

    @DataProvider
    public Object[] getData(){
        return this.homePage.getElementValidators()
                .toArray();
    }
}
