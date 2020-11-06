package com.acti.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	public DriverScript()
	{
		//Inside this constructor i am going to load the properties file
		try
		{
			prop = new Properties();
			File src = new File(".//aConfiguration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Cannot Find the File "+e.getMessage());
		}
	}
	
	public static void initBrowser()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./aBrowsers/chromedriver.exe");
				driver=new ChromeDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String url = prop.getProperty("qaURL");
		driver.get(url);
	}
}









