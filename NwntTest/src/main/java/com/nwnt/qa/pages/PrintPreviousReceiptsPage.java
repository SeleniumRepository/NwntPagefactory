package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintPreviousReceiptsPage 
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
	
	//to locate the label "Relationship No"
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_LblRelationship']")
	WebElement LblRelationship;
	
	//to locate the label "Registration Date"
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_LblRegistartionDate']")
	WebElement LblRegistartionDate;
	
	//to locate the label "Name"
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_LblName']")
	WebElement LblName;
	
	//to locate the label "Date of Birth"
	@FindBy(xpath="//span[@id='ctl00_CenterAreaHolder_LblDOB']")
	WebElement LblDOB;
	
	//to locate the image box "photo"
	@FindBy(xpath="//img[@id='ctl00_CenterAreaHolder_ImgPhoto']")
	WebElement ImgPhoto;
	
	//to locate the label "Receipt Date"
	@FindBy(xpath="//Input[@id='ctl00_CenterAreaHolder_grdPaymentDetail_ctl02_btnPrintRecepit']")
	WebElement btnReceiptDate;
	
	//to locate the image button "Print"
	@FindBy(xpath="//Input[@id='ctl00_CenterAreaHolder_grdPaymentDetail_ctl02_imgButtonPrint']")
	WebElement imgButtonPrint;
	
	//to locate the rows in table "Payment Detail"
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdPaymentDetail']//tr")
	List<WebElement> grdPaymentDetail;


}
