package com.nwnt.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.nwnt.qa.base.Testbase;

public class PrintPreviousPayReceiptPage extends Testbase
{
	String parentWindowId;
	String childWindowId;

	public PrintPreviousPayReceiptPage() throws Throwable 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void closePrinterPage() throws Exception
	{
		//Create the object of screen class - Sikuli
		Screen s = new Screen();
		//click button Cancel on the printer page
		Pattern patt = new Pattern("D:\\Amritesh\\Selenium\\git\\NWNTAutomation\\NwntPagefactory\\NwntTest\\src\\main\\java\\com\\nwnt\\qa\\sikuliObjects\\CancelPrintPrescription.PNG");
		s.wait(patt, 2000);
		s.click();
	}
	
	public void switchToChildWindow()
	{
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		parentWindowId = it.next();
		childWindowId = it .next();
		driver.switchTo().window(childWindowId);
		driver.close();
	}
}
