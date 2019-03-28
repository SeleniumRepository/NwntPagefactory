package com.nwnt.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.nwnt.qa.base.Testbase;

public class CaptureScreen
{

	public void takeScreenSnap() throws IOException
	{
		
		File srcFile = ((TakesScreenshot)Testbase.driver).getScreenshotAs(OutputType.FILE);
		//File destFile = new File("D:\\Amritesh\\Selenium\\Screenshot\\"+Testbase.driver.getTitle()+".png");
		File destFile = new File("D:\\Amritesh\\Selenium\\Screenshot\\"+System.currentTimeMillis()+".png");
		FileUtils.getFileUtils().copyFile(srcFile, destFile);
		
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
