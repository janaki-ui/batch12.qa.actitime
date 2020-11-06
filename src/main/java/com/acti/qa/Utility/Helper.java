package com.acti.qa.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Helper extends com.acti.qa.Base.DriverScript {
	
	public static void highLightElement(WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",ele);
	}
	
	public static String takeScreenShot(WebDriver driver, String sshot)
	{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String dest=System.getProperty("user.dir") + ".//aReports/screenshots/" + sshot + ".png";
			File finalDestination = new File(dest);
			try {
				FileUtils.copyFile(src, finalDestination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Returns the captured file path
			return dest;
	}


}
