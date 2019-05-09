package com.nwnt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.AdvancePaymentsPage;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.util.TestUtil;

public class AdvancePaymentPageTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	AdvancePaymentsPage advancePaymentsPage;

	public AdvancePaymentPageTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		advancePaymentsPage = new AdvancePaymentsPage();
		advancePaymentsPage = loginPage.login().clickBtnAdvancePayments();
	}
	
	@DataProvider
	public Object[][] getMakeAdvancePaymentTestData() throws Throwable
	{
		Object[][] data = TestUtil.getTestData(prop.getProperty("advancePaymentTestFile"), prop.getProperty("advancePaymentSheet"));
		return data;
	}
	
	@Test(dataProvider="getMakeAdvancePaymentTestData")
	public void makeAdvancePayment(String payMode, String amount, String discount, String discType, String payFor, String btnCommand)
	{
		advancePaymentsPage.selectPaymentmode(payMode);
		advancePaymentsPage.inputAmount(amount);
		advancePaymentsPage.inputDiscount(discount);
		advancePaymentsPage.selectDiscountType(discType);
		advancePaymentsPage.selectPaymentFor(payFor);
		//advancePaymentsPage.clickSubmitOrCancel(btnCommand);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
