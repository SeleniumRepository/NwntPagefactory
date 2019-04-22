package com.nwnt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.AllPrescriptionPage;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;

public class AllPrescriptionPageTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	AllPrescriptionPage allPrescriptionPage;

	public AllPrescriptionPageTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		allPrescriptionPage = new AllPrescriptionPage();
		allPrescriptionPage = (loginPage.login()).clickBtnPrintPrescriptions();
	}
	
	@Test
	public void viewPrescription()
	{
		allPrescriptionPage.openPrescriptionOf("20-04-2019");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
