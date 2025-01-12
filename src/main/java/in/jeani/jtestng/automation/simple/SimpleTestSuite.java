/**
 * 
 */
package in.jeani.jtestng.automation.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jeani.jtestng.automation.generics.impl.AbstractTestSuite;

/**
 * 
 */
@Service
public class SimpleTestSuite extends AbstractTestSuite {

	@Autowired
	SimpleWorkflow simpleWorkflow;
	
	@Override
	public String getName() {
		return "Simple workflow";
	}

	@Override
	public String getId() {
		return "simpleWorkflow";
	}

	public void init() {
		this.addWorkflow(simpleWorkflow);
	}
}
