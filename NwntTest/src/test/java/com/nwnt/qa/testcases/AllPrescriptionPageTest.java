package com.nwnt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.AllPrescriptionPage;
import com.nwnt.qa.pages.LoginPage;

public class AllPrescriptionPageTest extends Testbase
{
	LoginPage loginPage;
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
		allPrescriptionPage = new AllPrescriptionPage();
		System.out.println("*****Now, Executing the All Prescription Test.*****");
		allPrescriptionPage = loginPage.login().clickBtnPrintPrescriptions();
	}
	
	@Test(groups= {"Regression", "ViewPrescription"})
	public void getNumberofPrescription()
	{
		allPrescriptionPage.getPrescriptionsCount();
	}
	
	@Test(groups= {"Regression", "ViewPrescription"})
	public void viewPrescription() throws Throwable
	{
		allPrescriptionPage.openPrescriptionOf("20-04-2019");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
