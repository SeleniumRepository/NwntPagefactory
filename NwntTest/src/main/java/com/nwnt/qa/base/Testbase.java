package com.nwnt.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nwnt.qa.util.TestUtil;

public class Testbase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase() throws Throwable
	{
		try
		{
		prop = new Properties();
		//FileInputStream ip = new FileInputStream("D:\\Amritesh\\Selenium\\Workspace\\NwntTest\\src\\main\\java\\com\\nwnt\\qa\\config\\config.properties");		
		FileInputStream ip = new FileInputStream("D:\\Amritesh\\Selenium\\git\\NWNTAutomation\\NwntPagefactory\\NwntTest\\src\\main\\java\\com\\nwnt\\qa\\config\\config.properties");
		prop.load(ip); 
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		System.out.println("Initializing webdriver.");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Amritesh\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Amritesh\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	

}
