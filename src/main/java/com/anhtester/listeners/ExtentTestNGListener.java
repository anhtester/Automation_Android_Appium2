package com.anhtester.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtentTestNGListener implements ITestListener {
    private final ExtentReports extent = ExtentManager.createInstance();
    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        Reporter.log("Test Started: " + result.getName(), true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        Reporter.log("Test Passed: " + result.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        Reporter.log("Test Failed: " + result.getName(), true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
        Reporter.log("Test Skipped: " + result.getName(), true);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

