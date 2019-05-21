package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class ViewPreviousPayReceiptsPage extends Testbase
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
	//@FindBy(xpath="//Input[@id='ctl00_CenterAreaHolder_grdPaymentDetail_ctl02_btnPrintRecepit']")
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdPaymentDetail']//input[@type='submit']")
	List<WebElement> btnReceiptsDate;
	
	//to locate the image button "Print"
	//@FindBy(xpath="//Input[@id='ctl00_CenterAreaHolder_grdPaymentDetail_ctl02_imgButtonPrint']")
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdPaymentDetail']//input[@type='image']")
	List<WebElement> imgButtonsPrint;
	
	//to locate the rows in table "Payment Detail"
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdPaymentDetail']//tr")
	List<WebElement> grdPaymentDetail;
	
	public ViewPreviousPayReceiptsPage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	// to open the specific date Receipt
	public PrintPreviousPayReceiptPage openPaymentReceiptOf(String givenReceiptDate) throws Throwable
	{
		for(int i=0,j=2; i<btnReceiptsDate.size()&&j<2+btnReceiptsDate.size(); i++,j++)
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();", btnReceiptsDate.get(i));
			System.out.println(btnReceiptsDate.get(i).getAttribute("value"));
			if(givenReceiptDate.equals(btnReceiptsDate.get(i).getAttribute("value")))
			{
				String dateId = btnReceiptsDate.get(i).getAttribute("id");
				String strImgBtnPrint = dateId.replace(dateId.substring(dateId.lastIndexOf("_")+1), "imgButtonPrint");
				if(driver.findElement(By.id(strImgBtnPrint)).isDisplayed())
				{
					driver.findElement(By.id(strImgBtnPrint)).click();
					break;
				}
			}
		}
		return new PrintPreviousPayReceiptPage();
	}
	
	//to count the generated receipts 
	public int allReceipts()
	{
		return btnReceiptsDate.size();
	}

}
