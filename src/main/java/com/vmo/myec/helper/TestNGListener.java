package com.vmo.myec.helper;

import com.vmo.myec.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("--onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("--onTestSuccess");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
      //  saveScreenShot(webDriver);
       // ExcelUtils.setCellData("PASSED",ExcelUtils.rowNumber,ExcelUtils.columnNumber);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("--onTestFailure");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
      //  saveScreenShot(webDriver);
        // ExcelUtil.setCellData("FAILED",ExcelUtil.rowNumber,ExcelUtil.columnNumber);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("--onTestSkipped");
        // ExcelUtil.setCellData("SKIPPED",ExcelUtil.rowNumber,ExcelUtil.columnNumber);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("--onStart");
    }


    @Attachment()
    public static byte[] saveScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
