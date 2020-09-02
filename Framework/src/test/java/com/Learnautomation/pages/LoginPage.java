package com.Learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
//	this is new commit from pravin
	public LoginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="user_login") WebElement username;
	@FindBy(id="user_pass") WebElement password;
	@FindBy(xpath="//input[@id='wp-submit']") WebElement loginButton;
	

	public void loginToWordpress(String Uname,String Pass)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		username.sendKeys(Uname);
		password.sendKeys(Pass);
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
