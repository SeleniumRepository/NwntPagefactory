package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nwnt.qa.base.Testbase;

public class AdvancePaymentsPage  extends Testbase
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

	// to locate the Payment mode radio button list
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_RBLPaymentMode']//td")
	List<WebElement> RBLPaymentMode;

	//to locate the textbox "Cash Amount"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtCashAmount']")
	WebElement TxtCashAmount;

	//to locate the textbox "Payment Date"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtPaymentDate']")
	WebElement TxtPaymentDate;

	//to locate the textbox "Discount Amount"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_txtDiscountAmount']")
	WebElement txtDiscountAmount;

	//to locate the radio button list "Discount Type"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_rblDiscountType']//td")
	List<WebElement> rblDiscountType;

	//to locate the Dropdownlist "Payment for"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_ddlpaymentfor']")
	WebElement ddlpaymentfor;

	//to locate the button "Submit"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_btnsubmit']")
	WebElement btnsubmit;

	//to locate the button "Cancel"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_btncancel']")
	WebElement btncancel;

	//to locate the label "Note"
	@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_lblNote']")
	WebElement lblNote;

	//to locate the textbox "Full Name"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtFullName']")
	WebElement TxtFullName;

	//to locate the textbox "Relationship No"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtRelationshipNo']")
	WebElement TxtRelationshipNo;

	//to locate the textbox "Mobile No"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtMobileNo']")
	WebElement TxtMobileNo;

	//to locate the textbox "Gender"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtGender']")
	WebElement TxtGender;

	//to locate the textbox "EmailId"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtEmailId']")
	WebElement TxtEmailId;

	//to locate the textbox "Account Balance"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtAccountBalance']")
	WebElement TxtAccountBalance;
	
	public AdvancePaymentsPage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogoImage()
	{
		return logoImage_lnk.isDisplayed();
	}
	
	//return the value for Payment Mode RBL 
	public String selectPaymentmode(String payMode) 
	{
		String pay = null;
		for (int i = 0; i < RBLPaymentMode.size(); i++) {
			if (payMode.equals(RBLPaymentMode.get(i).getText())) 
			{
				RBLPaymentMode.get(i).click();
				pay = RBLPaymentMode.get(i).getText();
				break;
			}
		}
		return pay;
	}
	
	//return the value for Discount Type RBL
	public String selectDiscountType(String discType)
	{
		String type = null;
		for (int i = 0; i < rblDiscountType.size(); i++) {
			if (discType.equals(rblDiscountType.get(i).getText())) {
				rblDiscountType.get(i).click();
				type = rblDiscountType.get(i).getText();
				break;
			}
		}
		return type;
	}
	
	public void selectPaymentFor(String payFor)
	{
		Select payf = new Select(ddlpaymentfor);
		payf.selectByVisibleText(payFor);
	}
	
	
	public void depositAmount(String paymentMode)
	{
		
	}
	
}
