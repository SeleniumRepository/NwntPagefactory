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
	List<WebElement> rblPaymentMode;

	//to locate the textbox "Cash Amount"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtCashAmount']")
	WebElement txtCashAmount;

	//to locate the textbox "Payment Date"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtPaymentDate']")
	WebElement txtPaymentDate;

	//to locate the textbox "Discount Amount"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_txtDiscountAmount']")
	WebElement txtDiscount;

	//to locate the radio button list "Discount Type"
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblDiscountType']//input")
	List<WebElement> rblDiscountType;
	
	//to locate the radio button list "Discount Type" labels
	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_rblDiscountType']//label")
	List<WebElement> rblDiscountTypeLbl;

	//to locate the Dropdownlist "Payment for"
	@FindBy(xpath = "//select[@id='ctl00_CenterAreaHolder_ddlpaymentfor']")
	WebElement ddlPaymentfor;

	//to locate the button "Submit"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_btnsubmit']")
	WebElement btnSubmit;

	//to locate the button "Cancel"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_btncancel']")
	WebElement btnCancel;

	//to locate the label "Note"
	@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_lblNote']")
	WebElement lblNote;

	//to locate the textbox "Full Name"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtFullName']")
	WebElement txtFullName;

	//to locate the textbox "Relationship No"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtRelationshipNo']")
	WebElement txtRelationshipNo;

	//to locate the textbox "Mobile No"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtMobileNo']")
	WebElement txtMobileNo;

	//to locate the textbox "Gender"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtGender']")
	WebElement txtGender;

	//to locate the textbox "EmailId"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtEmailId']")
	WebElement txtEmailId;

	//to locate the textbox "Account Balance"
	@FindBy(xpath = "//input[@id='ctl00_CenterAreaHolder_TxtAccountBalance']")
	WebElement txtAccountBalance;
	
	public AdvancePaymentsPage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogoImage()
	{
		return logoImage_lnk.isDisplayed();
	}
	
	//to get the value for Payment Mode RBL 
	public void selectPaymentmode(String payMode) 
	{
		for (int i = 0; i < rblPaymentMode.size(); i++) {
			if (payMode.equals(rblPaymentMode.get(i).getText())) 
			{
				rblPaymentMode.get(i).click();
				break;
			}
		}
	}
	
	public void inputAmount(String amount)
	{
		txtCashAmount.sendKeys(amount);
	}
	
	public void inputDiscount(String discount)
	{
		txtDiscount.sendKeys(discount);
	}
	
	//return the value for Discount Type RBL
	public void selectDiscountType(String discType)
	{
		for (int i = 0; i < rblDiscountType.size(); i++) {
			if (discType.equals(rblDiscountTypeLbl.get(i).getText()))
			{
				rblDiscountType.get(i).click();
				break;
			}
		}
	}
	
	public void selectPaymentFor(String payFor)
	{
		Select payf = new Select(ddlPaymentfor);
		payf.selectByVisibleText(payFor);
	}
	
	public void clickSubmitOrCancel(String btnCommand)
	{
		if (btnCommand.equals(btnSubmit.getText().trim()))
			btnSubmit.click();
		else if(btnCommand.equals(btnCancel.getText().trim()))
			btnCancel.click();
		else
			System.out.println("Given command is not valid.");
	}
	
	public String getVisitorName()
	{
		return txtFullName.getAttribute("value");
	}
}
