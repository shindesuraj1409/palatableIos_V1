package com.palatable.ios.pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ErrorPopup 
{
	IOSDriver driver;
	public ErrorPopup(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(accessibility = "OK")
	static IOSElement ok_button;
	
	public static void ok_tap()
	{
		if(ok_button.isEnabled())
		{
			ok_button.click();	
		}
		
	
	}

}
