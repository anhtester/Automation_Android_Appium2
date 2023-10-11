package com.anhtester.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginScreen {

    private final By emailLocator = AppiumBy.accessibilityId("Username input field");

    private final By passwordLocator = AppiumBy.accessibilityId("Password input field");

    private final By loginButtonLocator = AppiumBy.accessibilityId("Login button");

    //AndroidDriver driver;
    AppiumDriver driver;

    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * @param email    value from src/test/resources/testdata/loginTestData.json
     * @param Password value from src/test/resources/testdata/loginTestData.json
     * @return HomeScreen
     */

    @Step("login Using Valid Email & Password")
    public HomeScreen loginWithValidEmailAndPassword(String email, String Password) {
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(Password);
        driver.findElement(loginButtonLocator).click();
        return new HomeScreen(driver);
    }
}
