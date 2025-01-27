/**
 * 
 */
package com.icw.automation.mobile.generics.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.icw.automation.mobile.generics.ITestSuite;
import com.icw.automation.mobile.generics.IWorkflow;
import com.icw.automation.mobile.generics.impl.defaults.DefaultStepExecution;
import com.icw.automation.mobile.generics.util.ReportingUtil;
import com.icw.automation.mobile.generics.util.WorkflowUtil;

/**
 * 
 */
public abstract class AbstractTestSuite implements ITestSuite {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestSuite.class);
	
	private List<IWorkflow> workflows = new ArrayList<>();

	private String generatedEmail;
	private String accessToken;
	
	@Autowired
	private ReportingUtil reporting;

	@Autowired
	DefaultStepExecution stepExecutor;
	
	@Autowired
	WorkflowUtil util;
	
	@Override
	public void init() {
		this.setGeneratedEmail(util.generateRandomEmail());
		reporting.init();
		reporting.logInfo("Initiazlize Test Suite", "Initializing test suite.");
	}
	
	public void test() {
		for (IWorkflow workflow : workflows) {
			workflow.test();
		}
		reporting.flush();
		try {
			util.sendEmail();
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}
	public void addWorkflow(IWorkflow workflow) {
		workflow.setAccessToken(accessToken);
		workflow.setGeneratedEmail(generatedEmail);
		LOGGER.debug("Initializing workflows.");
		workflows.add(workflow);
		LOGGER.debug("After adding workflows.");
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
