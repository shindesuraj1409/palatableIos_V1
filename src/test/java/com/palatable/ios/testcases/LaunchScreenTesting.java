package com.palatable.ios.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.palatable.ios.pageobjects.ErrorPopup;
import com.palatable.ios.pageobjects.LoginSceen;
import com.palatable.ios.pageobjects.WelcomeScreen;

public class LaunchScreenTesting extends BaseClass
{
	
	
	@Test(enabled=false)
	public void get_started_check()
	{
		WelcomeScreen ls=new WelcomeScreen(driver);
		
		ls.tap_get_started();
				
	}
	
	@Test(enabled=false)
	public void invalid_user_signin() throws InterruptedException
	{
		WelcomeScreen ws=new WelcomeScreen(driver);
		LoginSceen ls= new LoginSceen(driver);
		
		ws.tap_i_have_account();
		ls.email_input("email");
		ls.password_input("password");
		driver.hideKeyboard(); //hide the keyboard
		ls.singin_tap();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		//ErrorPopup.ok_tap();
		ls.backkey_loginscreen();
	}
	
	@Test(enabled=false)
	public void check_signup_screens() throws InterruptedException
	{
		WelcomeScreen ws=new WelcomeScreen(driver);
		LoginSceen ls= new LoginSceen(driver);
		
		ws.tap_i_have_account();
		ls.signup_tap();
		Thread.sleep(3000);
		ls.backkey_loginscreen();
		
	}
	
	@Test(enabled=true)
	public void check_facebook_links() throws InterruptedException
	{
		WelcomeScreen ws=new WelcomeScreen(driver);
		//sws.tap_get_started();

		driver.findElement(By.xpath("//*[@text='GET STARTED' and @class='UIAButton']")).click();
		log.info("Get Started Clicked");
        driver.findElement(By.xpath("//*[@text='backGreen']")).click();
        log.info("Back key clicked");
        driver.findElement(By.xpath("//*[@text='GET STARTED' and @class='UIAButton']")).click();
        log.info("Clicked Get Started");
        driver.findElement(By.xpath("//*[@text='Next' and @class='UIAButton']")).click();
        log.info("Next button clicked");
        driver.findElement(By.xpath("//*[@text='Skip' and @class='UIAButton']")).click();
        log.info("Skip button clicked");
		
	}

}
