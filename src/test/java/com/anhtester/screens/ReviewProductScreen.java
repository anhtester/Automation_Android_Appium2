package com.anhtester.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ReviewProductScreen {
    private final By placeOrderButton = AppiumBy.xpath("//*[@content-desc=\"Place Order button\"]");

    AppiumDriver driver;

    public ReviewProductScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * @return CheckoutCompleteScreen
     */
    @Step("clickOnPlaceOrderButton")
    public CheckoutCompleteScreen clickOnPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
        return new CheckoutCompleteScreen(driver);
    }
}
