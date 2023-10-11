package com.anhtester;

import com.anhtester.screens.HomeScreen;
import com.anhtester.utils.JsonReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class DemoAppTest extends BaseTest {
    String loginTestData = "src/test/resources/testdata/loginTestData.json";
    String checkoutTestData = "src/test/resources/testdata/checkoutTestData.json";
    String paymentTestData = "src/test/resources/testdata/paymentTestData.json";
    static SoftAssert productsAssert = new SoftAssert();

    @Description
            (
                    "Given user open Sauce labs mobile application"+
                            "When click on Menu"+
                            "And click on Login"+
                            "And login Using Valid Email & Password"+
                            "And choose Product"+
                            "And click on counter Plus Button"+
                            "And click on add To Cart button"+
                            "And click on Cart Badge"+
                            "And click on Proceed To Checkout Button"+
                            "And fill Checkout Information"+
                            "And fill Payment Information"+
                            "And click on place order button"+
                            "And click on continue shopping button"+
                            "Then user should return to Home screen"
            )
    @Test(description = "Executing E2E ordering item scenario")
    public void CheckOutOrderTest() throws IOException, ParseException {
        new HomeScreen(driver)
                .clickOnOpenMenu()
                .clickOnLoginButton()
                .loginWithValidEmailAndPassword
                        (
                                JsonReader.getJson(loginTestData, "email"),
                                JsonReader.getJson(loginTestData, "password")
                        )
                .clickOnProduct1()
                .clickOnCounterPlusButton()
                .clickOnAddToCartButton()
                .clickOnCartBadge()
                .clickOnProceedToCheckoutButton()
                .fillCheckoutInformation
                        (
                                JsonReader.getJson(checkoutTestData, "FullName"),
                                JsonReader.getJson(checkoutTestData, "AddressLine"),
                                JsonReader.getJson(checkoutTestData, "AddressLine2"),
                                JsonReader.getJson(checkoutTestData, "City"),
                                JsonReader.getJson(checkoutTestData, "State"),
                                JsonReader.getJson(checkoutTestData, "ZipCode"),
                                JsonReader.getJson(checkoutTestData, "Country")
                        )
                .fillPaymentInformation
                        (
                                JsonReader.getJson(paymentTestData, "FullName"),
                                JsonReader.getJson(paymentTestData, "CardNumber"),
                                JsonReader.getJson(paymentTestData, "ExpirationDate"),
                                JsonReader.getJson(paymentTestData, "SecurityCode")
                        )
                .clickOnPlaceOrderButton()
                .clickOnContinueShoppingButton();

        String productText = driver.findElement(HomeScreen.products).getText();
        productsAssert.assertEquals(productText, "Products");
        Allure.step("user should return to Home screen");
        saveScreenshotPNG();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}