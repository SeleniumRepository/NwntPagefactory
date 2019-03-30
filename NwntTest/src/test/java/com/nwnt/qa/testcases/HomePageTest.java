package com.nwnt.qa.testcases;

import java.io.IOException;

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
import com.nwnt.qa.util.CaptureScreen;

public class HomePageTest extends Testbase
{
	YourProfilePage yourProfilePage;
	ChangePasswordPage changePasswordPage;
	AppointmentPage appointmentPage;
	LogoutPage logoutPage;
	LoginPage loginPage;
	HomePage homePage;
	CaptureScreen captureScreen;

	public HomePageTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		yourProfilePage = new YourProfilePage();
		changePasswordPage = new ChangePasswordPage();
		appointmentPage = new AppointmentPage();
		logoutPage = new LogoutPage();
		captureScreen = new CaptureScreen();
		homePage=loginPage.login();
	}
	
	@Test(priority=1)
	public void homePageTitleTest() throws IOException
	{
		String title = homePage.validatePageTitle();
 		Assert.assertEquals(title, "No Worry No Tension-Users", "Page Title didn't matched.");
	}
	
	@Test(priority=2)
	public void clickingUrProfileTest() throws Throwable
	{
		yourProfilePage = homePage.clickYourProfileLink();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=3)
	public void clickChangePasswordTest() throws Throwable
	{
		changePasswordPage = homePage.clickChangePassword();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=4)
	public void clickAppointmentsTest() throws Throwable
	{
		appointmentPage = homePage.clickAppointment();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=5)
	public void clickLogoutTest() throws Throwable
	{
		loginPage = homePage.clickLogout();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=6)
	public void openVisitorProfile() throws Throwable
	{
		homePage.checkVisitorProfile();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=7)
	public void clickAssignAppointmentTest() throws Throwable
	{
		homePage.clickBtnAssignAppointment();;
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=8)
	public void clickStressometerTest() throws Throwable
	{
		homePage.clickBtnSOMtest();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=9)
	public void clickAdvancePaymentTest() throws Throwable
	{
		homePage.clickBtnAdvancePayments();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=10)
	public void clickPrintPrescriptionsTest() throws Throwable
	{
		homePage.clickBtnPrintPrescriptions();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=11)
	public void clickPrintPreviousReceiptsTest() throws Throwable
	{
		homePage.clickBtnPrintPreviousReceipts();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=12)
	public void clickViewOpenAppointmentsTest() throws Throwable
	{
		homePage.clickBtnViewOpenAppointments();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=13)
	public void clickUploadPrescriptionsTest() throws Throwable
	{
		homePage.clickBtnUploadPrescriptions();
 		captureScreen.takeScreenSnap();
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
