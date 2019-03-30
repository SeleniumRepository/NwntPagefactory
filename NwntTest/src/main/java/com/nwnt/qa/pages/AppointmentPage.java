package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class AppointmentPage extends Testbase {
	//WebElement "Home" menu
	@FindBy(xpath = "//a[contains(text(),'Home')]//ancestor::div[@class='tpmnus']")
	WebElement menu_home;

	//WebElement "Your Profile" menu
	@FindBy(xpath = "//a[contains(text(),'Your')]//ancestor::div[@class='tpmnus']")
	WebElement menu_yourProfile;

	//WebElement "Change Password" menu
	@FindBy(xpath = "//a[contains(text(),'Change Password')]//ancestor::div[@class='tpmnus']")
	WebElement menu_changePassword;

	//WebElement "Appointments" menu
	@FindBy(xpath = "//a[contains(text(),'Appointments')]//ancestor::div[@class='tpmnus']")
	WebElement menu_appointments;

	//WebElement "logout" menu
	@FindBy(xpath = "//a[contains(text(),'Logout')]//ancestor::div[@class='tpmnus']")
	WebElement menu_logout;

	//WebElement "Logo Image" menu
	@FindBy(id = "ctl00_Logo")
	WebElement logoImage_lnk;

	// class constructor
	public AppointmentPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}

	// to get the Title of the page
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	// to verify the Logo image on page
	public boolean verifyLogoImage() {
		return logoImage_lnk.isDisplayed();
	}

	// to access the Your profile page
	public YourProfilePage clickYourProfile() throws Throwable {
		menu_yourProfile.click();
		return new YourProfilePage();
	}

	// to access the Change Password page
	public ChangePasswordPage clickChangePassword() throws Throwable {
		menu_changePassword.click();
		return new ChangePasswordPage();
	}

	// to access the Appointments page
	public AppointmentPage clickAppointment() throws Throwable {
		menu_appointments.click();
		return new AppointmentPage();
	}

	// to Logout from application
	public LoginPage clickLogout() throws Throwable {
		menu_logout.click();
		return new LoginPage();
	}
}
