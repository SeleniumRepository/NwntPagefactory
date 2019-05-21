package com.nwnt.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
		uploadPrescriptionsPage = new UploadPrescriptionsPage();
		uploadPrescriptionsPage = (loginPage.login()).clickBtnUploadPrescriptions();
		System.out.println("*****Now, Executing the Upload Prescripton Test.*****");
		explicitWait.until(ExpectedConditions.urlContains("UploadPrescription"));
		Assert.assertEquals(driver.getCurrentUrl().contains("UploadPrescription"), true, "You are not landed on Upload Prescription page.");
	}
	
	@DataProvider
	public Object[][] getUploadLabReportData() throws Throwable
	{
		Object[][] data = TestUtil.getTestData(prop.getProperty("uploadLabReportsFile"), prop.getProperty("uploadLabReportsSheet"));
		return data;
	}
	
	@Test(dataProvider="getUploadLabReportData")
	public void uploadLabReport(String reportName, String reportDate, String reportfilePath)
	{
		uploadPrescriptionsPage.selectLabReportType(reportName);
		uploadPrescriptionsPage.inputLabReportDate(reportDate);
		uploadPrescriptionsPage.clickFileSelectionBrowseBtn(reportfilePath);
		//uploadPrescriptionsPage.clickFileUploadBtn();
	}
	
	@DataProvider
	public Object[][] getAddInvestigationData() throws Throwable
	{
		Object[][] data = TestUtil.getTestData(prop.getProperty("uploadLabReportsFile"), prop.getProperty("addInvestigationSheet"));
		return data;
	}
	
	@Test(dataProvider="getAddInvestigationData")
	public void add_saveInvestigation(String givenInvestigation, String patientValue, String givenDate)
	{
		uploadPrescriptionsPage.selectInvestigation(givenInvestigation);
		uploadPrescriptionsPage.inputPatientValue(patientValue);
		uploadPrescriptionsPage.inputInvestDate(givenDate);
		//uploadPrescriptionsPage.clickBtnAddInvestigation();
		//uploadPrescriptionsPage.clickBtnSaveInvestigation();
	}
	
	@DataProvider
	public Object[][] getRevisedMedicine() throws Throwable
	{
		Object[][] data = TestUtil.getTestData(prop.getProperty("uploadLabReportsFile"), prop.getProperty("addComplaintsSheet"));
		return data;
	}
	
	@Test(dataProvider="getRevisedMedicine")
	public void Revise_adjustMedicines(String givenComplaint, String revisedMedicine)
	{
		uploadPrescriptionsPage.inputComplaint(givenComplaint);
		uploadPrescriptionsPage.inputRevisedMedicine(revisedMedicine);
		//uploadPrescriptionsPage.clickBtnAddcompalint();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
