/**
 * 
 */
package com.icw.automation.mobile.drivers.impl;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icw.automation.mobile.generics.util.PropertiesUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * 
 */
@Component
public class AndroidAppiumDriver {
	
	@Autowired
	PropertiesUtil props;
	
	public AppiumDriver getDriver() {
		DesiredCapabilities capabilities = getCapabilities();
		AppiumDriver driver = new AndroidDriver(capabilities);
		return driver;
	}
	private DesiredCapabilities getCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", props.getAndroidPlatform());
		capabilities.setCapability("appium:platformVersion", props.getAndroidVersion());
		capabilities.setCapability("appium:deviceName", props.getAndroidDeviceName());
		capabilities.setCapability("appium:automationName", props.getAndroidAutomationName());
		capabilities.setCapability("appium:appPackage", props.getAndroidAppPackage());
		capabilities.setCapability("appium:appActivity", props.getAndroidActivity());
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);
		return capabilities;
	}
}
