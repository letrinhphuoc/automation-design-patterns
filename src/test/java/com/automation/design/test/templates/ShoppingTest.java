package com.automation.design.test.templates;

import com.automation.design.templates.AmazonShopping;
import com.automation.design.templates.EBayShopping;
import com.automation.design.templates.ShoppingTemplate;
import com.automation.design.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate){
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData(){
        return new Object[] {
                new AmazonShopping(driver, "samsung"),
//                new EBayShopping(driver,"samsung")
        };
    }
}
