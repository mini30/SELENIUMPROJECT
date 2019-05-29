package com.qa.AmazonTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Resources.Base;

public class StartStopDriverTest extends Base{
	
	static WebDriver  driver;
	public ExtentReports report;
	public ExtentTest logger;
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss"). format(Calendar. getInstance(). getTime());
	
	@BeforeClass(alwaysRun=true)
	public  void setUpSuite() throws IOException
	{
	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Amazon"+timeStamp+".html"));
	report =new ExtentReports();
	report.attachReporter(extent);
	}
	@BeforeSuite(alwaysRun=true)
	public  WebDriver startDriver() throws IOException
	{
		driver=initializeDriver();
		return driver;
	}
	@AfterSuite(alwaysRun=true)
	public void closeDriver()
	{
		driver.close();
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(result)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
		logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(result)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
		logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(result)).build());
		}
		report.flush();
	}

}
