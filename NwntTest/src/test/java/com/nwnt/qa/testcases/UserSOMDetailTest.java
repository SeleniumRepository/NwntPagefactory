package com.nwnt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.pages.LoginPage;
import com.nwnt.qa.pages.SOMOverallResultPage;
import com.nwnt.qa.pages.SOMSummaryPage;
import com.nwnt.qa.pages.UserSOMDetailPage;

public class UserSOMDetailTest extends Testbase
{
	LoginPage loginPage;
	UserSOMDetailPage userSOMDetailPage;
	SOMOverallResultPage overallResultPage;
	SOMSummaryPage somSummaryPage;
	
	String givendate = prop.getProperty("given_date");

	public UserSOMDetailTest() throws Throwable 
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initialization();
		loginPage = new LoginPage();
		userSOMDetailPage = new UserSOMDetailPage();
		overallResultPage = new SOMOverallResultPage();
		somSummaryPage = new SOMSummaryPage();
		System.out.println("*****Now, Executing the User SOM Detail Test.*****");
		userSOMDetailPage = (loginPage.login()).clickBtnSOMtest();
	}
	
	@Test(priority=1, groups= {"Regression", "ViewSOMResult"})
	public void viewOverallResult() throws Throwable
	{
		try 
		{
			overallResultPage=userSOMDetailPage.clickOverallResultOf(givendate);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(groups= {"Regression", "ViewSOMResult"})
	public void viewNatureSelectedQues()
	{
		userSOMDetailPage.clickNatureResultOf(givendate);
	}
	
	@Test(groups= {"Regression", "ViewSOMResult"})
	public void viewCircumstancesSelectedQues()
	{
		userSOMDetailPage.clickCircumsatncesResultOf(givendate);
	}
	
	@Test(groups= {"Regression", "ViewSOMResult"})
	public void viewBodyMindSelectedQues()
	{
		userSOMDetailPage.clickBodyAndMindResultOf(givendate);
	}
	
	@Test(groups= {"Regression", "ViewSOMResult"})
	public void viewHomeLifeSelectedQues()
	{
		userSOMDetailPage.clickHomeLifeResultOf(givendate);
	}
	
	@Test(groups= {"Regression", "ViewSOMResult"})
	public void viewWorkLifeSelectedQues()
	{
		userSOMDetailPage.clickWorkResultOf(givendate);
	}
	
	/*@Test
	public void viewFilledQuestionnaireTest()
	{
		userSOMDetailPage.clickQuestionnaireResult("19-Apr-2019");
	}*/
	
	@Test(priority=0, groups= {"Regression", "ViewSOMResult"})
	public void viewSummaryResult()
	{
		try {
			somSummaryPage=userSOMDetailPage.clickSummaryResultOf(givendate);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
