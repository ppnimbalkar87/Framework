package com.Learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

// screenshot,alert,frames,windows,sync issues,javascript executers
public class Helper {

	public static String capturescreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/Wordpress_"+getCurrentDateTime()+".png";
		try
		{
			
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured succes");
			
		} catch (Exception e)
		{
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}
		return screenshotPath;
	}
	public static String getCurrentDateTime()
	{
		DateFormat Customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return Customformat.format(currentDate);
	}
	
	
}
