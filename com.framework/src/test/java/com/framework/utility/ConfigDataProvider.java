package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
 //constructor	
public ConfigDataProvider()
{
File src = new File("./Config/config.Properties");
try {
	FileInputStream fis = new FileInputStream(src);
    pro = new Properties();
	pro.load(fis);
}
catch (Exception e)
{
System.out.println("Unable to load config file :"+e.getMessage());	
} 
}

public String getDataFromConfig(String keyToSearch)
{
return pro.getProperty("keyToSearch");	
}

public String getConfigBrowser()
{
return pro.getProperty("Browser");	
}

public String getConfigAppURL()
{
return pro.getProperty("qaUrl");	
}
		
	
}
