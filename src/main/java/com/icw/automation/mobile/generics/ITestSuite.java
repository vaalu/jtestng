/**
 * 
 */
package com.icw.automation.mobile.generics;

import com.aventstack.extentreports.ExtentReports;

/**
 * 
 */
public interface ITestSuite {
	void init();
	void test();
	String getName();
	String getId();
	ExtentReports getReporting();
	void setReporting(ExtentReports reporting);
}
