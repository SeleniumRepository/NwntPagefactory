package com.nwnt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.AppointmentPage;
import com.nwnt.qa.pages.ChangePasswordPage;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.LogoutPage;
import com.nwnt.qa.pages.YourProfilePage;

public class HomePageTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	YourProfilePage yourProfilePage;
	ChangePasswordPage changePasswordPage;
	AppointmentPage appointmentPage;
	LogoutPage logoutPage;

	public HomePageTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "No Worry No Tension-Users", "Page Title didn't matched.");
	}
	
	@Test(priority=2)
	public void clickAppointmentTest() throws Throwable
	{
		yourProfilePage = homePage.clickYourProfile();
	}
	
	@Test(priority=3)
	public void clickChangePasswordTest() throws Throwable
	{
		changePasswordPage = homePage.clickChangePassword();
	}
	
	@Test(priority=4)
	public void clickAppointmentsTest() throws Throwable
	{
		appointmentPage = homePage.clickAppointment();
	}
	
	@Test(priority=5)
	public void clickLogoutTest() throws Throwable
	{
		loginPage = homePage.clickLogout();
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
