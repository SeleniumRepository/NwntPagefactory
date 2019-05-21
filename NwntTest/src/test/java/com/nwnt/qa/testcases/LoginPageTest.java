package com.nwnt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.util.CaptureScreen;

public class LoginPageTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	
	CaptureScreen captureScreen = new CaptureScreen();
	
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
		System.out.println("*****Now, Executing the Login Page Test.*****");
	}
	
	@Test(groups= {"Sanity", "Regression"})
	public void loginPageTitleTest() throws InterruptedException
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	}
	
	@Test(groups= {"Sanity", "Regression", "ViewSOMResult", "AssignAppointment", "ViewPrescription", "ViewReceipt"})
	public void loginTest() throws Throwable
	{
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login();
		captureScreen.takeScreenSnap();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
