package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class LoginPage extends Testbase
{	
	@FindBy(name="txtUserName")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(id="ibtnEnter")
	WebElement loginBtn;
	
	@FindBy(id="HyperLink1")
	WebElement forgotPwd_Lnk;
	
	//@FindBy(xpath="//div[@class='login-logo']//a[@href='Default.aspx']//img[@alt='NWNT']")
	@FindBy(xpath="//img[(@alt='NWNT')]//ancestor::div[@class='login-logo']")
	WebElement logoImg_Lnk;
	
	//initializing the page objects
	public LoginPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) throws Throwable
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public boolean verifyLogoImage()
	{
		return logoImg_Lnk.isDisplayed();
	}
	
	public ForgotPasswordPage forgotPassword()
	{
		forgotPwd_Lnk.click();
		return new ForgotPasswordPage();
	}

}
