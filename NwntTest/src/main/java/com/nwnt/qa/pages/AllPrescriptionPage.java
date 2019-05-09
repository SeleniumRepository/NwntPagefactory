package com.nwnt.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class AllPrescriptionPage extends Testbase
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

	//
	@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_LblRelationship']")
	WebElement lblRelationship;

	@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_LblRegistartionDate']")
	WebElement lblRegistartionDate;

	@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_LblName']")
	WebElement lblName;

	@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_LblDOB']")
	WebElement lblDOB;

	@FindBy(xpath = "//img[@id='ctl00_CenterAreaHolder_ImgPhoto']")
	WebElement imgPhoto;

	@FindBy(xpath = "//table[@id='ctl00_CenterAreaHolder_grdUserAppointments']//tr")
	List<WebElement> grdUserAppointments;

	//@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_grdUserAppointments_ctl02_lblAppintmentTime']")
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdUserAppointments']//span")
	List<WebElement> lblAppointmentsTime;

	//@FindBy(xpath = "//span[@id='ctl00_CenterAreaHolder_grdUserAppointments_ctl02_imgBtnPrint']")
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdUserAppointments']//input")
	List<WebElement> imgBtnPrescription;
	
	//String before_xpath="//span[@id='ctl00_CenterAreaHolder_grdUserAppointments_ctl";
	//String after_xpath="_imgBtnPrint']";
	public AllPrescriptionPage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getPrescriptionsCount()
	{
		System.out.println("Total Generated prescriptions for "+lblName.getText()+" ("+lblRelationship.getText()+")  are : "+imgBtnPrescription.size());
	}
	
	public PrintPrescriptionsPage openPrescriptionOf(String givenPresDate) throws Throwable
	{
		for(int i=0,j=2; i<lblAppointmentsTime.size()&&j<2+lblAppointmentsTime.size(); i++,j++)
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();", lblAppointmentsTime.get(i));
			
			String[] arrStr = lblAppointmentsTime.get(i).getText().split(" ");
			if(givenPresDate.equals(arrStr[0]))
			//if(givenPresDate.equals(DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).toFormat().format(lblAppointmentsTime.get(i).getText())))
			{
				String dateId = lblAppointmentsTime.get(i).getAttribute("id");
				String strImgBtnPrint = dateId.replace(dateId.substring(dateId.lastIndexOf("_")+1), "imgBtnPrint");
				if(driver.findElement(By.id(strImgBtnPrint)).isDisplayed())
				{
					driver.findElement(By.id(strImgBtnPrint)).click();
					break;
				}
			}
		}
		return new PrintPrescriptionsPage();
	}

}
