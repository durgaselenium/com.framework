package com.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework.pages.BaseClass;
import com.framework.pages.LogOutPage;
import com.framework.pages.LoginPage;
import com.framework.utility.BrowserFactory;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class FaceBookTest extends BaseClass {

@Test	
public void testFacebook()
{
     logger = report.createTest("Login to FaceBook");
LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
     logger.info("Starting Application");
//loginpage.verifyLoginPage("deviselenium663@gmail.com", "sridevi111");
loginpage.verifyLoginPage(excel.getStringData("login", 0,0),excel.getStringData("login", 0,1));
    logger.pass("Login Successfully");
LogOutPage logoutpage = PageFactory.initElements(driver, LogOutPage.class);
    logger.info("Logout Starting Application");
logoutpage.verifyLogOutPage();
    logger.fail("LogOut Successfully");
Helper.capturedScreenshot(driver);
}

}
