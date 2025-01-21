/**
 * 
 */
package com.icw.automation.mobile.generics.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.icw.automation.mobile.generics.IStepExecution;
import com.icw.automation.mobile.generics.ITestStep;
import com.icw.automation.mobile.generics.IWorkflow;
import com.icw.automation.mobile.generics.impl.defaults.DefaultStepExecution;
import com.icw.automation.mobile.generics.util.ExcelUtils;
import com.icw.automation.mobile.generics.util.WorkflowUtil;

/**
 * 
 */
public abstract class AbstractWorkflow implements IWorkflow {

	@Autowired
	protected WorkflowUtil util;
	
	@Autowired
	protected ExcelUtils excelUtil;
	
	@Autowired
	DefaultStepExecution stepExecution;
	
	private IStepExecution stepExecutor;
	
	private String generatedEmail;
	private String accessToken;
	
	private List<ITestStep> steps = new ArrayList<>();
	
	@Override
	public void init() {
		this.setAccessToken(util.getAccessToken());
		stepExecution.setAccessToken(this.accessToken);
		stepExecution.init();
		this.setStepExecutor(stepExecution);
	}
	
	@Override
	public void addStep(ITestStep step) {
		steps.add(step);
	}
	
	@Override
	public void test() {
		for (ITestStep step : steps) {
			this.getStepExecutor().perform(step);
		}
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
	
	@Override
	public void setStepExecutor(IStepExecution stepExecutor) {
		this.stepExecutor = stepExecution;
	}

	/**
	 * @return the stepExecutor
	 */
	public IStepExecution getStepExecutor() {
		return stepExecutor;
	}

	/**
	 * @return the steps
	 */
	public List<ITestStep> getSteps() {
		return steps;
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<ITestStep> steps) {
		this.steps = steps;
	}
	
}
