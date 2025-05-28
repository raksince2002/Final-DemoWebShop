package com.demo.runners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import driverfactory.DriverFactory;
import util.CommonTestMethods;

public class RetryAnalyzer implements IRetryAnalyzer {

	int max = 3;
	int count=0;
	
	WebDriver wd = DriverFactory.getinstance();
	CommonTestMethods c1 = new CommonTestMethods();
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess()) {
			if(count<max) {
				count++;
				return true;
			}
		}
		
		c1.init_common(wd);
		try {
			c1.capture_ss(result.getName(), "Screenshots");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
