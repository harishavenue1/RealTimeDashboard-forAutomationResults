package com.tmb.listeners;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.config.ConfigFactory;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.ELKUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentLogger.info("URL: "+ ConfigFactory.getConfig().url() + " is launched");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.info(result.getName() + " is failed");
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.info(Arrays.toString(result.getThrowable().getStackTrace()));
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "Fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.info(result.getName() + " is skipped");
        ELKUtils.sendDetailsToElk(result.getMethod().getDescription(), "Skip");
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }
}
