/**
 * 
 */
package com.icw.automation.mobile.generics;

import com.aventstack.extentreports.ExtentReports;

/**
 * 
 */
public interface IWorkflow {
	void init();
	void test();
	void addStep(ITestStep step);
	void setStepExecutor(IStepExecution stepExecutor);
	/**
	 * @return the generatedEmail
	 */
	String getGeneratedEmail();
	/**
	 * @param generatedEmail the generatedEmail to set
	 */
	void setGeneratedEmail(String generatedEmail);
	/**
	 * @return the accessToken
	 */
	String getAccessToken();
	/**
	 * @param accessToken the accessToken to set
	 */
	void setAccessToken(String accessToken);
	/**
	 * @return the reporting
	 */
	public ExtentReports getReporting();
	/**
	 * @param reporting the reporting to set
	 */
	public void setReporting(ExtentReports reporting);
}
