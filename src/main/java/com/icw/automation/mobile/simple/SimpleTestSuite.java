/**
 * 
 */
package com.icw.automation.mobile.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icw.automation.mobile.generics.impl.AbstractTestSuite;
import com.icw.automation.mobile.generics.util.WorkflowUtil;

/**
 * 
 */
@Service
public class SimpleTestSuite extends AbstractTestSuite {

	@Autowired
	SimpleWorkflow simpleWorkflow;
	
	@Autowired
	WorkflowUtil workflowUtil;
	
	@Override
	public String getName() {
		return "Simple workflow";
	}

	@Override
	public String getId() {
		return "simpleWorkflow";
	}

	public void init() {
		super.init();
		simpleWorkflow.setReporting(getReporting());
		simpleWorkflow.setGeneratedEmail(getGeneratedEmail());
		simpleWorkflow.init();
		this.addWorkflow(simpleWorkflow);
	}
}
