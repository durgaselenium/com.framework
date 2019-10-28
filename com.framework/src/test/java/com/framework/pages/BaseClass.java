package com.framework.pages;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Utilities;

import org.omg.PortableServer.RequestProcessingPolicyOperations;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.utility.BrowserFactory;
import com.framework.utility.ConfigDataProvider;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class BaseClass {
 public  WebDriver driver;
 public ExcelDataProvider excel;
 public ConfigDataProvider config;
 public ExtentReports report;
 public ExtentTest logger;
 
 @BeforeSuite
 public void setUpSuit()
 {
	Reporter.log("Setting up Reports and Test is getting ready", true);
 excel = new ExcelDataProvider();
 config = new ConfigDataProvider();
 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FaceBook_"+Helper.getCurrentDateTime()+".html"));
 report = new ExtentReports();
 report.attachReporter(extent);
   Reporter.log("Setting Done-Test can be started", true);
 }
 
@BeforeClass	
public void setUp()
{
	 Reporter.log("Trying to start Browser and Getting Application ready", true);
 //driver = BrowserFactory.startApplication(driver,"chrome","https://www.facebook.com/");	
 driver = BrowserFactory.startApplication(driver,config.getConfigBrowser(),config.getConfigAppURL());
    Reporter.log("Browser and Application is up and running", true);
}

@AfterClass
public void tearDown()
{
 BrowserFactory.closeBrowser(driver);	
}

@BeforeMethod
public void tearDownMethod(ITestResult result) throws IOException
{
	Reporter.log("Test is about to end", true);
if (result.getStatus()==ITestResult.FAILURE)
{
//Helper.capturedScreenshot(driver);
//failed screenshot add on reports
 logger.pass("TestCase fail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturedScreenshot(driver)).build());		
}
else if (result.getStatus()==ITestResult.SUCCESS)
{
logger.fail("TestCase pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturedScreenshot(driver)).build());	
}
report.flush();
Reporter.log("Test Completed>>>>Reports Generated", true);
}
	

}
