package com.qa.Amazon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.AmazonPageObjects.AmazonLoginPage;

public class LoginPage {
public WebDriver driver;
	AmazonLoginPage login;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	login=new AmazonLoginPage(driver);
	}

public void openUrl(String url)
{
	driver.get(url);
}
public void enterUserName(String email)
{
	login.userNameTextField.sendKeys(email);
}
public void clickOnContinueBtn()
{
	login.continueButton.click();	
}
public void enterPwd(String pwd)
{
	login.passwordTextField.sendKeys(pwd);	
}
public void clickOnSignInBtn()
{
	login.signInBtn.click();
}

public void signInWithCredentials(String email,String pwd)
{
	login.userNameTextField.sendKeys(email);
	login.continueButton.click();	
	login.passwordTextField.sendKeys(pwd);	
	login.signInBtn.click();
}

}
