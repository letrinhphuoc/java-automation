package com.phuoclet.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.phuoclet.assessment.PaymentScreenPage;
import com.phuoclet.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import static com.phuoclet.test.PaymentScreenActions.*;


public class PaymentScreenTest {
    private WebDriver driver;
    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        this.paymentScreenPage = new PaymentScreenPage(driver);
    }

    @Test(dataProvider = "criteriaProvider")
    public void paymentScreenTest(Consumer<PaymentScreenPage> consumer){
        paymentScreenPage.goTo();
        consumer.accept(paymentScreenPage);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] testData(){
        return new Object[]{
            validCC.andThen(buy).andThen(successfulPurchase),
            freeCoupon.andThen(buy).andThen(successfulPurchase),
            discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
            invalidCC.andThen(buy).andThen(failedPurchase),
            invalidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
            buy.andThen(failedPurchase)

        };
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

}
