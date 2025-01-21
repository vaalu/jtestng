/**
 * 
 */
package com.icw.automation.mobile.generics;

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
}
