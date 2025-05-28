package com.demo.runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Listeners({ExtentReports.class,AnnotationTransformer.class})
@CucumberOptions(features="src/main/resources/com.demo.Features", glue={"com.demo.stepdefinitions","com.demo.hooks"}, tags="@tag1 or @tag3 or @tag4 or @tag5 or @tag6 or @tag7 or @tag8 or @tag91 or @tag92 or @tag93 or @tag94 or @tag95 or @tag96 or @tag10 or @tag11")
public class TestRunner extends AbstractTestNGCucumberTests {
  
	// or @tag3 or @tag4 or @tag5 or @tag6 or @tag7 or @tag8 or 

	
}
