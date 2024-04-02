package com.phuoclet.test;

import com.phuoclet.supplier.DriverFactory;
import com.phuoclet.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StreamParallelProcessing {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkTest(){
        driver.get("https://www.google.com");
        System.out.println("Before :: " + LocalDateTime.now());

        List<WebElement> elements = driver.findElements(By.xpath("//*[@href]"));
        List<String> list = elements.stream()
                                    .parallel()
                                    .map(element -> element.getAttribute("href"))
                                    .filter(href -> LinkUtil.getResponseCode(href) != 200)
                                    .collect(Collectors.toList());

        System.out.println("After :: " + LocalDateTime.now());

    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}
