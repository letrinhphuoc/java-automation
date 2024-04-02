package com.phuoclet.test;

import com.phuoclet.predicate.Rules;
import com.phuoclet.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class DriverTestStream {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    // do not allow blank links
    // do not allow links containing s
    // convert link text to uppercase
    // print on the console

    @Test
    public void googleTest(){
        driver.get("https://google.com/");
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.stream()
                .filter( element -> element.getText().trim().length() > 0)
                .filter(element -> !element.getText().toLowerCase().contains("s"))
                .map(element -> element.getText().toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void googleTestRefactor(){
        driver.get("https://google.com/");
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(s -> s.length() > 0)
                .filter(s -> !s.toLowerCase().contains("s"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}
