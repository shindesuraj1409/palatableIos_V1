package com.palatable.ios.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WelcomeScreen 
{
	IOSDriver driver;
	public WelcomeScreen(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(name ="GET STARTED")
	IOSElement get_started;
	
	@FindBy(name="I HAVE AN ACCOUNT")
	IOSElement i_have_account;
	
	public void tap_get_started()
	{
		get_started.click();
	}
	
	public void tap_i_have_account() 
	
	{
		if(i_have_account.isEnabled())
		{
		i_have_account.click();
		}
	}
}
