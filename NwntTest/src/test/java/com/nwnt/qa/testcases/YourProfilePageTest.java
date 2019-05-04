package com.nwnt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.YourProfilePage;

public class YourProfilePageTest extends Testbase
{
	LoginPage loginPage;
	YourProfilePage yourProfilePage;

	public YourProfilePageTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		yourProfilePage = new YourProfilePage();
		yourProfilePage = (loginPage.login()).clickYourProfileLink();
	}
	
	public void updateInformation()
	{
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
