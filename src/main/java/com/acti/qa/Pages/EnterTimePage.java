package com.acti.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.qa.Base.DriverScript;
import com.acti.qa.Utility.Helper;


public class EnterTimePage extends DriverScript {
	
	@FindBy(id="logoutLink") WebElement logOutLnk;
	@FindBy(xpath="//a[@class='content tasks']") WebElement menuTask;
	
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogout()
	{
		Helper.highLightElement(logOutLnk);
		logOutLnk.click();
	}
	
	public void clickTaskMenu()
	{
		Helper.highLightElement(menuTask);
		menuTask.click();
	}

}
