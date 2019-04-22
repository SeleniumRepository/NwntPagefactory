package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class SOMSummaryPage extends Testbase
{
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()='Home']")
	WebElement menuHome;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()='About Us']")
	WebElement menuAboutUs;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()='Stress-o-meter']")
	WebElement menuSOM;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()='Media']")
	WebElement menuMedia;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()='Behavioural Disorders']")
	WebElement menuBehaviouralDisorders;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()='Contact']")
	WebElement menuContact;
	
	@FindBy(xpath="//div[@id='ctl00_LogoStyle']/a/img")
	WebElement topLogo;
	
	public SOMSummaryPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	
}
