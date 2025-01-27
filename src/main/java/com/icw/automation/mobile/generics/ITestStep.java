/**
 * 
 */
package com.icw.automation.mobile.generics;

/**
 * 
 */
public interface ITestStep {

	void init();
	
	/**
	 * @return the workflow
	 */
	public String getWorkflow();
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier();

	/**
	 * @return the idType
	 */
	public String getIdType();
	
	/**
	 * @return the action
	 */
	public String getAction();
	
	/**
	 * @return the value
	 */
	public String getValue();
	
	/**
	 * @return the expected
	 */
	public String getExpected();
	
	/**
	 * @return the comments
	 */
	public String getComments();
	
	/**
	 * @return the stepTitle
	 */
	public String getStepTitle();

	/**
	 * @param stepTitle the stepTitle to set
	 */
	public void setStepTitle(String stepTitle);
}
