package com.qa.AmazonPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AmazonLoginPage {
	public WebDriver driver;
	
	
	public AmazonLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	public WebElement userNameTextField;
	
	@FindBy(id="continue")
	public WebElement continueButton;
	
	@FindBy(id="ap_password")
	public WebElement passwordTextField;
	
	@FindBy(id="signInSubmit")
	public WebElement signInBtn;
	
	
	
}

	

