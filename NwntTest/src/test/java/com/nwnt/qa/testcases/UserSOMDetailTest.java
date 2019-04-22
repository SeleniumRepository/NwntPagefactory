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
		userSOMDetailPage = (loginPage.login()).clickBtnSOMtest();
	}
	
	@Test(priority=1)
	public void viewOverallResultTest() throws Throwable
	{
		try 
		{
			overallResultPage=userSOMDetailPage.clickOverallResult("19-Apr-2019");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void viewNatureSelectedQuesTest()
	{
		userSOMDetailPage.clickNatureResult("19-Apr-2019");
	}
	
	@Test
	public void viewCircumstancesSelectedQuesTest()
	{
		userSOMDetailPage.clickCircumsatncesResult("19-Apr-2019");
	}
	
	@Test
	public void viewBodyMindSelectedQuesTest()
	{
		userSOMDetailPage.clickBodyAndMindResult("19-Apr-2019");
	}
	
	@Test
	public void viewHomeLifeSelectedQuesTest()
	{
		userSOMDetailPage.clickHomeLifeResult("19-Apr-2019");
	}
	
	@Test
	public void viewWorkLifeSelectedQuesTest()
	{
		userSOMDetailPage.clickWorkResult("19-Apr-2019");
	}
	
	/*@Test
	public void viewFilledQuestionnaireTest()
	{
		userSOMDetailPage.clickQuestionnaireResult("19-Apr-2019");
	}*/
	
	@Test(priority=0)
	public void viewSummaryResultTest()
	{
		try {
			somSummaryPage=userSOMDetailPage.clickSummaryResult("19-Apr-2019");
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
