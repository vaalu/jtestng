package com.icw.automation.mobile.init;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.icw.automation.mobile.generics.ITestSuite;
import com.icw.automation.mobile.simple.SimpleTestSuite;

@Component
@ComponentScan(basePackages = "com.icw.automation")
public class AppRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
	
	private List<ITestSuite> testSuites = new ArrayList<>();
	
	@Autowired
	SimpleTestSuite simpleSuite;
	
	@Override
	public void run(String... args) throws Exception {
		init();
		testAll();
	}
	
	private void init() {
		LOGGER.debug("Initializing test suites.");
		testSuites.add(simpleSuite);
	}
	
	private void testAll() {
		
		for (ITestSuite suite : testSuites) {
			LOGGER.debug("Starting test suite: {} - {}", suite.getId(), suite.getName());
			suite.init();
			suite.test();
		}
	}

}
