/**
 * 
 */
package com.icw.automation.mobile.generics.impl.defaults;

import com.icw.automation.mobile.generics.impl.AbstractTestStep;

/**
 * 
 */
public class DefaultTestStep extends AbstractTestStep {

	public DefaultTestStep() {
	}
	public DefaultTestStep(String type, String identifier, String value, String action) {
		this.setIdType(type);
		this.setIdentifier(identifier);
		this.setValue(value);
		this.setAction(action);
	}
	
	@Override
	public void init() {
	}

}
