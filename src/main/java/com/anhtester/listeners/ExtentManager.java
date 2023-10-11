package com.anhtester.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}

