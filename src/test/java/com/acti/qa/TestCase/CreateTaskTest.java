package com.acti.qa.TestCase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;



public class CreateTaskTest extends TestBase {
	
	@Test
	public void testCreateTask() throws Exception
	{
		test=extent.createTest("Creating New Task");
		lp.login("admin", "manager");
		test.log(Status.PASS, "Logged in Successfully");
		et.clickTaskMenu();
		test.log(Status.PASS, "Click on Task Menu");
		tp.clickAddNewBtn();
		test.log(Status.PASS, "Click on Add New Button");
		tp.clickAddNewCustomer();
		test.log(Status.PASS, "Click on Add New Customer");
		tp.enterCustomerName("shantosh");
		test.log(Status.PASS, "Click on Entered Customer Name");
		tp.enterCustDescription("Dummy Cutomer Created for Testing Purpsose");
		test.log(Status.PASS, "Click on Entered Customer Description");
		tp.clickCreateCustomer();
		test.log(Status.PASS, "Clicked on Customer Button");
		Thread.sleep(3000);
     	et.clickLogout();
     	test.log(Status.PASS, "Click logout");
	}

}
