package com.nwnt.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nwnt.qa.base.Testbase;

public class UploadPrescriptionsPage extends Testbase
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
	WebElement txtComplaint;
	
	//to locate the textbox "Revised Medicine"
	@FindBy(xpath="//textarea[@id='ctl00_CenterAreaHolder_Precomputerization1_TxtRevisedMedicine']")
	WebElement txtRevisedMedicine;
	
	//to locate the button "Add"
	@FindBy(xpath="//input[@id='ctl00_CenterAreaHolder_Precomputerization1_btnRevisedMedicine']")
	WebElement btnAddRevisedMedicine;
	
	public UploadPrescriptionsPage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	/*******Activities to Upload Lab Reports********/
	//Select a investigation category from dropdownlist
	public void selectLabReportType(String reportCatg)
	{
		Select lr = new Select(ddlInvestigationCategory);
		//jse.executeScript("arguments[0].scrollIntoView(true);", reportCatg);
		lr.selectByVisibleText(reportCatg);
	}
	
	//Select given date (in dd-mmm-yyyy format) from Calender control
	public void selectLabReportDateInCalender(String givenDate)
	{
		
	}
	
	//Directly input the given date(in dd-mmm-yyyy format) in textbox
	public void inputLabReportDate(String givenDate)
	{
		txtInvestigationDate.sendKeys(givenDate);
	}
	
	//click Browse button or send direct path to upload a file
	public void clickFileSelectionBrowseBtn(String filePath)
	{
		fuPrescription.sendKeys(filePath);
	}
	
	//click Upload button to upload the selected file
	public void clickFileUploadBtn()
	{
		btnUpload.click();
	}
	
	public void uploadLabReports()
	{
		selectLabReportType("Vitamin B12");
		inputLabReportDate("20-Apr-2019");
		clickFileSelectionBrowseBtn("given FilePath");
		clickFileUploadBtn();
	}
	
	/******Activities to save the Investigation values******/
	//select given Investigation in dropdownlist 
	public void selectInvestigation(String givenInvs)
	{
		Select invs = new Select(ddlInvestigations);
		invs.selectByVisibleText(givenInvs);
	}
	
	//Input patient Value
	public void inputPatientValue(String patientVal)
	{
		txtPatientValue.sendKeys(patientVal);
	}
	
	//input investigation date from 
	public void inputInvestDate(String givenDate)
	{
		txtLabInvestigationDate.sendKeys(givenDate);
	}
	
	//input the investigation date from calendar control
	public void selectInvestigationDate()
	{
		ImgBtncalanderInvestigations.click();
		/*
		 and select a date from calender
		 */
	}
	
	//click to add the investigation
	public void clickBtnAddInvestigation()
	{
		btnAddDocEvalInvestigation.click();
	}
	
	//click the save button to save the added investigation
	public void clickBtnSaveInvestigation()
	{
		btnSaveInvestigation.click();
	}
	
	public void addInvestigation()
	{
		selectInvestigation("Haemoglobin");
		inputPatientValue("14.34");
		inputInvestDate("20-Apr-2019");
		clickBtnAddInvestigation();
	}
	
	/*****Activities to add the Revised Medicine*****/
	//Input complaint in textbox
	public void inputComplaint(String givenComplaint)
	{
		txtComplaint.sendKeys(givenComplaint);
	}
	
	//input Revised medicine in textbox
	public void inputRevisedMedicine(String revisedMedicine)
	{
		txtRevisedMedicine.sendKeys(revisedMedicine);
	}
	
	//click Add button to add the revised medicine
	public void clickBtnAddcompalint()
	{
		btnAddRevisedMedicine.click();
	}
	
	//Add Revised Medicine
	public void addRevisedMedicine()
	{
		inputComplaint("Few complaints increased/decreased, reported by patient.");
		inputRevisedMedicine("Revised/adjusted medicines by doctor");
		clickBtnAddcompalint();
	}

}
