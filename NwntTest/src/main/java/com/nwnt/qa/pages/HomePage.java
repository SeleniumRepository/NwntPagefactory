package com.nwnt.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class HomePage extends Testbase
{
	@FindBy(xpath="//a[contains(text(),'Home')]//ancestor::div[@class='tpmnus']")
	WebElement menu_home;
	
	@FindBy(xpath="//a[contains(text(),'Your')]//ancestor::div[@class='tpmnus']")
	WebElement menu_yourProfile;
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]//ancestor::div[@class='tpmnus']")
	WebElement menu_changePassword;
	
	@FindBy(xpath="//a[contains(text(),'Appointments')]//ancestor::div[@class='tpmnus']")
	WebElement menu_appointments;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]//ancestor::div[@class='tpmnus']")
	WebElement menu_logout;
	
	@FindBy(id="ctl00_Logo")
	WebElement logoImage_lnk;
	
	@FindBy(id="ctl00_CenterAreaHolder_DropDownListSearchBy")
	WebElement searchBy_DD;
	
	@FindBy(id="ctl00_CenterAreaHolder_TextBoxSearchedValue")
	WebElement searchValue;
	
	@FindBy(id="ctl00_CenterAreaHolder_ClearSearchCriteriaButton")
	WebElement Btn_clearSearchCriteria;
	
	@FindBy(id="ctl00_CenterAreaHolder_BtnSearch")
	WebElement Btn_search;
	
	@FindBy(id="ctl00_CenterAreaHolder_BtnAddNewVisitor")
	WebElement Btn_AddNewVisitor;
	
	@FindBy(id="ctl00_CenterAreaHolder_lblTotalRecord")
	WebElement lbl_TotalRecordsCount;
	
	@FindBy(xpath="//div[@class='btmmnus']//td")
	WebElement lbl_copyrightText;
	
	@FindBy(xpath="//a//parent::td//ancestor::tr[@class='tbl-footer']")
	WebElement btn_pageNo;
	
	
	public HomePage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	//to verify the Logo image on page
	public boolean verifyLogoImage()
	{
		return logoImage_lnk.isDisplayed();
	} 
	
	//to access the Your profile page
	public YourProfilePage clickYourProfile() throws Throwable
	{
		menu_yourProfile.click();
		return new YourProfilePage();
	}
	
	//to access the Change Password page
	public ChangePasswordPage clickChangePassword() throws Throwable
	{
		menu_changePassword.click();
		return new ChangePasswordPage();
	}
	
	//to access the Appointments page
	public AppointmentPage clickAppointment() throws Throwable
	{
		menu_appointments.click();
		return new AppointmentPage();
	}
	
	//to Logout from application
	public LoginPage clickLogout() throws Throwable
	{
		menu_logout.click();
		return new LoginPage();
	}
	
	public void checkVisitorProfile(String visitorName)
	{
		//id='ctl00_CenterAreaHolder_GridUsers_ctl04_hlnkFullName'
		String before_xpath="//[@id='ctl00_CenterAreaHolder_GridUsers_ct";
		String after_xpath="_hlnkFullName']";
		for(int i=102; i>=116; i++)
		{
			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			if(name.contains(visitorName))
			{
				driver.findElement(By.xpath(before_xpath+i+after_xpath)).click();
				break;
			}
		}
			
	}

}
