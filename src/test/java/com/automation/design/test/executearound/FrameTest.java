package com.automation.design.test.executearound;

import com.automation.design.executedaround.MainPage;
import com.automation.design.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    private MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest(){
        this.mainPage.goTo();
        this.mainPage.onFrameA(frameA -> {
            frameA.setFirstName("fn1");
            frameA.setMessage("I am going to fill text area");
        });
        /*
        frameA is just a variable name used to refer to instance of FrameA that will be passed to the
        "accept" method when the consumerFunction is invoked.
        "setFirstName" and "setMessage" are methods that you defined in the "FrameA" class, and these methods will be
        called on the "frameA" (an instance of "FrameA")
         */
        this.mainPage.onFrameC(frameC -> frameC.setAddress("address for FrameC"));
        this.mainPage.onFrameB(frameB -> frameB.setMessage("this is for Frame B"));
    }

}
