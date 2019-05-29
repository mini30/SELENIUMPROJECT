package com.qa.AmazonTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.qa.Amazon.Pages.HomePage;
import com.qa.Amazon.Pages.LoginPage;
import com.qa.AmazonPageObjects.AmazonHomePage;
import com.qa.AmazonPageObjects.AmazonLoginPage;

import Resources.Base;


public class AmazonHomePageAfterSignInTest extends Base {
	
	AmazonHomePageTest at=new AmazonHomePageTest();
	AmazonLoginTest lt=new AmazonLoginTest();
	public WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	AmazonHomePage amazonhomepage;
	
	@BeforeClass(alwaysRun=true)
	public void setUpandInitialize() throws IOException
	{
		this.driver=StartStopDriverTest.driver;
		driver.get(readProperty("Url"));
		homepage=new HomePage(driver);
		loginpage = new LoginPage(driver);
		amazonhomepage=new AmazonHomePage(driver);
	}
	@Test(priority=1,groups="smoke")
	public void validateContentOnHomePage() throws IOException
	{
		//amazonhomepage.helloSignInBtn.click();
		//loginpage.signInWithCredentials(readProperty("email"),readProperty("password"));
		Boolean isHomepagedisplayed=amazonhomepage.homePageLogo.isDisplayed();
		Assert.assertTrue(isHomepagedisplayed);
		Boolean shopByCategoryOption=amazonhomepage.shopByCategory.isDisplayed();
		Assert.assertTrue(shopByCategoryOption);
		Assert.assertEquals(amazonhomepage.getHelloUserName("Hello, "+readProperty("username")).getText(), "Hello, Sign in");
		Assert.assertEquals(amazonhomepage.getHelloUserName("Hello, "+readProperty("username")).getText(), "Hello");
		System.out.println("hii"+amazonhomepage.getHelloUserName("Hello, "+readProperty("username")).getText());
	    System.out.println("insidesmoke");
	}
	
	@Test(priority=2,groups="regression")
	public void clickOnShopByCategoryOption()
	{
		amazonhomepage.shopByCategory.click();
		System.out.println("insideregression");
	}
	
	@Test(groups="smoke")
	public void printtextInSignPage()
	{
	System.out.println("Inside home page after sign on ");
	System.out.println("insidesmoke");
}
}

