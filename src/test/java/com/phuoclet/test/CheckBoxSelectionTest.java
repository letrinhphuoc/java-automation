package com.phuoclet.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.phuoclet.pages.TableDemoPage;
import com.phuoclet.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckBoxSelectionTest {
    private WebDriver driver;
    private TableDemoPage tableDemoPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        this.tableDemoPage = new TableDemoPage(driver);
    }
    @Test
    public void selectAllCheckBox(){
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        elements.stream()
                .forEach(WebElement::click);
    }

    @Test (dataProvider = "criteriaProvider")
    public void tableRowTest(Predicate<List<WebElement>> searchCriteria){
        tableDemoPage.goTo();
        tableDemoPage.selectRows(searchCriteria);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testData(){
        // SO if give me a list of WebElement , I will accessing the second element I will checking its text and I will check of its male..
        Predicate<List<WebElement>> allMale = elements -> elements.get(1).getText().equalsIgnoreCase("male");
        Predicate<List<WebElement>> allFemale = elements -> elements.get(1).getText().equalsIgnoreCase("female");
        Predicate<List<WebElement>> allGender = allMale.or(allFemale);
        Predicate<List<WebElement>> allAU = elements -> elements.get(2).getText().equalsIgnoreCase("AU");
        Predicate<List<WebElement>> allFemaleAU = allFemale.and(allAU);
        return new Object[] {
//                allMale,
//                allFemale,
//                allGender,
                allAU,
                allFemaleAU

        };
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}

