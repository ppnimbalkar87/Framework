package com.Learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Learnautomation.pages.Baseclass;
import com.Learnautomation.pages.LoginPage;
import com.Learnautomation.utility.BrowserFactory;
import com.Learnautomation.utility.ExcelDataProvider;
import com.Learnautomation.utility.Helper;

public class LoginTest extends Baseclass {

	
	@Test
	public void test1()
	{
		logger=report.createTest("LogintoWordpress");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginpage.loginToWordpress(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login Sudccesfully");
		
	}
}
