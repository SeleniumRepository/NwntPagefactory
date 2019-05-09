package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class SOMSummaryPage extends Testbase
{
	@FindBy(xpath="//a[text()= 'Home']")
	WebElement menuHome;
	
	@FindBy(xpath="//a[text()= 'Your Profile']")
	WebElement menuYourProfile;
	
	@FindBy(xpath="//a[text()= 'Change Password']")
	WebElement menuChangePassword;
	
	@FindBy(xpath="//a[text()= 'Appointments']")
	WebElement menuAppointments;
	
	@FindBy(xpath="//a[text()= 'Logout']")
	WebElement menuLogout;
	
	@FindBy(xpath="//a[@id='ctl00_LinkProfileName']")
	WebElement menuContact;
	
	@FindBy(xpath="//img[@id='ctl00_Logo']")
	WebElement logoImg;
	
	@FindBy(xpath="//a[@id='ctl00_CenterAreaHolder_btnSomTest']")
	WebElement btnNewSOMTest;
	
	@FindBy(xpath="//a[@id='ctl00_CenterAreaHolder_LblSomRelationshipNo']")
	WebElement lblSomRelationshipNo;
	
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_LblSomPatientName']")
	WebElement lblSomPatientName;
	
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_LblSomAge']")
	WebElement lblSomAge;
	
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdStressResult']//td[@class='modifiedCell']")
	List<WebElement> lblSomDate;
	
	public SOMSummaryPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	
}
