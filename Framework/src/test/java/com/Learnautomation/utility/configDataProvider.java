package com.Learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {
	
	Properties pro;
	public configDataProvider()
	{
		File src=new File("./Config/Config.properties");
		try {
			FileInputStream fin=new FileInputStream(src);
			pro=new Properties();
			pro.load(fin);
		} catch (Exception e) {
		
			System.out.println("Unable to Load config file "+e.getMessage());
		} 
	}
	
	public String getDataFromConfig(String KeytoSearch)
	{
		return pro.getProperty(KeytoSearch);
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	public String getAppUrl()
	{
		return pro.getProperty("AppUrl");
	}
}
