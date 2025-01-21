/**
 * 
 */
package com.icw.automation.mobile.simple.steps;

import com.icw.automation.mobile.generics.impl.AbstractTestStep;

/**
 * 
 */
public class SimpleStep extends AbstractTestStep {
	
	public SimpleStep() {
	}
	public SimpleStep(String type, String identifier, String value, String action) {
		this.setIdType(type);
		this.setIdentifier(identifier);
		this.setValue(value);
		this.setAction(action);
	}
	@Override
	public void init() {
	}
}
