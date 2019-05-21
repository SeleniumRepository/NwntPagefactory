package com.nwnt.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.AppointmentPage;
import com.nwnt.qa.pages.ChangePasswordPage;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.LogoutPage;
import com.nwnt.qa.pages.YourProfilePage;
import com.nwnt.qa.util.CaptureScreen;
import com.nwnt.qa.util.TestUtil;

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
		System.out.println("*****Now, Executing the Home Page Test.*****");
		homePage=loginPage.login();
	}
	
	@Test(priority=1, groups= {"Sanity", "Regression"})
	public void homePageTitleTest() throws IOException
	{
		String title = homePage.validatePageTitle();
 		Assert.assertEquals(title, "No Worry No Tension-Users", "Page Title didn't matched.");
	}
	
	@Test(priority=2, groups= {"Regression"})
	public void clickYourProfile() throws Throwable
	{
		yourProfilePage = homePage.clickYourProfileLink();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=3, groups= {"Regression"})
	public void clickChangePassword() throws Throwable
	{
		changePasswordPage = homePage.clickChangePassword();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=4, groups= {"Regression", "AssignAppointment"})
	public void clickAppointments() throws Throwable
	{
		appointmentPage = homePage.clickAppointment();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=5, groups= {"Regression"})
	public void clickLogout() throws Throwable
	{
		loginPage = homePage.clickLogout();
		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=6, groups= {"Regression"})
	public void openVisitorProfile() throws Throwable
	{
		homePage.checkVisitorProfile();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=7, groups= {"Regression", "AssignAppointment"})
	public void clickAssignAppointment() throws Throwable
	{
		homePage.clickBtnAssignAppointment();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=8, groups= {"Regression", "ViewSOMResult"})
	public void clickStressometer() throws Throwable
	{
		homePage.clickBtnSOMtest();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=9, groups= {"Regression"})
	public void clickAdvancePayment() throws Throwable
	{
		homePage.clickBtnAdvancePayments();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=10, groups= {"Regression", "ViewPrescription"})
	public void clickPrintPrescriptions() throws Throwable
	{
		homePage.clickBtnPrintPrescriptions();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=11, groups= {"Regression", "ViewReceipt"})
	public void clickPrintPreviousReceipts() throws Throwable
	{
		homePage.clickBtnPrintPreviousReceipts();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=12, groups= {"Regression", "ViewOpenAppointment"})
	public void clickViewOpenAppointments() throws Throwable
	{
		homePage.clickBtnViewOpenAppointments();
 		captureScreen.takeScreenSnap();
	}
	
	@Test(priority=13, groups= {"Regression", "UploadReports"})
	public void clickUploadPrescriptions() throws Throwable
	{
		homePage.clickBtnUploadPrescriptions();
 		captureScreen.takeScreenSnap();
	}
	
	@DataProvider
	public Object[][] getSearchCriteriaTestData() throws Throwable
	{
		Object[][] data= TestUtil.getTestData(prop.getProperty("searchCriteriaTestFile"), prop.getProperty("searchCriteriaSheet"));
		return data;
	}
	
	@Test(dataProvider="getSearchCriteriaTestData", groups= {"Sanity", "Regression"})
	public void searchAgainstCriteria(String searchBy, String criteria)
	{
		homePage.selectSearchCriteria(searchBy, criteria);
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
