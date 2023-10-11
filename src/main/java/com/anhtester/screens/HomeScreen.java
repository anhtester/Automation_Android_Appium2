package com.anhtester.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomeScreen {
    public static By products = AppiumBy.xpath("//*[@text='Products']");

    private final By openMenuLocator = AppiumBy.xpath("//*[@content-desc=\"open menu\"]");

    private final By loginButton = AppiumBy.accessibilityId("menu item log in");

    private final By product1 = AppiumBy.xpath("(//*[@content-desc=\"store item\"])[1]");

    AppiumDriver driver;

    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * @return HomeScreen
     */
    @Step("clickOnOpenMenu")
    public HomeScreen clickOnOpenMenu() {
        driver.findElement(openMenuLocator).click();
        return this;
    }

    /**
     * @return LoginScreen
     */
    @Step("clickOnLoginButton")
    public LoginScreen clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }

    /**
     * @return ProductsScreen
     */
    @Step("clickOnProduct1")
    public ProductsScreen clickOnProduct1() {
        driver.findElement(product1).click();
        return new ProductsScreen(driver);
    }
}

