/**
 * 
 */
package com.icw.automation.mobile.generics;

import io.appium.java_client.AppiumDriver;

/**
 * 
 */
public interface IStepExecution {
	void init();
	void perform(ITestStep testStep);
	AppiumDriver getDriver();
}
