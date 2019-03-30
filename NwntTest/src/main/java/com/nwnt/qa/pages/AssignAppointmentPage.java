package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class AssignAppointmentPage extends Testbase {

	// to locate the element "Home" in menu bar
	@FindBy(xpath = "//a[contains(text(),'Home')]//ancestor::div[@class='tpmnus']")
	WebElement menu_home;

	// to locate the element "Your Profile" in menu bar
	@FindBy(xpath = "//div[@class='tpmnus']//a[contains(text(), 'Your Profile')]")
	WebElement menu_yourProfile;

	// to locate the element "Change Password" in menu bar
	@FindBy(xpath = "//a[contains(text(), 'Change Password')]")
	WebElement menu_changePassword;

	// to locate the element "Appointments" in menu bar
	@FindBy(xpath = "//div[@class='tpmnus']//a[contains(text(), 'Appointments')]")
	WebElement menu_appointments;

	// to locate the element "Logout" in menu bar
	@FindBy(xpath = "//div[@class='tpmnus']//a[contains(text(), 'Logout')]")
	WebElement menu_logout;

	// to locate the element "Logo Image" in menu bar
	@FindBy(id = "ctl00_Logo")
	WebElement logoImage_lnk;

	// to locate the radio button list "Appointment with"
	@FindBy(xpath = "//table[@id = 'ctl00_CenterAreaHolder_RDLAppointmentWith']//input")
	WebElement AppointmentWith_rbl;

	// to locate the radio button list "Clinic location"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblClinicLocation']//input")
	WebElement ClinicLocation_rbl;

	// to locate the Dropdown list(Doctor) "Appointment to"
	@FindBy(id = "ctl00_CenterAreaHolder_DDLAppointedDoctor")
	WebElement AppointmentTo_DDLAppointedDoctor;

	// to locate the Dropdown list(Panel) "Appointment to"
	@FindBy(id = "ctl00_CenterAreaHolder_DDLPanel")
	WebElement AppointmentTo_DDLPanel;

	// to locate the input box(Doctor) "Appointment Date"
	@FindBy(id = "ctl00_CenterAreaHolder_ImgCalenderDoctor")
	WebElement AppointmentDate_ImgCalenderDoctor;

	// to locate the Dropdown list(Doctor) "Appointment time hour"
	@FindBy(id = "ctl00_CenterAreaHolder_DropHour")
	WebElement AppointmentTime_DropHourDoctor;

	// to locate the Dropdown list(Doctor) "Appointment time minute"
	@FindBy(id = "ctl00_CenterAreaHolder_DropMinute")
	WebElement AppointmentTime_DropMinuteDoctor;

	// to locate the Dropdown list(Doctor) "AM/PM"
	@FindBy(id = "ctl00_CenterAreaHolder_DropAmPm")
	WebElement AppointmentTime_ddlDoctorAMPM;

	// to locate the input box "Appointment Time Slot Hour"
	@FindBy(id = "ctl00_CenterAreaHolder_TxtTimeSlotHour")
	WebElement AppointmentTime_TxtTimeSlotHour;

	// to locate the input box "Appointment Time Slot Minute"
	@FindBy(id = "ctl00_CenterAreaHolder_TxtTimeSlotMinute")
	WebElement AppointmentTime_TxtTimeSlotMinute;

	// to locate the radio button list "Case Type"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblCaseType']//input[@type='radio']")
	WebElement CaseType_rbl;

	// to locate the radio button list "Appointment In"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_RadioButtonAppointmentIn']//input[@type='radio']")
	WebElement AppointmentIn_rblDoctor;

	// to locate the check Box "Patient not brought"
	@FindBy(id = "ctl00_CenterAreaHolder_PatientNotBrought")
	WebElement PatientNotBrought_cb;

	// to locate the button "Submit"
	@FindBy(id = "ctl00_CenterAreaHolder_Submitbtn")
	WebElement Submit_btnDoctor;

	// to locate the Appointment list
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_GrdAllAppointments']//descendant::tr")
	WebElement AllAppointments_Grd;

	// ********Elements present for Panel Appointment*********
	// to locate the input box(Panel) "Appointment Date"
	@FindBy(id = "ctl00_CenterAreaHolder_ImgBtnPanelCalender")
	WebElement AppointmentDate_ImgBtnPanelCalender;

	// to locate the Dropdown list(Panel) "Appointment time hour"
	@FindBy(id = "ctl00_CenterAreaHolder_DDLPanelHour")
	WebElement AppointmentTime_DDLPanelHour;

	// to locate the Dropdown list(Panel) "Appointment time minute"
	@FindBy(id = "ctl00_CenterAreaHolder_DDLPanelMinute")
	WebElement AppointmentTime_DDLPanelMinute;

	// to locate the Dropdown list(Panel) "AM/PM"
	@FindBy(id = "ctl00_CenterAreaHolder_DDLpanelAMPM")
	WebElement AppointmentTime_DDLpanelAMPM;

	// to locate the input box(Panel) "Appointment Time Slot Hour"
	@FindBy(id = "ctl00_CenterAreaHolder_TxtPanelHour")
	WebElement AppointmentTime_TxtPanelHour;

	// to locate the input box(Panel) "Appointment Time Slot Minute"
	@FindBy(id = "ctl00_CenterAreaHolder_TxtPanelMinute")
	WebElement AppointmentTime_TxtPanelMinute;

	// to locate the radio button list(Panel) "Case Type"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblPnlCaseType']//input[@type='radio']")
	WebElement CaseType_rblPanel;

	// to locate the radio button list(Panel) "Appointment In"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_RBLPanelAppointmentIn']//input[@type='radio']")
	WebElement AppointmentIn_rblPanel;

	// to locate the button(Panel) "Submit"
	@FindBy(id = "ctl00_CenterAreaHolder_BTNPanelSubmit")
	WebElement Submit_btnPanel;

	// class constructor
	public AssignAppointmentPage() throws Throwable {
		PageFactory.initElements(driver, this);
	}

	// to get the home page title
	public String validatePageTitle() {
		return driver.getTitle();
	}

	// to verify the Logo image on page
	public boolean verifyLogoImage() {
		return logoImage_lnk.isDisplayed();
	}

	// to access the Your profile page
	public YourProfilePage clickYourProfileLink() throws Throwable {
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
