package com.nwnt.qa.testcases;

import org.openqa.selenium.NoSuchElementException;
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
	
	//Xls_Reader xlsReader;
	
	//XL_Reader xlReader;
       
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
		
		//xlsReader = new Xls_Reader();
		//xlReader = new XL_Reader();
	}
	
	//@DataProvider
	/*public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}*/
	@DataProvider
	public Object[][] getDrAppTestData() throws Throwable
	{
		//String[][] data = xlsReader.getCellData();
		//Object[][] data = xlsReader.getTestData();
		Object[][] data = TestUtil.getTestData(prop.getProperty("testDatafilePath"), prop.getProperty("drAppSheetName"));
		return data;
		/*for(int r=1, c=0; r<xlsReader.getRowCount()&&c<xlsReader.getColCount(); r++,c++)
		{
			String str1 = data[r][c];
		}*/
		
	}
	
	@Test(dataProvider="getDrAppTestData")
	public void assignDrAppointmentTest(String AppointmentWith, String ClinicLocation, String AppointmentTo, String CaseType, String AppointmentIn, String PatientNotBrought, String IsCorporateVisitor)
	{
		System.out.println("AppointmentWith "+AppointmentWith+" ClinicLocation "+ClinicLocation+" AppointmentTo "+AppointmentTo+" CaseType "+CaseType+" AppointmentIn "+AppointmentIn+" PatientNotBrought "+PatientNotBrought+" IsCorporateVisitor "+IsCorporateVisitor);
		assignAppPage.selectAppointmentWith(AppointmentWith);
		assignAppPage.selectClinicLocation(ClinicLocation);
		assignAppPage.selectDrAppointmentTo(AppointmentTo);
		assignAppPage.selectDrCaseType(CaseType);
		assignAppPage.selectDrAppointmentIn(AppointmentIn);
		assignAppPage.checkPatientNotBrought(PatientNotBrought);
		try {
			if (assignAppPage.isDrCorporateAppointmentVisible() == true)
				assignAppPage.checkIsDrCorporateAppointment(IsCorporateVisitor);
		} catch (NoSuchElementException e) {
			System.out.println("This visitor is not eligible for Corporate Appointment.");
		}
		
		//assignAppPage.clickDrSubmitApp();
	}
	
	@DataProvider
	public Object[][] getPnlAppTestData() throws Throwable
	{
		Object[][] data = TestUtil.getTestData(prop.getProperty("testDatafilePath"), prop.getProperty("pnlAppSheetName"));
		return data;
	}
	
	@Test(dataProvider="getPnlAppTestData")
	public void assignPnlAppointmentTest(String AppointmentWith, String ClinicLocation, String AppointmentTo, String CaseType, String AppointmentIn, String IsCorporateVisitor)
	{
		assignAppPage.selectAppointmentWith(AppointmentWith);
		assignAppPage.selectClinicLocation(ClinicLocation);
		assignAppPage.selectPnlAppointmentTo(AppointmentTo);
		assignAppPage.selectPnlCaseType(CaseType);
		assignAppPage.selectPnlAppointmentIn(AppointmentIn);
		try 
		{
			if(assignAppPage.isPnlCorporateAppointmentVisible()==true)
				assignAppPage.checkIsPnlCorporateAppointment(IsCorporateVisitor);
		}
		catch(NoSuchElementException e)
		{System.out.println("This visitor is not eligible for Corporate Appointment.");}
		//assignAppPage.clickDrSubmitApp();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
