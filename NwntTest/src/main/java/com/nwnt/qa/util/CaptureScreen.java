package com.nwnt.qa.util;

import java.io.File;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestResult;

import com.nwnt.qa.base.Testbase;

public class CaptureScreen
{

	public void takeScreenSnap()
	{
		try 
		{
		File srcFile = ((TakesScreenshot)Testbase.driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:\\Amritesh\\Selenium\\Screenshot\\"+Testbase.driver.getTitle()+".png");
		FileUtils.getFileUtils().copyFile(srcFile, destFile);
		} catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/*public void takeFailureSnap(ITestResult result)
	{
		try
		{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println(result.getStatus());
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.getFileUtils().copyFile(scrFile, new File("D:\\Amritesh\\Selenium\\Screenshot\\"+driver.getTitle()+".png"));
		}
	}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		}*/
}
