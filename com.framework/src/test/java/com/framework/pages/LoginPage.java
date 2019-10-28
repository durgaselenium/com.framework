package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
 WebDriver driver;
 
public LoginPage(WebDriver ldriver)
{
  this.driver=ldriver;
}
	
 @FindBy(xpath="//input[@type='email']")WebElement username;
 @FindBy(xpath="//input[@name='pass']")WebElement password;
 @FindBy(xpath="//input[@value='Log In']")WebElement btnLogin;
	
 public void verifyLoginPage(String uid,String pass)
 {
 try {
	Thread.sleep(3000);
}
 catch (InterruptedException e)
 {
	
}	 
  username.sendKeys(uid);
  password.sendKeys(pass);
  btnLogin.click();
 }
	
	
}
