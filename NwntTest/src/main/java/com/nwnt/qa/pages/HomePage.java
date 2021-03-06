package com.nwnt.qa.pages;

//import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nwnt.qa.base.Testbase;

public class HomePage extends Testbase
{ 
	@FindBy(xpath="//a[contains(text(),'Home')]//ancestor::div[@class='tpmnus']")
	WebElement menu_home;
	
	//@FindBy(xpath="//a[contains(text(),'Your Profile')]//ancestor::div[@class='tpmnus']")
	@FindBy(xpath="//div[@class='tpmnus']//a[contains(text(), 'Your Profile')]")
	WebElement menu_yourProfile;
	
	//@FindBy(xpath="//a[contains(text(),'Change Password')]//ancestor::div[@class='tpmnus']")
	//@FindBy(xpath="//div[@class='tpmnus']//a[contains(text(), 'Change Password')]")
	@FindBy(xpath="//a[contains(text(), 'Change Password')]")
	WebElement menu_changePassword;
	
	//@FindBy(xpath="//a[contains(text(),'Appointments')]//ancestor::div[@class='tpmnus']")
	@FindBy(xpath="//div[@class='tpmnus']//a[contains(text(), 'Appointments')]")
	WebElement menu_appointments;
	
	//@FindBy(xpath="//a[contains(text(),'Logout')]//ancestor::div[@class='tpmnus']")
	@FindBy(xpath="//div[@class='tpmnus']//a[contains(text(), 'Logout')]")
	WebElement menu_logout;
	
	@FindBy(id="ctl00_Logo")
	WebElement logoImage_lnk;
	
	@FindBy(id="ctl00_CenterAreaHolder_DropDownListSearchBy")
	WebElement searchBy_DD;
	
	@FindBy(id="ctl00_CenterAreaHolder_TextBoxSearchedValue")
	WebElement txtSearchValue;
	
	@FindBy(id="ctl00_CenterAreaHolder_TxtStartDate") 
	WebElement txtStartDate;
	
	@FindBy(id="ctl00_CenterAreaHolder_CalExtSatrtDate_popupDiv")
	WebElement startDate_popup;
	
	@FindBy(id="ctl00_CenterAreaHolder_CalExtSatrtDate_prevArrow")
	WebElement cal_btn_prev;
	
	/*@FindBy(id="")
	WebElement cal_btn_next;*/
	
	@FindBy(id="ctl00_CenterAreaHolder_CalExtSatrtDate_title") 
	WebElement cal_title;
	
	@FindBy(id="ctl00_CenterAreaHolder_TxtEnddate")
	WebElement txtEndDate;
	
	@FindBy(id="ctl00_CenterAreaHolder_ClearSearchCriteriaButton")
	WebElement btnClearSearchCriteria;
	
	@FindBy(id="ctl00_CenterAreaHolder_BtnSearch")
	WebElement btnSearch;
	
	@FindBy(id="ctl00_CenterAreaHolder_BtnAddNewVisitor")
	WebElement btnAddNewVisitor;
	
	@FindBy(id="ctl00_CenterAreaHolder_lblTotalRecord")
	WebElement lblTotalRecordsCount;
	
	@FindBy(xpath="//div[@class='btmmnus']//td")
	WebElement lblCopyrightText;
	
	@FindBy(xpath="//a//parent::td//ancestor::tr[@class='tbl-footer']")
	WebElement btnPageNo;
	
	
	int cal_year;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions action = new Actions(driver);
	//Initialize the elements
	public HomePage() throws Throwable
	{
		PageFactory.initElements(driver, this);
	}

	//**Actions**
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	//to verify the Logo image on page
	public boolean verifyLogoImage()
	{
		return logoImage_lnk.isDisplayed();
	} 
	
	//to access the Your profile page
	public YourProfilePage clickYourProfileLink() throws Throwable
	{
		menu_yourProfile.click();
		return new YourProfilePage();
	}
	
	//to access the Change Password page
	public ChangePasswordPage clickChangePassword() throws Throwable
	{
		menu_changePassword.click();
		return new ChangePasswordPage();
	}
	
	//to access the Appointments page
	public AppointmentPage clickAppointment() throws Throwable
	{
		menu_appointments.click();
		return new AppointmentPage();
	}
	
	//to Logout from application
	public LoginPage clickLogout() throws Throwable
	{
		menu_logout.click();
		return new LoginPage();
	}
	
	//select value from dropdown
	public void selectSearchCriteria(String searchBy, String criteria)
	{ 
		Select selectValue = new Select(searchBy_DD);
		selectValue.selectByVisibleText(searchBy);
		String selectedValue = selectValue.getFirstSelectedOption().getText();
		if(searchBy.trim().equals(selectedValue))//||value.contains("Apollo ID")||value.contains("First Name")||value.contains("Email")||value.contains("Mobile Number")||value.contains("Registration Number")||value.contains("UID Number"))
		{
			txtSearchValue.clear();
			txtSearchValue.sendKeys(criteria);
		}
		else if(searchBy.trim().equals(selectedValue))
		{
			txtSearchValue.clear();
			txtSearchValue.sendKeys(criteria);
		}
		else if(searchBy.trim().equals(selectedValue))
		{
			txtSearchValue.clear();
			txtSearchValue.sendKeys(criteria);
		}
		else if(searchBy.trim().equals(selectedValue))
		{
			txtSearchValue.clear();
			txtSearchValue.sendKeys(criteria);
		}
		else if(searchBy.trim().equals(selectedValue))
		{
			txtSearchValue.clear();
			txtSearchValue.sendKeys(criteria);
		}
		else if(searchBy.trim().equals(selectedValue))
		{
			txtSearchValue.clear();
			txtSearchValue.sendKeys(criteria);
		}
		else if(searchBy.trim().equals(selectedValue))
		{
			txtSearchValue.clear();
			txtSearchValue.sendKeys(criteria);
		}
		/*else if(searchBy.trim().equals("Registration Date"))
		{
			//Select start date from calender popup
			txtStartDate.click();
			selectGivenDate("21-Jan-2019");
			
			//Select end date from calender popup
			txtEndDate.click();
			selectGivenDate("11-Feb-2019");
		}*/
		else if(searchBy.trim().equals(selectedValue))
		btnSearch.click();
		btnSearch.click();
	}
	
	//check the visitor profile
	public void checkVisitorProfile()
	{
		/*//id='ctl00_CenterAreaHolder_GridUsers_ctl04_hlnkFullName'
		String before_xpath="//[@id='ctl00_CenterAreaHolder_GridUsers_ct";
		String after_xpath="_hlnkFullName']";
		for(int i=102; i>=116; i++)
		{
			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			if(name.contains(visitorName))
			{
				driver.findElement(By.xpath(before_xpath+i+after_xpath)).click();
				break;
			}
		}*/
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//tr/td/a"));
		/*String before_xpath="//[@id='ctl00_CenterAreaHolder_GridUsers_ct";
		String after_xpath="_hlnkFullName']";*/
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//Actions action = new Actions(driver);
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
						
			//for(int r=102; r<=116; r++)
			//{
				//List <WebElement> visitorsName = driver.findElements(By.xpath(before_xpath+r+after_xpath));
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						visitorsName.get(i).click();
						existMain=true;
						break;
					}
					
				}
				
				if(existMain!=true)//(pageTab.get(p).getTagName()).equalsIgnoreCase("a")&& 
				{
					js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
					action.moveToElement(pageTab.get(p)).click().build().perform();	
				}
				else
					break;
				
				/*try {//find all webelements pagewise and 1. getText() of each element and match with required
					WebElement ele = driver.findElement(By.xpath("//a[contains(text(), 'Mrs. Suman Bansal')]"));
					if(ele.isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", ele);
						ele.click();
						break;
					}
					else
					{
						pageTab.get(p+1).click();	
					}
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			//}
		}
		//js.executeScript("window.scrollBy(0,500)","");
		
	}
	
	//Select Given Date Criteria
	public void selectGivenDate(String given_date)
	{
		//String given_date = "21-Jan-2019";
		String[] given_ddmmmyyyy = given_date.split("-");
		int given_day = Integer.parseInt(given_ddmmmyyyy[0]);
		String given_month = given_ddmmmyyyy[1];
		int given_year = Integer.parseInt(given_ddmmmyyyy[2]);
		/*LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();*/
		driver.switchTo().frame(startDate_popup); 
		String month_year_title = cal_title.getText();
		String[] month_year_text = month_year_title.split(", ");
		String selected_month = month_year_text[0].substring(0, 3);
		int selected_year = Integer.parseInt(month_year_text[1]);
		if(selected_year!=given_year)
		{
			int diff_year=selected_year-given_year;
			cal_title.click();
				//List<WebElement> all_years = driver.findElements(By.xpath("//tbody[@id='ctl00_CenterAreaHolder_CalExtSatrtDate_yearsBody']//div[@class='ajax__calendar_year']"));
				for(int i=0;i<diff_year;i++)
				{
					cal_btn_prev.click();
				}
		}
		
			/*if(selected_year<currentYear)
			{
				cal_title.click();
				cal_title.click();//ctl00_CenterAreaHolder_CalExtSatrtDate_body   
				do
				{
					List<WebElement> all_years = driver.findElements(By.xpath("//tbody[@id='ctl00_CenterAreaHolder_CalExtSatrtDate_yearsBody']//div[@class='ajax__calendar_year']"));
					for(int i=0;i<all_years.size();i++)
					{
						int cal_year = Integer.parseInt(all_years.get(i).getText());
						if(given_year==cal_year)
						{
							all_years.get(i).click();
							break;
						}
					}
					cal_btn_prev.click();
				}
				while(given_year!=cal_year);    
			}*/
		
		else if(!selected_month.equals(given_month))
		{
			List<WebElement> all_months = driver.findElements(By.xpath("//tbody[@id='ctl00_CenterAreaHolder_CalExtSatrtDate_monthsBody']//div[@class='ajax__calendar_month']"));
			for(int i=0;i<all_months.size();i++)
			{
				String cal_month = all_months.get(i).getText();
				if(given_month.equals(cal_month))
				{
					all_months.get(i).click();
					break;
				}
			}
		}
		else
		{
			List<WebElement> all_days = driver.findElements(By.xpath("//tbody[@id='ctl00_CenterAreaHolder_CalExtSatrtDate_daysBody']//td[not(contains(@class, 'ajax__calendar_other'))]"));
			for(int i=0;i<all_days.size();i++)
			{
				int cal_day = Integer.parseInt(all_days.get(i).getText());
				if(given_day==cal_day)
				{
					all_days.get(i).click();
					break;
				}
			}
		}
	}
	
	//Click "Assign Appointment" Button
	public AssignAppointmentPage clickBtnAssignAppointment() throws Throwable
	{
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//a"));
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						String fullNameId = visitorsName.get(i).getAttribute("id");
						String strAssignAppointmentId = fullNameId.replace(fullNameId.substring(fullNameId.lastIndexOf("_")+1), "BtnFutureAppointment");
						if(driver.findElement(By.id(strAssignAppointmentId)).isDisplayed())
						driver.findElement(By.id(strAssignAppointmentId)).click();
						existMain=true;
						break;
					}
				}
				if(!existMain)//(pageTab.get(p).getTagName()).equalsIgnoreCase("a")&& 
				{
					js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
					action.moveToElement(pageTab.get(p)).click().build().perform();
				}
				else
					break;
		}
		return new AssignAppointmentPage();
	}
	
	//Click "Stress-o-meter Test" Button
	public UserSOMDetailPage clickBtnSOMtest() throws Throwable
	{
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//a"));
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						String fullNameId = visitorsName.get(i).getAttribute("id");
						
						String strBtnSOMtestId = fullNameId.replace(fullNameId.substring(fullNameId.lastIndexOf("_")+1), "btnSomtest");
						if(driver.findElement(By.id(strBtnSOMtestId)).isDisplayed())
						driver.findElement(By.id(strBtnSOMtestId)).click();
						existMain=true;
						break;
					}
				}
				if(existMain!=true)//(pageTab.get(p).getTagName()).equalsIgnoreCase("a")&& 
				{
					try
					{
					js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
					action.moveToElement(pageTab.get(p)).click().build().perform();
					}catch(IndexOutOfBoundsException i)
					{
						i.getMessage();
					}
				}
				else
					break;
		}
		return new UserSOMDetailPage();
	}
	
	//Click "Advance Payment" Button
	public AdvancePaymentsPage clickBtnAdvancePayments() throws Throwable
	{
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//a"));
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						String fullNameId = visitorsName.get(i).getAttribute("id");
						String strBtnAdvancePaymentId = fullNameId.replace(fullNameId.substring(fullNameId.lastIndexOf("_")+1), "BtnAdvanceFee");
						if(driver.findElement(By.id(strBtnAdvancePaymentId)).isDisplayed())
						driver.findElement(By.id(strBtnAdvancePaymentId)).click();
						existMain=true;
						break;
					}
				}
				if(existMain!=true) 
				{
					try
					{
						js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
						action.moveToElement(pageTab.get(p)).click().build().perform();
					}catch(IndexOutOfBoundsException i)
					{i.getMessage();}	
				}
				else
					break;
		}
		return new AdvancePaymentsPage();
	}
	
	//Click "Print Prescriptions" Button
	public AllPrescriptionPage clickBtnPrintPrescriptions() throws Throwable
	{
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//a"));
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						String fullNameId = visitorsName.get(i).getAttribute("id");
						String strBtnPrintPrescriptionId = fullNameId.replace(fullNameId.substring(fullNameId.lastIndexOf("_")+1), "BtnPrint");
						if(driver.findElement(By.id(strBtnPrintPrescriptionId)).isDisplayed())
						driver.findElement(By.id(strBtnPrintPrescriptionId)).click();
						existMain=true;
						break;
					}
				}
				if(existMain!=true) 
				{
					try
					{
					js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
					action.moveToElement(pageTab.get(p)).click().build().perform();	
					}catch(IndexOutOfBoundsException i)
					{i.getMessage();}
				}
				else
					break;
		}
		return new AllPrescriptionPage();
	}
	
	//Click "Print Previous Receipts" Button
	public ViewPreviousPayReceiptsPage clickBtnPrintPreviousReceipts() throws Throwable
	{
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//a"));
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						String fullNameId = visitorsName.get(i).getAttribute("id");
						String strBtnPrintPreviousReceiptsId = fullNameId.replace(fullNameId.substring(fullNameId.lastIndexOf("_")+1), "btnAccounts");
						if(driver.findElement(By.id(strBtnPrintPreviousReceiptsId)).isDisplayed())
						driver.findElement(By.id(strBtnPrintPreviousReceiptsId)).click();
						existMain=true;
						break;
					}
				}
				if(existMain!=true) 
				{
					try {
					js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
					action.moveToElement(pageTab.get(p)).click().build().perform();	
					}catch(IndexOutOfBoundsException i)
					{i.getMessage();}
				}
				else
					break;
		}
		return new ViewPreviousPayReceiptsPage();
	}
	
	//Click "View Open Appointments" Button
	public ViewOpenAppointmentsPage clickBtnViewOpenAppointments()
	{
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//a"));
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						String fullNameId = visitorsName.get(i).getAttribute("id");
						String strBtnViewOpenAppointmentsId = fullNameId.replace(fullNameId.substring(fullNameId.lastIndexOf("_")+1), "btnOpenAppointments");
						if(driver.findElement(By.id(strBtnViewOpenAppointmentsId)).isDisplayed())
						driver.findElement(By.id(strBtnViewOpenAppointmentsId)).click();
						existMain=true;
						break;
					}
				}
				if(existMain!=true) 
				{
					try {
					js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
					action.moveToElement(pageTab.get(p)).click().build().perform();
					}catch(IndexOutOfBoundsException i)
					{i.getMessage();}
				}
				else
					break;
		}
		return new ViewOpenAppointmentsPage();
	}
	
	//Click "Upload Prescriptions" Button
	public UploadPrescriptionsPage clickBtnUploadPrescriptions() throws Throwable
	{
		List<WebElement> pageTab = driver.findElements(By.xpath("//tr[@class='tbl-footer']//a"));
		boolean existMain=false;
		for(int p=0; p<=pageTab.size(); p++)
		{
			if(existMain)
			{break;}
				List <WebElement> visitorsName = driver.findElements(By.xpath("//table[@class='tbl-data']/tbody/tr[not(contains(@class, 'tbl-footer'))]//a"));
				
				for(int i=0; i<visitorsName.size(); i++)
				{
					if(prop.getProperty("visitorname").equals(visitorsName.get(i).getText()) && visitorsName.get(i).isDisplayed()==true)
					{
						js.executeScript("arguments[0].scrollIntoView();", visitorsName.get(i));
						String fullNameId = visitorsName.get(i).getAttribute("id");
						String strBtnUploadPrescriptions = fullNameId.replace(fullNameId.substring(fullNameId.lastIndexOf("_")+1), "btnUploadReport");
						if(driver.findElement(By.id(strBtnUploadPrescriptions)).isDisplayed())
						driver.findElement(By.id(strBtnUploadPrescriptions)).click();
						existMain=true;
						break;
					}
				}
				if(existMain!=true) 
				{
					try {
					js.executeScript("arguments[0].scrollIntoView();", pageTab.get(p));
					action.moveToElement(pageTab.get(p)).click().build().perform();
					}catch(IndexOutOfBoundsException i)
					{i.getMessage();}
				}
				else
					break;
		}
		return new UploadPrescriptionsPage();
	}
	
}
