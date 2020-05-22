package com.palatable.ios.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.palatable.ios.utilites.ReadConfig;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass 
{
	ReadConfig rc= new ReadConfig();
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static IOSDriver<IOSElement> driver;
	public static Logger log;

	@BeforeTest
	public void setupAppium() throws MalformedURLException
	{
		
		log= Logger.getLogger("Platable");
		PropertyConfigurator.configure("log4j.properties");
		
		final String URL_STRING="http://localhost:4723/wd/hub";
		url=new URL(URL_STRING);
		capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,rc.get_deviceName());
		capabilities.setCapability(MobileCapabilityType.UDID, rc.get_udid());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, rc.get_platformName());
		capabilities.setCapability("xcodeOrgId", "MQ7X5VPF23");
		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
	 //capabilities.setCapability(MobileCapabilityType, "13.3.1");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, rc.get_platformVersion());
		capabilities.setCapability(MobileCapabilityType.APP, rc.get_app());
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability("updatedWDABundleId", "com.facebook123.WebDriverAgentLib");
		capabilities.setCapability("useNewWDA", false);
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		//capabilities.setCapability("xcodeConfigFile", "/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/node_modules/appium-webdriveragent/Config.xcconfig");
		driver = new IOSDriver<IOSElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
	@AfterTest
	public void uninstallApp() throws InterruptedException
	{
		//driver.resetApp();
	}
	
	public void captureScreen(IOSDriver  driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	

}
