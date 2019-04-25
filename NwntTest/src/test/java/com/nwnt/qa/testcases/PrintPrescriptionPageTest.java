package com.nwnt.qa.testcases;

import java.util.Iterator;
import java.util.Set;

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
		printPrescriptionsPage=(loginPage.login()).clickBtnPrintPrescriptions().openPrescriptionOf("20-04-2019");
	}
	
	@Test(priority=1)
	public void sendPrescriptionMail()
	{
		printPrescriptionsPage.switchToChildWindow();
		printPrescriptionsPage.acceptAlert();
		printPrescriptionsPage.clickBtnSendEmail();
		printPrescriptionsPage.acceptAlert();
		driver.close();
	}
	
	@Test(priority=2)
	public void PrintPrescription()
	{
		printPrescriptionsPage.switchToChildWindow();
		printPrescriptionsPage.acceptAlert();
		printPrescriptionsPage.clickBtnPrint();
		driver.close();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
