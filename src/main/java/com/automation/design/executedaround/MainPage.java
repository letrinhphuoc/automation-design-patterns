package com.automation.design.executedaround;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class MainPage {
    private final WebDriver driver;
    @FindBy(id="a")
    private WebElement a;

    @FindBy(id="b")
    private WebElement b;

    @FindBy(id="c")
    private WebElement c;

    private FrameA frameA;
    private FrameB frameB;
    private FrameC frameC;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.frameA = PageFactory.initElements(driver,FrameA.class);
        this.frameB = PageFactory.initElements(driver,FrameB.class);
        this.frameC = PageFactory.initElements(driver,FrameC.class);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public void onFrameA(Consumer<FrameA> consumer){
        this.driver.switchTo().frame(a);
        consumer.accept(this.frameA); // Execute the consumer function on FrameA
        /*
         - The "accept" method is part of the "Consumer" interface in Java's functional programming feature.
         The "Consumer" interface is a functional interface that represents an operation that takes a single input and returns no result.
         - "consumer" is an instance of the "Consumer<FrameA>" functional interface.
         - "this.frameA" is an instance of the "FrameA" class
         - When we say that a functional interface "returns no result,"
         it means that the method in that functional interface does not produce or return a value. In the case of Consumer,
         the accept method does something with the input but doesn't provide a result that needs to be captured or used further.
         - In Java's functional programming, the Consumer interface is often used when you want to perform some action on an input without needing a result.
         It allows you to pass behavior around as a parameter,
         which can be useful for tasks like iteration, filtering, or performing operations on elements in a collection.
         */
        this.driver.switchTo().defaultContent();
        /*
        So, when calling onFrameA(Consumer<FrameA> consumer) , it will switch to A frame execute the specified methods on the
        FrameA instance and then back to the default content.
         */
    }
    public void onFrameB(Consumer<FrameB> consumer){
        this.driver.switchTo().frame(b);
        consumer.accept(this.frameB); // Execute the consumer function on FrameB
        this.driver.switchTo().defaultContent();
    }

    public void onFrameC(Consumer<FrameC> consumer){
        this.driver.switchTo().frame(c);
        consumer.accept(this.frameC); // // Execute the consumer function on FrameC
        this.driver.switchTo().defaultContent();
    }
}
