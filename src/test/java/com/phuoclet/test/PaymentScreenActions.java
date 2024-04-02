package com.phuoclet.test;

import com.phuoclet.assessment.PaymentScreenPage;
import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentScreenActions {
    public static final Consumer<PaymentScreenPage>  freeCoupon = paymentScreenPage -> paymentScreenPage.applyPromoCode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage>  discountedCoupon = paymentScreenPage -> paymentScreenPage.applyPromoCode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage>  validCC = paymentScreenPage -> paymentScreenPage.enterCC("4111111111111111","2023","123");
    public static final Consumer<PaymentScreenPage>  invalidCC = paymentScreenPage -> paymentScreenPage.enterCC("41111111111111112","2023","123");
    public static final Consumer<PaymentScreenPage>  buy = paymentScreenPage -> paymentScreenPage.buy();

    // validations:
    public static final Consumer<PaymentScreenPage> successfulPurchase = paymentScreenPage -> Assert.assertEquals(paymentScreenPage.getStatus(), "PASS");
    public static final Consumer<PaymentScreenPage> failedPurchase = paymentScreenPage -> Assert.assertEquals(paymentScreenPage.getStatus(), "FAIL");

}
