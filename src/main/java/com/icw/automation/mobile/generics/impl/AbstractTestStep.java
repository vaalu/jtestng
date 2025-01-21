/**
 * 
 */
package com.icw.automation.mobile.generics.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icw.automation.mobile.generics.ITestStep;

/**
 * 
 */
public abstract class AbstractTestStep implements ITestStep {
	public static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestStep.class);
	
	private String workflow;
	private String identifier;
	private String idType;
	private String action;
	private String value;
	private String expected;
	private String comments;
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("identifier : ").append(identifier);
		sb.append(" : idType : ").append(idType);
		sb.append(" : action : ").append(action);
		sb.append(" : value : ").append(value);
		return sb.toString();
	}

	/**
	 * @return the workflow
	 */
	public String getWorkflow() {
		return workflow;
	}

	/**
	 * @param workflow the workflow to set
	 */
	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}

	/**
	 * @return the expected
	 */
	public String getExpected() {
		return expected;
	}

	/**
	 * @param expected the expected to set
	 */
	public void setExpected(String expected) {
		this.expected = expected;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
}
