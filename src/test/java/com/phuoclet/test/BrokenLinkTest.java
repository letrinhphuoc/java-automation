package com.phuoclet.test;

import com.phuoclet.predicate.Rules;
import com.phuoclet.supplier.DriverFactory;
import com.phuoclet.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@src]"));
        elements.stream()
                .map(element -> element.getAttribute("src"))
                .forEach(src -> {
                    System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
                });

    }
    @Test
    public void assertLinkTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@src]"));
        Boolean result = elements.stream()
                .map(element -> element.getAttribute("src"))
                .map(src -> LinkUtil.getResponseCode(src))
                .anyMatch(rc -> rc != 200);

        Assert.assertFalse(result);

    }

    @Test
    public void assertUsingCollect(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@src]"));
        List<String> list =  elements.stream()
                .map(element -> element.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());

        Assert.assertEquals(list.size(), 0, list.toString());

    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}
