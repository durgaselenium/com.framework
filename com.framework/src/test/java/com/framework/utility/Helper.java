package com.framework.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

public static String  capturedScreenshot(WebDriver driver)
{
File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String Screenshotpath = System.getProperty("user.dir")+"./Screenshots/faceBook_"+getCurrentDateTime()+".png";
try {
	FileHandler.copy(src, new File(Screenshotpath));
}
catch (IOException e)
{
 System.out.println("Unable to Captured Screenshot:"+e.getMessage());	
}
return Screenshotpath;	

}

public static String getCurrentDateTime()
{
DateFormat customeDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
Date currentDate = new Date();
return customeDate.format(currentDate);
}
	
	
}
