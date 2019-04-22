package com.nwnt.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class SOMPaymentOptionPage extends Testbase 
{
	@FindBy(xpath="//ul[@id='UlTopNav']//a")
	List<WebElement> topMenuElement;
	
	@FindBy(xpath="//label[@id='ctl00_drp_username']")
	WebElement username;
	
	@FindBy(xpath="//a[@id='ctl00_lnklogout']")
	WebElement lnklogout;
	
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblfort']")
	WebElement lblSOMType;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_chkAcceptAgreement']")
	WebElement chkAcceptAgreement;
	
	@FindBy(xpath="//a[@class='lnk02']")
	WebElement lnkTermsCondition;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_PendingTestButton']")
	WebElement PendingTestButton;

	public SOMPaymentOptionPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}

}
