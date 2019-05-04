package com.nwnt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.UploadPrescriptionsPage;
import com.nwnt.qa.util.TestUtil;

public class UploadPrescriptionTest extends Testbase
{
	LoginPage loginPage;
	HomePage homePage;
	UploadPrescriptionsPage uploadPrescriptionsPage;

	public UploadPrescriptionTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		uploadPrescriptionsPage = new UploadPrescriptionsPage();
		uploadPrescriptionsPage = (loginPage.login()).clickBtnUploadPrescriptions();
		Assert.assertEquals(driver.getCurrentUrl().contains("UploadPrescription"), true, "You are not landed on Upload Prescription page.");
	}
	
	@DataProvider
	public Object[][] getUploadLabReportTestData() throws Throwable
	{
		Object[][] data = TestUtil.getTestData(prop.getProperty("uploadLabReportsFile"), prop.getProperty("uploadLabReportsSheet"));
		return data;
	}
	
	
	@Test(dataProvider="getUploadLabReportTestData")
	public void uploadLabReport(String reportName, String reportDate, String reportfilePath)
	{
		uploadPrescriptionsPage.selectLabReportType(reportName);
		uploadPrescriptionsPage.inputLabReportDate(reportDate);
		uploadPrescriptionsPage.clickFileSelectionBrowseBtn(reportfilePath);
		//uploadPrescriptionsPage.clickFileUploadBtn();
	}
	
	/*@Test
	public void add_saveInvestigation()
	{
		uploadPrescriptionsPage.addInvestigation();
		uploadPrescriptionsPage.clickBtnSaveInvestigation();
	}
	
	@Test
	public void Revise_adjustMedicines()
	{
		uploadPrescriptionsPage.addRevisedMedicine();
	}*/
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
