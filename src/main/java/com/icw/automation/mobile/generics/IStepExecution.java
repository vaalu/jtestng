/**
 * 
 */
package com.icw.automation.mobile.generics;

import com.aventstack.extentreports.ExtentReports;

import io.appium.java_client.AppiumDriver;

/**
 * 
 */
public interface IStepExecution {
	void init();
	void perform(ITestStep testStep);
	AppiumDriver getDriver();
	/**
	 * @return the reporting
	 */
	public ExtentReports getReporting();
	/**
	 * @param reporting the reporting to set
	 */
	public void setReporting(ExtentReports reporting);
}
