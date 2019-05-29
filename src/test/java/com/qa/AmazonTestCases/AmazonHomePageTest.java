package com.qa.AmazonTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.qa.Amazon.Pages.HomePage;
import com.qa.Amazon.Pages.LoginPage;
import com.qa.AmazonPageObjects.AmazonHomePage;
import com.qa.AmazonPageObjects.AmazonLoginPage;

import Resources.Base;


public class AmazonHomePageTest extends Base{

	public WebDriver driver;
	HomePage homepage;
	AmazonHomePage amazonhomepage;
	
	
   @BeforeClass
    public void initialzePageObjectsAndMethodsInHomePage() throws IOException
   {
	  // this.driver=StartStopDriverTest.driver;
	   driver.get(readProperty("Url"));
		homepage=new HomePage(driver);
		amazonhomepage=new AmazonHomePage(driver);
    }
	

	@Test
	public void clickONHelloSignOnAndSignOn()
	{
		amazonhomepage.helloSignInBtn.click();
	}
	
}
