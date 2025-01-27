/**
 * 
 */
package com.icw.automation.mobile.generics.util;

import org.springframework.stereotype.Component;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * 
 */
@Component
public class ReportingUtil {

	private ExtentReports reporting;
	
	public void init() {
		reporting = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(WorkflowUtil.HTML_REPORT_FILE_PATH);
		reporting.attachReporter(reporter);
	}
	
	public void logSuccess(String title, String message) {
		this.reporting.createTest(title).log(Status.PASS, message);
	}
	
	public void logFail(String title, String message) {
		this.reporting.createTest(title).log(Status.FAIL, message);
	}
	
	public void logInfo(String title, String message) {
		this.reporting.createTest(title).log(Status.INFO, message);
	}
	
	public void logWarning(String title, String message) {
		this.reporting.createTest(title).log(Status.WARNING, message);
	}
	
	public void flush() {
		this.reporting.flush();
	}

	/**
	 * @return the reporting
	 */
	public ExtentReports getReporting() {
		return reporting;
	}

	/**
	 * @param reporting the reporting to set
	 */
	public void setReporting(ExtentReports reporting) {
		this.reporting = reporting;
	}
	
}
