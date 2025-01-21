/**
 * 
 */
package com.icw.automation.mobile.generics.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.icw.automation.mobile.generics.ITestSuite;
import com.icw.automation.mobile.generics.IWorkflow;
import com.icw.automation.mobile.generics.impl.defaults.DefaultStepExecution;

/**
 * 
 */
public abstract class AbstractTestSuite implements ITestSuite {

	private List<IWorkflow> workflows = new ArrayList<>();

	private String generatedEmail;
	private String accessToken;
	
	@Autowired
	DefaultStepExecution stepExecutor;
	
	public void test() {
		for (IWorkflow workflow : workflows) {
			workflow.test();
		}
	}
	public void addWorkflow(IWorkflow workflow) {
		workflow.setAccessToken(accessToken);
		workflow.setGeneratedEmail(generatedEmail);
		workflows.add(workflow);
	}
	/**
	 * @return the generatedEmail
	 */
	public String getGeneratedEmail() {
		return generatedEmail;
	}
	/**
	 * @param generatedEmail the generatedEmail to set
	 */
	public void setGeneratedEmail(String generatedEmail) {
		this.generatedEmail = generatedEmail;
	}
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
