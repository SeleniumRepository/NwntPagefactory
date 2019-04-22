package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPrescriptionsPage 
{
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
	
	/*****elements to upload the lab reports under heading "Upload Documents"*****/
	//to locate the dropdownlist "Investigation Category" 
	@FindBy(id="ctl00_CenterAreaHolder_Precomputerization1_ddlInvestigationCategory")
	WebElement ddlInvestigationCategory;
	
	//to locate the textbox "Investigation Date"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_txtInvestigationDate']")
	WebElement txtInvestigationDate;
	
	//to locate the image calendar "Calender Popup"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_ImageCalenderPopup']")
	WebElement ImageCalenderPopup;
	
	//to locate the file upload button "Browse"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_fuPrescription']")
	WebElement fuPrescription;
	
	//to locate the button "Upload"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_btnUpload']")
	WebElement btnUpload;
	
	/**********Elements under heading "Investigations"**********/
	//to locate the dropdownlist "Investigation"
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_Precomputerization1_ddlInvestigations']")
	WebElement ddlInvestigations;
	
	//to locate the textbox "Patient Value"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_txtPatientValue']")
	WebElement txtPatientValue;
	
	//to locate the dropdownlist "Reference Range"
	@FindBy(xpath="//select[@id='ctl00_CenterAreaHolder_Precomputerization1_ddlReferenceRange']")
	WebElement ddlReferenceRange;
	
	//to locate the textbox "Lab Investigation Date"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_txtLabInvestigationDate']")
	WebElement txtLabInvestigationDate;
	
	//to locate the calendar Image Button "Calendar Investigation"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_ImgBtncalanderInvestigations']")
	WebElement ImgBtncalanderInvestigations;
	
	//to locate the button "Add" to add investigation
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_btnAddDocEvalInvestigation']")
	WebElement btnAddDocEvalInvestigation;
	
	//to locate the button "Save" to save added Investigation
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_SaveInvestigation']")
	WebElement btnSaveInvestigation;
	
	/**********Elements under heading "Revised Medicine"**********/
	//to locate the textbox "Compalint" 
	@FindBy(xpath="//textarea[@id='ctl00_CenterAreaHolder_Precomputerization1_TxtComplain']")
	WebElement TxtComplain;
	
	//to locate the textbox "Revised Medicine"
	@FindBy(xpath="//textarea[@id='ctl00_CenterAreaHolder_Precomputerization1_TxtRevisedMedicine']")
	WebElement TxtRevisedMedicine;
	
	//to locate the button "Add"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_btnRevisedMedicine']")
	WebElement btnAdd;


}
