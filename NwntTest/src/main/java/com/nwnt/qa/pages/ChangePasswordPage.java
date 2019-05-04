package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;
import com.nwnt.qa.util.Xls_Reader;

public class ChangePasswordPage extends Testbase
{
	Xls_Reader reader = new Xls_Reader(prop.getProperty("Path_TestData"));
	
	//For Home link in menubar
	@FindBy(xpath="//a[contains(text(),'Home')]//ancestor::div[@class='tpmnus']")
	WebElement menu_home;
	
	//For Your Profile link in menubar
	@FindBy(xpath="//a[contains(text(),'Your')]//ancestor::div[@class='tpmnus']")
	WebElement menu_yourProfile;
	
	//For Change Password link in menubar
	@FindBy(xpath="//a[contains(text(), 'Change Password')]")
	WebElement menu_changePassword;
	
	//For Appointments link in menubar
	@FindBy(xpath="//a[contains(text(),'Appointments')]//ancestor::div[@class='tpmnus']")
	WebElement menu_appointments;
	
	//For Logout link in menubar
	@FindBy(xpath="//a[contains(text(),'Logout')]//ancestor::div[@class='tpmnus']")
	WebElement menu_logout;
	
	//For Logo image link in top of the page
	@FindBy(id="ctl00_Logo")
	WebElement logoImage_lnk;
	
	//For Old Password textbox
	@FindBy(id="ctl00_CenterAreaHolder_txtoldpwd")
	WebElement txt_oldPwd;
	
	//For New Password textbox
	@FindBy(id="ctl00_CenterAreaHolder_txtnewpwd")
	WebElement txt_newPwd;
	
	//For Confirm Password textbox
	@FindBy(id="ctl00_CenterAreaHolder_txtconfirmpwd")
	WebElement txt_confirmPwd;
	
	//For Save button
	@FindBy(id="ctl00_CenterAreaHolder_btnchangpass")
	WebElement btn_Save;
	
	//For Cancel button
	@FindBy(id="ctl00_CenterAreaHolder_btncancel")
	WebElement btn_cancel;
	
	//For Change Password confirmation message
	@FindBy(id="ctl00_CenterAreaHolder_ChangePasswordSuccess")
	WebElement msg_pwdChangeSuccess;
	
	//For invalid old Password error message
	@FindBy(id="ctl00_CenterAreaHolder_ChangePasswordError")
	WebElement msg_pwdChangeError;
	
	/*@FindBy(xpath="//div[@class='col-sm-8']/div[3]//li")
	WebElement msg_validation;*/
	
	//For different confirm Password error message
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_CompareValidator1']")
	WebElement msg_compareValidator;
	
	//For invalid format new Password error message
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_RegularExpressionValidator1']")
	WebElement msg_invalidFormatPass;
	
	public ChangePasswordPage() throws Throwable 
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

	// To change the existing password
	public void changePassword() throws Throwable 
	{
		String[][] abc = reader.getcelldata(prop.getProperty("ChangePassSheetData"));
		for (int r = 1; r < abc.length; r++) 
		{ 
			for (int c = 0; c < abc[r].length; c++) 
			{
				if (c == 0) 
				{
					txt_oldPwd.clear();
					txt_oldPwd.sendKeys(abc[r][c]);
				} else if (c == 1) 
				{
					txt_newPwd.clear();
					txt_newPwd.sendKeys(abc[r][c]);
				} else if (c == 2) 
				{
					txt_confirmPwd.clear();
					txt_confirmPwd.sendKeys(abc[r][c]);
				}
			}
			btn_Save.click();
			this.verifySuccessMsg();
		}
	}

	public void verifySuccessMsg() throws Throwable 
	{
		if (msg_pwdChangeSuccess.isDisplayed()) 
		{
			System.out.println(msg_pwdChangeSuccess.getText());
		}

		else if (msg_invalidFormatPass.isDisplayed())
		{
			System.out.println(msg_invalidFormatPass.getText());
		} else if (msg_compareValidator.isDisplayed()) 
		{
			System.out.println(msg_compareValidator.getText());
		} else if (msg_pwdChangeError.isDisplayed()) 
		{
			System.out.println(msg_pwdChangeError.getText());
		} else {
			System.out.println("*********Unexpected exception on previous function***********");
		}
		menu_changePassword.click();

	}
}
