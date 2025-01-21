/**
 * 
 */
package com.icw.automation.mobile.simple;

import java.util.List;

import org.springframework.stereotype.Component;

import com.icw.automation.mobile.generics.ITestStep;
import com.icw.automation.mobile.generics.impl.AbstractWorkflow;

/**
 * 
 */
@Component
public class SimpleWorkflow extends AbstractWorkflow {

	@Override
	public void init() {
		super.init();
		List<ITestStep> testSteps = excelUtil.readInputFile();
		this.setSteps(testSteps);
	}
}
