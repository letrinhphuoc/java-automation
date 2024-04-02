package com.phuoclet.test;

import com.phuoclet.predicate.Rules;
import com.phuoclet.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class DriverTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest(){
        driver.get("https://google.com/");
        List<WebElement> elements = driver.findElements(By.tagName("a"));
//                .forEach(element -> System.out.println(element.getText()));

        System.out.println("Before :: " + elements.size());

        /*
        We are getting all the rules here for each rule. Just give pass it to elements.removeIf
         */
//        Rules.get().forEach(rule -> elements.removeIf(rule));
        Rules.get().forEach(elements::removeIf);

//        elements.removeIf(isBlank.or(hasS));

        System.out.println("After :: "+ elements.size());
        elements.forEach(element -> System.out.println(element.getText()));
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}
