package com.palatable.ios.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig() 
	{
		File src= new File("./Configurations/config.properties");
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
			
		}catch(Exception e)
		{
			System.out.println("Exceptio is:"+e.getMessage());
		}
		
		
	}
	public String get_deviceName()
	{
		String deviceName=pro.getProperty("deviceName");
		return deviceName;
	}
	
	public String get_udid()
	{
		String udid=pro.getProperty("udid");
		return udid;
	}
	
	public String get_platformName()
	{
		String platformName=pro.getProperty("platformName");
		return platformName;
	}
	
	public String get_platformVersion()
	{
		String platformVersion=pro.getProperty("platformVersion");
		return platformVersion;
	}
	
	public String get_app()
	{
		String app=pro.getProperty("app");
		return app;
	}
	
	
	
	
	
	
	

}
