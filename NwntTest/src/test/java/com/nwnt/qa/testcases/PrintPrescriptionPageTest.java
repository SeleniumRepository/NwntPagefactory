package com.nwnt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.AllPrescriptionPage;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.PrintPrescriptionsPage;

public class PrintPrescriptionPageTest extends Testbase
{
	String parentWindowId;
	String childWindowId;
	LoginPage loginPage;
	HomePage homePage;
	AllPrescriptionPage allPrescriptionPage;
	PrintPrescriptionsPage printPrescriptionsPage;
	
	public PrintPrescriptionPageTest() throws Throwable 
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
		printPrescriptionsPage = new PrintPrescriptionsPage();
		System.out.println("*****Now, Executing the Print Prescription Test.*****");
		printPrescriptionsPage=(loginPage.login()).clickBtnPrintPrescriptions().openPrescriptionOf("13-05-2019");
	}
	
	@Test(priority=1, groups= {"Regression", "ViewPrescription"})
	public void sendPrescriptionMail()
	{
		try 
		{
		printPrescriptionsPage.switchToChildWindow();
		printPrescriptionsPage.acceptAlert();
		printPrescriptionsPage.clickBtnSendEmail();
		printPrescriptionsPage.acceptAlert();
		driver.close();
		}catch(Exception e)
		{e.printStackTrace();}
	}
	
	@Test(priority=2, groups= {"Regression", "ViewPrescription"})
	public void PrintPrescription()
	{
		try
		{
		printPrescriptionsPage.switchToChildWindow();
		printPrescriptionsPage.acceptAlert();
		printPrescriptionsPage.clickBtnPrint();
		driver.close();
		}catch(Exception e)
		{e.printStackTrace();}
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
