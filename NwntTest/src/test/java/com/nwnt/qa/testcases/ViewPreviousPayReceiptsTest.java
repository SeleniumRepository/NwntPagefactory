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
	ViewPreviousPayReceiptsPage viewPreviousPayReceiptsPage;
	
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
		viewPreviousPayReceiptsPage = new ViewPreviousPayReceiptsPage();
		System.out.println("*****Now, Executing the View Previous Pay Receipts Test.*****");
		viewPreviousPayReceiptsPage = (loginPage.login()).clickBtnPrintPreviousReceipts();
	}
	
	@Test
	public void countViewReceipt() throws Throwable
	{
		System.out.println("Total count of Payments Receipts are: "+ viewPreviousPayReceiptsPage.allReceipts());
	}
	
	/*@Test
	public void openReceipt() throws Throwable
	{
		viewPreviousPayReceiptsPage.openPaymentReceiptOf("11-May-2019");
	}*/
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
