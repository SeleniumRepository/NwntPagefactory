package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
	List<WebElement> AppointmentWith_rbl;
	
	@FindBy(xpath = "//table[@id = 'ctl00_CenterAreaHolder_RDLAppointmentWith']//label")
	List<WebElement> AppointmentWith_rblLabel;

	// to locate the radio button list "Clinic location"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblClinicLocation']//input")
	List<WebElement> ClinicLocation_rbl;
	
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblClinicLocation']//label")
	List<WebElement> ClinicLocation_rblLabel;

	// ********Elements present for Doctor Appointment*********
	// to locate the Dropdown list(Doctor) "Appointment to"
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_DDLAppointedDoctor']//option") // (xpath="//select[@id='ctl00_CenterAreaHolder_DDLAppointedDoctor']//option")
	//WebElement AppointmentTo_DDLDoctor;
	List<WebElement> AppointmentTo_DDLDoctor;

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
	List<WebElement> CaseType_rbl;
	
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblCaseType']//label")
	List<WebElement> CaseType_rblLabel;

	// to locate the radio button list "Appointment In"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_RadioButtonAppointmentIn']//input[@type='radio']")
	List<WebElement> AppointmentInDoctor_rbl;
	
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_RadioButtonAppointmentIn']//input[@type='radio']")
	List<WebElement> AppointmentInDoctor_rblLabel;

	// to locate the check Box "Patient not brought"
	@FindBy(id = "ctl00_CenterAreaHolder_PatientNotBrought")
	WebElement PatientNotBrought_cb;

	// to locate the check Box "Is Corporate Appointment"
	//@FindBy(xpath = "//input[@id = 'ctl00_CenterAreaHolder_IsDrAppforCorporate']")
	@FindBy(xpath = "//table[@class='tbl-normal']//input[@id = 'ctl00_CenterAreaHolder_IsDrAppforCorporate']")
	WebElement IsDrAppforCorporate;

	// to locate the button "Submit"
	@FindBy(id = "ctl00_CenterAreaHolder_Submitbtn")
	WebElement Submit_btnDoctor;

	// to locate the Appointment list
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_GrdAllAppointments']//descendant::tr")
	WebElement AllAppointments_Grd;

	// ********Elements present for Panel Appointment*********
	// to locate the Dropdown list(Panel) "Appointment to"
	@FindBy(xpath = "//select[@id='ctl00_CenterAreaHolder_DDLPanel']//option")
	List<WebElement> AppointmentTo_DDLPanel;

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
	List<WebElement> CaseType_rblPanel;

	// to locate the radio button list(Panel) "Appointment In"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_RBLPanelAppointmentIn']//input[@type='radio']")
	List<WebElement> AppointmentIn_rblPanel;

	// to locate the check Box "Is Corporate Appointment"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_IsPnlAppforCorporate']")
	WebElement IsPnlAppforCorporate;

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

	// Select the value for Appointment With
	public void selectAppointmentWith(String AppointmentWith) 
	{
		for (int i=0; i<AppointmentWith_rbl.size(); i++) 
		{
			if (AppointmentWith.equals(AppointmentWith_rblLabel.get(i).getText())) 
			{
				AppointmentWith_rbl.get(i).click();
				break;
			}
		}
	}

	// Select the value for "Clinic Location"
	public void selectClinicLocation(String clinicLocation) 
	{
		for (int i = 0; i < ClinicLocation_rbl.size(); i++) 
		{
			if (clinicLocation.equals(ClinicLocation_rblLabel.get(i).getText())) 
			{
				ClinicLocation_rbl.get(i).click();
				break;
			}
		}
	}
	
	/********************Actions to book the Dr Appointment*********************/
	// Return the value for Doctor "Appointment to"
	public void selectDrAppointmentTo(String appointmentTo) 
	{
		// Select opt = new Select(AppointmentTo_DDLDoctor);
		// opt.selectByVisibleText(appointmentTo.trim());
		if (AppointmentTo_DDLDoctor.size() > 1) 
		{
			for (int i = 0; i < AppointmentTo_DDLDoctor.size(); i++) 
			{
				if (appointmentTo.equals(AppointmentTo_DDLDoctor.get(i).getText()))
					AppointmentTo_DDLDoctor.get(i).click();
			}
		}
	}

	// Select the value for Doctor "Case Type"
	public void selectDrCaseType(String caseType) 
	{
		for (int i = 0; i < CaseType_rbl.size(); i++) 
		{
			if (caseType.equals(CaseType_rblLabel.get(i).getText())) 
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true);", CaseType_rbl.get(i));
				CaseType_rbl.get(i).click();
				break;
			}
		}
	}

	// Select the value for Doctor "Appointment In"
	public void selectDrAppointmentIn(String AppointmentIn) 
	{
		for (int i = 0; i < AppointmentInDoctor_rbl.size(); i++) 
		{
			if (AppointmentIn.equals(AppointmentInDoctor_rblLabel.get(i).getText())) 
			{
				AppointmentInDoctor_rbl.get(i).click();
				break;
			}
		}
	}

	// To check/uncheck the checkbox "PatientNotBrought"
	public void checkPatientNotBrought(String Status) 
	{
		if ((Status.toLowerCase()).equals("no")) 
		{
			if (PatientNotBrought_cb.isSelected())
			{PatientNotBrought_cb.click();}
				
		} else if((Status.toLowerCase()).equals("yes"))
			PatientNotBrought_cb.click();
	}

	//Check IsForCorporateAppointment is enable on page
	public boolean isDrCorporateAppointmentVisible()
	{
		boolean isVisible=false;
		if(IsDrAppforCorporate.isDisplayed()==true)
		{
			isVisible = true;
		}
			
		return isVisible;
	}

	// To check/uncheck the checkbox "Patient Not Brought"
	public void checkIsDrCorporateAppointment(String Status) 
	{
		if ((Status.toLowerCase()).equals("no")) 
		{
			if (IsDrAppforCorporate.isSelected())
				IsDrAppforCorporate.click();
		} 
		else if ((Status.toLowerCase()).equals("yes")) 
		{
			if (IsDrAppforCorporate.isSelected())
				System.out.println("Checkbox already checked.");
			IsDrAppforCorporate.click();
		} 
		else
			System.out.println("Invalid input found. Plz check your Datasheet.");
	}

	// To book Dr appointment click "Submit" button
	public void clickDrSubmitApp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].ScrollIntoView();", Submit_btnDoctor);
		Submit_btnDoctor.click();
	}
	
	/********************Actions to book the Panel Appointment*********************/
	// Return the value for Doctor "Appointment to"
	public void selectPnlAppointmentTo(String appointmentTo) {		
		//Select opt = new Select(AppointmentTo_DDLDoctor);
		
		if(AppointmentTo_DDLPanel.size()>1)
		{
		for(int i=0; i<AppointmentTo_DDLPanel.size(); i++)
		{
			if(appointmentTo.equals(AppointmentTo_DDLPanel.get(i).getText()))
				AppointmentTo_DDLPanel.get(i).click();
		}
		}
		
		//opt.selectByVisibleText(appointmentTo.trim());
	}

	// Return the value for Doctor "Case Type"
	public String selectPnlCaseType(String caseType) {
		String Case = null;
		for (int i = 0; i < CaseType_rblPanel.size(); i++) {
			if (caseType.equals(CaseType_rblPanel.get(i).getText())) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true);", CaseType_rblPanel.get(i));
				CaseType_rblPanel.get(i).click();
				Case = CaseType_rblPanel.get(i).getText();
				break;
			}
		}
		return Case;
	}

	// Return the value for Doctor "Appointment In"
	public String selectPnlAppointmentIn(String AppointmentIn) {
		String AppIn = null;
		for (int i = 0; i < AppointmentIn_rblPanel.size(); i++) {
			if (AppointmentIn.equals(AppointmentIn_rblPanel.get(i).getText())) {
				AppointmentIn_rblPanel.get(i).click();
				AppIn = AppointmentIn_rblPanel.get(i).getText();
				break;
			}
		}
		return AppIn;
	}
	
	//Check IsForCorporateAppointment is enable on page
		public boolean isPnlCorporateAppointmentVisible()
		{
			boolean isVisible=false;
			if(IsPnlAppforCorporate.isDisplayed()==true)
			{
				isVisible = true;
			}
				
			return isVisible;
		}

		// To check/uncheck the checkbox "Patient Not Brought"
		public void checkIsPnlCorporateAppointment(String Status) 
		{
			if ((Status.toLowerCase()).equals("no")) 
			{
				if (IsDrAppforCorporate.isSelected())
					IsDrAppforCorporate.click();
			} 
			else if ((Status.toLowerCase()).equals("yes")) 
			{
				if (IsDrAppforCorporate.isSelected())
					System.out.println("Checkbox already checked.");
				IsDrAppforCorporate.click();
			} 
			else
				System.out.println("Invalid input found. Plz check your Datasheet.");
		}


	// To book Dr appointment click "Submit" button
	public void clickPnlSubmit() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].ScrollIntoView();", Submit_btnPanel);
		Submit_btnPanel.click();
	}

}
