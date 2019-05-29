package com.qa.AmazonPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.Base;

public class AmazonHomePage  {
	public WebDriver driver;
	
	public AmazonHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String hellouser="//span[text()='%s']";
	
	
	@FindBy(xpath="//a[@href='/ref=nav_logo']")
	public WebElement homePageLogo;
	
	
	@FindBy(xpath="//a[@id='nav-link-shopall']")
	public WebElement shopByCategory;
	

	
	@FindBy(id="(//span[text()='Echo & Alexa'])[1]")
	public WebElement echoAndAlexaOptionInCategory;
	
	@FindBy(xpath="//span[text()='Hello, Sign in']")
	public WebElement helloSignInBtn;
	
	@FindBy(xpath="(//span[text()='Sign in'])[2]")
	public WebElement SignInBtnOnAmazonHomePage;
	
	 public WebElement getHelloUserName(String text) {
		    return driver.findElement(By.xpath(String.format("//span[text()='%s']", text)));
		  }
	
}
