package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.nwnt.qa.base.Testbase;

public class SOMOverallResultPage extends Testbase
{
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()= 'Home']")
	WebElement menuHome;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()= 'About Us']")
	WebElement menuAboutUs;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()= 'Stress-o-meter']")
	WebElement menuSOM;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()= 'Media']")
	WebElement menuMedia;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()= 'Behavioural Disorders']")
	WebElement menuBehaviouralDisorders;
	
	@FindBy(xpath="//ul[@id='UlTopNav']//a[text()= 'Contact']")
	WebElement menuContact;
	
	@FindBy(xpath="//div[@id='ctl00_LogoStyle']/a/img")
	WebElement logoImg;
	
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_ResultCaptionLabel']")
	WebElement lblResultCaption;
	

	public SOMOverallResultPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkLandingPage()
	{
		Assert.assertTrue(lblResultCaption.getText().contains("Your Result"), "Oppps!!!! User is not landed on Overall Result Page.");
	}
	
}
