package com.acti.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.qa.Base.DriverScript;
import com.acti.qa.Utility.Helper;

public class TaskPage extends DriverScript {
	
	@FindBy(xpath="//div[@class='title ellipsis']") WebElement btnAddNew;
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement optAddNewCustomer;
//	@FindBy(xpath="//div[@class='customerNameDiv']//input[@placeholder='Enter Customer Name']") WebElement customerNametb;
	@FindBy(xpath="//div[@placeholder='Enter Customer Name']") WebElement customerNametb;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']") WebElement customerDestA;
	@FindBy(xpath="//div[contains(text(),'Create Customer')]") WebElement createCustbtn;

	public TaskPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddNewBtn()
	{
		Helper.highLightElement(btnAddNew);
		btnAddNew.click();
	}
	
	public void clickAddNewCustomer()
	{
		Helper.highLightElement(optAddNewCustomer);
		optAddNewCustomer.click();
	}
	
	public void enterCustomerName(String custName)
	{
		Helper.highLightElement(customerNametb);
		customerNametb.sendKeys(custName);
	}
	
	public void enterCustDescription(String custdes)
	{
		Helper.highLightElement(customerDestA);
		customerDestA.sendKeys(custdes);
	}
	
	public void clickCreateCustomer()
	{
		Helper.highLightElement(createCustbtn);
		createCustbtn.click();
	}
}
