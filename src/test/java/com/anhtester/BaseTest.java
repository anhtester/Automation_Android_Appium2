package com.anhtester;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private UiAutomator2Options option;

    @BeforeSuite
    public void RunServer() {
        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("0.0.0.0");
        builder.usingPort(4723);

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

//        service = AppiumDriverLocalService.buildDefaultService();
//        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\votha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withTimeout(Duration.ofSeconds(120))
//                .withIPAddress("0.0.0.0").usingPort(4723).build();
//        service.start();
    }

    @BeforeClass
    public void RunApplication() {
        option = new UiAutomator2Options();
        option.setDeviceName(System.getProperty("deviceName"));
        option.setPlatformName(System.getProperty("platformName"));
        option.setAutomationName(System.getProperty("androidAutomationName"));
        option.setAppActivity(System.getProperty("androidAppActivity"));
        option.setAppPackage(System.getProperty("androidAppPackage"));
        option.setApp(System.getProperty("user.dir") + "/src/test/resources/app/Android-SauceDemoApp.1.3.0.build-244.apk");
    }

    @BeforeMethod
    public void createAndroidDriver() throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), option);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void quitAndroidDriver() {
        driver.quit();
    }

    @AfterSuite
    public void stopServer() {
        service.stop();
    }
}
