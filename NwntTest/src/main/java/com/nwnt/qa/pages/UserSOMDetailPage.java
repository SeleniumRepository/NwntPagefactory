package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class UserSOMDetailPage extends Testbase
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
	
	//to locate the button "New Stress-o-meter test"
	@FindBy(xpath="//a[@id = 'ctl00_CenterAreaHolder_btnSomTest']")
	WebElement btnNewSomTest;
	
	//to locate the Label "SOM Relationship No"
	@FindBy(xpath="//span[@id = 'ctl00_CenterAreaHolder_LblSomRelationshipNo']")
	WebElement LblSomRelationshipNo;
	
	// to locate the Label "SOM Patient Name"
	@FindBy(xpath = "//span[@id = 'ctl00_CenterAreaHolder_LblSomPatientName']")
	WebElement LblSomPatientName;
	
	// to locate the Label "SOM Patient Age"
	@FindBy(xpath = "//span[@id = 'ctl00_CenterAreaHolder_LblSomAge']")
	WebElement LblSomAge;
	
	//to locate the heading label "Bar View"
	@FindBy(xpath="//u[.=' Bar View']//ancestor::div[@class='col-lg-12']")
	WebElement lblBarView;
	
	//to get all elements of completed SOM
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdStressResult']//tr")
	List<WebElement> grdStressResultAdult;
	
	@FindBy(xpath="//table[@id='ctl00_CenterAreaHolder_grdStressResult']//tr/td[@class='modifiedCell']")
	List<WebElement> lblSOMTakenDate;
	
	String before_xpath="//a[@id='ctl00_CenterAreaHolder_grdStressResult_ctl";	
	
	public UserSOMDetailPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogoImage()
	{
		return logoImage_lnk.isDisplayed();
	}
	
	//to click the New SOM Test
	public void clickNewSOM_Test()
	{
		btnNewSomTest.click();
	}
	
	//to check the Overall result click respective Overall result link
	public SOMOverallResultPage clickOverallResult(String testDate) throws Throwable
	{
		String after_xpath= "_hplResult']";
		for (int i=0,j=02; i<lblSOMTakenDate.size()&&j<lblSOMTakenDate.size()+02; i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
		return new SOMOverallResultPage();
	}
	
	//to check the Nature result click respective Nature result link 
	public void clickNatureResult(String testDate)
	{
		String after_xpath = "_NatureLabel']";
		for (int i=0, j=2; i<lblSOMTakenDate.size()&&j<lblSOMTakenDate.size()+2; i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
	}
	
	//to check the Circumstance result click respective Circumstance result link
	public void clickCircumsatncesResult(String testDate)
	{
		String after_xpath = "_CircumsatncesLabel']";
		for (int i=0,j=2; i<lblSOMTakenDate.size()&&j<2+lblSOMTakenDate.size(); i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
	}
	
	//to check the Body&Mind result click respective Body&Mind result link 
	public void clickBodyAndMindResult(String testDate)
	{
		String after_xpath = "_BodyAndMindLabel']";
		for (int i=0,j=2; i<lblSOMTakenDate.size()&&j<2+lblSOMTakenDate.size(); i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
	}
	
	//to check the Home Life result click respective Home Life result link
	public void clickHomeLifeResult(String testDate)
	{
		String after_xpath = "_HomeLifeLabel']";
		for (int i=0,j=2; i<lblSOMTakenDate.size()&&j<2+lblSOMTakenDate.size(); i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
	}
	
	//to check the Work result click respective work result link
	public void clickWorkResult(String testDate)
	{
		String after_xpath = "_WorkLabel']";
		for (int i=0,j=2; i<lblSOMTakenDate.size()&&j<2+lblSOMTakenDate.size(); i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
	}
	
	//to check the Questionnaire with option selection, click respective View link
	public void clickQuestionnaireResult(String testDate)
	{
		String after_xpath = "_QuestionnaireLink']";
		for (int i=0,j=2; i<lblSOMTakenDate.size()&&j<2+lblSOMTakenDate.size(); i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
	}
	
	//to check the Questionnaire summary with selected option, click respective Summary link
	public SOMSummaryPage clickSummaryResult(String testDate) throws Throwable
	{
		String after_xpath = "_SummaryLink']";
		for (int i=0,j=2; i<lblSOMTakenDate.size()&&j<2+lblSOMTakenDate.size(); i++,j++) 
		{
			if (testDate.equals(lblSOMTakenDate.get(i).getText())) 
			{
				if(i<8)
				{
					driver.findElement(By.xpath(before_xpath+"0"+j+after_xpath)).click();
				}
				else
				{
					driver.findElement(By.xpath(before_xpath+j+after_xpath)).click();
				}
				break;
			}
		}
		return new SOMSummaryPage();
	}
}
