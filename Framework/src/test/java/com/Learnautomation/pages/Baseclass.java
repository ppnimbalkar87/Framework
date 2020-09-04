package com.Learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.w3c.dom.UserDataHandler;

import com.Learnautomation.utility.BrowserFactory;
import com.Learnautomation.utility.ExcelDataProvider;
import com.Learnautomation.utility.Helper;
import com.Learnautomation.utility.configDataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public configDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setupSuite()
	{
		excel=new ExcelDataProvider();
		config=new configDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
	}
	@Parameters({"browser","UrltobeTested"})
	@BeforeClass
	public void setup(String browser,String UrltobeTested)
	{
//		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getAppUrl());
		driver=BrowserFactory.startApplication(driver, browser, UrltobeTested);
	}
	
	@AfterClass
	public void teardown() 
	{
		BrowserFactory.quitBrowser(driver);	
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.capturescreenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			Helper.capturescreenshot(driver);
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			Helper.capturescreenshot(driver);
			logger.skip("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		report.flush();
	}
}
