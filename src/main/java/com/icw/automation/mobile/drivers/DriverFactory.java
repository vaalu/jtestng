/**
 * 
 */
package com.icw.automation.mobile.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icw.automation.mobile.drivers.impl.AndroidAppiumDriver;
import com.icw.automation.mobile.generics.util.PropertiesUtil;

import io.appium.java_client.AppiumDriver;

/**
 * 
 */
@Component
public class DriverFactory {
	
	@Autowired
	PropertiesUtil props;
	
	@Autowired
	AndroidAppiumDriver androidDriver;
	
	public AppiumDriver getDriver() {
		String driverType = props.getDriverType();
		switch (driverType) {
		case "android":
			return androidDriver.getDriver();
		default:
			return androidDriver.getDriver();
		}
	}
}
