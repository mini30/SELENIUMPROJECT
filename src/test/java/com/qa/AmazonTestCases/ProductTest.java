package com.qa.AmazonTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.Amazon.Pages.LoginPage;
import com.qa.AmazonPageObjects.AmazonLoginPage;
import com.qa.AmazonPageObjects.ProductsPage;

import Resources.Base;

public class ProductTest extends StartStopDriverTest {
	public WebDriver driver;
	LoginPage loginpage;
	AmazonLoginPage loginpageobject;
	ProductsPage products;
	AmazonHomePageTest at=new AmazonHomePageTest();
	
	
   @BeforeClass(alwaysRun=true)
    public void initialzePageObjectsAndMethodsInLoginPage() throws IOException
   {
	   logger=report.createTest("My initialize Test");
	   this.driver=StartStopDriverTest.driver;
		driver.get(readProperty("Url"));
		logger.info("Url entered");
		loginpage=new LoginPage(driver);
		loginpageobject=new AmazonLoginPage(driver);
		products=new ProductsPage(driver);
	logger.pass("iniitilazed success");
    }
   
   @Test(groups="smoke")
   public void printText()
   {
	   System.out.println("heyyyyyyyyyyyy i m printtext for producttest");
	   System.out.println("insidesmoke");
   }
	
	@Test(groups="regression")
	public void clickOnGivenTextOnSearchBox() throws InterruptedException
	
	{   
		products.searchBox.sendKeys("redmi");
		Actions action =new Actions(driver);
		for(int i=1;i<11;i++)
		{
			System.out.println("value"+products.searchBox.getAttribute("value"));
		if(products.searchBox.getAttribute("value").equals("redmi note 6pro"))
				{
			products.searchBox.sendKeys(Keys.ENTER);
			break;
				}
		else
		{
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(3000);
		}
		}
		
		System.out.println("insideregression");
	
}

}

