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
	public SOMOverallResultPage clickOverallResultOf(String testDate) throws Throwable
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
		return new SOMOverallResultPage();
	}
	
	//to check the Nature result click respective Nature result link 
	public void clickNatureResultOf(String testDate)
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
	}
	
	//to check the Circumstance result click respective Circumstance result link
	public void clickCircumsatncesResultOf(String testDate)
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
	}
	
	//to check the Body&Mind result click respective Body&Mind result link 
	public void clickBodyAndMindResultOf(String testDate)
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
	}
	
	//to check the Home Life result click respective Home Life result link
	public void clickHomeLifeResultOf(String testDate)
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
	}
	
	//to check the Work result click respective work result link
	public void clickWorkResultOf(String testDate)
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
	}
	
	//to check the Questionnaire with option selection, click respective View link
	public void clickQuestionnaireResultOf(String testDate)
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
	}
	
	//to check the Questionnaire summary with selected option, click respective Summary link
	public SOMSummaryPage clickSummaryResultOf(String testDate) throws Throwable
	{
		if(lblSOMTakenDate.size()<=0)
			System.out.println("Yet, user didn't take any test.");
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
			else
				System.out.println("There is no taken SOM for given Date Criteria.");
		}
		return new SOMSummaryPage();
	}
}
