package com.acti.qa.TestCase;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.acti.qa.Base.DriverScript;
import com.acti.qa.Pages.EnterTimePage;
import com.acti.qa.Pages.LoginPage;
import com.acti.qa.Pages.TaskPage;
import com.acti.qa.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase extends DriverScript {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent ;
	ExtentTest test;
	
	LoginPage lp;
	EnterTimePage et;
	TaskPage tp;

	public TestBase() {
		super();
	}

	@BeforeSuite
	public void startTest() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/aReports/Automation.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", "Windows10");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("ActiTime Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@BeforeMethod
	public void preTest() {
		initBrowser();
		lp = new LoginPage();
		et = new EnterTimePage();
		tp = new TaskPage();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			String screenShotPath = Helper.takeScreenShot(driver, "sshot");
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Failed due to", ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("Snapshot below: " +
			test.addScreenCaptureFromPath(screenShotPath));
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Passed ", ExtentColor.GREEN));
		}
	}
	
	/*@AfterMethod
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),ExtentColor.YELLOW));
		}
	}
	*/

	@AfterSuite
	public void tearDown() 
	{
		extent.flush();
	}
}