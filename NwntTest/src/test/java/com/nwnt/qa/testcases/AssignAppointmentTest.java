package com.nwnt.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.AssignAppointmentPage;
import com.nwnt.qa.pages.HomePage;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.util.TestUtil;

public class AssignAppointmentTest extends Testbase 
{
	AssignAppointmentPage assignAppPage;
	HomePage homePage;
	LoginPage loginPage;

	public AssignAppointmentTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		assignAppPage = new AssignAppointmentPage();
		homePage = loginPage.login();
		assignAppPage = homePage.clickBtnAssignAppointment();
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getTestData")
	public void assignDrAppointmentTest(String AppointmentWith, String ClinicLocation, String AppointmentTo, String CaseType, String AppointmentIn, String PatientNotBrought, String IsCorporateVisitor)
	{
		assignAppPage.selectAppointmentWith(AppointmentWith);
		assignAppPage.selectClinicLocation(ClinicLocation);
		assignAppPage.selectDrAppointmentTo(AppointmentTo);
		assignAppPage.selectDrCaseType(CaseType);
		assignAppPage.selectDrAppointmentIn(AppointmentIn);
		assignAppPage.checkPatientNotBrought(PatientNotBrought);
		if(assignAppPage.isCorporateAppointmentVisible()==true)
			assignAppPage.checkIsCorporateAppointment(IsCorporateVisitor);
		//assignAppPage.clickDrSubmitApp();
	}
	
	@Test(dataProvider="getTestData")
	public void assignPnlAppointmentTest(String AppointmentWith, String ClinicLocation, String AppointmentTo, String CaseType, String AppointmentIn, String PatientNotBrought, String IsCorporateVisitor)
	{
		assignAppPage.selectAppointmentWith(AppointmentWith);
		assignAppPage.selectClinicLocation(ClinicLocation);
		assignAppPage.selectPnlAppointmentTo(AppointmentTo);
		assignAppPage.selectPnlCaseType(CaseType);
		assignAppPage.selectPnlAppointmentIn(AppointmentIn);
		if(assignAppPage.isCorporateAppointmentVisible()==true)
			assignAppPage.checkIsCorporateAppointment(IsCorporateVisitor);
		//assignAppPage.clickDrSubmitApp();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
