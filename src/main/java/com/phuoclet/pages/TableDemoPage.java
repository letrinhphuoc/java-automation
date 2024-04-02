package com.phuoclet.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class TableDemoPage {
    private final WebDriver driver;

    public TableDemoPage(WebDriver driver){
        this.driver = driver;
    }
    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
    }

    /*public void selectRows(String gender){
        List<WebElement> elements = this.driver.findElements(By.tagName("tr"));// rows
        elements.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td"))) // td list
                .peek(tdList -> System.out.println("tdList :: " + tdList.size()))
                .filter(tdList -> tdList.size() == 4)
                .filter(tdList -> tdList.get(1).getText().equalsIgnoreCase(gender)) // gender check
                .map(tdList -> tdList.get(3)) // td containing checkbox
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }
     */
    // refactor
    public void selectRows(Predicate<List<WebElement>> predicate){
        List<WebElement> elements = this.driver.findElements(By.tagName("tr"));// rows
        elements.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td"))) // td list
                .peek(tdList -> System.out.println("tdList :: " + tdList.size()))
                .filter(tdList -> tdList.size() == 4)
                .filter(predicate)
                .map(tdList -> tdList.get(3)) // td containing checkbox
                .map(td -> td.findElement(By.tagName("input")))
                .forEach(WebElement::click);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }



}
