package com.acti.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.qa.Base.DriverScript;
import com.acti.qa.Utility.Helper;

public class LoginPage extends DriverScript {
	
	@FindBy(name="username") WebElement usernameTB;
	@FindBy(name="pwd") WebElement passwordTB;
	@FindBy(id="loginButton") WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String password)
	{
		Helper.highLightElement(usernameTB);
		usernameTB.sendKeys(un);
		Helper.highLightElement(passwordTB);
		passwordTB.sendKeys(password);
		Helper.highLightElement(loginBtn);
		loginBtn.click();
	}

}
