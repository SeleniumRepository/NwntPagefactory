package com.nwnt.qa.testcases;

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
import com.nwnt.qa.util.Xls_Reader;

public class ChangePasswordTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	YourProfilePage yourProfile;
	ChangePasswordPage changePass;
	AppointmentPage appointments;
	LogoutPage logout;
	Xls_Reader reader;
	
	public ChangePasswordTest() throws Throwable
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		yourProfile = new YourProfilePage();
		changePass = new ChangePasswordPage();
		appointments = new AppointmentPage();
		logout = new LogoutPage();
		try {
			homePage = loginPage.login();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void changePassTest() throws Throwable 
	{
		try {
			changePass = homePage.clickChangePassword();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		changePass.changePassword();
		//changePass.verifySuccessMsg();
	}
	
	@Test(priority=2)
	public void yourProfileTest()
	{
		try {
			yourProfile =changePass.clickYourProfile();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void appointmentsTest()
	{
		try {
			appointments = changePass.clickAppointment();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public void logoutTest()
	{
		try {
			loginPage = changePass.clickLogout();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

} 
