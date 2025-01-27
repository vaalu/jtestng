/**
 * 
 */
package com.icw.automation.mobile.generics.impl;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.icw.automation.mobile.drivers.DriverFactory;
import com.icw.automation.mobile.generics.IStepExecution;
import com.icw.automation.mobile.generics.ITestStep;
import com.icw.automation.mobile.generics.util.PropertiesUtil;
import com.icw.automation.mobile.generics.util.ReportingUtil;
import com.icw.automation.mobile.generics.util.WorkflowUtil;

import io.appium.java_client.AppiumDriver;

/**
 * 
 */
public abstract class AbstractStepExecution implements IStepExecution {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractStepExecution.class);

	@Autowired
	DriverFactory driverFactory;

	@Autowired
	PropertiesUtil props;
	
	@Autowired
	WorkflowUtil util;
	
	@Autowired
	ReportingUtil reporting;

	private AppiumDriver driver;

	private WebDriverWait wait;
	
	private String accessToken;
	
	private String email;

	public void init() {
		// this.setDriver(driverFactory.getDriver());
		// this.wait = new WebDriverWait(this.driver, propsUtil.getWebDriverWaitInSeconds());
	}
	private WebElement getElement(String idType, String identifier) {
		WebElement webElement = null;
		if (null != idType) {
			switch (idType.toUpperCase()) {
				case "XPATH": {
					// webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
					break;
				}
				case "ID": {
					// webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
					break;
				}
				case "CSSCLASS": {
					// webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(identifier)));
					break;
				}
				
			}
		}
		return webElement;
	}
	private void uploadDocs(ITestStep testStep) {
		String uploadUrl = props.getUploadDocsUrl();
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost postReq = new HttpPost(uploadUrl);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addTextBody("documentIdType", "1");
			String fileInfo = testStep.getValue();
			if (null != fileInfo) {
				String[] files = fileInfo.split(",");
				for (String file : files) {
					String[] info = file.split(":");
					builder.addBinaryBody(info[0].trim(), new File("uploads/" + info[1].trim()));
				}
			}
			HttpEntity multipart = builder.build();
			postReq.setEntity(multipart);
			postReq.setHeader("Authorization", "Bearer " + this.accessToken);
			
			try (CloseableHttpResponse response = client.execute(postReq)) {
				LOGGER.info("File upload status: {}",response.getCode());
				String responseBody = EntityUtils.toString(response.getEntity());
				LOGGER.info("File upload response: {}", responseBody);
				if (response.getCode() == 200) {
					LOGGER.info("Documents uploaded successfully: {}", responseBody);
				} else {
					LOGGER.error("Unable to upload documents. {}", responseBody);
				}
			} catch (ParseException e) {
				LOGGER.error("Error occurred while uploading documents.", e);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private boolean performAction(ITestStep testStep, WebElement webElement) {
		this.reporting.logInfo(testStep.getStepTitle(), testStep.toString());
		
		String action = testStep.getAction();
		String value = testStep.getValue();
		String message = testStep.toString();
		boolean isComplete = false;
		if (null != action) {
			switch (action.toUpperCase()) {
				case "CLICK": {
					// webElement.click();
					this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
					break;
				}
				case "SENDKEYS": {
					// webElement.sendKeys(value);
					this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
					break;
				}
				case "SCROLLDOWN": {
					try {
						scrollDown(testStep);
						this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
					} catch (Exception e) {
						LOGGER.error("ERROR: Error while scrolling down. {}", e);
					}
					break;
				}
				case "SCROLLUP": {
					this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
					break;
				}
				case "SCROLLLEFT": {
					this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
					break;
				}
				case "SCROLLRIGHT": {
					this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
					break;
				}
				case "UPLOAD": {
					this.uploadDocs(testStep);
					this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
				}
				case "LOGIN": {
					util.login(email, accessToken);
					this.reporting.logSuccess(testStep.getStepTitle(), testStep.toString());
					break;
				}
			}
			isComplete = true;
		}
		return isComplete;
	}
	private void scrollDown(ITestStep testStep) throws Exception {
		Dimension size = this.driver.manage().window().getSize();
		int startX = size.getHeight()/2;
		int startY = size.getWidth()/2;
		int endX = startX;
		int endY = (int)(size.getHeight() * 0.25);
		boolean isElementVisible = false;
		while (!isElementVisible) {
			WebElement element = getElement(testStep.getIdType(), testStep.getIdentifier());
			if (element.isDisplayed()) {
				isElementVisible = performAction(testStep, element);
			}
			
			PointerInput fingerInput = new PointerInput(PointerInput.Kind.TOUCH, "fingerInput");
			Sequence sequence = new Sequence(fingerInput, 0);
			sequence
				.addAction(fingerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(fingerInput.createPointerDown(0))
				.addAction(new Pause(fingerInput, Duration.ofMillis(200)))
				.addAction(fingerInput.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(fingerInput.createPointerUp(0));
			this.driver.perform(Collections.singletonList(sequence));
			Thread.sleep(500);
		}
	}
	
	public void perform(ITestStep testStep) {
		LOGGER.debug("Executing step: {}", testStep);
		String identifier = testStep.getIdentifier();
		String idType = testStep.getIdType();
		WebElement webElement = null;
		if (null != idType) {
			webElement = getElement(idType, identifier);
			performAction(testStep, webElement);
		}
	}

	/**
	 * @return the driver
	 */
	public AppiumDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(AppiumDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the wait
	 */
	public WebDriverWait getWait() {
		return wait;
	}

	/**
	 * @param wait the wait to set
	 */
	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
