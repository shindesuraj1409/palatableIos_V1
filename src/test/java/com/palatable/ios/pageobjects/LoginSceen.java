package com.palatable.ios.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginSceen 
{
	IOSDriver driver;
	public LoginSceen(IOSDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Identify the elements on the page
	@iOSFindBy(accessibility="emailID")
	IOSElement email_address;
	
	@iOSFindBy(accessibility = "password")
	IOSElement password;
	
	@FindBy(name="Forgot Password?")
	IOSElement forgout_passowrd_link;
	
	//Privacy and Terms and condition pending
	
	@FindBy(name="facebookButton")
	IOSElement facebookbutton;
	
	@FindBy(name="googlePlusLoginButton")
	IOSElement googlePlusLoginButton;
	
	@FindBy(name="Sign Up")
	IOSElement signup;
	
	@FindBy(name="SIGN IN")
	IOSElement signin;
	
	@FindBy(name="backGreen")
	IOSElement backKey_loginscreen;
	
	//Action methods
	public void email_input(String email)
	{
		email_address.sendKeys(email);
	}
	
	public void password_input(String password_string)
	{
		password.sendKeys(password_string);
	}
	
	public void forgot_pasword_tap()
	{
		forgout_passowrd_link.click();
	}
	
	public void facebook_tap()
	{
		facebookbutton.click();
	}
	
	public void google_button_tap()
	{
		googlePlusLoginButton.click();
	}
	
	public void signup_tap()
	{
		signup.click();
	}
	
	public void singin_tap()
	{
		signin.click();
	}
	
	public void backkey_loginscreen()
	{
		
		if(backKey_loginscreen.isEnabled())
		{
			backKey_loginscreen.click();	
		}
		
		
	}

}
