package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class YourProfilePage extends Testbase
{
	/*****Page objects in Menu bar*****/
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
	
	@FindBy(id="ctl00_CenterAreaHolder_TxtRegistrationNumber")
	WebElement relationshipNo_ReadonlyTxtbox;
	
	/*****Page objects on the page*****/
	//Patient Relationship Information Section
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtRegistrationNumber']")
	WebElement txtRegistrationNumber;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtRegistrationDate']")
	WebElement txtRegistrationDate;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtMobileNo']")
	WebElement txtMobileNo;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtRefferedBy']")
	WebElement txtRefferedBy;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_FluUploadPhoto']")
	WebElement fuUploadPhoto;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_ConsentFormUpload']")
	WebElement fuUploadConsent;
	
	//Patient Personel Information Section
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropPrefix']//options")
	List<WebElement> ddlPrefix;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtFirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtMiddleName']")
	WebElement txtMiddleName;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtLastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_ddlCategory']//option")
	List<WebElement> ddlCategory;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtGuardianName']")
	WebElement txtGuardianName;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtAge']")
	WebElement txtAge;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtUIDNumber']")
	WebElement txtUIDNumber;
	
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_RadioGender']//td[@type='radio']")
	List<WebElement> RadioGender;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropMaritalStatus']//option")
	List<WebElement> ddlMaritalStatus;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropCitizenCountry']//option")
	List<WebElement> ddlCitizenCountry;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtOccupation']")
	WebElement txtOccupation;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropMonthlyIncome']//option")
	List<WebElement> ddlMonthlyIncome;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtAppoloId']")
	WebElement txtAppoloId;
	
	/************Page objects for Delhi NCR Address**************/
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNAStreet']")
	WebElement txtDNAStreet;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNABlock']")
	WebElement txtDNABlock;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNABuildingFloor']")
	WebElement txtDNABuildingFloor;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNACity']")
	WebElement txtDNACity;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNAPostalCode']")
	WebElement txtDNAPostalCode;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropDNACountry']//option")
	List<WebElement> ddlDNACountry;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropDNAState']//option")
	List<WebElement> ddlDNAState;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNAPersonalMobileNumber']")
	WebElement txtDNAPersonalMobileNumber;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNALandline']")
	WebElement txtDNALandline;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNAEmail']")
	WebElement txtDNAEmail;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNAFax']")
	WebElement txtDNAFax;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtDNAWebSite']")
	WebElement txtDNAWebSite;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_ChkCopyDNAtoPermanentAddress']")
	WebElement chkCopyDNAtoPermanentAddress;
	
	/***********Page Objects for Permanent Address************/
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressStreet']")
	WebElement txtPermanentAddressStreet;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressBlock']")
	WebElement txtPermanentAddressBlock;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressBuildingFloor']")
	WebElement txtPermanentAddressBuildingFloor;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressCity']")
	WebElement txtPermanentAddressCity;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressPostalCode']")
	WebElement txtPermanentAddressPostalCode;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropPermanentCountry']//option")
	List<WebElement> ddlPermanentCountry;
	
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DropPermanentState']//option")
	WebElement ddlPermanentState;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressPersonalMobileNo']")
	WebElement txtPermanentAddressPersonalMobileNo;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressLandline']")
	WebElement txtPermanentAddressLandline;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressEmail']")
	WebElement txtPermanentAddressEmail;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressFax']")
	WebElement txtPermanentAddressFax;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_TxtPermanentAddressWebSite']")
	WebElement txtPermanentAddressWebSite;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_ChkCopyPermanentToDNA']")
	WebElement chkCopyPermanentToDNA;
	
	//Page Objects available in footer
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_chkAcceptAgreement']")
	WebElement chkAcceptAgreement;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_BtnSave']")
	WebElement btnSave;
	
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_BtnCancel']")
	WebElement btnCancel;
	
	@FindBy(xpath="//div[@class='btmmnus']//td")
	WebElement ftCopyright;
	
	public YourProfilePage() throws Throwable 
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
	
	// to access the Your profile page
	public YourProfilePage clickYourProfile() throws Throwable 
	{
		menu_yourProfile.click();
		return new YourProfilePage();
	}

	// to access the Change Password page
	public ChangePasswordPage clickChangePassword() throws Throwable 
	{
		menu_changePassword.click();
		return new ChangePasswordPage();
	}

	// to access the Appointments page
	public AppointmentPage clickAppointment() throws Throwable 
	{
		menu_appointments.click();
		return new AppointmentPage();
	}

	// to Logout from application
	public LoginPage clickLogout() throws Throwable 
	{
		menu_logout.click();
		return new LoginPage();
	}

}
