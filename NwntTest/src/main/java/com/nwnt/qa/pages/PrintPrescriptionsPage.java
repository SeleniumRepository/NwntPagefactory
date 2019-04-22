package com.nwnt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintPrescriptionsPage 
{
	@FindBy(xpath="//input[@id='bntMail']")
	WebElement bntMail;
	
	@FindBy(xpath="//input[@id='BtnPrint']")
	WebElement BtnPrint;
	
	@FindBy(xpath="//input[@id='btnIpad']")
	WebElement btnIpad;
	
}
