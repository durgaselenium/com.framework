package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage {
 WebDriver driver;
 
public LogOutPage(WebDriver ldriver)
{
  this.driver=ldriver;	
}
	
@FindBy(xpath="//a[text()='Log Out']")WebElement btnLogOut;
	
public void verifyLogOutPage()
{
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	
}	
	
btnLogOut.click();	
}
	
}
