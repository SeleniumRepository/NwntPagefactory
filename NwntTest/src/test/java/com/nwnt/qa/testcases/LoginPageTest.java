package com.nwnt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;

public class LoginPageTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws Throwable 
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		try {
			loginPage = new LoginPage();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	}
	
	@Test
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
