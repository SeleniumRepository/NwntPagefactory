package com.nwnt.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwnt.qa.base.Testbase;

public class PrintPrescriptionsPage extends Testbase
{
	@FindBy(xpath="//input[@id='bntMail']")
	WebElement btnSendMail;
	
	@FindBy(xpath="//input[@id='BtnPrint']")
	WebElement BtnPrint;
	
	@FindBy(xpath="//input[@id='btnIpad']")
	WebElement btnIpad;
	
	String parentWindowId=null;
	String childWindowId=null;
	
	public PrintPrescriptionsPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	
	public Alert switchToAlert()
	{
		Alert alertbox = driver.switchTo().alert();
		return alertbox;
	}
	
	public void getAlertMessage()
	{
		switchToAlert().getText();
	}
	
	public void switchToParentWindow()
	{
		Set<String> windowHandler = driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		parentWindowId = it.next();
		childWindowId = it.next();
		driver.switchTo().window(parentWindowId);
	}
	
	public void switchToChildWindow()
	{
		Set<String> windowHandler = driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		parentWindowId = it.next();
		childWindowId = it.next();
		driver.switchTo().window(childWindowId);
	}
	
	public void acceptAlert()
	{
		switchToAlert().accept();
	}
	
	public void dismissAlert()
	{
		switchToAlert().dismiss();
	}
	
	public void clickBtnSendEmail()
	{
		btnSendMail.click();
	}
	
	public void clickBtnPrint()
	{
		BtnPrint.click();
	}
	
	public void clickBtnIpad()
	{
		btnIpad.click();
	}
}
