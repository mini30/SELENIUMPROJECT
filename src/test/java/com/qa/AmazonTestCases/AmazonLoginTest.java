package com.qa.AmazonTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.Amazon.Pages.LoginPage;
import com.qa.AmazonPageObjects.AmazonLoginPage;

import Resources.Base;


public class AmazonLoginTest extends Base {
	public WebDriver driver;
	LoginPage loginpage;
	AmazonLoginPage loginpageobject;
	AmazonHomePageTest at=new AmazonHomePageTest();
	
	
   @BeforeClass
    public void initialzePageObjectsAndMethodsInLoginPage() throws IOException
   {
	   this.driver=StartStopDriverTest.driver;
	    driver.get(readProperty("Url"));
		loginpage=new LoginPage(driver);
		loginpageobject=new AmazonLoginPage(driver);
    }
	
	@Test
	public void enterCredentialsOnLoginPage()
	
	{   at.clickONHelloSignOnAndSignOn();
		loginpage.enterUserName(System.getProperty("email"));
		loginpage.clickOnContinueBtn();
		loginpage.enterPwd(System.getProperty("password"));
		loginpage.clickOnSignInBtn();
	}
	
}
