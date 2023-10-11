package com.anhtester.keywords;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;

public class MobileUI {

    public static void sleep(double second){
        try {
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * appium-wait-plugin
     * Installation: appium plugin install --source=npm appium-wait-plugin
     * Activation: appium --use-plugins=element-wait
     *
     * @param driver the driver want to set wait
     * @param timeoutMillis the millisecond
     */
    public static AppiumDriver waitElement(AppiumDriver driver, int timeoutMillis){
        driver.executeScript("plugin: setWaitPluginProperties", ImmutableMap.of("timeout", timeoutMillis , "intervalBetweenAttempts", 500 ));
        return driver;
    }


}
