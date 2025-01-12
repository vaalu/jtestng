/**
 * 
 */
package in.jeani.jtestng.automation.generics.impl;

import org.springframework.beans.factory.annotation.Autowired;

import in.jeani.jtestng.automation.generics.IWorkflow;
import in.jeani.jtestng.automation.generics.util.WorkflowUtil;

/**
 * 
 */
public abstract class AbstractWorkflow implements IWorkflow {

	@Autowired
	WorkflowUtil util;
	
}
