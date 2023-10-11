package com.anhtester.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductsScreen {

    private final By counterPlusButton = AppiumBy.xpath("//*[@content-desc=\"counter plus button\"]");

    private final By addToCartButton = AppiumBy.xpath("//*[@content-desc=\"Add To Cart button\"]");

    private final By cartBadge = AppiumBy.xpath("//*[@content-desc=\"cart badge\"]");

    AppiumDriver driver;

    public ProductsScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * @return Product Screen
     */
    @Step("clickOnCounterPlusButton")
    public ProductsScreen clickOnCounterPlusButton() {
        driver.findElement(counterPlusButton).click();
        return this;
    }

    /**
     * @return Product Screen
     */
    @Step("clickOnAddToCartButton")
    public ProductsScreen clickOnAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    /**
     * @return new CartScreen
     */
    @Step("clickOnCartBadge")
    public CartScreen clickOnCartBadge() {
        driver.findElement(cartBadge).click();
        return new CartScreen(driver);
    }
}
