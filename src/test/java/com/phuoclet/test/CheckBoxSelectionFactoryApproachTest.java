package com.phuoclet.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.phuoclet.pages.TableDemoPage;
import com.phuoclet.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckBoxSelectionFactoryApproachTest {
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
        return new Object[] {
                SearchCriteriaFactory.getCriteria("allMale"),
                SearchCriteriaFactory.getCriteria("allFemale"),
                SearchCriteriaFactory.getCriteria("allGender"),
                SearchCriteriaFactory.getCriteria("allAU"),
                SearchCriteriaFactory.getCriteria("allFemaleAU")
        };
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}

