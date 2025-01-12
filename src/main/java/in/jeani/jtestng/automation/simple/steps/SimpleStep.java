/**
 * 
 */
package in.jeani.jtestng.automation.simple.steps;

import in.jeani.jtestng.automation.generics.impl.AbstractTestStep;

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
	@Override
	public void test() {
		LOGGER.debug("Testing step: ", this.toString());
	}
}
