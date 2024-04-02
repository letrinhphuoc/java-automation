package com.phuoclet.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.phuoclet.assessment.PriceTable;
import com.phuoclet.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class PriceTableTest {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
    }
    @Test
    public void minPriceTest(){
        PriceTable priceTable = new PriceTable(driver);
        priceTable.selectMinPriceRow();
        String status = priceTable.getStatus();
        Assert.assertEquals("PASS", status);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }
    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}
