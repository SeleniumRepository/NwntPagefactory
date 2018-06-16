package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class ChangePasswordPage extends Testbase
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
	
	@FindBy(id="ctl00_CenterAreaHolder_txtoldpwd")
	WebElement txt_oldPwd;
	
	@FindBy(id="ctl00_CenterAreaHolder_txtnewpwd")
	WebElement txt_newPwd;
	
	@FindBy(id="ctl00_CenterAreaHolder_txtconfirmpwd")
	WebElement txt_confirmPwd;
	
	@FindBy(id="ctl00_CenterAreaHolder_btnchangpass")
	WebElement btn_changePass;
	
	@FindBy(id="ctl00_CenterAreaHolder_btncancel")
	WebElement btn_cancel;
	
	@FindBy(id="ctl00_CenterAreaHolder_ChangePasswordSuccess")
	WebElement msg_pwdChangeSuccess;
	
	@FindBy(id="ctl00_CenterAreaHolder_ChangePasswordError")
	WebElement msg_pwdChangeError;
	
	@FindBy(id="ctl00_CenterAreaHolder_CompareValidator1")
	WebElement msg_compareValidator;
	
	@FindBy(id="ctl00_CenterAreaHolder_RegularExpressionValidator1")
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
		
		public void changePassword(String oldpass, String newpass)
		{
			txt_oldPwd.clear();
			txt_oldPwd.sendKeys(oldpass);
			txt_newPwd.clear();
			txt_newPwd.sendKeys(newpass);
			txt_confirmPwd.clear();
			txt_confirmPwd.sendKeys(newpass);
			btn_changePass.click();
		}
		
		public void verifySuccessMsg()
		{
			String success = msg_pwdChangeSuccess.getText();
			if(success.contains("changed successfuly"))
			{
				System.out.println();
			}
		}
		
		public void enterInvalidOldPassword(String oldpass, String newpass)
		{
			txt_oldPwd.clear();
			txt_oldPwd.sendKeys(oldpass);
			txt_newPwd.clear();
			txt_newPwd.sendKeys(newpass);
			txt_confirmPwd.clear();
			txt_confirmPwd.sendKeys(newpass);
			btn_changePass.click();
		}
		
		public void enterInvalidFormatNewPass(String oldpass)
		{
			txt_oldPwd.clear();
			txt_oldPwd.sendKeys(oldpass);
			txt_newPwd.clear();
			txt_newPwd.sendKeys("newpassword");
		}
		
		public void enterInvalidConfirmPassword(String oldpass, String newpass)
		{
			txt_oldPwd.clear();
			txt_oldPwd.sendKeys(oldpass);
			txt_newPwd.clear();
			txt_newPwd.sendKeys(newpass);
			txt_confirmPwd.clear();
			txt_confirmPwd.sendKeys("amritesh");
			btn_changePass.click();
		}

}
