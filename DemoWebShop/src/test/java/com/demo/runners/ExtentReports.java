package com.demo.runners;
 
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driverfactory.DriverFactory;
import util.CommonTestMethods;
import util.ExtentReportManager;

 
public class ExtentReports implements ITestListener {
    private static com.aventstack.extentreports.ExtentReports extent = ExtentReportManager.getInstance();
    private static ExtentTest test;
    CommonTestMethods c1 = new CommonTestMethods();
 
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
 
    @Override
    public void onTestSuccess(ITestResult result) {
    	test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.PASS, "✅ " + result.getMethod().getMethodName() + " passed.");
    }
 
    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "❌ " + result.getMethod().getMethodName() + " failed.");
        test.log(Status.FAIL, result.getThrowable());
        WebDriver wd = DriverFactory.getinstance();
        String s="";
        c1.init_common(wd);
        try {
			s = c1.capture_ss(result.getMethod().getMethodName(), "Screenshots");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        test.addScreenCaptureFromPath(s);
        
}
 
    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "⚠️ " + result.getMethod().getMethodName() + " skipped.");
    }
 
    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Write the report to disk
    }
}