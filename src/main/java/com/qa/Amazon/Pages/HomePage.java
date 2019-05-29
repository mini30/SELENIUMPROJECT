package com.qa.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.AmazonPageObjects.AmazonHomePage;
import com.qa.AmazonPageObjects.AmazonLoginPage;

public class HomePage {
	public WebDriver driver;
	public AmazonHomePage homepage;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		homepage=new AmazonHomePage(driver);
		}
	
	
}
