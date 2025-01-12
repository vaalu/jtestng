/**
 * 
 */
package in.jeani.jtestng.automation.generics.impl;

import java.util.ArrayList;
import java.util.List;

import in.jeani.jtestng.automation.generics.ITestSuite;
import in.jeani.jtestng.automation.generics.IWorkflow;

/**
 * 
 */
public abstract class AbstractTestSuite implements ITestSuite {

	private List<IWorkflow> workflows = new ArrayList<>();
	
	public void test() {
		for (IWorkflow workflow : workflows) {
			workflow.test();
		}
	}
	public void addWorkflow(IWorkflow workflow) {
		workflows.add(workflow);
	}
}
