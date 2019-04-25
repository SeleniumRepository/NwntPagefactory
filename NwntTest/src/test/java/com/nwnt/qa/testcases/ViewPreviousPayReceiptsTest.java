package com.nwnt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.ViewPreviousPayReceiptsPage;

public class ViewPreviousPayReceiptsTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	ViewPreviousPayReceiptsPage printPreviousReceiptsPage;
	
	public ViewPreviousPayReceiptsTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		printPreviousReceiptsPage = new ViewPreviousPayReceiptsPage();
		printPreviousReceiptsPage = (loginPage.login()).clickBtnPrintPreviousReceipts();
	}
	
	@Test
	public void countViewReceipt() throws Throwable
	{
		printPreviousReceiptsPage.openPaymentReceiptOf("20-Apr-2019");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
