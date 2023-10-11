package com.anhtester.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CheckoutCompleteScreen {

    private final By continueShoppingButton = AppiumBy.xpath("//*[@content-desc=\"Continue Shopping button\"]");

    AppiumDriver driver;

    public CheckoutCompleteScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * @return new Home Screen
     */
    @Step("clickOnContinueShoppingButton")
    public HomeScreen clickOnContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
        return new HomeScreen(driver);
    }
}
