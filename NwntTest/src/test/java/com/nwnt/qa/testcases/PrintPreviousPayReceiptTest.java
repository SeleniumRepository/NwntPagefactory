package com.nwnt.qa.testcases;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.PrintPreviousPayReceiptPage;
import com.nwnt.qa.pages.ViewPreviousPayReceiptsPage;

public class PrintPreviousPayReceiptTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	ViewPreviousPayReceiptsPage viewPreviousPayReceiptsPage;
	PrintPreviousPayReceiptPage printPreviousPayReceiptPage;
	
	public PrintPreviousPayReceiptTest() throws Throwable 
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
		printPreviousPayReceiptPage = new PrintPreviousPayReceiptPage();
		printPreviousPayReceiptPage = (loginPage.login()).clickBtnPrintPreviousReceipts().openPaymentReceiptOf("24-Apr-2019");
	}
	
	@Test
	public void printReceipt() throws Exception
	{
		Thread.sleep(2000);
		printPreviousPayReceiptPage.closePrinterPage();
		Thread.sleep(5000);
		printPreviousPayReceiptPage.switchToChildWindow();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
